package com.ruoyi.lineInfo.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产线管理对象 line_basic
 * 
 * @author mazijian
 * @date 2021-11-17
 */
public class LineBasic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String lineName;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String lineIdentifier;

    /** 设备厂家 */
    @Excel(name = "设备厂家")
    private String manufacturer;

    /** 设备线速 */
    @Excel(name = "设备线速")
    private String linearVelocity;

    /** 设备状态 */
    @Excel(name = "设备状态")
    private Long lineStatus;

    /** 投产时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "投产时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productionTime;

    /** 年产能力 */
    @Excel(name = "年产能力")
    private String annualCapacity;

    /** 产品范围 */
    @Excel(name = "产品范围")
    private String productRange;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLineName(String lineName) 
    {
        this.lineName = lineName;
    }

    public String getLineName() 
    {
        return lineName;
    }
    public void setLineIdentifier(String lineIdentifier) 
    {
        this.lineIdentifier = lineIdentifier;
    }

    public String getLineIdentifier() 
    {
        return lineIdentifier;
    }
    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }
    public void setLinearVelocity(String linearVelocity) 
    {
        this.linearVelocity = linearVelocity;
    }

    public String getLinearVelocity() 
    {
        return linearVelocity;
    }
    public void setLineStatus(Long lineStatus) 
    {
        this.lineStatus = lineStatus;
    }

    public Long getLineStatus() 
    {
        return lineStatus;
    }
    public void setProductionTime(Date productionTime) 
    {
        this.productionTime = productionTime;
    }

    public Date getProductionTime() 
    {
        return productionTime;
    }
    public void setAnnualCapacity(String annualCapacity) 
    {
        this.annualCapacity = annualCapacity;
    }

    public String getAnnualCapacity() 
    {
        return annualCapacity;
    }
    public void setProductRange(String productRange) 
    {
        this.productRange = productRange;
    }

    public String getProductRange() 
    {
        return productRange;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("lineName", getLineName())
            .append("lineIdentifier", getLineIdentifier())
            .append("manufacturer", getManufacturer())
            .append("linearVelocity", getLinearVelocity())
            .append("lineStatus", getLineStatus())
            .append("productionTime", getProductionTime())
            .append("annualCapacity", getAnnualCapacity())
            .append("productRange", getProductRange())
            .toString();
    }
}
