package com.gxuwz.medical.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 报销对象 reimburse
 * 
 * @author ruoyi
 * @date 2020-06-06
 */
public class Reimburse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报销单号 */
    private String reiNo;

    /** 身份证 */
    private String idCard;

    /** 农合编号 */
    private String chroNo;

    /** 已报销金额 */
    private Long reiAlre;

    /** 本次报销金额 */
    private Long reiNow;

    /** 可报销金额 */
    private String reiRema;

    /** 创建时间 */
    private Date creaTime;

    /** 疾病名称 */
    private String diseaseName;

    /** 医疗总费 */
    private Long cost;

    /** 发票号 */
    private String invoice;

    /** 就诊时间 */
    private Date treaTime;

    /** 创建者 */
    private String creator;

    private String status;

    public void setReiNo(String reiNo) 
    {
        this.reiNo = reiNo;
    }

    public String getReiNo() 
    {
        return reiNo;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setChroNo(String chroNo) 
    {
        this.chroNo = chroNo;
    }

    public String getChroNo() 
    {
        return chroNo;
    }
    public void setReiAlre(Long reiAlre) 
    {
        this.reiAlre = reiAlre;
    }

    public Long getReiAlre() 
    {
        return reiAlre;
    }
    public void setReiNow(Long reiNow) 
    {
        this.reiNow = reiNow;
    }

    public Long getReiNow() 
    {
        return reiNow;
    }
    public void setReiRema(String reiRema) 
    {
        this.reiRema = reiRema;
    }

    public String getReiRema() 
    {
        return reiRema;
    }
    public void setCreaTime(Date creaTime) 
    {
        this.creaTime = creaTime;
    }

    public Date getCreaTime() 
    {
        return creaTime;
    }
    public void setDiseaseName(String diseaseName) 
    {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseName() 
    {
        return diseaseName;
    }
    public void setCost(Long cost) 
    {
        this.cost = cost;
    }

    public Long getCost() 
    {
        return cost;
    }
    public void setInvoice(String invoice) 
    {
        this.invoice = invoice;
    }

    public String getInvoice() 
    {
        return invoice;
    }
    public void setTreaTime(Date treaTime) 
    {
        this.treaTime = treaTime;
    }

    public Date getTreaTime() 
    {
        return treaTime;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("reiNo", getReiNo())
            .append("idCard", getIdCard())
            .append("chroNo", getChroNo())
            .append("reiAlre", getReiAlre())
            .append("reiNow", getReiNow())
            .append("reiRema", getReiRema())
            .append("creaTime", getCreaTime())
            .append("updateTime", getUpdateTime())
            .append("diseaseName", getDiseaseName())
            .append("cost", getCost())
            .append("invoice", getInvoice())
            .append("treaTime", getTreaTime())
            .append("creator", getCreator())
                .append("status", getStatus())
            .toString();
    }
}
