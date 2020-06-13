package com.gxuwz.medical.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * 付款对象 t_payment
 * 
 * @author 麦奇
 * @date 2020-06-05
 */
public class TPayment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 参合证号 */
    private Long payno;

    /** 参合发票号 */
    private String perscode;

    /** 缴费金额 */
    private Long paycost;

    /** 缴费年度 */
    private Long runyear;

    /** 缴费时间 */
    private Date paytime;

    /** 操作员 */
    private String creator;

    /** 家庭编号 */
    private String famicode;

    public void setPayno(Long payno) 
    {
        this.payno = payno;
    }

    public Long getPayno() 
    {
        return payno;
    }
    public void setPerscode(String perscode) 
    {
        this.perscode = perscode;
    }

    public String getPerscode() 
    {
        return perscode;
    }
    public void setPaycost(Long paycost) 
    {
        this.paycost = paycost;
    }

    public Long getPaycost() 
    {
        return paycost;
    }
    public void setRunyear(Long runyear) 
    {
        this.runyear = runyear;
    }

    public Long getRunyear() 
    {
        return runyear;
    }
    public void setPaytime(Date paytime) 
    {
        this.paytime = paytime;
    }

    public Date getPaytime() 
    {
        return paytime;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setFamicode(String famicode) 
    {
        this.famicode = famicode;
    }

    public String getFamicode() 
    {
        return famicode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("payno", getPayno())
            .append("perscode", getPerscode())
            .append("paycost", getPaycost())
            .append("runyear", getRunyear())
            .append("paytime", getPaytime())
            .append("creator", getCreator())
            .append("famicode", getFamicode())
            .toString();
    }
}
