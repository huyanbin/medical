package com.gxuwz.medical.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * 记录对象 t_recordfree
 * 
 * @author 麦奇
 * @date 2020-06-05
 */
public class TRecordfree extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String perscode;

    /** 免费 */
    private Long freetotal;

    public void setPerscode(String perscode) 
    {
        this.perscode = perscode;
    }

    public String getPerscode() 
    {
        return perscode;
    }
    public void setFreetotal(Long freetotal) 
    {
        this.freetotal = freetotal;
    }

    public Long getFreetotal() 
    {
        return freetotal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("perscode", getPerscode())
            .append("freetotal", getFreetotal())
            .toString();
    }
}
