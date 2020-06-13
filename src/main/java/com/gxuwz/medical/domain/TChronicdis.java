package com.gxuwz.medical.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 慢性病对象 t_chronicdis
 * 
 * @author 麦奇
 * @date 2020-06-05
 */
public class TChronicdis extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 疾病编码 */
    private String illcode;

    /** 拼音码 */
    private String pycode;

    /** 疾病名称 */
    private String illname;

    /** wb码 */
    private String wbcode;

    /** 得病率 */
    private Double rate;

    public void setIllcode(String illcode) 
    {
        this.illcode = illcode;
    }

    public String getIllcode() 
    {
        return illcode;
    }
    public void setPycode(String pycode) 
    {
        this.pycode = pycode;
    }

    public String getPycode() 
    {
        return pycode;
    }
    public void setIllname(String illname) 
    {
        this.illname = illname;
    }

    public String getIllname() 
    {
        return illname;
    }
    public void setWbcode(String wbcode) 
    {
        this.wbcode = wbcode;
    }

    public String getWbcode() 
    {
        return wbcode;
    }
    public void setRate(Double rate) 
    {
        this.rate = rate;
    }

    public Double getRate() 
    {
        return rate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("illcode", getIllcode())
            .append("pycode", getPycode())
            .append("illname", getIllname())
            .append("wbcode", getWbcode())
            .append("rate", getRate())
            .toString();
    }
}
