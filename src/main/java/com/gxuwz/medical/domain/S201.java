package com.gxuwz.medical.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 关系对象 s201
 * 
 * @author 麦奇
 * @date 2020-06-05
 */
public class S201 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 编码 */
    private String itemcode;

    /** 名称 */
    private String itemname;

    /** 皮特码 */
    private String pitemcode;

    /** 类型：02：隶属关系；06：机构级别；04：机构级别；01：机构所属经济类型；03卫生机构； */
    private String type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setItemcode(String itemcode) 
    {
        this.itemcode = itemcode;
    }

    public String getItemcode() 
    {
        return itemcode;
    }
    public void setItemname(String itemname) 
    {
        this.itemname = itemname;
    }

    public String getItemname() 
    {
        return itemname;
    }
    public void setPitemcode(String pitemcode) 
    {
        this.pitemcode = pitemcode;
    }

    public String getPitemcode() 
    {
        return pitemcode;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("itemcode", getItemcode())
            .append("itemname", getItemname())
            .append("pitemcode", getPitemcode())
            .append("type", getType())
            .toString();
    }
}
