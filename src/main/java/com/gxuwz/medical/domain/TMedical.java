package com.gxuwz.medical.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * 医疗对象 t_medical
 * 
 * @author 麦奇
 * @date 2020-06-05
 */
public class TMedical extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 机构编码 */
    private String jgbm;

    /** 组织机构编号 */
    private String zzjgbm;

    /** 机构名称 */
    private String jgmc;

    /** 地区代码 */
    private String dqbm;

    /** 行政区编码 */
    private String areacode;

    /** 隶属关系 */
    private String lsgx;

    /** 机构级别 */
    private String jgjb;

    /** 申报定点类型 */
    private String sbddlx;

    /** 批准定点类型 */
    private String pzddlx;

    /** 机构所属经济 */
    private String ssjjlx;

    /** 卫生机构大类别 */
    private String wsjgdl;

    /** 卫生机构小类别 */
    private String wsjgxl;

    /** 主管单位 */
    private String zgdw;

    /** 成立时间 */
    private String kysj;

    /** 法人 */
    private String frdb;

    /** 注册资金 */
    private Long zczj;

    public void setJgbm(String jgbm) 
    {
        this.jgbm = jgbm;
    }

    public String getJgbm() 
    {
        return jgbm;
    }
    public void setZzjgbm(String zzjgbm) 
    {
        this.zzjgbm = zzjgbm;
    }

    public String getZzjgbm() 
    {
        return zzjgbm;
    }
    public void setJgmc(String jgmc) 
    {
        this.jgmc = jgmc;
    }

    public String getJgmc() 
    {
        return jgmc;
    }
    public void setDqbm(String dqbm) 
    {
        this.dqbm = dqbm;
    }

    public String getDqbm() 
    {
        return dqbm;
    }
    public void setAreacode(String areacode) 
    {
        this.areacode = areacode;
    }

    public String getAreacode() 
    {
        return areacode;
    }
    public void setLsgx(String lsgx) 
    {
        this.lsgx = lsgx;
    }

    public String getLsgx() 
    {
        return lsgx;
    }
    public void setJgjb(String jgjb) 
    {
        this.jgjb = jgjb;
    }

    public String getJgjb() 
    {
        return jgjb;
    }
    public void setSbddlx(String sbddlx) 
    {
        this.sbddlx = sbddlx;
    }

    public String getSbddlx() 
    {
        return sbddlx;
    }
    public void setPzddlx(String pzddlx) 
    {
        this.pzddlx = pzddlx;
    }

    public String getPzddlx() 
    {
        return pzddlx;
    }
    public void setSsjjlx(String ssjjlx) 
    {
        this.ssjjlx = ssjjlx;
    }

    public String getSsjjlx() 
    {
        return ssjjlx;
    }
    public void setWsjgdl(String wsjgdl) 
    {
        this.wsjgdl = wsjgdl;
    }

    public String getWsjgdl() 
    {
        return wsjgdl;
    }
    public void setWsjgxl(String wsjgxl) 
    {
        this.wsjgxl = wsjgxl;
    }

    public String getWsjgxl() 
    {
        return wsjgxl;
    }
    public void setZgdw(String zgdw) 
    {
        this.zgdw = zgdw;
    }

    public String getZgdw() 
    {
        return zgdw;
    }
    public void setKysj(String kysj) 
    {
        this.kysj = kysj;
    }

    public String getKysj() 
    {
        return kysj;
    }
    public void setFrdb(String frdb) 
    {
        this.frdb = frdb;
    }

    public String getFrdb() 
    {
        return frdb;
    }
    public void setZczj(Long zczj) 
    {
        this.zczj = zczj;
    }

    public Long getZczj() 
    {
        return zczj;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("jgbm", getJgbm())
            .append("zzjgbm", getZzjgbm())
            .append("jgmc", getJgmc())
            .append("dqbm", getDqbm())
            .append("areacode", getAreacode())
            .append("lsgx", getLsgx())
            .append("jgjb", getJgjb())
            .append("sbddlx", getSbddlx())
            .append("pzddlx", getPzddlx())
            .append("ssjjlx", getSsjjlx())
            .append("wsjgdl", getWsjgdl())
            .append("wsjgxl", getWsjgxl())
            .append("zgdw", getZgdw())
            .append("kysj", getKysj())
            .append("frdb", getFrdb())
            .append("zczj", getZczj())
            .toString();
    }
}
