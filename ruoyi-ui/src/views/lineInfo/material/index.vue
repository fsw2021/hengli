<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="设备名称" prop="lineName">
        <el-input
          v-model="queryParams.lineName"
          placeholder="请输入设备名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['lineInfo:basic:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['lineInfo:basic:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['lineInfo:basic:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          :loading="exportLoading"
          @click="handleExport"
          v-hasPermi="['lineInfo:basic:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="basicList" @selection-change="handleSelectionChange" stripe>
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="序号" align="center" type="index" :index="indexMethod"/>
      <el-table-column label="设备名称" align="center" prop="lineName"/>
      <el-table-column label="设备编号" align="center" prop="lineIdentifier"/>
      <el-table-column label="设备厂家" align="center" prop="manufacturer"/>
      <el-table-column label="生产任务号" align="center" prop="productionTaskNo">
        <template slot-scope="scope">
          12345
        </template>
      </el-table-column>
      <el-table-column label="原材管理" align="center" prop="rawMaterials">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-search"
            @click="handleRawMaterials(scope.row)"
          >点击查看
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="成品管理" align="center" prop="endProducts">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-search"
            @click="handleEndProducts(scope.row)"
          >点击查看
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="卷料信息" align="center" prop="coilInfo">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-search"
            @click="handleCoilInfo(scope.row)"
          >点击查看
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createdTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(new Date(1637817664757), '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改产线管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="设备名称" prop="lineName">
          <el-input v-model="form.lineName" placeholder="请输入设备名称"/>
        </el-form-item>
        <el-form-item label="设备编号" prop="lineIdentifier">
          <el-input v-model="form.lineIdentifier" placeholder="请输入设备编号"/>
        </el-form-item>
        <el-form-item label="设备厂家" prop="manufacturer">
          <el-input v-model="form.manufacturer" placeholder="请输入设备厂家"/>
        </el-form-item>
        <el-form-item label="设备线速(m/min)" prop="linearVelocity">
          <el-input v-model="form.linearVelocity" placeholder="请输入设备线速"/>
        </el-form-item>
        <el-form-item label="设备状态">
          <el-radio-group v-model="form.lineStatus">
            <el-radio
              v-for="dict in dict.type.line_status"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="投产时间" prop="productionTime">
          <el-date-picker clearable size="small"
                          v-model="form.productionTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择投产时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="年产能力(T)" prop="annualCapacity">
          <el-input v-model="form.annualCapacity" placeholder="请输入年产能力"/>
        </el-form-item>
        <el-form-item label="产品范围" prop="productRange">
          <el-input v-model="form.productRange" type="textarea" placeholder="请输入产品范围"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 原材管理 -->
    <el-dialog :title="rawMaterialsTitle" :visible.sync="rawMaterialsOpen" width="1500px" append-to-body>
      <el-row :gutter="10" class="mb8">
        <el-button type="primary" size="mini" plain icon="el-icon-plus" @click="rawMaterialsList.push({})">新增
        </el-button>
      </el-row>
      <el-table :data="rawMaterialsList">
        <el-table-column label="序号" align="center" type="index"/>
        <el-table-column label="卷材厚度" align="center" prop="thickness">
          <template slot-scope="scope">
            <el-input placeholder="请输入" v-model="scope.row.thickness" style="width: 75%">
            </el-input>
            mm
          </template>
        </el-table-column>
        <el-table-column label="卷材宽度" align="center" prop="width">
          <template slot-scope="scope">
            <el-input placeholder="请输入" v-model="scope.row.width" style="width: 75%">
            </el-input>
            mm
          </template>
        </el-table-column>
        <el-table-column label="卷材内径" align="center" prop="interDiameter">
          <template slot-scope="scope">
            Φ
            <el-input placeholder="请输入" v-model="scope.row.interDiameter" style="width: 65%">
            </el-input>
            mm
          </template>
        </el-table-column>
        <el-table-column label="卷材外径" align="center" prop="outerDiameter">
          <template slot-scope="scope">
            Φ
            <el-input placeholder="请输入" v-model="scope.row.outerDiameter" style="width: 70%">
            </el-input>
            mm
          </template>
        </el-table-column>
        <el-table-column label="抗拉强度" align="center" prop="tensileStrength">
          <template slot-scope="scope">
            σ<sub>b</sub>≤
            <el-input placeholder="请输入" v-model="scope.row.tensileStrength" style="width: 55%">
            </el-input>
            MPa
          </template>
        </el-table-column>
        <el-table-column label="屈服强度" align="center" prop="yieldStrength">
          <template slot-scope="scope">
            σ<sub>s</sub>≤
            <el-input placeholder="请输入" v-model="scope.row.yieldStrength" style="width: 55%">
            </el-input>
            MPa
          </template>
        </el-table-column>
        <el-table-column label="最高线速" align="center" prop="highestSpeed">
          <template slot-scope="scope">
            <el-input placeholder="请输入" v-model="scope.row.highestSpeed" style="width: 55%">
            </el-input>
            m/min
          </template>
        </el-table-column>
        <el-table-column label="卷重" align="center" prop="weight">
          <template slot-scope="scope">
            Max
            <el-input placeholder="请输入" v-model="scope.row.weight" style="width: 55%; text-align: center;">
            </el-input>
            T
          </template>
        </el-table-column>
        <el-table-column align="center" prop="remove" width="65">
          <template slot-scope="scope">
            <el-button type="danger" size="mini" icon="el-icon-delete"
                       @click="rawMaterialsList.splice(scope.$index, 1)"></el-button>
          </template>
        </el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="rawMaterialsOpen = false;">确 定</el-button>
        <el-button @click="rawMaterialsOpen = false;">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 成品管理 -->
    <el-dialog :title="endProductsTitle" :visible.sync="endProductsOpen" width="1500px" append-to-body>
      <el-row :gutter="10" class="mb8">
        <el-button type="primary" size="mini" plain icon="el-icon-plus" @click="endProductsList.push({})">新增
        </el-button>
      </el-row>
      <el-table :data="endProductsList">
        <el-table-column label="序号" align="center" type="index"/>
        <el-table-column label="定尺范围" align="center" prop="scaleRange">
          <template slot-scope="scope">
            <el-input placeholder="请输入" v-model="scope.row.scaleRange" style="width: 75%">
            </el-input>
            mm
          </template>
        </el-table-column>
        <el-table-column label="长度精度" align="center" prop="lengthAccuracy">
          <template slot-scope="scope">
            ±
            <el-input placeholder="请输入" v-model="scope.row.lengthAccuracy1" style="width: 45%">
            </el-input>
            mm/
            <el-input placeholder="请输入" v-model="scope.row.lengthAccuracy2" style="width: 45%">
            </el-input>
            mm
          </template>
        </el-table-column>
        <el-table-column label="对角线" align="center" prop="diagonal">
          <template slot-scope="scope">
            ≤±
            <el-input placeholder="请输入" v-model="scope.row.diagonal" style="width: 55%">
            </el-input>
            mm
          </template>
        </el-table-column>
        <el-table-column label="毛刺" align="center" prop="skinNeedling">
          <template slot-scope="scope">
            ≤
            <el-input placeholder="请输入" v-model="scope.row.skinNeedling1" style="width: 75%">
            </el-input>
            （板厚
            <el-input placeholder="请输入" v-model="scope.row.skinNeedling2" style="width: 45%">
            </el-input>
            mm）
          </template>
        </el-table-column>
        <el-table-column label="堆垛参差度" align="center" prop="stackingIrregularity">
          <template slot-scope="scope">
            <el-input placeholder="请输入" v-model="scope.row.stackingIrregularity1" style="width: 65%">
            </el-input>
            ＜
            <el-input placeholder="请输入" v-model="scope.row.stackingIrregularity2" style="width: 65%">
            </el-input>
            mm
          </template>
        </el-table-column>
        <el-table-column label="平整度" align="center" prop="planeness">
          <template slot-scope="scope">
            <el-input type="textarea" placeholder="请输入" v-model="scope.row.planeness">
            </el-input>
          </template>
        </el-table-column>
        <el-table-column label="料片形状" align="center" prop="shape">
          <template slot-scope="scope">
            <el-input type="textarea" placeholder="请输入" v-model="scope.row.shape">
            </el-input>
          </template>
        </el-table-column>
        <el-table-column align="center" prop="remove" width="65">
          <template slot-scope="scope">
            <el-button type="danger" size="mini" icon="el-icon-delete"
                       @click="endProductsList.splice(scope.$index, 1)"></el-button>
          </template>
        </el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="endProductsOpen = false;">确 定</el-button>
        <el-button @click="endProductsOpen = false;">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 卷料信息 -->
    <el-dialog :title="coilInfoTitle" :visible.sync="coilInfoOpen" width="900px" append-to-body>
      <el-form :model="coilInfoForm" ref="coilInfoForm" :inline="true" label-width="68px">
        <el-form-item label="批号" prop="batchNumber">
          <el-input
            v-model="coilInfoForm.batchNumber"
            placeholder="请输入批号"
            clearable
            size="small"
          />
        </el-form-item>
        <el-form-item label="来源地" prop="source">
          <el-input
            v-model="coilInfoForm.source"
            placeholder="请输入来源地"
            clearable
            size="small"
          />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-check" size="mini">保存</el-button>
        </el-form-item>
      </el-form>
      <el-descriptions title="卷料读取信息" :column="2" border :labelStyle="{'text-align': 'center'}" :contentStyle="{'text-align': 'center'}">
        <el-descriptions-item label="厚度(mm)">*.**</el-descriptions-item>
        <el-descriptions-item label="宽度(mm)">*.**</el-descriptions-item>
        <el-descriptions-item label="内径(mm)">*.**</el-descriptions-item>
        <el-descriptions-item label="外径(mm)">*.**</el-descriptions-item>
        <el-descriptions-item label="原始长度(m)">*.**</el-descriptions-item>
        <el-descriptions-item label="剩余长度(m)">*.**</el-descriptions-item>
        <el-descriptions-item label="重量(T)">*.**</el-descriptions-item>
      </el-descriptions>
    </el-dialog>
  </div>
</template>

<script>
import {listBasic, getBasic, delBasic, addBasic, updateBasic, exportBasic} from "@/api/lineInfo/basic";

export default {
  name: "material",
  dicts: ['line_status'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 产线管理表格数据
      basicList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        lineName: null,
        lineIdentifier: null,
        manufacturer: null,
        lineStatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
      // 新增参数
      rawMaterialsTitle: '',
      endProductsTitle: '',
      coilInfoTitle: '',
      rawMaterialsOpen: false,
      endProductsOpen: false,
      coilInfoOpen: false,
      rawMaterialsList: [
        {
          thickness: '0.3~1.6',
          width: '300~1850',
          interDiameter: '508/610',
          outerDiameter: '650~2100',
          tensileStrength: '1180',
          yieldStrength: '970',
          highestSpeed: '90',
          weight: '20'
        },
        {
          thickness: '1.6~2.2',
          width: '300~1850',
          interDiameter: '508/610',
          outerDiameter: '650~2100',
          tensileStrength: '980',
          yieldStrength: '780',
          highestSpeed: '90',
          weight: '20'
        },
        {
          thickness: '2.2~3.2',
          width: '300~1850',
          interDiameter: '508/610',
          outerDiameter: '650~2100',
          tensileStrength: '790',
          yieldStrength: '590',
          highestSpeed: '90',
          weight: '20'
        }
      ],
      endProductsList: [
        {
          scaleRange: '300~4300',
          lengthAccuracy1: '0.2',
          lengthAccuracy2: '2000',
          diagonal: '0.5',
          skinNeedling1: '0.03 mm',
          skinNeedling2: '≤1.0',
          stackingIrregularity1: '层间偏差',
          stackingIrregularity2: '1',
          planeness: '低于原板不平度的10%',
          shape: '矩形板  梯形板 平行四边形板 异形板'
        },
        {
          scaleRange: '300~4300',
          lengthAccuracy1: '0.2',
          lengthAccuracy2: '4300',
          diagonal: '0.5',
          skinNeedling1: '板厚的3%',
          skinNeedling2: '>1.0',
          stackingIrregularity1: '堆垛偏差',
          stackingIrregularity2: '2',
          planeness: '低于原板不平度的10%',
          shape: '矩形板  梯形板 平行四边形板 异形板'
        }
      ],
      coilInfoForm: {
        batchNumber: '123456',
        source: '浙江省'
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    indexMethod(index) {
      return index + 1;
    },
    /** 查询产线管理列表 */
    getList() {
      this.loading = true;
      listBasic(this.queryParams).then(response => {
        this.basicList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        lineName: null,
        lineIdentifier: null,
        manufacturer: null,
        linearVelocity: null,
        lineStatus: 1,
        productionTime: null,
        annualCapacity: null,
        productRange: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加产线管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getBasic(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改产线管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBasic(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBasic(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除产线管理编号为"' + ids + '"的数据项？').then(function () {
        return delBasic(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$modal.confirm('是否确认导出所有产线管理数据项？').then(() => {
        this.exportLoading = true;
        return exportBasic(queryParams);
      }).then(response => {
        this.$download.name(response.msg);
        this.exportLoading = false;
      }).catch(() => {
      });
    },

    // 新增函数
    handleRawMaterials(row) {
      this.rawMaterialsTitle = row.lineName + '原材管理';
      this.rawMaterialsOpen = true;
    },
    handleEndProducts(row) {
      this.endProductsTitle = row.lineName + '成品管理';
      this.endProductsOpen = true;
    },
    handleCoilInfo(row) {
      this.coilInfoTitle = row.lineName + '卷料信息';
      this.coilInfoOpen = true;
    },
  }
}
</script>

<style scoped>

</style>
