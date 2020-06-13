package com.gxuwz.medical.service;

import com.gxuwz.medical.domain.TFamily;

import java.util.List;

/**
 * 家庭档案Service接口
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
public interface ITFamilyService 
{
    /**
     * 查询家庭档案
     * 
     * @param famicode 家庭档案ID
     * @return 家庭档案
     */
    public TFamily selectTFamilyById(String famicode);

    /**
     * 查询家庭档案列表
     * 
     * @param tFamily 家庭档案
     * @return 家庭档案集合
     */
    public List<TFamily> selectTFamilyList(TFamily tFamily);

    /**
     * 新增家庭档案
     * 
     * @param tFamily 家庭档案
     * @return 结果
     */
    public int insertTFamily(TFamily tFamily);

    /**
     * 修改家庭档案
     * 
     * @param tFamily 家庭档案
     * @return 结果
     */
    public int updateTFamily(TFamily tFamily);

    /**
     * 批量删除家庭档案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTFamilyByIds(String ids);

    /**
     * 删除家庭档案信息
     * 
     * @param famicode 家庭档案ID
     * @return 结果
     */
    public int deleteTFamilyById(String famicode);
}
