package com.ruoyi.lineInfo.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 生产任务管理对象 line_task
 * 
 * @author mazijian
 * @date 2021-12-10
 */
public class LineTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 产线id */
    @Excel(name = "产线id")
    private Long lineId;

    /** 生产任务号 */
    @Excel(name = "生产任务号")
    private String productionTaskNo;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gmtCreate;

    /** 修改时间 */
    private Date gmtModified;

    /** $table.subTable.functionName信息 */
    private List<LineTaskRaw> lineTaskRawList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLineId(Long lineId) 
    {
        this.lineId = lineId;
    }

    public Long getLineId() 
    {
        return lineId;
    }
    public void setProductionTaskNo(String productionTaskNo) 
    {
        this.productionTaskNo = productionTaskNo;
    }

    public String getProductionTaskNo() 
    {
        return productionTaskNo;
    }
    public void setGmtCreate(Date gmtCreate) 
    {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtCreate() 
    {
        return gmtCreate;
    }
    public void setGmtModified(Date gmtModified) 
    {
        this.gmtModified = gmtModified;
    }

    public Date getGmtModified() 
    {
        return gmtModified;
    }

    public List<LineTaskRaw> getLineTaskRawList()
    {
        return lineTaskRawList;
    }

    public void setLineTaskRawList(List<LineTaskRaw> lineTaskRawList)
    {
        this.lineTaskRawList = lineTaskRawList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("lineId", getLineId())
            .append("productionTaskNo", getProductionTaskNo())
            .append("gmtCreate", getGmtCreate())
            .append("gmtModified", getGmtModified())
            .append("lineTaskRawList", getLineTaskRawList())
            .toString();
    }
}
