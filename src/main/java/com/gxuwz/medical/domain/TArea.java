package com.gxuwz.medical.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 行政区域信息对象 t_area
 * 
 * @author 麦奇
 * @date 2020-06-05
 */
public class TArea extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 区域编码 */
    private String areacode;

    /** 区域名称 */
    private String areaname;

    /** 级别 */
    private String grade;

    public void setAreacode(String areacode) 
    {
        this.areacode = areacode;
    }

    public String getAreacode() 
    {
        return areacode;
    }
    public void setAreaname(String areaname) 
    {
        this.areaname = areaname;
    }

    public String getAreaname() 
    {
        return areaname;
    }
    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

    public String getGrade() 
    {
        return grade;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("areacode", getAreacode())
            .append("areaname", getAreaname())
            .append("grade", getGrade())
            .toString();
    }
}
