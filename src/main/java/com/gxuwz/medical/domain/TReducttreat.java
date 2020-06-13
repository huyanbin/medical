package com.gxuwz.medical.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * 还原处理对象 t_reducttreat
 * 
 * @author 麦奇
 * @date 2020-06-05
 */
public class TReducttreat extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 慢性病证 */
    private String chronicinfoid;

    /** 治疗时间 */
    private String treattime;

    /** 费用 */
    private Long money;

    /** 医院发票号 */
    private String hosid;

    /** 0为已提交申请，1为审核确定汇款，2为审核取消汇款，没有删除一项 */
    private Long reductstatus;

    /** 缴费 */
    private Long freemoney;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setChronicinfoid(String chronicinfoid) 
    {
        this.chronicinfoid = chronicinfoid;
    }

    public String getChronicinfoid() 
    {
        return chronicinfoid;
    }
    public void setTreattime(String treattime) 
    {
        this.treattime = treattime;
    }

    public String getTreattime() 
    {
        return treattime;
    }
    public void setMoney(Long money) 
    {
        this.money = money;
    }

    public Long getMoney() 
    {
        return money;
    }
    public void setHosid(String hosid) 
    {
        this.hosid = hosid;
    }

    public String getHosid() 
    {
        return hosid;
    }
    public void setReductstatus(Long reductstatus) 
    {
        this.reductstatus = reductstatus;
    }

    public Long getReductstatus() 
    {
        return reductstatus;
    }
    public void setFreemoney(Long freemoney) 
    {
        this.freemoney = freemoney;
    }

    public Long getFreemoney() 
    {
        return freemoney;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("chronicinfoid", getChronicinfoid())
            .append("treattime", getTreattime())
            .append("money", getMoney())
            .append("hosid", getHosid())
            .append("reductstatus", getReductstatus())
            .append("freemoney", getFreemoney())
            .toString();
    }
}
