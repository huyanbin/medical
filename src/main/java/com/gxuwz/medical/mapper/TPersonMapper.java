package com.gxuwz.medical.mapper;

import com.gxuwz.medical.domain.TPerson;

import java.util.List;

/**
 * 人Mapper接口
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
public interface TPersonMapper 
{
    /**
     * 查询人
     * 
     * @param perscode 人ID
     * @return 人
     */
    public TPerson selectTPersonById(String perscode);


    public TPerson selectTPersonByCardId(String cardId);

    /**
     * 查询人列表
     * 
     * @param tPerson 人
     * @return 人集合
     */
    public List<TPerson> selectTPersonList(TPerson tPerson);

    /**
     * 新增人
     * 
     * @param tPerson 人
     * @return 结果
     */
    public int insertTPerson(TPerson tPerson);

    /**
     * 修改人
     * 
     * @param tPerson 人
     * @return 结果
     */
    public int updateTPerson(TPerson tPerson);

    /**
     * 删除人
     * 
     * @param perscode 人ID
     * @return 结果
     */
    public int deleteTPersonById(String perscode);

    /**
     * 批量删除人
     * 
     * @param perscodes 需要删除的数据ID
     * @return 结果
     */
    public int deleteTPersonByIds(String[] perscodes);
}
