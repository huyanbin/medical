package com.gxuwz.medical.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * 期限对象 t_payperiod
 * 
 * @author 麦奇
 * @date 2020-06-05
 */
public class TPayperiod extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 年份 */
    private Long runyear;

    /** 量 */
    private Double amount;

    /** 开始时间 */
    private String startime;

    /** 结束时间 */
    private String endtime;

    /** 状态 */
    private Long status;

    public void setRunyear(Long runyear) 
    {
        this.runyear = runyear;
    }

    public Long getRunyear() 
    {
        return runyear;
    }
    public void setAmount(Double amount) 
    {
        this.amount = amount;
    }

    public Double getAmount() 
    {
        return amount;
    }
    public void setStartime(String startime) 
    {
        this.startime = startime;
    }

    public String getStartime() 
    {
        return startime;
    }
    public void setEndtime(String endtime) 
    {
        this.endtime = endtime;
    }

    public String getEndtime() 
    {
        return endtime;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("runyear", getRunyear())
            .append("amount", getAmount())
            .append("startime", getStartime())
            .append("endtime", getEndtime())
            .append("status", getStatus())
            .toString();
    }
}
