package com.gxuwz.medical.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 慢性病证信息对象 t_chronicinfo
 * 
 * @author 麦奇
 * @date 2020-06-05
 */
public class TChronicinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 农合编号 */
    private String id;

    /** 开始时间 */
    private String starttime;

    /** 结束时间 */
    private String endtime;

    /** 状态 */
    private String status;

    /** 创建时间 */
    private Date creattime;

    /** 创建者 */
    private String creator;

    /** 新闻码 */
    private String perscode;

    /** 疾病码 */
    private String illcode;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setStarttime(String starttime) 
    {
        this.starttime = starttime;
    }

    public String getStarttime() 
    {
        return starttime;
    }
    public void setEndtime(String endtime) 
    {
        this.endtime = endtime;
    }

    public String getEndtime() 
    {
        return endtime;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setCreattime(Date creattime) 
    {
        this.creattime = creattime;
    }

    public Date getCreattime() 
    {
        return creattime;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setPerscode(String perscode) 
    {
        this.perscode = perscode;
    }

    public String getPerscode() 
    {
        return perscode;
    }
    public void setIllcode(String illcode) 
    {
        this.illcode = illcode;
    }

    public String getIllcode() 
    {
        return illcode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("starttime", getStarttime())
            .append("endtime", getEndtime())
            .append("status", getStatus())
            .append("creattime", getCreattime())
            .append("creator", getCreator())
            .append("perscode", getPerscode())
            .append("illcode", getIllcode())
            .toString();
    }
}
