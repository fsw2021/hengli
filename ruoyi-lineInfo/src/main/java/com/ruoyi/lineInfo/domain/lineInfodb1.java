package com.ruoyi.lineInfo.domain;

import org.springframework.data.mongodb.core.mapping.Field;

public class lineInfodb1 {

    /**
     * 材料厚度(mm)
     */
    @Field("UnitInfo_UncoilUnit_CoilThickness")
    private int CoilThickness;
    /**
     * 材料宽度(mm)
     */
    @Field("UnitInfo_UncoilUnit_CoilWidth")
    private int CoilWidth;
    /**
     * 卷外径(mm)
     */
    @Field("UnitInfo_UncoilUnit_CoilExternalDiameter")
    private int CoilExternalDiameter;
    /**
     * 实时卷径(mm)
     */
    @Field("UnitInfo_UncoilUnit_RealtimeDiameter")
    private int RealtimeDiameter;
    /**
     * 待裁卷长(m)
     */
    @Field("UnitInfo_UncoilUnit_ResidueLength")
    private int ResidueLength;
    /**
     * 待裁张数
     */
    @Field("UnitInfo_UncoilUnit_ResiduePieces")
    private int ResiduePieces;
    /**
     * 开卷张力
     */
    @Field("UnitInfo_UncoilUnit_Tension")
    private int Tension;
    /**
     * 转矩反馈
     */
    @Field("UnitInfo_UncoilUnit_TorqueFeedback")
    private int TorqueFeedback;
    /**
     * CPC : 1 or 0
     */
    @Field("UnitInfo_UncoilUnit_CPCUseOrNot")
    private boolean CPCUseOrNot;
    /**
     * 清洗剂使用与否
     */
    @Field("UnitInfo_WasherUnit_WasherUseOrNot")
    private boolean WasherUseOrNot;
    /**
     * 清洗剂在线与否
     */
    @Field("UnitInfo_WasherUnit_OnlineOrOffline")
    private boolean OnlineOrOffline;
    /**
     * 清洗剂运行与否
     */
    @Field("UnitInfo_WasherUnit_RunningStatus")
    private boolean RunningStatus;
    /**
     * 夹送辊 实时速度 000.00m/min
     */
    @Field("UnitInfo_WasherUnit_PinchRollStatus_RealtimeSpeed")
    private int PinchRollStatusRealtimeSpeed;
    /**
     * 夹送辊 实时转矩 000%
     */
    @Field("UnitInfo_WasherUnit_PinchRollStatus_RealtimeTorque")
    private int pinchRollStatusRealtimeTorque;
    /**
     * 夹送辊 母线电压 000V
     */
    @Field("UnitInfo_WasherUnit_PinchRollStatus_DCVoltage")
    private int pinchRollStatusDCVoltage;
    /**
     * 刷辊 刷辊实时速度 000.00m/min
     */
    @Field("UnitInfo_WasherUnit_BrushRollStatus_RealtimeSpeed")
    private int brushRollStatusRealtimeSpeed;
    /**
     * 1#挤干辊实时速度 000.00m/min
     */
    @Field("UnitInfo_WasherUnit_WringerRoll1Status_RealtimeSpeed")
    private int wringerRoll1StatusRealtimeSpeed;
    /**
     * 1#挤干辊实时转矩 000%
     */
    @Field("UnitInfo_WasherUnit_WringerRoll1Status_RealtimeTorque")
    private int wringerRoll1StatusRealtimeTorque;
    /**
     * 1#挤干辊母线电压 000V
     */
    @Field("UnitInfo_WasherUnit_WringerRoll1Status_DCVoltage")
    private int wringerRoll1StatusDCVoltage;
    /**
     * 1#挤干辊 OS 侧压力 0000KPa
     */
    @Field("UnitInfo_WasherUnit_WringerRoll1Status_PressureOS")
    private int wringerRoll1StatusPressureOS;
    /**
     * 1#挤干辊 DS 侧压力 0000KPa
     */
    @Field("UnitInfo_WasherUnit_WringerRoll1Status_PressureDS")
    private int wringerRoll1StatusPressureDS;

    /**
     * 2#挤干辊实时速度 000.00m/min
     */
    @Field("UnitInfo_WasherUnit_WringerRoll2Status_RealtimeSpeed")
    private int wringerRoll2StatusRealtimeSpeed;
    /**
     * 2#挤干辊实时转矩 000%
     */
    @Field("UnitInfo_WasherUnit_WringerRoll2Status_RealtimeTorque")
    private int wringerRoll2StatusRealtimeTorque;
    /**
     * 2#挤干辊母线电压 000V
     */
    @Field("UnitInfo_WasherUnit_WringerRoll2Status_DCVoltage")
    private int wringerRoll2StatusDCVoltage;
    /**
     * 2#挤干辊 OS 侧压力 0000KPa
     */
    @Field("UnitInfo_WasherUnit_WringerRoll2Status_PressureOS")
    private int wringerRoll2StatusPressureOS;
    /**
     * 2#挤干辊 DS 侧压力 0000KPa
     */
    @Field("UnitInfo_WasherUnit_WringerRoll2Status_PressureDS")
    private int wringerRoll2StatusPressureDS;

    /**
     * 校平单元
     */
    @Field("UnitInfo_FlattenerUnit_WorkRollHeight_Entrance")
    private int workRollHeightEntrance;
    @Field("UnitInfo_FlattenerUnit_WorkRollHeight_Exit")
    private int workRollHeightExit;
    @Field("UnitInfo_FlattenerUnit_SideGuideWidth_OS")
    private int sideGuideWidthOS;
    @Field("UnitInfo_FlattenerUnit_SideGuideWidth_DS")
    private int sideGuideWidthDS;
    @Field("UnitInfo_FlattenerUnit_RollSetType_40mm")
    private boolean rollSetType40mm;
    @Field("UnitInfo_FlattenerUnit_RollSetType_60mm")
    private boolean rollSetType60mm;

    @Field("UnitInfo_FlattenerUnit_EntrancePinchStatus_RealtimeSpeed")
    private int ePRealtimeSpeed;
    @Field("UnitInfo_FlattenerUnit_EntrancePinchStatus_RealtimeTorque")
    private int ePRealtimeTorque;
    @Field("UnitInfo_FlattenerUnit_EntrancePinchStatus_DCVoltage")
    private int epDCVoltage;
    @Field("UnitInfo_FlattenerUnit_EntrancePinchStatus_RealtimeCurrent")
    private int epRealtimeCurrent;
    @Field("UnitInfo_FlattenerUnit_FlattenRollStatus_RealtimeSpeed")
    private int frRealtimeSpeed;
    @Field("UnitInfo_FlattenerUnit_FlattenRollStatus_RealtimeTorque")
    private int frRealtimeTorque;
    @Field("UnitInfo_FlattenerUnit_FlattenRollStatus_DCVoltage")
    private int frDCVoltage;
    @Field("UnitInfo_FlattenerUnit_FlattenRollStatus_RealtimeCurrent")
    private int frRealtimeCurrent;
    @Field("UnitInfo_FlattenerUnit_ExitPinchStatus_RealtimeSpeed")
    private int exRealtimeSpeed;
    @Field("UnitInfo_FlattenerUnit_ExitPinchStatus_RealtimeTorque")
    private int exRealtimeTorque;
    @Field("UnitInfo_FlattenerUnit_ExitPinchStatus_DCVoltage")
    private int exDCVoltage;
    @Field("UnitInfo_FlattenerUnit_ExitPinchStatus_RealtimeCurrent")
    private int exRealtimeCurrent;

    /**
     * 定尺送料信息
     */
    @Field("UnitInfo_FeederUnit_FeedLengthSetValue")
    private int feedLengthSetValue;
    @Field("UnitInfo_FeederUnit_FeedLengthPresentValue")
    private int feedLengthPresentValue;
    @Field("UnitInfo_FeederUnit_FeedRollPressure")
    private int feedRollPressure;
    @Field("UnitInfo_FeederUnit_ServoFaultCode")
    private int feederUnitServoFaultCode;


    @Field("UnitInfo_PressUnit_LifeTimeCounter")
    private int preLifeTimeCounter;
    @Field("UnitInfo_PressUnit_RealtimeStrokeTimes")
    private int preRealtimeStrokeTimes;
    @Field("UnitInfo_PressUnit_CamPresentValue")
    private int preCamPresentValue;
    @Field("UnitInfo_PressUnit_DieHeightPresentValue")
    private int preDieHeightPresentValue;
    @Field("UnitInfo_PressUnit_ProductionPresetValue")
    private int preProductionPresetValue;
    @Field("UnitInfo_PressUnit_ProductionPresentValue")
    private int preProductionPresentValue;
    @Field("UnitInfo_PressUnit_CurrentDieName")
    private String preCurrentDieName;
    @Field("UnitInfo_PressUnit_SecondDieName")
    private String preSecondDieName;
    @Field("UnitInfo_PressUnit_ServoFaultCode")
    private int preServoFaultCode;
    @Field("UnitInfo_PressUnit_MaintenanceToRemind")
    private boolean preMaintenanceToRemind;

    //摆剪
    @Field("UnitInfo_OscillateShearUnit_AnglePresentValue")
    private int osAnglePresentValue;
    @Field("UnitInfo_OscillateShearUnit_Angle1SetValue")
    private int osAngle1SetValue;
    @Field("UnitInfo_OscillateShearUnit_Angle2SetValue")
    private int osAngle2SetValue;
    @Field("UnitInfo_OscillateShearUnit_OSLengthCalculatedValue")
    private int osOSLengthCalculatedValue;
    @Field("UnitInfo_OscillateShearUnit_DSLengthCalculatedValue")
    private int osDSLengthCalculatedValue;
    @Field("UnitInfo_OscillateShearUnit_ServoFaultCode")
    private int osServoFaultCode;

    /**
     * 堆垛1
     */
    @Field("UnitInfo_Stack1Unit_ProductionSetValue")
    private int s1ProductionSetValue;
    @Field("UnitInfo_Stack1Unit_ProductionActualValue")
    private int s1ProductionActualValue;
    @Field("UnitInfo_Stack1Unit_RecipeNo")
    private int s1RecipeNo;
    /**
     * 堆垛2
     */
    @Field("UnitInfo_Stack2Unit_ProductionSetValue")
    private int s2ProductionSetValue;
    @Field("UnitInfo_Stack2Unit_ProductionActualValue")
    private int s2ProductionActualValue;
    @Field("UnitInfo_Stack2Unit_RecipeNo")
    private int s2RecipeNo;

    public int getCoilThickness() {
        return CoilThickness;
    }

    public int getCoilWidth() {
        return CoilWidth;
    }

    public int getCoilExternalDiameter() {
        return CoilExternalDiameter;
    }

    public int getRealtimeDiameter() {
        return RealtimeDiameter;
    }

    public int getResidueLength() {
        return ResidueLength;
    }

    public int getResiduePieces() {
        return ResiduePieces;
    }

    public int getTension() {
        return Tension;
    }

    public int getTorqueFeedback() {
        return TorqueFeedback;
    }

    public boolean isCPCUseOrNot() {
        return CPCUseOrNot;
    }

    public boolean isWasherUseOrNot() {
        return WasherUseOrNot;
    }

    public boolean isOnlineOrOffline() {
        return OnlineOrOffline;
    }

    public boolean isRunningStatus() {
        return RunningStatus;
    }

    public int getPinchRollStatusRealtimeSpeed() {
        return PinchRollStatusRealtimeSpeed;
    }

    public int getPinchRollStatusRealtimeTorque() {
        return pinchRollStatusRealtimeTorque;
    }

    public int getPinchRollStatusDCVoltage() {
        return pinchRollStatusDCVoltage;
    }

    public int getBrushRollStatusRealtimeSpeed() {
        return brushRollStatusRealtimeSpeed;
    }

    public int getWringerRoll1StatusRealtimeSpeed() {
        return wringerRoll1StatusRealtimeSpeed;
    }

    public int getWringerRoll1StatusRealtimeTorque() {
        return wringerRoll1StatusRealtimeTorque;
    }

    public int getWringerRoll1StatusDCVoltage() {
        return wringerRoll1StatusDCVoltage;
    }

    public int getWringerRoll1StatusPressureOS() {
        return wringerRoll1StatusPressureOS;
    }

    public int getWringerRoll1StatusPressureDS() {
        return wringerRoll1StatusPressureDS;
    }

    public int getWringerRoll2StatusRealtimeSpeed() {
        return wringerRoll2StatusRealtimeSpeed;
    }

    public int getWringerRoll2StatusRealtimeTorque() {
        return wringerRoll2StatusRealtimeTorque;
    }

    public int getWringerRoll2StatusDCVoltage() {
        return wringerRoll2StatusDCVoltage;
    }

    public int getWringerRoll2StatusPressureOS() {
        return wringerRoll2StatusPressureOS;
    }

    public int getWringerRoll2StatusPressureDS() {
        return wringerRoll2StatusPressureDS;
    }

    public int getWorkRollHeightEntrance() {
        return workRollHeightEntrance;
    }

    public int getWorkRollHeightExit() {
        return workRollHeightExit;
    }

    public int getSideGuideWidthOS() {
        return sideGuideWidthOS;
    }

    public int getSideGuideWidthDS() {
        return sideGuideWidthDS;
    }

    public boolean isRollSetType40mm() {
        return rollSetType40mm;
    }

    public boolean isRollSetType60mm() {
        return rollSetType60mm;
    }

    public int getePRealtimeSpeed() {
        return ePRealtimeSpeed;
    }

    public int getePRealtimeTorque() {
        return ePRealtimeTorque;
    }

    public int getEpDCVoltage() {
        return epDCVoltage;
    }

    public int getEpRealtimeCurrent() {
        return epRealtimeCurrent;
    }

    public int getFrRealtimeSpeed() {
        return frRealtimeSpeed;
    }

    public int getFrRealtimeTorque() {
        return frRealtimeTorque;
    }

    public int getFrDCVoltage() {
        return frDCVoltage;
    }

    public int getFrRealtimeCurrent() {
        return frRealtimeCurrent;
    }

    public int getExRealtimeSpeed() {
        return exRealtimeSpeed;
    }

    public int getExRealtimeTorque() {
        return exRealtimeTorque;
    }

    public int getExDCVoltage() {
        return exDCVoltage;
    }

    public int getExRealtimeCurrent() {
        return exRealtimeCurrent;
    }

    public int getFeedLengthSetValue() {
        return feedLengthSetValue;
    }

    public int getFeedLengthPresentValue() {
        return feedLengthPresentValue;
    }

    public int getFeedRollPressure() {
        return feedRollPressure;
    }

    public int getFeederUnitServoFaultCode() {
        return feederUnitServoFaultCode;
    }

    public int getPreLifeTimeCounter() {
        return preLifeTimeCounter;
    }

    public int getPreRealtimeStrokeTimes() {
        return preRealtimeStrokeTimes;
    }

    public int getPreCamPresentValue() {
        return preCamPresentValue;
    }

    public int getPreDieHeightPresentValue() {
        return preDieHeightPresentValue;
    }

    public int getPreProductionPresetValue() {
        return preProductionPresetValue;
    }

    public int getPreProductionPresentValue() {
        return preProductionPresentValue;
    }

    public String getPreCurrentDieName() {
        return preCurrentDieName;
    }

    public String getPreSecondDieName() {
        return preSecondDieName;
    }

    public int getPreServoFaultCode() {
        return preServoFaultCode;
    }

    public boolean isPreMaintenanceToRemind() {
        return preMaintenanceToRemind;
    }

    public int getOsAnglePresentValue() {
        return osAnglePresentValue;
    }

    public int getOsAngle1SetValue() {
        return osAngle1SetValue;
    }

    public int getOsAngle2SetValue() {
        return osAngle2SetValue;
    }

    public int getOsOSLengthCalculatedValue() {
        return osOSLengthCalculatedValue;
    }

    public int getOsDSLengthCalculatedValue() {
        return osDSLengthCalculatedValue;
    }

    public int getOsServoFaultCode() {
        return osServoFaultCode;
    }

    public int getS1ProductionSetValue() {
        return s1ProductionSetValue;
    }

    public int getS1ProductionActualValue() {
        return s1ProductionActualValue;
    }

    public int getS1RecipeNo() {
        return s1RecipeNo;
    }

    public int getS2ProductionSetValue() {
        return s2ProductionSetValue;
    }

    public int getS2ProductionActualValue() {
        return s2ProductionActualValue;
    }

    public int getS2RecipeNo() {
        return s2RecipeNo;
    }
}