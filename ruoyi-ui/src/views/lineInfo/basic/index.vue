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
      <el-form-item label="设备编号" prop="lineIdentifier">
        <el-input
          v-model="queryParams.lineIdentifier"
          placeholder="请输入设备编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备厂家" prop="manufacturer">
        <el-input
          v-model="queryParams.manufacturer"
          placeholder="请输入设备厂家"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备状态" prop="lineStatus">
        <el-select v-model="queryParams.lineStatus" placeholder="请选择设备状态" clearable size="small">
          <el-option
            v-for="dict in dict.type.line_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <!--增删查改-->
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
      <!--      <el-table-column label="主键id" align="center" prop="id"/>-->
      <el-table-column label="详细信息" type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand" label-width="120px">
            <el-form-item label="设备名称" style="width: 30%;">
              <span>{{ props.row.lineName }}</span>
            </el-form-item>
            <el-form-item label="设备编号" style="width: 30%;">
              <span>{{ props.row.lineIdentifier }}</span>
            </el-form-item>
            <el-form-item label="设备厂家" style="width: 30%;">
              <span>{{ props.row.manufacturer }}</span>
            </el-form-item>
            <el-form-item label="设备运行时间(h)" style="width: 30%;">
              <span> 9999 </span>
            </el-form-item>
            <el-form-item label="实时剪切数量(次)" style="width: 30%;">
              <span> 9999 </span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column label="序号" align="center" type="index" :index="indexMethod"/>
      <el-table-column label="设备名称" align="center" prop="lineName"/>
      <el-table-column label="设备编号" align="center" prop="lineIdentifier"/>
      <el-table-column label="设备厂家" align="center" prop="manufacturer"/>
      <el-table-column label="设备线速(m/min)" align="center" prop="linearVelocity"/>
      <el-table-column label="设备状态" align="center" prop="lineStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.line_status" :value="scope.row.lineStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="投产时间" align="center" prop="productionTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.productionTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="年产能力(T)" align="center" prop="annualCapacity"/>
      <el-table-column label="产品范围" align="center" prop="productRange"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lineInfo:basic:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lineInfo:basic:remove']"
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
  </div>
</template>

<script>
import {listBasic, getBasic, delBasic, addBasic, updateBasic, exportBasic} from "@/api/lineInfo/basic";

export default {
  name: "Basic",
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
      /**配料表DB2002的前端数据*/
      queryParamsDB2002: {
        pageNum: 1,
        pageSize: 10,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {}
    };
  },
  created() {
    this.getList();
    // this.getIngredientList()
  },
  methods: {
    indexMethod(index) {
      return index + 1;
    },
    /** 查询产线管理列表 */
    getList() {
      this.loading = true;
      listBasic(this.queryParams).then(response => {
        console.log("getlist===>")
        console.log(response);
        this.basicList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询配料表DB2002数据*/
    getIngredientList(){
      getBasicDB02(this.queryParamsDB2002).then(response => {
        console.log("getIngredientList===>")
        console.log(response);
        // this.basicList = response.rows;
        // this.total = response.total;
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
    }
  }
};
</script>

<style>
.demo-table-expand {
  font-size: 0;
}

.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}

.demo-table-expand .el-form-item {
  margin-left: 15px;
  margin-right: 0;
  margin-bottom: 0;
  width: 30%;
}
</style>
