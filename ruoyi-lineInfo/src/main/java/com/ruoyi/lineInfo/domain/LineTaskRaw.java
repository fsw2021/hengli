package com.ruoyi.lineInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * ${subTable.functionName}对象 line_task_raw
 * 
 * @author mazijian
 * @date 2021-12-10
 */
public class LineTaskRaw extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 生产任务id */
    @Excel(name = "生产任务id")
    private Long taskId;

    /** 卷材厚度 */
    @Excel(name = "卷材厚度")
    private String thickness;

    /** 卷材宽度 */
    @Excel(name = "卷材宽度")
    private String width;

    /** 卷材内径 */
    @Excel(name = "卷材内径")
    private String interDiameter;

    /** 卷材外径 */
    @Excel(name = "卷材外径")
    private String outerDiameter;

    /** 抗拉强度 */
    @Excel(name = "抗拉强度")
    private String tensileStrength;

    /** 屈服强度 */
    @Excel(name = "屈服强度")
    private String yieldStrength;

    /** 最高线速 */
    @Excel(name = "最高线速")
    private String highestSpeed;

    /** 卷重 */
    @Excel(name = "卷重")
    private String weight;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setThickness(String thickness) 
    {
        this.thickness = thickness;
    }

    public String getThickness() 
    {
        return thickness;
    }
    public void setWidth(String width) 
    {
        this.width = width;
    }

    public String getWidth() 
    {
        return width;
    }
    public void setInterDiameter(String interDiameter) 
    {
        this.interDiameter = interDiameter;
    }

    public String getInterDiameter() 
    {
        return interDiameter;
    }
    public void setOuterDiameter(String outerDiameter) 
    {
        this.outerDiameter = outerDiameter;
    }

    public String getOuterDiameter() 
    {
        return outerDiameter;
    }
    public void setTensileStrength(String tensileStrength) 
    {
        this.tensileStrength = tensileStrength;
    }

    public String getTensileStrength() 
    {
        return tensileStrength;
    }
    public void setYieldStrength(String yieldStrength) 
    {
        this.yieldStrength = yieldStrength;
    }

    public String getYieldStrength() 
    {
        return yieldStrength;
    }
    public void setHighestSpeed(String highestSpeed) 
    {
        this.highestSpeed = highestSpeed;
    }

    public String getHighestSpeed() 
    {
        return highestSpeed;
    }
    public void setWeight(String weight) 
    {
        this.weight = weight;
    }

    public String getWeight() 
    {
        return weight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("taskId", getTaskId())
            .append("thickness", getThickness())
            .append("width", getWidth())
            .append("interDiameter", getInterDiameter())
            .append("outerDiameter", getOuterDiameter())
            .append("tensileStrength", getTensileStrength())
            .append("yieldStrength", getYieldStrength())
            .append("highestSpeed", getHighestSpeed())
            .append("weight", getWeight())
            .toString();
    }
}
