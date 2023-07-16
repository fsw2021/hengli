package com.ruoyi.lineInfo.domain;

public class lineInfodb0 {
    /**
     * 厚度(mm)
     */
    private String LineInfo_Thickness;
    /**
     * 宽度(mm)
     */
    private String LineInfo_Width;
    /**
     * 内径(mm)
     */
    private String LineInfo_InternalDiameter;
    /**
     * 外径(mm)
     */
    private String LineInfo_ExternalDiameter;
    /**
     * 原始长度(m)
     */
    private String LineInfo_OriginalLength;

    /**
     * 剩余长度(m)
     */
    private String LineInfo_ResidueLength;
    /**
     * 生产任务号
     */
    private String LineInfo_TaskNo;
    /**
     * 产品名称
     */
    private String LineInfo_ProductName;
    /**
     * 配方号
     */
    private String LineInfo_RecipeNo;
    /**
     * 实时线速度(m/min)
     */
    private String LineInfo_RealtimeLineSpeed;
    /**
     * 实时冲压SPM
     */
    private String LineInfo_RealtimeStrokeTimes;
    /**
     * 定尺长度(mm)
     */
    private String LineInfo_FeedLength;
    /**
     * 计划产量(张)
     */
    private String LineInfo_PlanProduction;
    /**
     * 已完成数(张)
     */
    private String LineInfo_CompletedQuantity;
    /**
     * 未完成数(张)
     */
    private String LineInfo_UncompletedQuantity;
    /**
     * 当前班组任务产量(张)
     */
    private String LineInfo_PlanProduction_Currentteam;
    /**
     * 当前班组实际产量(张)
     */
    private String LineInfo_CompletedQuantity_Currentteam;
    /**
     * 不良数(张)
     */
    private String LineInfo_ScrapeQuantity;
    /**
     * 当日加工量(张)
     */
    private String LineInfo_DayQuantity;


    public String getLineInfo_Width() {
        return LineInfo_Width;
    }

    public String getLineInfo_InternalDiameter() {
        return LineInfo_InternalDiameter;
    }

    public String getLineInfo_ExternalDiameter() {
        return LineInfo_ExternalDiameter;
    }

    public String getLineInfo_OriginalLength() {
        return LineInfo_OriginalLength;
    }

    public String getLineInfo_ResidueLength() {
        return LineInfo_ResidueLength;
    }

    public String getLineInfo_Thickness() {
        return LineInfo_Thickness;

    }
    public String getLineInfo_TaskNo() {
        return LineInfo_TaskNo;
    }

    public String getLineInfo_ProductName() {
        return LineInfo_ProductName;
    }

    public String getLineInfo_RecipeNo() {
        return LineInfo_RecipeNo;
    }

    public String getLineInfo_RealtimeLineSpeed() {
        return LineInfo_RealtimeLineSpeed;
    }

    public String getLineInfo_RealtimeStrokeTimes() {
        return LineInfo_RealtimeStrokeTimes;
    }

    public String getLineInfo_FeedLength() {
        return LineInfo_FeedLength;
    }

    public String getLineInfo_PlanProduction() {
        return LineInfo_PlanProduction;
    }

    public String getLineInfo_CompletedQuantity() {
        return LineInfo_CompletedQuantity;
    }

    public String getLineInfo_UncompletedQuantity() {
        return LineInfo_UncompletedQuantity;
    }

    public String getLineInfo_PlanProduction_Currentteam() {
        return LineInfo_PlanProduction_Currentteam;
    }

    public String getLineInfo_CompletedQuantity_Currentteam() {
        return LineInfo_CompletedQuantity_Currentteam;
    }

    public String getLineInfo_ScrapeQuantity() {
        return LineInfo_ScrapeQuantity;
    }

    public String getLineInfo_DayQuantity() {
        return LineInfo_DayQuantity;
    }

}
