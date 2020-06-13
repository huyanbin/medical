package com.gxuwz.medical.service.impl;

import java.util.List;

import com.gxuwz.medical.domain.TFamily;
import com.gxuwz.medical.mapper.TFamilyMapper;
import com.gxuwz.medical.service.ITFamilyService;
import com.gxuwz.medical.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 家庭档案Service业务层处理
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Service
public class TFamilyServiceImpl implements ITFamilyService
{
    @Autowired
    private TFamilyMapper tFamilyMapper;

    /**
     * 查询家庭档案
     * 
     * @param famicode 家庭档案ID
     * @return 家庭档案
     */
    @Override
    public TFamily selectTFamilyById(String famicode)
    {
        return tFamilyMapper.selectTFamilyById(famicode);
    }

    /**
     * 查询家庭档案列表
     * 
     * @param tFamily 家庭档案
     * @return 家庭档案
     */
    @Override
    public List<TFamily> selectTFamilyList(TFamily tFamily)
    {
        return tFamilyMapper.selectTFamilyList(tFamily);
    }

    /**
     * 新增家庭档案
     * 
     * @param tFamily 家庭档案
     * @return 结果
     */
    @Override
    public int insertTFamily(TFamily tFamily)
    {
        return tFamilyMapper.insertTFamily(tFamily);
    }

    /**
     * 修改家庭档案
     * 
     * @param tFamily 家庭档案
     * @return 结果
     */
    @Override
    public int updateTFamily(TFamily tFamily)
    {
        return tFamilyMapper.updateTFamily(tFamily);
    }

    /**
     * 删除家庭档案对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTFamilyByIds(String ids)
    {
        return tFamilyMapper.deleteTFamilyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除家庭档案信息
     * 
     * @param famicode 家庭档案ID
     * @return 结果
     */
    @Override
    public int deleteTFamilyById(String famicode)
    {
        return tFamilyMapper.deleteTFamilyById(famicode);
    }
}
