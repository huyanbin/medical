package com.gxuwz.medical.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * 人对象 t_person
 * 
 * @author 麦奇
 * @date 2020-06-05
 */
public class TPerson extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 档案编号 */
    private String perscode;

    /** 家庭编号 */
    private String famicode;

    /** 农合证号 */
    private String ruralCard;

    /** 医疗证号 */
    private String mediCard;

    /** 户内编号 */
    private String houseNum;

    /** 名字 */
    private String persname;

    /** 与户主关系 */
    private String relation;

    /** 身份证 */
    private String cardId;

    /** 性别 */
    private String sex;

    /** 健康状况 */
    private Integer stateHealth;

    /** 出生日期 */
    private Date birthday;

    /** 是否农村户口 */
    private Long isRural;

    /** 职业类型 */
    private String occupation;

    /** 电话 */
    private String telephone;

    public void setPerscode(String perscode) 
    {
        this.perscode = perscode;
    }

    public String getPerscode() 
    {
        return perscode;
    }
    public void setFamicode(String famicode) 
    {
        this.famicode = famicode;
    }

    public String getFamicode() 
    {
        return famicode;
    }
    public void setRuralCard(String ruralCard) 
    {
        this.ruralCard = ruralCard;
    }

    public String getRuralCard() 
    {
        return ruralCard;
    }
    public void setMediCard(String mediCard) 
    {
        this.mediCard = mediCard;
    }

    public String getMediCard() 
    {
        return mediCard;
    }
    public void setHouseNum(String houseNum) 
    {
        this.houseNum = houseNum;
    }

    public String getHouseNum() 
    {
        return houseNum;
    }
    public void setPersname(String persname) 
    {
        this.persname = persname;
    }

    public String getPersname() 
    {
        return persname;
    }
    public void setRelation(String relation) 
    {
        this.relation = relation;
    }

    public String getRelation() 
    {
        return relation;
    }
    public void setCardId(String cardId) 
    {
        this.cardId = cardId;
    }

    public String getCardId() 
    {
        return cardId;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setStateHealth(Integer stateHealth) 
    {
        this.stateHealth = stateHealth;
    }

    public Integer getStateHealth() 
    {
        return stateHealth;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setIsRural(Long isRural) 
    {
        this.isRural = isRural;
    }

    public Long getIsRural() 
    {
        return isRural;
    }
    public void setOccupation(String occupation) 
    {
        this.occupation = occupation;
    }

    public String getOccupation() 
    {
        return occupation;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }

    public TPerson(String famicode) {
        this.famicode = famicode;
    }

    public TPerson() {
    }

    public TPerson(String perscode, String famicode, String ruralCard, String mediCard, String houseNum, String persname, String relation, String cardId, String sex, Integer stateHealth, Date birthday, Long isRural, String occupation, String telephone) {
        this.perscode = perscode;
        this.famicode = famicode;
        this.ruralCard = ruralCard;
        this.mediCard = mediCard;
        this.houseNum = houseNum;
        this.persname = persname;
        this.relation = relation;
        this.cardId = cardId;
        this.sex = sex;
        this.stateHealth = stateHealth;
        this.birthday = birthday;
        this.isRural = isRural;
        this.occupation = occupation;
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("perscode", getPerscode())
            .append("famicode", getFamicode())
            .append("ruralCard", getRuralCard())
            .append("mediCard", getMediCard())
            .append("houseNum", getHouseNum())
            .append("persname", getPersname())
            .append("relation", getRelation())
            .append("cardId", getCardId())
            .append("sex", getSex())
            .append("stateHealth", getStateHealth())
            .append("birthday", getBirthday())
            .append("isRural", getIsRural())
            .append("occupation", getOccupation())
            .append("telephone", getTelephone())
            .toString();
    }
}
