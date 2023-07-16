<template>
  <div class="app-container-1">

    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="配方名称" prop="erstrDataSetName">
        <el-input
          v-model="queryParams.erstrDataSetName"
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
      当前配方：第{{ entraRecipe.count+1 }}组:{{ entraRecipe.info.erstrDataSetName }}
    </div>
    <div style="display: block; font-size: 20px; vertical-align: middle; word-wrap: break-word; margin-bottom: 20px;">
      创建时间：{{ entraRecipe.time }}
    </div>
    <el-row>
      <el-col :span="7" class="card-box">
        <el-card>
          <div slot="header"><span>材料</span></div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%;">
              <thead>
              <tr>
                <th class="el-table__cell is-leaf">
                  <div class="cell">属性</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">值</div>
                </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">卷径/mm</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.erMaterialDiameter }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">材料宽度/mm</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.erMaterialWidth }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">材料厚度/mm</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.erMaterialThickness }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">内径/mm</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.erMaterialMiniDiameter }}</div>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>
      <el-col :span="8" class="card-box">
        <el-card>
          <div slot="header"><span>挤压辊</span></div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%;">
              <thead>
              <tr>
                <th class="el-table__cell is-leaf title_center">
                  <div class="cell">属性</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">值</div>
                </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">挤干辊1驱动侧压力/KPa</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.washerWringRollN1DsPressure }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">挤干辊1操作侧压力/KPa</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.washerWringRollN1OsPressure }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">挤干辊2驱动侧压力/KPa</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.washerWringRollN2DsPressure }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">挤干辊2操作侧压力/KPa</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.washerWringRollN2OsPressure }}</div>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>
      <el-col :span="9" class="card-box" >
        <el-card>
          <div slot="header"><span>摆剪参数</span></div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%;">
              <thead>
              <tr>
                <th class="el-table__cell is-leaf title_center">
                  <div class="cell">属性</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">值</div>
                </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">摆剪刀使用否</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.erbRotaryCutterUsed}}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">摆剪位置1(左)/0.01度</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.eri32RotaryCutterLeftPosition }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">摆剪位置2(右)/0.01度</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.eri32RotaryCutterRightPosition}}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">摆剪出侧皮带速度/0.01mpm</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.eri32RotaryCutterBeltVelocity }}</div>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>
      <el-col :span="24" class="card-box" style="padding-top: 20px;">
        <el-card>
          <div slot="header">
            <span>送料参数</span>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%;">
              <thead>
              <tr>
                <th class="el-table__cell  is-leaf">
                  <div class="cell">驱动侧入侧导位置/mm</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">驱动侧出侧导位置/mm</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">尾送料侧导位置/mm</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">送料平台高度/mm</div>
                </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ entraRecipe.info.erFeedGuideEntryDsPosition }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ entraRecipe.info.erFeedGuideExitDsPosition }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ entraRecipe.info.erEndFeedGuideWidth }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ entraRecipe.info.erFeedTableHeight }}</div>
                </td>
              </tr>

              </tbody>
              <thead>
              <tr>
                <th class="el-table__cell el-table__cell is-leaf">
                  <div class="cell">操作侧入侧导位置/mm</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">操作侧出侧导位置/mm</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">送料长度/mm</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">送料速度/mpm</div>
                </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.erFeedGuideEntryOsPosition}}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.erFeedGuideExitDsPosition}}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.eri32FeedLength}}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.eri32FeedVelocity}}</div>
                </td>
              </tr>
              </tbody>

              <thead>
              <tr>
                <th class="el-table__cell is-leaf">
                  <div class="cell">送料加速度</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">送料减速度</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">送料辊驱动侧压力/KPa</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">送料辊操作侧压力/KPa</div>
                </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.eri32FeedAcc}}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.eri32FeedDec}}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.eri32FeedRollDsPressure}}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.eri32FeedRollOsPressure}}</div>
                </td>
              </tr>
              </tbody>

              <thead>
              <tr>
                <th class="el-table__cell is-leaf">
                  <div class="cell">送料加加速</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">送料平台位置/mm</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">尾送料长度修正/mm</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">主送料半闭环全闭环模式</div>
                </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.eri32FeedJerk}}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.eri32FeedTableLength}}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.eri32EndFeedLengthImpose}}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.erbCloseLoopMode}}</div>
                </td>
              </tr>

              </tbody>

            </table>
          </div>
        </el-card>
      </el-col>
      <el-col :span="12" class="card-box" style="padding-top: 20px;">
        <el-card>
          <div slot="header"><span>出侧皮带</span></div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%;">
              <thead>
              <tr>
                <th class="el-table__cell is-leaf">
                  <div class="cell">属性</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">值</div>
                </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">出侧伸缩皮带速度/0.01mpm</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.eri32ExitBeltVelocity }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">出侧伸缩皮带伸出位置/0.01mm</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.eri32ExitBeltPosition }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">出侧伸缩皮带高度/0.01mm</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.eri32ExitBeltHeight }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">出侧皮带停延迟/s</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.ertBeltDelay }}</div>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>
      <el-col :span="12" class="card-box" style="padding-top: 20px;">
        <el-card>
          <div slot="header"><span>校平辊和产量</span></div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%;">
              <thead>
              <tr>
                <th class="el-table__cell is-leaf">
                  <div class="cell">属性</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">值</div>
                </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">校平工作辊入侧间隙量/0.001mm</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.eri32WorkRollEntryPosition }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">校平工作辊出侧间隙量/0.001mm</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.eri32WorkRollExitPosition}}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">校平侧导位置/0.01mm</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.eri32FlattenGuidePosition }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">产量</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell"> {{ entraRecipe.info.eri32Count }}</div>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>
      <el-col :span="24" class="card-box" style="padding-top: 20px;">
        <el-card>
          <div slot="header">
            <span>其他</span>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%;">
              <thead>
              <tr>
                <th class="el-table__cell  is-leaf">
                  <div class="cell">CPC 使用否</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">上下开卷模式</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">接料台板角度/0.01mm</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">接料台板位置/0.01mm</div>
                </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ entraRecipe.info.erbCpcUsed }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ entraRecipe.info.erbUncoilModeUpDown }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ entraRecipe.info.eri32TrayMaterialTableAngle }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ entraRecipe.info.eri32TrayMaterialTablePosition }}</div>
                </td>
              </tr>

              </tbody>
              <thead>
              <tr>
                <th class="el-table__cell el-table__cell is-leaf">
                  <div class="cell">自由辊位置/0.01mm</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">开卷张力%</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">剪废料长度/0.001mm</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">废料剪数量</div>
                </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.eri32FreeRollPosition}}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.eri32materialUsedTensionPercent}}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.eri32WasteCutterLength}}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.eri32WasteCutterCount}}</div>
                </td>
              </tr>
              </tbody>
              <thead>
              <tr>
                <th class="el-table__cell is-leaf">
                  <div class="cell">清洗机使用否</div>
                </th>
                <th class="el-table__cell is-leaf">
                  <div class="cell">侧堆垛使用否</div>
                </th>

              </tr>
              </thead>
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.erbWasherUsed}}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{entraRecipe.info.erbSidePilerUsed}}</div>
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
import {getBasicDB02} from "@/api/recipe/recipe";

export default {
  name: "entrarecipe",

  data() {
    return {
      // 定时器
      timer:null,
      entraRecipe: {
        // 条目标记
        count: 0,
        time:null,
        name:'',
        info: {
          erstrDataSetName: '',
          erMaterialDiameter: 0,
          erMaterialMiniDiameter: false,
          erMaterialThickness: 0,
          erMaterialWidth: 0,

          washerWringRollN1DsPressure: 0,
          washerWringRollN1OsPressure: 0,
          washerWringRollN2DsPressure: 0,
          washerWringRollN2OsPressure: 0,

          erEndFeedGuideWidth: 0,
          erFeedGuideEntryDsPosition: 0,
          erFeedGuideExitDsPosition: 0,
          erFeedTableHeight: 0,

          erFeedGuideEntryOsPosition: 0,
          erFeedGuideExitOsPosition: 0,
          eri32FeedLength: 0,
          eri32FeedVelocity: 0,

          eri32FeedAcc:0,
          eri32FeedDec:0,
          eri32FeedRollDsPressure :0,
          eri32FeedRollOsPressure:0,

          eri32FeedJerk:0,
          eri32FeedTableLength:0,
          eri32EndFeedLengthImpose:0,
          erbCloseLoopMode:false,

          erbRotaryCutterUsed:false,
          eri32RotaryCutterLeftPosition:0,
          eri32RotaryCutterRightPosition:0,
          eri32RotaryCutterBeltVelocity:0,

          eri32ExitBeltVelocity:0,
          eri32ExitBeltPosition:0,
          eri32ExitBeltHeight:0,
          ertBeltDelay:0,

          eri32WorkRollEntryPosition:0,
          eri32WorkRollExitPosition:0,
          eri32FlattenGuidePosition:0,
          eri32Count:0,

          erbCpcUsed:0,
          erbUncoilModeUpDown:0,
          eri32TrayMaterialTableAngle:0,
          eri32TrayMaterialTablePosition:0,
          eri32FreeRollPosition:0,
          eri32materialUsedTensionPercent:0,
          eri32WasteCutterLength:0,
          eri32WasteCutterCount:0,
          erbWasherUsed:0,
          erbSidePilerUsed:0,
        }
      },
      //查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 1,
        erstrDataSetName: null,
        // lineIdentifier: null,
        // manufacturer: null,
        // lineStatus: null,
      },
      // 总条数
      total: 0,
      showSearch: true,
      // queryParamsDB2002: {
      //   pageNum: 1,
      //   pageSize: 2,
      // },
    };
  },
  created() {
    this.getEntry();
    this.getEntrarecipe();
  },
  mounted() {

  },
  methods: {
    /** 查询配料表DB2002数据*/
    getEntrarecipe() {
      if(this.timer){
        //分页后重新刷新页面之前清理timer
        clearInterval(this.timer)
        console.log("分页后重新刷新页面之前清理timer")
        this.getEntry()
      }
      this.timer = setInterval(() => {
        console.log("chaxun")
        this.getEntry()
      },600000)
    },
    getEntry() {
      getBasicDB02(this.queryParams).then(response => {
        console.log("getIngredientList===>")
        console.log(response);
        this.entraRecipe = response.rows[0];
        this.total = response.total;
        if(this.total==0){
          this.$message.error('未查询到相关配方数据')
          return
        }
        // this.basicList = response.rows;
        // this.total = response.total;
      });
      console.log("查询配料表DB2002数据")
    },
    handleQuery(){
      this.queryParams.pageNum = 1;
      this.getEntry();
    },
    resetQuery(){
      this.queryParams.die_DieName=null;
      this.resetForm("queryForm");
      this.getEntry();
    }
  },
  beforeDestroy() {
    clearInterval(this.timer)
  }
}

</script>

<style scoped>
.app-container-1 {
  padding-top: 30px;
  padding-left: 20px;
  padding-right:20px;
}
.pagination-popper {
  position: fixed;
}

/*.title_center {*/
/*  text-align: center;*/
/*}*/
</style>
