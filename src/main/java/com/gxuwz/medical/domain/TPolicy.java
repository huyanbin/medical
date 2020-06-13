package com.gxuwz.medical.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * 政策对象 t_policy
 * 
 * @author 麦奇
 * @date 2020-06-05
 */
public class TPolicy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 年份 */
    private String runyear;

    /** 最大 */
    private Double maxline;

    /** 状态 */
    private String status;

    private String remark;

    public void setRunyear(String runyear) 
    {
        this.runyear = runyear;
    }

    public String getRunyear() 
    {
        return runyear;
    }
    public void setMaxline(Double maxline) 
    {
        this.maxline = maxline;
    }

    public Double getMaxline() 
    {
        return maxline;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("runyear", getRunyear())
            .append("maxline", getMaxline())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
