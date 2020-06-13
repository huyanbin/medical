package com.gxuwz.medical.mapper;

import com.gxuwz.medical.domain.TInstitution;

import java.util.List;

/**
 * 机构Mapper接口
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
public interface TInstitutionMapper 
{
    /**
     * 查询机构
     * 
     * @param agencode 机构ID
     * @return 机构
     */
    public TInstitution selectTInstitutionById(String agencode);

    /**
     * 查询机构列表
     * 
     * @param tInstitution 机构
     * @return 机构集合
     */
    public List<TInstitution> selectTInstitutionList(TInstitution tInstitution);

    /**
     * 新增机构
     * 
     * @param tInstitution 机构
     * @return 结果
     */
    public int insertTInstitution(TInstitution tInstitution);

    /**
     * 修改机构
     * 
     * @param tInstitution 机构
     * @return 结果
     */
    public int updateTInstitution(TInstitution tInstitution);

    /**
     * 删除机构
     * 
     * @param agencode 机构ID
     * @return 结果
     */
    public int deleteTInstitutionById(String agencode);

    /**
     * 批量删除机构
     * 
     * @param agencodes 需要删除的数据ID
     * @return 结果
     */
    public int deleteTInstitutionByIds(String[] agencodes);
}
