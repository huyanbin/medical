package com.gxuwz.medical.service.impl;

import java.util.List;

import com.gxuwz.medical.domain.TInstitution;
import com.gxuwz.medical.mapper.TInstitutionMapper;
import com.gxuwz.medical.service.ITInstitutionService;
import com.gxuwz.medical.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 机构Service业务层处理
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Service
public class TInstitutionServiceImpl implements ITInstitutionService
{
    @Autowired
    private TInstitutionMapper tInstitutionMapper;

    /**
     * 查询机构
     * 
     * @param agencode 机构ID
     * @return 机构
     */
    @Override
    public TInstitution selectTInstitutionById(String agencode)
    {
        return tInstitutionMapper.selectTInstitutionById(agencode);
    }

    /**
     * 查询机构列表
     * 
     * @param tInstitution 机构
     * @return 机构
     */
    @Override
    public List<TInstitution> selectTInstitutionList(TInstitution tInstitution)
    {
        return tInstitutionMapper.selectTInstitutionList(tInstitution);
    }

    /**
     * 新增机构
     * 
     * @param tInstitution 机构
     * @return 结果
     */
    @Override
    public int insertTInstitution(TInstitution tInstitution)
    {
        return tInstitutionMapper.insertTInstitution(tInstitution);
    }

    /**
     * 修改机构
     * 
     * @param tInstitution 机构
     * @return 结果
     */
    @Override
    public int updateTInstitution(TInstitution tInstitution)
    {
        return tInstitutionMapper.updateTInstitution(tInstitution);
    }

    /**
     * 删除机构对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTInstitutionByIds(String ids)
    {
        return tInstitutionMapper.deleteTInstitutionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除机构信息
     * 
     * @param agencode 机构ID
     * @return 结果
     */
    @Override
    public int deleteTInstitutionById(String agencode)
    {
        return tInstitutionMapper.deleteTInstitutionById(agencode);
    }
}
