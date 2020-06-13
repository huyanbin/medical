package com.gxuwz.medical.service.impl;

import java.util.List;

import com.gxuwz.medical.domain.TMedical;
import com.gxuwz.medical.mapper.TMedicalMapper;
import com.gxuwz.medical.service.ITMedicalService;
import com.gxuwz.medical.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 医疗Service业务层处理
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Service
public class TMedicalServiceImpl implements ITMedicalService
{
    @Autowired
    private TMedicalMapper tMedicalMapper;

    /**
     * 查询医疗
     * 
     * @param jgbm 医疗ID
     * @return 医疗
     */
    @Override
    public TMedical selectTMedicalById(String jgbm)
    {
        return tMedicalMapper.selectTMedicalById(jgbm);
    }

    /**
     * 查询医疗列表
     * 
     * @param tMedical 医疗
     * @return 医疗
     */
    @Override
    public List<TMedical> selectTMedicalList(TMedical tMedical)
    {
        return tMedicalMapper.selectTMedicalList(tMedical);
    }

    /**
     * 新增医疗
     * 
     * @param tMedical 医疗
     * @return 结果
     */
    @Override
    public int insertTMedical(TMedical tMedical)
    {
        return tMedicalMapper.insertTMedical(tMedical);
    }

    /**
     * 修改医疗
     * 
     * @param tMedical 医疗
     * @return 结果
     */
    @Override
    public int updateTMedical(TMedical tMedical)
    {
        return tMedicalMapper.updateTMedical(tMedical);
    }

    /**
     * 删除医疗对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTMedicalByIds(String ids)
    {
        return tMedicalMapper.deleteTMedicalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除医疗信息
     * 
     * @param jgbm 医疗ID
     * @return 结果
     */
    @Override
    public int deleteTMedicalById(String jgbm)
    {
        return tMedicalMapper.deleteTMedicalById(jgbm);
    }
}
