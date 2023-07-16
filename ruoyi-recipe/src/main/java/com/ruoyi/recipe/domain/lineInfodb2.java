package com.ruoyi.recipe.domain;

import org.springframework.data.mongodb.core.mapping.Field;

public class lineInfodb2 {
    @Field("arsEntraRecipe_strDataSetName")
    private String erstrDataSetName;

    @Field("arsEntraRecipe_i32MaterialDiameter")
    private int erMaterialDiameter;

    @Field("arsEntraRecipe_i32MaterialWidth")
    private int erMaterialWidth;

    @Field("arsEntraRecipe_i32MaterialThickness")
    private int erMaterialThickness;

    @Field("arsEntraRecipe_bMaterialMiniDiameter")
    private boolean erMaterialMiniDiameter;

    /**
     * 挤干辊属性
     */
    @Field("arsEntraRecipe_i32WasherWringRollN1DsPressure")
    private int washerWringRollN1DsPressure;
    @Field("arsEntraRecipe_i32WasherWringRollN1OsPressure")
    private int washerWringRollN1OsPressure;
    @Field("arsEntraRecipe_i32WasherWringRollN2DsPressure")
    private int washerWringRollN2DsPressure;
    @Field("arsEntraRecipe_i32WasherWringRollN2OsPressure")
    private int washerWringRollN2OsPressure;

    /**
     * 送料信息第一行
     */
    @Field("arsEntraRecipe_i32FeedGuideEntryDsPosition")
    private int erFeedGuideEntryDsPosition;
    @Field("arsEntraRecipe_i32FeedGuideExitDsPosition")
    private int erFeedGuideExitDsPosition;
    @Field("arsEntraRecipe_i32EndFeedGuideWidth")
    private int erEndFeedGuideWidth;
    @Field("arsEntraRecipe_i32FeedTableHeight")
    private int erFeedTableHeight;
    /**
     * 送料信息第二行
     */
    @Field("arsEntraRecipe_i32FeedGuideEntryOsPosition")
    private int erFeedGuideEntryOsPosition;
    @Field("arsEntraRecipe_i32FeedGuideExitOsPosition")
    private int erFeedGuideExitOsPosition;
    @Field("arsEntraRecipe_i32FeedLength")
    private int eri32FeedLength;
    @Field("arsEntraRecipe_i32FeedVelocity")
    private int eri32FeedVelocity;
    /**
     * 送料信息第三行
     */
    @Field("arsEntraRecipe_i32FeedAcc")
    private int eri32FeedAcc;
    @Field("arsEntraRecipe_i32FeedDec")
    private int eri32FeedDec;
    @Field("arsEntraRecipe_i32FeedRollDsPressure")
    private int eri32FeedRollDsPressure;
    @Field("arsEntraRecipe_i32FeedRollOsPressure")
    private int eri32FeedRollOsPressure;

    /**
     * 送料信息第四行
     */
    @Field("arsEntraRecipe_i32FeedJerk")
    private int eri32FeedJerk;
    @Field("arsEntraRecipe_i32FeedTableLength")
    private int eri32FeedTableLength;
    @Field("arsEntraRecipe_i32EndFeedLengthImpose")
    private int eri32EndFeedLengthImpose;
    @Field("arsEntraRecipe_bCloseLoopMode")
    private boolean erbCloseLoopMode;

    /**
     * 摆剪信息
     */
    @Field("arsEntraRecipe_bRotaryCutterUsed")
    private boolean erbRotaryCutterUsed;
    @Field("arsEntraRecipe_i32RotaryCutterLeftPosition")
    private int eri32RotaryCutterLeftPosition;
    @Field("arsEntraRecipe_i32RotaryCutterRightPosition")
    private int eri32RotaryCutterRightPosition;
    @Field("arsEntraRecipe_i32RotaryCutterBeltVelocity")
    private int eri32RotaryCutterBeltVelocity;

    /**
     * 出侧皮带参数
     */
    @Field("arsEntraRecipe_i32ExitBeltVelocity")
    private int eri32ExitBeltVelocity;
    @Field("arsEntraRecipe_i32ExitBeltPosition")
    private int eri32ExitBeltPosition;
    @Field("arsEntraRecipe_i32ExitBeltHeight")
    private int eri32ExitBeltHeight;
    @Field("arsEntraRecipe_tBeltDelay")
    private int ertBeltDelay;
    /**
     * 交平以及产量
     */
    @Field("arsEntraRecipe_i32WorkRollEntryPosition")
    private int eri32WorkRollEntryPosition;
    @Field("arsEntraRecipe_i32WorkRollExitPosition")
    private int eri32WorkRollExitPosition;
    @Field("arsEntraRecipe_i32FlattenGuidePosition")
    private int eri32FlattenGuidePosition;
    @Field("arsEntraRecipe_i32Count")
    private int eri32Count;


    @Field("arsEntraRecipe_bCpcUsed")
    private boolean erbCpcUsed;
    @Field("arsEntraRecipe_bUncoilModeUpDown")
    private boolean erbUncoilModeUpDown;
    @Field("arsEntraRecipe_i32TrayMaterialTableAngle")
    private int eri32TrayMaterialTableAngle;
    @Field("arsEntraRecipe_i32TrayMaterialTablePosition")
    private int eri32TrayMaterialTablePosition;
    @Field("arsEntraRecipe_i32FreeRollPosition")
    private int eri32FreeRollPosition;
    @Field("arsEntraRecipe_i32materialUsedTensionPercent")
    private int eri32materialUsedTensionPercent;
    @Field("arsEntraRecipe_i32WasteCutterLength")
    private int eri32WasteCutterLength;
    @Field("arsEntraRecipe_i32WasteCutterCount")
    private int eri32WasteCutterCount;
    @Field("arsEntraRecipe_bWasherUsed")
    private boolean erbWasherUsed;
    @Field("arsEntraRecipe_bSidePilerUsed")
    private boolean erbSidePilerUsed;

    public boolean isErbCpcUsed() {
        return erbCpcUsed;
    }

    public boolean isErbUncoilModeUpDown() {
        return erbUncoilModeUpDown;
    }

    public int getEri32TrayMaterialTableAngle() {
        return eri32TrayMaterialTableAngle;
    }

    public int getEri32TrayMaterialTablePosition() {
        return eri32TrayMaterialTablePosition;
    }

    public int getEri32FreeRollPosition() {
        return eri32FreeRollPosition;
    }

    public int getEri32materialUsedTensionPercent() {
        return eri32materialUsedTensionPercent;
    }

    public int getEri32WasteCutterLength() {
        return eri32WasteCutterLength;
    }

    public int getEri32WasteCutterCount() {
        return eri32WasteCutterCount;
    }

    public boolean isErbWasherUsed() {
        return erbWasherUsed;
    }

    public boolean isErbSidePilerUsed() {
        return erbSidePilerUsed;
    }

    public int getEri32WorkRollEntryPosition() {
        return eri32WorkRollEntryPosition;
    }

    public int getEri32WorkRollExitPosition() {
        return eri32WorkRollExitPosition;
    }

    public int getEri32FlattenGuidePosition() {
        return eri32FlattenGuidePosition;
    }

    public int getEri32Count() {
        return eri32Count;
    }

    public int getEri32ExitBeltVelocity() {
        return eri32ExitBeltVelocity;
    }

    public int getEri32ExitBeltPosition() {
        return eri32ExitBeltPosition;
    }

    public int getEri32ExitBeltHeight() {
        return eri32ExitBeltHeight;
    }

    public int getErtBeltDelay() {
        return ertBeltDelay;
    }

    public boolean isErbRotaryCutterUsed() {
        return erbRotaryCutterUsed;
    }

    public int getEri32RotaryCutterLeftPosition() {
        return eri32RotaryCutterLeftPosition;
    }

    public int getEri32RotaryCutterRightPosition() {
        return eri32RotaryCutterRightPosition;
    }

    public int getEri32RotaryCutterBeltVelocity() {
        return eri32RotaryCutterBeltVelocity;
    }

    public int getEri32FeedJerk() {
        return eri32FeedJerk;
    }

    public int getEri32FeedTableLength() {
        return eri32FeedTableLength;
    }

    public int getEri32EndFeedLengthImpose() {
        return eri32EndFeedLengthImpose;
    }

    public boolean isErbCloseLoopMode() {
        return erbCloseLoopMode;
    }

    public int getEri32FeedAcc() {
        return eri32FeedAcc;
    }

    public int getEri32FeedDec() {
        return eri32FeedDec;
    }

    public int getEri32FeedRollDsPressure() {
        return eri32FeedRollDsPressure;
    }

    public int getEri32FeedRollOsPressure() {
        return eri32FeedRollOsPressure;
    }

    public int getErFeedGuideEntryOsPosition() {
        return erFeedGuideEntryOsPosition;
    }

    public int getErFeedGuideExitOsPosition() {
        return erFeedGuideExitOsPosition;
    }

    public int getEri32FeedLength() {
        return eri32FeedLength;
    }

    public int getEri32FeedVelocity() {
        return eri32FeedVelocity;
    }

    public String getErstrDataSetName() {
        return erstrDataSetName;
    }

    public int getErMaterialDiameter() {
        return erMaterialDiameter;
    }

    public int getErMaterialWidth() {
        return erMaterialWidth;
    }

    public int getErMaterialThickness() {
        return erMaterialThickness;
    }

    public boolean isErMaterialMiniDiameter() {
        return erMaterialMiniDiameter;
    }

    public int getWasherWringRollN1DsPressure() {
        return washerWringRollN1DsPressure;
    }

    public int getWasherWringRollN1OsPressure() {
        return washerWringRollN1OsPressure;
    }

    public int getWasherWringRollN2DsPressure() {
        return washerWringRollN2DsPressure;
    }

    public int getWasherWringRollN2OsPressure() {
        return washerWringRollN2OsPressure;
    }

    public int getErFeedGuideEntryDsPosition() {
        return erFeedGuideEntryDsPosition;
    }

    public int getErFeedGuideExitDsPosition() {
        return erFeedGuideExitDsPosition;
    }

    public int getErEndFeedGuideWidth() {
        return erEndFeedGuideWidth;
    }

    public int getErFeedTableHeight() {
        return erFeedTableHeight;
    }


}
