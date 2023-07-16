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
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          disabled
          :disabled="single"
          @click="handleUpdate"
        >修改
        </el-button>
      </el-col>
      <!--      <el-col :span="1.5">-->
      <!--        <el-button-->
      <!--          type="danger"-->
      <!--          plain-->
      <!--          icon="el-icon-delete"-->
      <!--          size="mini"-->
      <!--          :disabled="multiple"-->
      <!--          @click="handleDelete"-->
      <!--          v-hasPermi="['lineInfo:basic:remove']"-->
      <!--        >删除-->
      <!--        </el-button>-->
      <!--      </el-col>-->
      <!--      <el-col :span="1.5">-->
      <!--        <el-button-->
      <!--          type="warning"-->
      <!--          plain-->
      <!--          icon="el-icon-download"-->
      <!--          size="mini"-->
      <!--          :loading="exportLoading"-->
      <!--          @click="handleExport"-->
      <!--          v-hasPermi="['lineInfo:basic:export']"-->
      <!--        >导出-->
      <!--        </el-button>-->
      <!--      </el-col>-->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tableList" @selection-change="handleSelectionChange" stripe>
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="序号" align="center" type="index" :index="indexMethod"/>
      <el-table-column label="设备名称" align="center" prop="lineName"/>
      <el-table-column label="设备编号" align="center" prop="lineIdentifier"/>
      <el-table-column label="设备厂家" align="center" prop="manufacturer"/>
      <el-table-column label="生产任务号" align="center" prop="productionTaskNo">
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
      <el-table-column label="生产信息录入" align="center" prop="infoEntry">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-search"
            @click="handleInfoEntry(scope.row)"
          >点击查看
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createdTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createdTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click=""
          >删除
          </el-button>
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

    <!-- 添加或修改生产任务对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="设备名称" prop="lineName">
          <el-select v-model="form.lineName" placeholder="请选择设备名称" style="width: 100%;">
            <el-option
              v-for="item in lineList"
              :key="item.value"
              :label="item.label"
              :value="item.label">
              <span style="float: left">{{ item.label }}</span>
              <span style="float: right; color: #8492a6; font-size: 13px">{{ item.no }}</span>
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="生产任务号" prop="productionTaskNo">
          <el-select v-model="form.productionTaskNo" placeholder="请选择生产任务号" style="width: 100%;">
            <el-option
              v-for="item in ['12345', '67890']"
              :key="item"
              :label="item"
              :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="原材管理">
          现有 {{ form.rawMaterialsList.length }} 条原材记录
          <el-button
            type="text"
            icon="el-icon-search"
            @click="handleRawMaterials()"
          >点击查看
          </el-button>
        </el-form-item>
        <el-form-item label="成品管理">
          现有 {{ form.endProductsList.length }} 条成品记录
          <el-button
            type="text"
            icon="el-icon-search"
            @click="handleEndProducts()"
          >点击查看
          </el-button>
        </el-form-item>
        <el-form-item label="生产信息录入">
          <el-button
            type="text"
            icon="el-icon-search"
            @click="handleInfoEntry()"
          >点击查看
          </el-button>
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
        <el-button type="primary" size="mini" plain icon="el-icon-plus" @click="form.rawMaterialsList.push({})">新增
        </el-button>
      </el-row>
      <el-table :data="form.rawMaterialsList">
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
                       @click="form.rawMaterialsList.splice(scope.$index, 1)"></el-button>
          </template>
        </el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="finishRawMaterials">确 定</el-button>
        <el-button @click="cancelRawMaterials">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 成品管理 -->
    <el-dialog :title="endProductsTitle" :visible.sync="endProductsOpen" width="1500px" append-to-body>
      <el-row :gutter="10" class="mb8">
        <el-button type="primary" size="mini" plain icon="el-icon-plus" @click="form.endProductsList.push({})">新增
        </el-button>
      </el-row>
      <el-table :data="form.endProductsList">
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
                       @click="form.endProductsList.splice(scope.$index, 1)"></el-button>
          </template>
        </el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="finishEndProducts">确 定</el-button>
        <el-button @click="cancelEndProducts">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 生产信息录入 -->
    <el-dialog :title="infoEntryTitle" :visible.sync="infoEntryOpen" width="600px" append-to-body>
      <el-form :model="form.infoEntryForm" ref="infoEntryForm" label-width="100px" label-position="top">
        <el-form-item label="批号" prop="batchNumber">
          <el-input
            v-model="form.infoEntryForm.batchNumber"
            placeholder="请输入批号"
            clearable
          />
        </el-form-item>
        <el-form-item label="来源地" prop="source">
          <el-input
            v-model="form.infoEntryForm.source"
            placeholder="请输入来源地"
            clearable
          />
        </el-form-item>
        <el-form-item label="生产班组人员" prop="staff">
          <el-input
            v-model="form.infoEntryForm.staff"
            placeholder="请输入姓名"
            clearable
          />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="finishInfoEntry">确 定</el-button>
        <el-button @click="cancelInfoEntry">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {listBasic, getBasic, delBasic, addBasic, updateBasic, exportBasic} from "@/api/lineInfo/basic";

export default {
  name: "task",
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
      form: {
        id: null,
        lineId: null,
        lineName: null,
        lineIdentifier: null,
        manufacturer: null,
        productionTaskNo: null,
        rawMaterialsList: [],
        endProductsList: [],
        infoEntryForm: {
          batchNumber: null,
          source: null,
          staff: null
        },
        createdTime: null
      },
      // 表单校验
      rules: {},
      // 新增参数
      rawMaterialsTitle: '',
      endProductsTitle: '',
      infoEntryTitle: '',
      rawMaterialsOpen: false,
      endProductsOpen: false,
      infoEntryOpen: false,
      rawMaterialsId: null,
      endProductsId: null,
      tableList: [],
      // 新增生产任务部分
      lineList: [],
    };
  },
  created() {
    this.getList();
    this.getTableList();
    this.reset();
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
        this.getLineList();
      });
    },
    getTableList() {
      this.tableList = [];
      getBasic(1).then(response => {
        this.tableList.push({
          id: 1,
          lineId: 1,
          lineName: response.data.lineName,
          lineIdentifier: response.data.lineIdentifier,
          manufacturer: response.data.manufacturer,
          productionTaskNo: '12345',
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
          infoEntryForm: {
            batchNumber: '123456',
            source: '浙江省',
            staff: 'A'
          },
          createdTime: new Date(1637817664757)
        });
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
        lineId: null,
        lineName: null,
        lineIdentifier: null,
        manufacturer: null,
        productionTaskNo: null,
        rawMaterialsList: [],
        endProductsList: [],
        infoEntryForm: {
          batchNumber: null,
          source: null,
          staff: null
        },
        createdTime: null
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
      this.title = "添加生产任务";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids[0];
      this.form = this.tableList.find(item => item.id === id);
      this.open = true;
      this.title = "修改生产任务";
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.lineId = this.lineList.find(item => item.label === this.form.lineName).value;
          if (this.form.id != null) {
            getBasic(this.form.lineId).then(response => {
              let item = this.tableList.find(item => item.id === this.form.id);
              item.lineId = this.form.lineId;
              item.lineName = response.data.lineName;
              item.lineIdentifier = response.data.lineIdentifier;
              item.manufacturer = response.data.manufacturer;
              item.productionTaskNo = this.form.productionTaskNo;
              this.$modal.msgSuccess("修改成功");
              this.open = false;
            });
          } else {
            getBasic(this.form.lineId).then(response => {
              this.form.id = this.calculateId();
              this.form.lineIdentifier = response.data.lineIdentifier;
              this.form.manufacturer = response.data.manufacturer;
              this.form.createdTime = new Date();
              this.tableList.push(this.form);
              this.$modal.msgSuccess("新增成功");
              this.open = false;
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
      if (row) {
        this.rawMaterialsTitle = row.lineName + ' - ' + row.productionTaskNo + ' 原材管理';
        this.form.rawMaterialsList = row.rawMaterialsList;
      } else if (this.form.id) {
        let row = this.tableList.find(item => item.id === this.form.id);
        this.rawMaterialsTitle = row.lineName + ' - ' + row.productionTaskNo + ' 原材管理';
        this.form.rawMaterialsList = row.rawMaterialsList;
      } else {
        this.rawMaterialsTitle = '新任务原材管理';
      }
      this.rawMaterialsOpen = true;
    },
    handleEndProducts(row) {
      if (row) {
        this.endProductsTitle = row.lineName + ' - ' + row.productionTaskNo + ' 成品管理';
        this.form.endProductsList = row.endProductsList;
      } else if (this.form.id) {
        let row = this.tableList.find(item => item.id === this.form.id);
        this.endProductsTitle = row.lineName + ' - ' + row.productionTaskNo + ' 成品管理';
        this.form.endProductsList = row.endProductsList;
      } else {
        this.endProductsTitle = '新任务成品管理';
      }
      this.endProductsOpen = true;
    },
    handleInfoEntry(row) {
      if (row) {
        this.infoEntryTitle = row.lineName + ' - ' + row.productionTaskNo + ' 生产信息录入';
        this.form.infoEntryForm = row.infoEntryForm;
      } else {
        this.infoEntryTitle = '新任务生产信息录入';
        this.form.infoEntryForm = {};
      }
      this.infoEntryOpen = true;
    },
    finishRawMaterials() {
      this.rawMaterialsOpen = false;
    },
    cancelRawMaterials() {
      this.rawMaterialsOpen = false;
    },
    finishEndProducts() {
      this.endProductsOpen = false;
      if (this.endProductsId) {
        this.tableList.find(item => item.id === this.endProductsId).endProductsList = this.endProductsList;
      }
    },
    cancelEndProducts() {
      this.endProductsOpen = false;
    },
    finishInfoEntry() {
      this.infoEntryOpen = false;
      if (this.infoEntryForm.id) {
        this.tableList.find(item => item.id === this.infoEntryForm.id).infoEntryForm = this.infoEntryForm;
      }
    },
    cancelInfoEntry() {
      this.infoEntryOpen = false;
    },

    getLineList() {
      this.lineList = [];
      for (let row of this.basicList) {
        this.lineList.push({
          value: row.id,
          label: row.lineName,
          no: row.lineIdentifier
        });
      }
    },

    calculateId() {
      let ids = this.tableList.map(item => item.id);
      return Math.max(...ids) + 1;
    }
  }
}
</script>

<style scoped>
/*@media screen and (max-width: 1500px) {*/
/*  .el-dialog {*/
/*    width: 95% !important;*/
/*  }*/
/*}*/
</style>
