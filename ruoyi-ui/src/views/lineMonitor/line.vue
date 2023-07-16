<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-col :span="24">
        <router-link :to="`..`" style="margin: 5px;">
          <el-button type="primary" icon="el-icon-back" size="small">
            返回
          </el-button>
        </router-link>
        <div style="display: inline; font-size: 20px; vertical-align: middle; word-wrap: break-word; margin: 10px;">
          当前产线：{{ lineName }}（{{ lineIdentifier }}）
        </div>
      </el-col>
    </el-row>

    <div class="line-box">
      <el-scrollbar>
        <div>
          <el-image :src="require('@/assets/images/lineFrontView.png')"
                    fit="fill" style="height: 420px; width: 1660px;"></el-image>
          <div style="position: relative; top: -315px; left: 85px; height: 0; width: 0;">
            <el-button type="primary" @click="toUncoiler">开卷机</el-button>
          </div>
          <div style="position: relative; top: -150px; left: 315px; height: 0; width: 0;">
            <el-button type="primary" @click="toWasher">清洗机</el-button>
          </div>
          <div style="position: relative; top: -320px; left: 395px; height: 0; width: 0;">
            <el-button type="primary" @click="toLeveller">矫平机</el-button>
          </div>
          <div style="position: relative; top: -290px; left: 620px; height: 0; width: 0;">
            <el-button type="primary" @click="toRollFeed">定尺送料系统</el-button>
          </div>
          <div style="position: relative; top: -390px; left: 980px; height: 0; width: 0;">
            <el-button type="primary" @click="toPress">压机</el-button>
          </div>
          <div style="position: relative; top: -275px; left: 980px; height: 0; width: 0;">
            <el-button type="primary" @click="toSwingShear">摆剪</el-button>
          </div>
          <div style="position: relative; top: -330px; left: 1145px; height: 0; width: 0;">
            <el-button type="primary" @click="toStack(1)">堆垛#1</el-button>
          </div>
          <div style="position: relative; top: -330px; left: 1305px; height: 0; width: 0;">
            <el-button type="primary" @click="toStack(2)">堆垛#2</el-button>
          </div>
        </div>
      </el-scrollbar>
    </div>

    <el-divider></el-divider>

    <el-row>
      <el-col :lg="24" :md="24" class="card-box">
        <el-card shadow="hover" style="margin-bottom: 15px; height: 315px">
          <div slot="header" class="card-header">
            <span style="font-weight: bold">卷料信息</span>
            <el-button type="text" @click="toTop">返回</el-button>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%">
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">厚度(mm)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_Thickness }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">宽度(mm)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_Width }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">内径(mm)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_InternalDiameter }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">外径(mm)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_ExternalDiameter }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">原始长度(m)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_OriginalLength }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">剩余长度(m)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_ResidueLength }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">批号</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">*********</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">来源地</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">*********</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">重量(T)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_Weight }}</div>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>

      <el-col :lg="24" :md="24" class="card-box">
        <el-card shadow="hover" style="height: 460px">
          <div slot="header" class="card-header">
            <span style="font-weight: bold">生产任务信息</span>
            <el-button type="text" @click="toTop">返回</el-button>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%">
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">生产任务号</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_TaskNo }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">产品名称</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_ProductName }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">配方号</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_RecipeNo }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">实时线速度(m/min)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_RealtimeLineSpeed }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">实时冲压SPM</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_RealtimeStrokeTimes }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">定尺长度(mm)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_FeedLength }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">计划产量(张)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_PlanProduction }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">已完成数(张)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_CompletedQuantity }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">未完成数(张)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_UncompletedQuantity }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf" colspan="2">
                  <div class="cell bold">当前班组任务产量(张)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_PlanProduction_Currentteam }}</div>
                </td>
                <td class="el-table__cell is-leaf" colspan="2">
                  <div class="cell bold">当前班组实际产量(张)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_CompletedQuantity_Currentteam }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf" colspan="2">
                  <div class="cell bold">不良数(张)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_ScrapeQuantity }}</div>
                </td>
                <td class="el-table__cell is-leaf" colspan="2">
                  <div class="cell bold">当日加工量(张)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2000.info.lineInfo_DayQuantity }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf" colspan="3">
                  <div class="cell bold">当月加工量(张)</div>
                </td>
                <td class="el-table__cell is-leaf" colspan="3">
                  <div class="cell">******</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf" colspan="3">
                  <div class="cell bold">当年加工量(张)</div>
                </td>
                <td class="el-table__cell is-leaf" colspan="3">
                  <div class="cell">******</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf" colspan="3">
                  <div class="cell bold">...</div>
                </td>
                <td class="el-table__cell is-leaf" colspan="3">
                  <div class="cell">...</div>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <el-divider></el-divider>

    <el-row>
      <el-col :lg="9" :md="24" class="card-box" id="uncoiler">
        <el-card shadow="hover" style="margin-bottom: 15px; height: 380px">
          <div slot="header" class="card-header">
            <span style="font-weight: bold">开卷</span>
            <el-button type="text" @click="toTop">返回</el-button>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%">
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">材料厚度(mm)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.coilThickness }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">材料宽度(mm)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.coilWidth }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">卷外径(mm)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.coilExternalDiameter }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">实时卷径(mm)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.realtimeDiameter }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">待裁卷长(m)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.residueLength }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">待裁张数</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.residuePieces }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">开卷张力</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.tension }} %</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">转矩反馈</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.torqueFeedback }} %</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">CPC</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.cpcuseOrNot }}</div>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>

      <el-col :lg="15" :md="24" class="card-box" id="washer">
        <el-card shadow="hover" style="margin-bottom: 15px; height: 380px">
          <div slot="header" class="card-header">
            <span style="font-weight: bold">清洗机</span>
            <el-button type="text" @click="toTop">返回</el-button>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%; margin-bottom: 10px;">
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">使用与否</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.washerUseOrNot }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">在线与否</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.onlineOrOffline }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">运行状态</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.runningStatus }}</div>
                </td>
              </tr>
              </tbody>
            </table>
            <el-table :data="washerData" stripe>
              <el-table-column align="center" prop="roller"/>
              <el-table-column label="实时速度(m/min)" align="center" prop="realTimeSpeed"/>
              <el-table-column label="实时转矩" align="center" prop="realTimeTorque"/>
              <el-table-column label="母线电压(V)" align="center" prop="busVoltage"/>
              <el-table-column label="OS压力(kPa)" align="center" prop="OSPressure"/>
              <el-table-column label="DS压力(kPa)" align="center" prop="DSPressure"/>
            </el-table>
          </div>
        </el-card>
      </el-col>

      <el-col :lg="24" :sm="24" class="card-box" id="leveller">
        <el-card shadow="hover" style="margin-bottom: 15px; height: 415px">
          <div slot="header" class="card-header">
            <span style="font-weight: bold">校平</span>
            <el-button type="text" @click="toTop">返回</el-button>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%; margin-bottom: 10px;">
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf" colspan="2">
                  <div class="cell center bold">工作辊高度(mm)</div>
                </td>
                <td class="el-table__cell is-leaf" colspan="2">
                  <div class="cell center bold">侧导宽度(mm)</div>
                </td>
                <td class="el-table__cell is-leaf" colspan="2">
                  <div class="cell center bold">辊组类型</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell center bold">入侧</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell center bold">出侧</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell center bold">OS侧</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell center bold">DS侧</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell center bold">Φ40mm</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell center bold">Φ60mm</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell center">{{ DB2001.info.workRollHeightEntrance }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell center">{{ DB2001.info.workRollHeightExit }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell center">{{ DB2001.info.sideGuideWidthOS }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell center">{{ DB2001.info.sideGuideWidthDS
                    }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell center">{{ DB2001.info.rollSetType40mm }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell center">{{ DB2001.info.rollSetType60mm }}</div>
                </td>
              </tr>
              </tbody>
            </table>

            <el-table :data="levellerData" stripe>
              <el-table-column align="center" prop="name"/>
              <el-table-column label="实时速度(m/min)" align="center" prop="realTimeSpeed"/>
              <el-table-column label="实时转矩" align="center" prop="realTimeTorque"/>
              <el-table-column label="母线电压(V)" align="center" prop="busVoltage"/>
              <el-table-column label="实时电流(A)" align="center" prop="realTimeCurrent"/>
            </el-table>
          </div>
        </el-card>
      </el-col>

      <el-col :lg="24" :sm="24" class="card-box" id="rollFeed">
        <el-card shadow="hover" style="margin-bottom: 15px; height: 200px">
          <div slot="header" class="card-header">
            <span style="font-weight: bold">定尺送料</span>
            <el-button type="text" @click="toTop">返回</el-button>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%">
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">定尺设定值(mm)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.feedLengthSetValue }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">定尺辊压力(kPa)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.feedRollPressure }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">定尺实时值(mm)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.feedLengthPresentValue }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">定尺伺服故障</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{DB2001.info.feederUnitServoFaultCode}}</div>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>

      <el-col :lg="24" :sm="24" class="card-box" id="press">
        <el-card shadow="hover" style="margin-bottom: 15px; height: 315px">
          <div slot="header" class="card-header">
            <span style="font-weight: bold">压机</span>
            <el-button type="text" @click="toTop">返回</el-button>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%">
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">寿命计数</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.preLifeTimeCounter }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">实时SPM</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.preRealtimeStrokeTimes }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">保养状态提示</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.preMaintenanceToRemind }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">预调产量</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.preProductionPresetValue }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">剪床伺服故障</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.preServoFaultCode }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">实际产量</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.preProductionPresentValue }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">凸轮实时角度</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.preCamPresentValue }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">现模号</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.preCurrentDieName}}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">当前模高</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.preDieHeightPresentValue }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">次模号</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.preSecondDieName }}</div>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>

      <el-col :lg="24" :sm="24" class="card-box" id="swingShear">
        <el-card shadow="hover" style="margin-bottom: 15px; height: 250px">
          <div slot="header" class="card-header">
            <span style="font-weight: bold">摆剪</span>
            <el-button type="text" @click="toTop">返回</el-button>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%">
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">实时角度</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.osAnglePresentValue }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">摆动角度1</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.osAngle1SetValue }}</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">摆动角度2</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.osAngle2SetValue }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">OS侧长度(mm)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.osOSLengthCalculatedValue}}</div>
                </td>
                <td class="el-table__cell is-leaf" rowspan="2">
                  <div class="cell bold" style="margin-left: 10px;">摆剪伺服故障</div>
                </td>
                <td class="el-table__cell is-leaf" rowspan="2" colspan="3">
                  <div class="cell">{{ DB2001.info.osServoFaultCode }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">DS侧长度(mm)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.osDSLengthCalculatedValue }}</div>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>

      <el-col :lg="12" :sm="24" class="card-box" id="stack1">
        <el-card shadow="hover" style="margin-bottom: 15px; height: 200px">
          <div slot="header" class="card-header">
            <span style="font-weight: bold">堆垛#1</span>
            <el-button type="text" @click="toTop">返回</el-button>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%">
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">设定数量(张)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.s1ProductionSetValue }}</div>
                </td>
                <td class="el-table__cell is-leaf" rowspan="2">
                  <div class="cell bold" style="margin-left: 10px;">配方号</div>
                </td>
                <td class="el-table__cell is-leaf" rowspan="2">
                  <div class="cell">{{ DB2001.info.s1RecipeNo }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">实际数量(张)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.s1ProductionActualValue }}</div>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>

      <el-col :lg="12" :sm="24" class="card-box" id="stack2">
        <el-card shadow="hover" style="margin-bottom: 15px; height: 200px">
          <div slot="header" class="card-header">
            <span style="font-weight: bold">堆垛#2</span>
            <el-button type="text" @click="toTop">返回</el-button>
          </div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <table cellspacing="0" style="width: 100%">
              <tbody>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">设定数量(张)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.s2ProductionSetValue }}</div>
                </td>
                <td class="el-table__cell is-leaf" rowspan="2">
                  <div class="cell bold" style="margin-left: 10px;">配方号</div>
                </td>
                <td class="el-table__cell is-leaf" rowspan="2">
                  <div class="cell">{{ DB2001.info.s2RecipeNo }}</div>
                </td>
              </tr>
              <tr>
                <td class="el-table__cell is-leaf">
                  <div class="cell bold">实际数量(张)</div>
                </td>
                <td class="el-table__cell is-leaf">
                  <div class="cell">{{ DB2001.info.s2ProductionActualValue }}</div>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import {
  listBasic,
  getBasicDB00,
  getBasicDB01,
  getBasic,
  delBasic,
  addBasic,
  updateBasic,
  exportBasic
} from "@/api/lineInfo/basic";

export default {
  name: "LineDiagram",
  data() {
    return {
      //测试：卷料厚度
      DB2000: {
        info: {
          lineInfo_Thickness: 0,
          lineInfo_Width: 0,
          lineInfo_InternalDiameter: 0,
          lineInfo_ExternalDiameter: 0,
          lineInfo_OriginalLength: 0,
          lineInfo_ResidueLength: 0,
          lineInfo_Weight: 0,
          lineInfo_TaskNo: '',
          lineInfo_ProductName: '',
          lineInfo_RecipeNo: 0,
          lineInfo_RealtimeLineSpeed: 0,
          lineInfo_RealtimeStrokeTimes: 0,
          lineInfo_FeedLength: 0,
          lineInfo_PlanProduction: 0,
          lineInfo_CompletedQuantity: 0,
          lineInfo_UncompletedQuantity: 0,
          lineInfo_PlanProduction_Currentteam: 0,
          lineInfo_CompletedQuantity_Currentteam: 0,
          lineInfo_ScrapeQuantity: 0,
          lineInfo_DayQuantity: 0,
        }
      },
      DB2001: {
        info: {
          coilThickness: 0,
          coilWidth: 0,
          coilExternalDiameter: 0,
          realtimeDiameter: 0,
          residueLength: 0,
          residuePieces: 0,
          tension: 0,
          torqueFeedback: 0,
          cpcuseOrNot: false,
          washerUseOrNot: false,
          onlineOrOffline: false,
          runningStatus: false,

          // 校平
          workRollHeightEntrance:0,
          workRollHeightExit:0,
          sideGuideWidthDS:0,
          sideGuideWidthOS:0,
          rollSetType40mm:0,
          rollSetType60mm:0,

          // 定尺送料
          feedLengthPresentValue:0,
          feedLengthSetValue:0,
          feedRollPressure:0,
          feederUnitServoFaultCode:0,
          //压力机
          preLifeTimeCounter:0,
          preRealtimeStrokeTimes:0,
          preMaintenanceToRemind:false,
          preProductionPresetValue:0,
          preServoFaultCode:0,
          preProductionPresentValue:0,
          preCamPresentValue:0,
          preCurrentDieName:'',
          preDieHeightPresentValue:0,
          preSecondDieName:'',
          //摆剪
          osAngle1SetValue:0,
          osAngle2SetValue:0,
          osAnglePresentValue:0,
          osDSLengthCalculatedValue:0,
          osOSLengthCalculatedValue:0,
          osServoFaultCode:0,
          //堆垛1
          s1ProductionActualValue:0,
          s1ProductionSetValue:0,
          s1RecipeNo:0,
          //堆垛2
          s2ProductionActualValue:0,
          s2ProductionSetValue:0,
          s2RecipeNo:0,

        }
      },
      lineId: this.$route && this.$route.params.id,
      lineName: '',
      lineIdentifier: '',
      washerData: [
        {
          roller: '刷辊',
          realTimeSpeed: '*.**',
          realTimeTorque: '/',
          busVoltage: '/',
          OSPressure: '/',
          DSPressure: '/'
        },
        {
          roller: '夹送辊',
          realTimeSpeed: '*.**',
          realTimeTorque: '** %',
          busVoltage: '***',
          OSPressure: '/',
          DSPressure: '/'
        },
        {
          roller: '1#挤干辊',
          realTimeSpeed: '*.**',
          realTimeTorque: '** %',
          busVoltage: '***',
          OSPressure: '****',
          DSPressure: '****'
        },
        {
          roller: '2#挤干辊',
          realTimeSpeed: '*.**',
          realTimeTorque: '** %',
          busVoltage: '***',
          OSPressure: '****',
          DSPressure: '****'
        },
      ],
      levellerData: [
        {
          name: '入侧夹送',
          realTimeSpeed: '*.**',
          realTimeTorque: '** %',
          busVoltage: '***',
          realTimeCurrent: '***'
        },
        {
          name: '整平机',
          realTimeSpeed: '*.**',
          realTimeTorque: '** %',
          busVoltage: '***',
          realTimeCurrent: '***'
        },
        {
          name: '出侧夹送',
          realTimeSpeed: '*.**',
          realTimeTorque: '** %',
          busVoltage: '***',
          realTimeCurrent: '***'
        }
      ]
    }
  },
  created() {
    this.getLineInfo();

  },
  mounted() {
    this.getDB2000();
    this.getDB2001();
  },
  methods: {
    //测试 获取卷料厚度
    getDB2000() {
      getBasicDB00().then(response => {
        console.log("DB2000信息==>")
        console.log(response)
        this.DB2000 = response.rows[0]
        // console.log(this.DB2000)
        // this.Thickness=response.data
      })
    },
    getDB2001() {
      getBasicDB01().then(response => {
        console.log("DB2001信息==>")
        console.log(response)
        this.DB2001 = response.rows[0]
        this.washerData = [
          {
            roller: '刷辊',
            realTimeSpeed: response.rows[0].info.brushRollStatusRealtimeSpeed,
            realTimeTorque: '/',
            busVoltage: '/',
            OSPressure: '/',
            DSPressure: '/'
          },
          {
            roller: '夹送辊',
            realTimeSpeed: response.rows[0].info.pinchRollStatusRealtimeSpeed,
            realTimeTorque: response.rows[0].info.pinchRollStatusRealtimeTorque+'%',
            busVoltage: response.rows[0].info.pinchRollStatusDCVoltage,
            OSPressure: '/',
            DSPressure: '/'
          },
          {
            roller: '1#挤干辊',
            realTimeSpeed:  response.rows[0].info.wringerRoll1StatusRealtimeSpeed,
            realTimeTorque: response.rows[0].info.wringerRoll1StatusRealtimeTorque+'%',
            busVoltage: response.rows[0].info.wringerRoll1StatusDCVoltage,
            OSPressure: response.rows[0].info.wringerRoll1StatusPressureOS,
            DSPressure: response.rows[0].info.wringerRoll1StatusPressureDS
          },
          {
            roller: '2#挤干辊',
            realTimeSpeed:  response.rows[0].info.wringerRoll2StatusRealtimeSpeed,
            realTimeTorque: response.rows[0].info.wringerRoll2StatusRealtimeTorque+'%',
            busVoltage: response.rows[0].info.wringerRoll2StatusDCVoltage,
            OSPressure: response.rows[0].info.wringerRoll2StatusPressureOS,
            DSPressure: response.rows[0].info.wringerRoll2StatusPressureDS
          },
        ]
        this.levellerData=[
          {
            name: '入侧夹送',
            realTimeSpeed: response.rows[0].info.ePRealtimeSpeed,
            realTimeTorque: response.rows[0].info.ePRealtimeTorque+'%',
            busVoltage: response.rows[0].info.epDCVoltage,
            realTimeCurrent: response.rows[0].info.epRealtimeCurrent
          },
          {
            name: '整平机',
            realTimeSpeed: response.rows[0].info.exRealtimeSpeed,
            realTimeTorque:response.rows[0].info.exRealtimeTorque+'%',
            busVoltage: response.rows[0].info.exDCVoltage,
            realTimeCurrent: response.rows[0].info.exRealtimeCurrent
          },
          {
            name: '出侧夹送',
            realTimeSpeed: response.rows[0].info.ePRealtimeSpeed,
            realTimeTorque: response.rows[0].info.frRealtimeTorque+'%',
            busVoltage: response.rows[0].info.frDCVoltage,
            realTimeCurrent: response.rows[0].info.frRealtimeCurrent
          }
        ]
      })
    },

    getLineInfo() {
      getBasic(this.lineId).then(response => {
        this.lineName = response.data.lineName;
        this.lineIdentifier = response.data.lineIdentifier;
      });
    },
    toTop() {
      this.$nextTick(() => {
        let element = document.getElementById('app');
        element.scrollIntoView({behavior: 'smooth'});
      });
    },
    toUncoiler() {
      this.$nextTick(() => {
        let element = document.getElementById('uncoiler');
        element.scrollIntoView({behavior: 'smooth'});
        setTimeout(function () {
          element.firstElementChild.style.border = '5px solid #409EFF';
          setTimeout(function () {
            element.firstElementChild.style.border = '2px solid #DCDFE6';
          }, 800);
        }, 500);
      });
    },
    toWasher() {
      this.$nextTick(() => {
        let element = document.getElementById('washer');
        element.scrollIntoView({behavior: 'smooth'});
        setTimeout(function () {
          element.firstElementChild.style.border = '5px solid #409EFF';
          setTimeout(function () {
            element.firstElementChild.style.border = '2px solid #DCDFE6';
          }, 800);
        }, 500);
      });
    },
    toLeveller() {
      this.$nextTick(() => {
        let element = document.getElementById('leveller');
        element.scrollIntoView({behavior: 'smooth'});
        setTimeout(function () {
          element.firstElementChild.style.border = '5px solid #409EFF';
          setTimeout(function () {
            element.firstElementChild.style.border = '2px solid #DCDFE6';
          }, 800);
        }, 700);
      });
    },
    toRollFeed() {
      this.$nextTick(() => {
        let element = document.getElementById('rollFeed');
        element.scrollIntoView({behavior: 'smooth'});
        setTimeout(function () {
          element.firstElementChild.style.border = '5px solid #409EFF';
          setTimeout(function () {
            element.firstElementChild.style.border = '2px solid #DCDFE6';
          }, 800);
        }, 800);
      });
    },
    toPress() {
      this.$nextTick(() => {
        let element = document.getElementById('press');
        element.scrollIntoView({behavior: 'smooth'});
        setTimeout(function () {
          element.firstElementChild.style.border = '5px solid #409EFF';
          setTimeout(function () {
            element.firstElementChild.style.border = '2px solid #DCDFE6';
          }, 800);
        }, 900);
      });
    },
    toSwingShear() {
      this.$nextTick(() => {
        let element = document.getElementById('swingShear');
        element.scrollIntoView({behavior: 'smooth'});
        setTimeout(function () {
          element.firstElementChild.style.border = '5px solid #409EFF';
          setTimeout(function () {
            element.firstElementChild.style.border = '2px solid #DCDFE6';
          }, 800);
        }, 1000);
      });
    },
    toStack(number) {
      this.$nextTick(() => {
        let id = 'stack' + number;
        let element = document.getElementById(id);
        element.scrollIntoView({behavior: 'smooth'});
        setTimeout(function () {
          element.firstElementChild.style.border = '5px solid #409EFF';
          setTimeout(function () {
            element.firstElementChild.style.border = '2px solid #DCDFE6';
          }, 800);
        }, 1000);
      });
    },
  }
}
</script>

<style scoped>
.line-box {
  height: 475px;
  width: 100%;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.el-card {
  border: 2px solid #DCDFE6;
}

.el-card >>> .el-card__header {
  border-bottom: 2px solid #DCDFE6;
}

@media screen and (max-width: 991px) {
  .el-card {
    height: auto !important;
  }
}

.el-form >>> .el-form--inline {
  display: flex;
  align-items: center;
}

.bold {
  font-weight: bold;
}

.center {
  text-align: center;
}
</style>
