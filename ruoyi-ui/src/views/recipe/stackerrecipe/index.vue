<template>
  <div class="app-container-1">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="配方名称" prop="strDataSetName">
        <el-input
          v-model="queryParams.strDataSetName"
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
      当前配方：第{{ stackerRecipe.count + 1 }}组:{{ stackerRecipe.info.strDataSetName }}
    </div>
    <div style="display: block; font-size: 20px; vertical-align: middle; word-wrap: break-word; margin-bottom: 20px;">
      创建时间：{{ stackerRecipe.time }}
    </div>
    <el-row>

      <el-col :span="23" class="card-box" style="margin-left: 25px">
        <el-card>
          <div slot="header"><span>asBoard</span></div>
          <el-table :data="asBoardData"   class="card-box">
            <el-table-column align="center" prop="roller"/>
            <el-table-column label="挡板长度/mm" align="center" prop="length"/>
            <el-table-column label="挡板宽度/mm" align="center" prop="width"/>
            <el-table-column label="挡板角度/deg" align="center" prop="rot"/>
            <el-table-column label="挡板是否使用" align="center" prop="board"/>
            <el-table-column label="拍打是否使用" align="center" prop="pater"/>
          </el-table>
        </el-card>
      </el-col>

      <el-col :span="23" class="card-box" style="margin-left: 25px;margin-top: 15px;">
        <el-card>
          <div slot="header"><span>asBelt</span></div>
          <el-table :data="asBeltData"  >
            <el-table-column align="center" prop="roller"/>
            <el-table-column label="驱动侧/mm" align="center" prop="Ds"/>
            <el-table-column label="中央驱动侧/mm" align="center" prop="Cds"/>
            <el-table-column label="中央操作侧/mm" align="center" prop="Cos"/>
            <el-table-column label="操作侧/mm" align="center" prop="Os"/>
          </el-table>
        </el-card>
      </el-col>

      <el-col :span="23" class="card-box" style="margin-left: 25px;margin-top: 15px;">
        <el-card>
          <div slot="header"><span>asGuideAndCart</span></div>
          <el-table :data="asGuideAndCartData">
            <el-table-column align="center" prop="roller"/>
            <el-table-column label="驱动侧侧导/mm" align="center" prop="GuideDs"/>
            <el-table-column label="操作侧侧导/mm" align="center" prop="GuideOs"/>
            <el-table-column label="驱动侧台车逆角度/deg" align="center" prop="RotCwDs"/>
            <el-table-column label="驱动侧台车顺角度/deg" align="center" prop="RotCcwDs"/>
            <el-table-column label="操作侧台车顺角度/deg" align="center" prop="RotCwOs"/>
            <el-table-column label="操作侧台车逆角度/deg" align="center" prop="RotcwOs"/>
          </el-table>
        </el-card>
      </el-col>

      <el-col :span="23" class="card-box" style="margin-left: 25px;margin-top: 15px;">
        <el-card>
          <div slot="header"><span>asPileMinor</span></div>
          <el-table :data="asPileMinorData">
            <el-table-column label="asPileMinor" align="center" prop="roller"/>
            <el-table-column label="计数传感器选择(0:all;1:cAndDs2;cAndOs;3:center;4:Ds;5:Os)" align="center"
                             prop="MaterialDetect"/>
            <el-table-column label="每张板料孔个数(经过选定传感器)" align="center" prop="HoleNumber"/>
            <el-table-column label="产量设定" align="center" prop="ProductionSet"/>
            <el-table-column label="料满或(2号到1号)提前减速张数" align="center" prop="AheadSetForDecTo15Spm"/>
            <el-table-column label="料架下降频率(张/次)" align="center" prop="SheetsEveryToDown"/>
            <el-table-column label="拍打频率(张/次)" align="center" prop="SheetsEveryToPat"/>
          </el-table>

          <el-table :data="asPileMinorData">
            <el-table-column align="center" prop="roller"/>
            <el-table-column label="皮带减速提前距离0/mm" align="center"
                             prop="DecVelocityAheadInstance0"/>
            <el-table-column label="皮带减速提前距离1/mm" align="center" prop="DecVelocityAheadInstance1"/>
            <el-table-column label="消磁提前距离0/mm" align="center" prop="DemagnetAheadInstance0"/>
            <el-table-column label="消磁提前距离1/mm" align="center" prop="DemagnetAheadInstance1"/>
            <el-table-column label="零速启动提前距离0/mm" align="center" prop="ZeroStartAheadInstance0"/>
            <el-table-column label="零速启动提前距离1/mm" align="center" prop="ZeroStartAheadInstance1"/>
          </el-table>

          <el-table :data="asPileMinorData">
            <el-table-column align="center" prop="roller"/>
            <el-table-column label="每个料架堆两垛料模式(on:1-3;4-6二组,off:1-6集成为一起)" align="center"
                             prop="SeparateTwoPartMode"/>
            <el-table-column label="当堆两垛模式 ON 时才有效:前后交替堆垛模式(off:仅仅使用1-3或4-6,on:1-3,4-6交替各一张"
                             align="center" prop="FrontBackAlterModeOffOn"/>
            <el-table-column label="左右片模式;(os1-os3)电磁铁一直ON" align="center" prop="LeftRightPartMode"/>
            <el-table-column label="bBackUp" align="center" prop="BackUp"/>
            <el-table-column label="bBackUp2" align="center" prop="bBackUp2"/>
            <el-table-column label="i32BackUp" align="center" prop="i32BackUp"/>
          </el-table>

          <el-table :data="asPileMinorData">
            <el-table-column align="center" prop="roller"/>
            <el-table-column label="i32BackUp2" align="center"
                             prop="i32BackUp2"/>
            <el-table-column label="拍打动作延迟时间(信号下降边沿开始)/ms" align="center" prop="PatDelayTime"/>
            <el-table-column label="拍打动作保持时间/ms" align="center" prop="tPatOnKeepTime"/>

          </el-table>


        </el-card>
      </el-col>

      <el-col :span="23" class="card-box" style="margin-left: 25px;margin-top: 15px;">
        <el-card>
          <div slot="header"><span>消磁延时时间/ms?</span></div>
          <el-table :data="tDemagnetDelayTimeData"   class="card-box">
            <el-table-column align="center" prop="roller"/>
            <el-table-column label="1号堆垛&Ds" align="center" prop="dmd00"/>
            <el-table-column label="1号堆垛&Os" align="center" prop="dmd01"/>
            <el-table-column label="2号堆垛&Ds" align="center" prop="dmd10"/>
            <el-table-column label="2号堆垛&Os" align="center" prop="dmd11"/>
          </el-table>
          <el-table :data="i32MagnetNumberImposeData"   class="card-box" :show-header="false">
            <el-table-column align="center" prop="roller"/>
            <el-table-column align="center" prop="i32MagnetNumberImpose00"/>
            <el-table-column  align="center" prop="i32MagnetNumberImpose01"/>
            <el-table-column  align="center" prop="i32MagnetNumberImpose10"/>
            <el-table-column  align="center" prop="i32MagnetNumberImpose11"/>
          </el-table>
          <el-table :data="bMagnetSelectedData"   class="card-box" :show-header="false">
            <el-table-column align="center" prop="roller"/>
            <el-table-column align="center" prop="bMagnetSelected00"/>
            <el-table-column  align="center" prop="bMagnetSelected01"/>
            <el-table-column  align="center" prop="bMagnetSelected10"/>
            <el-table-column  align="center" prop="bMagnetSelected11"/>
          </el-table>
        </el-card>
      </el-col>

      <el-col :span="23" class="card-box" style="margin-left: 25px;margin-top: 15px;">
        <el-card>
          <div slot="header"><span>sMinorData(其他)</span></div>
          <el-table :data="sMinorData">
            <el-table-column label="伸缩带高度/mm" align="center" prop="TrayBeltHeight"/>
            <el-table-column label="伸缩带电磁铁ON时间" align="center"
                             prop="tTrayBeltMagnetOnKeepTime"/>
            <el-table-column label="伸缩带传感器到压断点距离(料尾)/mm" align="center"
                             prop="TraySenseToCuttedPointDistance"/>
            <el-table-column label="伸缩带速度/mpm" align="center" prop="TrayBeltVelocity"/>
            <el-table-column label="伸缩带加速度*%(10m/s2)" align="center" prop="TrayBeltAcceleration"/>
            <el-table-column label="伸缩带减速度*%(10m/s2)" align="center" prop="TrayBeltDeceleration"/>
            <el-table-column label="伸缩带板料检测传感器(0:all;1:ds;2:os)" align="center"
                             prop="TrayBeltMaterialDetect"/>
          </el-table>

          <el-table :data="sMinorData">
            <el-table-column label="孔数(当冲压完成后传感器检测到板料)" align="center"
                             prop="TrayBeltHoleNumberAfterCutted"/>
            <el-table-column label="前部支撑轮选择(0:不选择;1-11为对于组)" align="center"
                             prop="FrontSupportRollSet"/>
            <el-table-column label="后部支撑轮选择(0:不选择;1-11为对于组)" align="center" prop="BackSupportRollSet"/>
            <el-table-column label="堆垛带高速度/mpm" align="center" prop="PileHighVelocity"/>
            <el-table-column label="堆垛带低速度/mpm" align="center" prop="PileLowVelocity"/>
            <el-table-column label="堆垛带加速度*%(10m/s2)" align="center" prop="PileAcceleration"/>
            <el-table-column label="堆垛带加加速度*%(10m/s2)" align="center" prop="PilepPlusJerk"/>
          </el-table>

          <el-table :data="sMinorData">
            <el-table-column label="堆垛带减速度*%(10m/s2)" align="center" prop="PileDeceleration"/>
            <el-table-column label="堆垛带减减速度*%(10m/s2)" align="center"
                             prop="PileMinusJerk"/>
            <el-table-column label="消磁保持时间/ms" align="center" prop="DemagnetKeepTime"/>
            <el-table-column label="堆垛电磁铁电压 0:无;1:低;2:中;3:高" align="center" prop="magnetVoltage"/>
            <el-table-column label="堆垛机位置/mm(侧堆垛)" align="center" prop="PilerPosition"/>
            <el-table-column label="压一次出前后片模式(M7064)" align="center" prop="ModeFrontBack"/>
            <el-table-column label="n1和n2都为一个整体(既每个料架只能一堆;但可以交替模式" align="center"
                             prop="ModeAllTogether"/>

          </el-table>

          <el-table :data="sMinorData">
            <el-table-column label="启停模式(零速堆垛)6.00mpm" align="center" prop="StartStopModeOffOn"/>
            <el-table-column label="是否已经存储" align="center"
                             prop="PileMinusJerk"/>
            <el-table-column label="bBackUp" align="center" prop="bBackUp"/>
            <el-table-column label="bBackUp2" align="center" prop="bBackUp2"/>
            <el-table-column label="i32BackUp" align="center" prop="i32BackUp"/>
            <el-table-column label="i32BackUp2" align="center" prop="i32BackUp2"/>

          </el-table>


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
import {getBasicDB03} from "@/api/recipe/recipe";

export default {
  name: "stackerrecipe",
  data() {
    return {
      //定时器
      timer: null,
      //搜索框显示
      showSearch: true,
      //查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 1,
        strDataSetName: null,
      },
      // 总条数
      total: 0,
      stackerRecipe: {
        // 条目标记
        count: 0,
        time: null,
        name: '',
        info: {
          strDataSetName: '',
        }
      },
      asBoardData: [],
      asBeltData: [],
      asGuideAndCartData: [],
      asPileMinorData: [],
      sMinorData: [],
      tDemagnetDelayTimeData: [],
      i32MagnetNumberImposeData:[],
      bMagnetSelectedData:[]
    }
  },
  created() {
    this.getEntry();
    this.getEntrarecipe();
  },
  methods: {
    //生成挡板对应的各路数据
    setBoardData() {
      let asBoraddb = [];
      for (let i = 0; i < 24; i++) {
        let temp_asBoard = {};
        let length_db = `asBoard${i}_i32Length`;
        let width_db = `asBoard${i}_i32Width`;
        let rot_db = `asBoard${i}_i32Rot`;
        let board_db = `asBoard${i}_bBoardUsedOffOn`;
        let pater_db = `asBoard${i}_bPaterUsedOffOn`;

        let info = this.stackerRecipe.info;

        temp_asBoard.length = info[length_db];
        temp_asBoard.width = info[width_db];
        temp_asBoard.rot = info[rot_db];

        if (info[board_db]) {
          temp_asBoard.board = 'true';
        } else {
          temp_asBoard.board = 'false';
        }

        if (info[pater_db]) {
          temp_asBoard.pater = 'true';
        } else {
          temp_asBoard.pater = 'false';
        }

        temp_asBoard.roller = `挡板${i}`
        asBoraddb.push(temp_asBoard)

        this.asBoardData = asBoraddb;
      }
      console.log(this.asBoardData)
    },
    setBeltData() {
      let asBeltdb = [];
      for (let i = 0; i < 4; i++) {
        let temp_asBelt = {};
        let Ds_db = `asBelt${i}_i32Ds`;
        let Cds_db = `asBelt${i}_i32Cds`;
        let Cos_db = `asBelt${i}_i32Cos`;
        let Os_db = `asBelt${i}_i32Os`;


        let info = this.stackerRecipe.info;

        temp_asBelt.Ds = info[Ds_db];
        temp_asBelt.Cds = info[Cds_db];
        temp_asBelt.Cos = info[Cos_db];
        temp_asBelt.Os = info[Os_db];


        temp_asBelt.roller = `带${i}`
        asBeltdb.push(temp_asBelt)

        this.asBeltData = asBeltdb;
      }
      console.log(this.asBeltData)
    },
    setasGuideAndCartData() {
      let asGuideAndCartdb = [];
      for (let i = 0; i < 2; i++) {
        let temp = {};
        let Ds_db = `asGuideAndCart${i}_i32GuideDs`;
        let Os_db = `asGuideAndCart${i}_i32GuideOs`;
        let CwDs_db = `asGuideAndCart${i}_i32CartRotCwDs`;
        let CcDs_db = `asGuideAndCart${i}_i32CartRotCcwDs`;
        let CwOs_db = `asGuideAndCart${i}_i32CartRotCwOs`;
        let cwOs_db = `asGuideAndCart${i}_i32CartRotcwOs`;


        let info = this.stackerRecipe.info;

        temp.GuideDs = info[Ds_db];
        temp.GuideOs = info[Os_db];
        temp.RotCwDs = info[CwDs_db];
        temp.RotCcwDs = info[CcDs_db];
        temp.RotCwOs = info[CwOs_db];
        temp.RotcwOs = info[cwOs_db];


        temp.roller = `GuideAndCart${i}`
        asGuideAndCartdb.push(temp)

        this.asGuideAndCartData = asGuideAndCartdb;
      }
      console.log(this.asGuideAndCartData)
    },
    setasPileMinorData() {
      let asPileMinordb = [];
      for (let i = 0; i < 2; i++) {
        let temp = {};
        let MaterialDetect = `asPileMinor${i}_i32MaterialDetect`;
        let HoleNumber = `asPileMinor${i}_i32HoleNumber`;
        let ProductionSet = `asPileMinor${i}_i32ProductionSet`;
        let AheadSetForDecTo15Spm = `asPileMinor${i}_i32AheadSetForDecTo15Spm`;
        let SheetsEveryToDown = `asPileMinor${i}_i32SheetsEveryToDown`;
        let SheetsEveryToPat = `asPileMinor${i}_i32SheetsEveryToPat`;
        let DecVelocityAheadInstance0 = `asPileMinor${i}_ai32DecVelocityAheadInstance0`;
        let DecVelocityAheadInstance1 = `asPileMinor${i}_ai32DecVelocityAheadInstance1`;
        let DemagnetAheadInstance0 = `asPileMinor${i}_ai32DemagnetAheadInstance0`;
        let DemagnetAheadInstance1 = `asPileMinor${i}_ai32DemagnetAheadInstance1`;
        let ZeroStartAheadInstance0 = `asPileMinor${i}_ai32ZeroStartAheadInstance0`;
        let ZeroStartAheadInstance1 = `asPileMinor${i}_ai32ZeroStartAheadInstance1`;
        let SeparateTwoPartMode = `asPileMinor${i}_bSeparateTwoPartMode`;
        let FrontBackAlterModeOffOn = `asPileMinor${i}_bFrontBackAlterModeOffOn`;
        let LeftRightPartMode = `asPileMinor${i}_bLeftRightPartMode`;
        let BackUp = `asPileMinor${i}_bBackUp`;
        let bBackUp2 = `asPileMinor${i}_bBackUp2`;
        let i32BackUp = `asPileMinor${i}_i32BackUp`;
        let i32BackUp2 = `asPileMinor${i}_i32BackUp2`;

        //MongoDb中命名有问题的两个属性
        let PatDelayTime = `asPileMinor${i}_tPatDelayTime`;
        let tPatOnKeepTime = `asPileMinor${i}_tPatOnKeepTime`;

        let info = this.stackerRecipe.info;

        temp.MaterialDetect = info[MaterialDetect];
        temp.HoleNumber = info[HoleNumber];
        temp.ProductionSet = info[ProductionSet];
        temp.AheadSetForDecTo15Spm = info[AheadSetForDecTo15Spm];
        temp.SheetsEveryToDown = info[SheetsEveryToDown];
        temp.SheetsEveryToPat = info[SheetsEveryToPat];
        temp.DecVelocityAheadInstance0 = info[DecVelocityAheadInstance0];
        temp.DecVelocityAheadInstance1 = info[DecVelocityAheadInstance1];
        temp.DemagnetAheadInstance0 = info[DemagnetAheadInstance0];
        temp.DemagnetAheadInstance1 = info[DemagnetAheadInstance1];
        temp.ZeroStartAheadInstance0 = info[ZeroStartAheadInstance0];
        temp.ZeroStartAheadInstance1 = info[ZeroStartAheadInstance1];

        //MongoDb中命名有问题的两个属性
        temp.PatDelayTime = info[PatDelayTime];
        temp.tPatOnKeepTime = info[tPatOnKeepTime];

        if (info[SeparateTwoPartMode]) {
          temp.SeparateTwoPartMode = 'ON'
        } else {
          temp.SeparateTwoPartMode = 'OFF'
        }
        temp.FrontBackAlterModeOffOn = info[FrontBackAlterModeOffOn];
        if (info[FrontBackAlterModeOffOn]) {
          temp.FrontBackAlterModeOffOn = 'ON'
        } else {
          temp.FrontBackAlterModeOffOn = 'OFF'
        }
        if (info[LeftRightPartMode]) {
          temp.LeftRightPartMode = 'ON'
        } else {
          temp.LeftRightPartMode = 'OFF'
        }
        if (info[BackUp]) {
          temp.BackUp = 'ON'
        } else {
          temp.BackUp = 'OFF'
        }
        if (info[bBackUp2]) {
          temp.bBackUp2 = 'ON'
        } else {
          temp.bBackUp2 = 'OFF'
        }
        temp.i32BackUp = info[i32BackUp];
        temp.i32BackUp2 = info[i32BackUp2];


        temp.roller = `PileMinor${i}`
        asPileMinordb.push(temp)

        this.asPileMinorData = asPileMinordb;
      }
      console.log(this.asPileMinorData)
    },
    setsMinorDataData() {

      let sMinordb = [];

      let temp = {};
      let TrayBeltHeight = "sMinor_i32TrayBeltHeight";
      let tTrayBeltMagnetOnKeepTime = "sMinor_tTrayBeltMagnetOnKeepTime";
      let TraySenseToCuttedPointDistance = "sMinor_i32TraySenseToCuttedPointDistance";
      let TrayBeltVelocity = "sMinor_i32TrayBeltVelocity";
      let TrayBeltAcceleration = "sMinor_i32TrayBeltAcceleration";
      let TrayBeltDeceleration = "sMinor_i32TrayBeltDeceleration";
      let TrayBeltMaterialDetect = "sMinor_i32TrayBeltMaterialDetect";
      let TrayBeltHoleNumberAfterCutted = "sMinor_i32TrayBeltHoleNumberAfterCutted";
      let FrontSupportRollSet = "sMinor_i32FrontSupportRollSet";
      let BackSupportRollSet = "sMinor_i32BackSupportRollSet";
      let PileHighVelocity = "sMinor_i32PileHighVelocity";
      let PileLowVelocity = "sMinor_i32PileLowVelocity";
      let PileAcceleration = "sMinor_i32PileAcceleration";
      let PilepPlusJerk = "sMinor_i32PilepPlusJerk";
      let PileDeceleration = "sMinor_i32PileDeceleration";
      let PileMinusJerk = "sMinor_i32PileMinusJerk";
      let DemagnetKeepTime = "sMinor_tDemagnetKeepTime";
      let magnetVoltage = "sMinor_i32magnetVoltage";
      let PilerPosition = "sMinor_i32PilerPosition";
      let ModeFrontBack = "sMinor_bModeFrontBack";
      let ModeAllTogether = "sMinor_bModeAllTogether";
      let AlterModeOffOnWhileAllTogether = "sMinor_bAlterModeOffOnWhileAllTogether";
      let StartStopModeOffOn = "sMinor_bStartStopModeOffOn";
      let bSaved = "sMinor_bSaved";
      let bBackUp = "sMinor_bBackUp";
      let bBackUp2 = "sMinor_bBackUp2";
      let i32BackUp = "sMinor_i32BackUp";
      let i32BackUp2 = "sMinor_i32BackUp2";

      let info = this.stackerRecipe.info;

      temp.TrayBeltHeight = info[TrayBeltHeight];
      temp.tTrayBeltMagnetOnKeepTime = info[tTrayBeltMagnetOnKeepTime];
      temp.TraySenseToCuttedPointDistance = info[TraySenseToCuttedPointDistance];
      temp.TrayBeltVelocity = info[TrayBeltVelocity];
      temp.TrayBeltAcceleration = info[TrayBeltAcceleration];
      temp.TrayBeltDeceleration = info[TrayBeltDeceleration];
      temp.TrayBeltMaterialDetect = info[TrayBeltMaterialDetect];
      temp.TrayBeltHoleNumberAfterCutted = info[TrayBeltHoleNumberAfterCutted];
      temp.FrontSupportRollSet = info[FrontSupportRollSet];
      temp.BackSupportRollSet = info[BackSupportRollSet];
      temp.PileHighVelocity = info[PileHighVelocity];
      temp.PileLowVelocity = info[PileLowVelocity];
      temp.PileAcceleration = info[PileAcceleration];
      temp.PilepPlusJerk = info[PilepPlusJerk];
      temp.PileDeceleration = info[PileDeceleration];
      temp.PileMinusJerk = info[PileMinusJerk];
      temp.DemagnetKeepTime = info[DemagnetKeepTime];
      temp.magnetVoltage = info[magnetVoltage];
      temp.PilerPosition = info[PilerPosition];

      if (info[ModeFrontBack]) {
        temp.ModeFrontBack = 'ON'
      } else {
        temp.ModeFrontBack = 'OFF'
      }
      if (info[ModeAllTogether]) {
        temp.ModeAllTogether = 'ON'
      } else {
        temp.ModeAllTogether = 'OFF'
      }
      if (info[AlterModeOffOnWhileAllTogether]) {
        temp.AlterModeOffOnWhileAllTogether = 'ON'
      } else {
        temp.AlterModeOffOnWhileAllTogether = 'OFF'
      }
      if (info[StartStopModeOffOn]) {
        temp.StartStopModeOffOn = 'ON'
      } else {
        temp.StartStopModeOffOn = 'OFF'
      }
      if (info[bSaved]) {
        temp.bSaved = 'TRUE'
      } else {
        temp.bSaved = 'FALSE'
      }
      if (info[bBackUp]) {
        temp.bBackUp = 'ON'
      } else {
        temp.bBackUp = 'OFF'
      }
      if (info[bBackUp2]) {
        temp.bBackUp2 = 'ON'
      } else {
        temp.bBackUp2 = 'OFF'
      }
      if (info[i32BackUp]) {
        temp.i32BackUp = 'ON'
      } else {
        temp.i32BackUp = 'OFF'
      }
      if (info[i32BackUp2]) {
        temp.i32BackUp2 = 'ON'
      } else {
        temp.i32BackUp2 = 'OFF'
      }

      sMinordb.push(temp)

      this.sMinorData = sMinordb;

      console.log(this.sMinorData)
    },
    settDemagnetDelayTimeData() {
      let tDemagnetDelayTimedb = [];
      let info = this.stackerRecipe.info;
      for (let i = 0; i < 19; i++) {
        //存储电磁铁对应不同堆垛和DsOs时的延时时间
        let temp = {};
        for (let stacking = 0; stacking < 2; stacking++) {
          for (let DsOs = 0; DsOs < 2; DsOs++) {
            if (stacking == 0 & DsOs == 0) {
              let dmd00 = `tDemagnetDelayTime${stacking}_${DsOs}_${i}`;
              temp.dmd00 = info[dmd00];
            } else if (stacking == 0 & DsOs == 1) {
              let dmd01 = `tDemagnetDelayTime${stacking}_${DsOs}_${i}`;
              temp.dmd01 = info[dmd01];
            } else if (stacking == 1 & DsOs == 0) {
              let dmd10 = `tDemagnetDelayTime${stacking}_${DsOs}_${i}`;
              temp.dmd10 = info[dmd10];
            } else if (stacking == 1 & DsOs == 1) {
              let dmd11 = `tDemagnetDelayTime${stacking}_${DsOs}_${i}`;
              temp.dmd11 = info[dmd11];

            }
          }
        }
        temp.roller = `${i}号电磁铁`;
        tDemagnetDelayTimedb.push(temp);
      }
        this.tDemagnetDelayTimeData = tDemagnetDelayTimedb;
      console.log("tDemagnetDelayTimeData====>")
      console.log(this.tDemagnetDelayTimeData)

      let i32MagnetNumberImposedb = [];
      let temp = {};
      temp.roller="电铁号增量"
      temp.i32MagnetNumberImpose00=info.i32MagnetNumberImpose00;
      temp.i32MagnetNumberImpose01=info.i32MagnetNumberImpose01;
      temp.i32MagnetNumberImpose10=info.i32MagnetNumberImpose10;
      temp.i32MagnetNumberImpose11=info.i32MagnetNumberImpose11;
      i32MagnetNumberImposedb.push(temp);
      this.i32MagnetNumberImposeData=i32MagnetNumberImposedb;
      console.log("i32MagnetNumberImposeData====>")
      console.log(this.i32MagnetNumberImposeData)

      let bMagnetNumberImposedb = [];
      let temp1 = {};
      if (info.bMagnetSelected00){
        temp1.bMagnetSelected00='已选择'
      }else{
        temp1.bMagnetSelected00='未选择'
      }
      if (info.bMagnetSelected01){
        temp1.bMagnetSelected01='已选择'
      }else{
        temp1.bMagnetSelected01='未选择'
      }
      if (info.bMagnetSelected10){
        temp1.bMagnetSelected10='已选择'
      }else{
        temp1.bMagnetSelected10='未选择'
      }
      if (info.bMagnetSelected11){
        temp1.bMagnetSelected11='已选择'
      }else{
        temp1.bMagnetSelected11='未选择'
      }
      temp1.roller="电铁号选择"
      bMagnetNumberImposedb.push(temp1);
      this.bMagnetSelectedData=bMagnetNumberImposedb;
      console.log("bMagnetSelectedData====>")
      console.log(this.bMagnetSelectedData)
    },


    /** 查询配料表DB2003数据*/
    getEntrarecipe() {
      if (this.timer) {
        //分页后重新刷新页面之前清理timer
        clearInterval(this.timer)
        console.log("分页后重新刷新页面之前清理timer")
        this.getEntry()
      }
      this.timer = setInterval(() => {
        console.log("chaxun")
        this.getEntry()
      }, 600000)
    },
    getEntry() {
      getBasicDB03(this.queryParams).then(response => {
        console.log("getIngredientList===>")
        console.log(response);
        this.total = response.total;
        if (this.total == 0) {
          this.$message.error('未查询到相关配方数据')
          this.queryParams.strDataSetName=null;
          return
        }
        this.stackerRecipe = response.rows[0];
        this.setBoardData();
        this.setBeltData();
        this.setasGuideAndCartData();
        this.setasPileMinorData();
        this.setsMinorDataData();
        this.settDemagnetDelayTimeData();
        // this.basicList = response.rows;
        // this.total = response.total;
      });
    },
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getEntry();
    },
    resetQuery() {
      this.queryParams.die_DieName=null;
      this.resetForm("queryForm");
      this.getEntry();
    }
  },
}
</script>

<style scoped>
.app-container-1 {
  padding-top: 30px;
  padding-left: 20px;
  padding-right: 20px;
}


.el-table th > .cell {
  white-space: pre-wrap;
}

.pagination-popper {
  position: fixed;
}

</style>
