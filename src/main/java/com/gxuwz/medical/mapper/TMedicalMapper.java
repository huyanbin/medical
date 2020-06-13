package com.gxuwz.medical.mapper;

import com.gxuwz.medical.domain.TMedical;

import java.util.List;

/**
 * 医疗Mapper接口
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
public interface TMedicalMapper 
{
    /**
     * 查询医疗
     * 
     * @param jgbm 医疗ID
     * @return 医疗
     */
    public TMedical selectTMedicalById(String jgbm);

    /**
     * 查询医疗列表
     * 
     * @param tMedical 医疗
     * @return 医疗集合
     */
    public List<TMedical> selectTMedicalList(TMedical tMedical);

    /**
     * 新增医疗
     * 
     * @param tMedical 医疗
     * @return 结果
     */
    public int insertTMedical(TMedical tMedical);

    /**
     * 修改医疗
     * 
     * @param tMedical 医疗
     * @return 结果
     */
    public int updateTMedical(TMedical tMedical);

    /**
     * 删除医疗
     * 
     * @param jgbm 医疗ID
     * @return 结果
     */
    public int deleteTMedicalById(String jgbm);

    /**
     * 批量删除医疗
     * 
     * @param jgbms 需要删除的数据ID
     * @return 结果
     */
    public int deleteTMedicalByIds(String[] jgbms);
}
