package com.gxuwz.medical.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 家庭档案对象 t_family
 * 
 * @author 麦奇
 * @date 2020-06-05
 */
public class TFamily extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 家庭编号 */
    private String famicode;

    /** 县编号 */
    private String countyNumber;

    /** 乡镇编号 */
    private String townshipNumber;

    /** 村编号 */
    private String villageNumber;

    /** 户属性 */
    private String houseAttributes;

    /** 户主名字 */
    private String houseName;

    /** 家庭人口数 */
    private Long familyPopu;

    /** 农业人口数 */
    private Long agrinum;

    /** 地址 */
    private String address;

    /** 创建时间 */
    private Date creattime;

    /** 创建人 */
    private String creator;

    public void setFamicode(String famicode) 
    {
        this.famicode = famicode;
    }

    public String getFamicode() 
    {
        return famicode;
    }
    public void setCountyNumber(String countyNumber) 
    {
        this.countyNumber = countyNumber;
    }

    public String getCountyNumber() 
    {
        return countyNumber;
    }
    public void setTownshipNumber(String townshipNumber) 
    {
        this.townshipNumber = townshipNumber;
    }

    public String getTownshipNumber() 
    {
        return townshipNumber;
    }
    public void setVillageNumber(String villageNumber) 
    {
        this.villageNumber = villageNumber;
    }

    public String getVillageNumber() 
    {
        return villageNumber;
    }
    public void setHouseAttributes(String houseAttributes) 
    {
        this.houseAttributes = houseAttributes;
    }

    public String getHouseAttributes() 
    {
        return houseAttributes;
    }
    public void setHouseName(String houseName) 
    {
        this.houseName = houseName;
    }

    public String getHouseName() 
    {
        return houseName;
    }
    public void setFamilyPopu(Long familyPopu) 
    {
        this.familyPopu = familyPopu;
    }

    public Long getFamilyPopu() 
    {
        return familyPopu;
    }
    public void setAgrinum(Long agrinum) 
    {
        this.agrinum = agrinum;
    }

    public Long getAgrinum() 
    {
        return agrinum;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("famicode", getFamicode())
            .append("countyNumber", getCountyNumber())
            .append("townshipNumber", getTownshipNumber())
            .append("villageNumber", getVillageNumber())
            .append("houseAttributes", getHouseAttributes())
            .append("houseName", getHouseName())
            .append("familyPopu", getFamilyPopu())
            .append("agrinum", getAgrinum())
            .append("address", getAddress())
            .append("creattime", getCreattime())
            .append("creator", getCreator())
            .toString();
    }
}
