<template>
  <div class="app-container-1">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="配方名称" prop="strDataSetName">
        <el-input
          v-model="queryParams.die_DieName"
          placeholder="请输入配方名称"
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
    <div style="display: block; font-size: 20px; vertical-align: middle; word-wrap: break-word; margin-bottom: 20px;">
      当前配方：第{{ pressRecipe.count + 1 }}组
    </div>
    <div style="display: block; font-size: 20px; vertical-align: middle; word-wrap: break-word; margin-bottom: 20px;">
      创建时间：{{ pressRecipe.time }}
    </div>
    <el-row>
      <el-col :span="23" class="card-box" style="margin-left: 25px;margin-top: 15px;">
        <el-card>
          <div slot="header"><span>自动化气源</span></div>
          <el-table :data="AirSourceData">
            <el-table-column label="气源编号" align="center" prop="roller"/>
            <el-table-column label="E-camOnAngle/deg" align="center"
                             prop="e_camOnAngle"/>
            <el-table-column label="E-camOffAngle/deg" align="center"
                             prop="e_camOffAngle"/>
            <el-table-column label="DelayOffTime/s" align="center" prop="delayOffTime"/>
          </el-table>
        </el-card>
      </el-col>
      <el-col :span="23" class="card-box" style="padding-top: 20px;margin-left: 25px;">
        <el-card>
          <div slot="header">
            <span>其他参数</span>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%;">
              <thead >
              <tr>
                <th class="el-table__cell  is-leaf">
                  <div class="cell">模具号</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">模具名称</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">平衡器压力/MPa</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">装模高度/mm</div>
                </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_DieNumber}}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_DieName }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_BalanceAirPressure }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_DieSetHeight }}</div>
                </td>
              </tr>

              </tbody>
              <thead>
              <tr>
                <th class="el-table__cell el-table__cell is-leaf">
                  <div class="cell">闭模高度/mm</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">摆剪ON角度/deg</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">摆剪OFF角度/eg</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">送料ON角度/deg</div>
                </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_DieShutHeight }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_SwingShearAngleOn }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_SwingShearAngleOff }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_FeederAngleOn }}</div>
                </td>
              </tr>
              </tbody>

              <thead>
              <tr>
                <th class="el-table__cell is-leaf">
                  <div class="cell">送料OFF角度/deg</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">上夹模器选择</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">废料槽选择</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">皮带高度/mm</div>
                </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_FeederAngleOff}}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_TravelingClampSelect }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_ScrapChuteSelect }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_BeltHeight }}</div>
                </td>
              </tr>
              </tbody>

              <thead>
              <tr>
                <th class="el-table__cell is-leaf">
                  <div class="cell">工作冲程SPM</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">预留1</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">预留2</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">预留3</div>
                </th>

              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_SPM }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_spare1 }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_spare2 }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_spare3 }}</div>
                </td>

              </tr>

              </tbody>

              <thead>
              <tr>
                <th class="el-table__cell is-leaf">
                  <div class="cell">预留4</div>
                </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ pressRecipe.info.die_spare4 }}</div>
                </td>
              </tr>

              </tbody>


            </table>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :page-sizes="[1]"
      :hide-on-single-page="true"
      @pagination="getEntrarecipe"
      style="margin-bottom: 50px;"
      :popper-class="'pagination-popper'"
    />
  </div>
</template>

<script>
import {getBasicDB05} from "@/api/recipe/recipe";

export default {
  name: "pressrecipe.vue",
  data() {
    return {
      //定时器
      timer: null,
      //搜索框显示
      showSearch: true,
      // 总条数
      total: 0,
      pressRecipe: {
        // 条目标记
        count: 0,
        time: null,
        name: '',
        info: {
          die_DieName: '',
          die_AutoEjectorSelect: 0,
          die_BalanceAirPressure: 0,
          die_BeltHeight: 0,
          die_DieNumber: 0,
          die_DieSetHeight: 0,
          die_DieShutHeight: 0,
          die_FeederAngleOff: 0,
          die_FeederAngleOn: 0,
          die_SPM: 0,
          die_ScrapChuteSelect: 0,
          die_SwingShearAngleOff: 0,
          die_SwingShearAngleOn: 0,
          die_TravelingClampSelect: 0,
          die_spare1: 0,
          die_spare2: 0,
          die_spare3: 0,
          die_spare4: 0,
        }
      },
      queryParams: {
        pageNum: 1,
        pageSize: 1,
        die_DieName: null,
      },
      AirSourceData: []

    }
  },
  created() {
    this.getEntry();
    this.getEntrarecipe();
  },
  methods: {
    //获取
    setAirSourceData() {
      let AirSourcedb = [];
      let info = this.pressRecipe.info;
      for (let i = 1; i < 16; i++) {
        //存储电磁铁对应不同堆垛和DsOs时的延时时间
        let temp = {};
        temp.delayOffTime = info[`delayOffTime${i}`];
        temp.e_camOffAngle = info[`e_camOffAngle${i}`];
        temp.e_camOnAngle = info[`e_camOnAngle${i}`];
        temp.roller = `${i}号自动化气源`;
        AirSourcedb.push(temp);
      }

      this.AirSourceData = AirSourcedb;
      console.log("AirSourceData====>");
      console.log(this.AirSourceData);


    },
    /** 查询配料表DB2005数据*/
    getEntrarecipe() {
      if (this.timer) {
        //分页后重新刷新页面之前清理timer
        clearInterval(this.timer)
        console.log("分页后重新刷新页面之前清理timer")
        this.getEntry()
      }
      this.timer = setInterval(() => {
        this.getEntry()
      }, 600000)
    },
    getEntry() {
      getBasicDB05(this.queryParams).then(response => {
        console.log("getIngredientList2005===>")
        console.log(response);
        this.total = response.total;
        if (this.total == 0) {
          this.$message.error('未查询到相关配方数据')
          this.queryParams.strDataSetName = null;
          return
        }
        this.pressRecipe = response.rows[0];
        this.setAirSourceData();
        // this.basicList = response.rows;
        // this.total = response.total;
      });
    },
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getEntry();
    },
    resetQuery() {
      this.queryParams.die_DieName = null;
      this.resetForm("queryForm");
      this.getEntry();
    }
  }
}
</script>

<style scoped>
.app-container-1 {
  padding-top: 30px;
  padding-left: 20px;
  padding-right: 20px;
}
th {
  color: #515a6e;
  background:#f8f8f9 !important;
}
th,td {
  text-align: center !important;
}
.pagination-popper {
  position: fixed;
}
</style>
