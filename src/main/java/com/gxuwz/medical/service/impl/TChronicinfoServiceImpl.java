package com.gxuwz.medical.service.impl;

import java.util.List;

import com.gxuwz.medical.domain.TChronicinfo;
import com.gxuwz.medical.mapper.TChronicinfoMapper;
import com.gxuwz.medical.service.ITChronicinfoService;
import com.gxuwz.medical.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 慢性信息Service业务层处理
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Service
public class TChronicinfoServiceImpl implements ITChronicinfoService
{
    @Autowired
    private TChronicinfoMapper tChronicinfoMapper;

    /**
     * 查询慢性信息
     * 
     * @param id 慢性信息ID
     * @return 慢性信息
     */
    @Override
    public TChronicinfo selectTChronicinfoById(String id)
    {
        return tChronicinfoMapper.selectTChronicinfoById(id);
    }

    /**
     * 查询慢性信息列表
     * 
     * @param tChronicinfo 慢性信息
     * @return 慢性信息
     */
    @Override
    public List<TChronicinfo> selectTChronicinfoList(TChronicinfo tChronicinfo)
    {
        return tChronicinfoMapper.selectTChronicinfoList(tChronicinfo);
    }

    /**
     * 新增慢性信息
     * 
     * @param tChronicinfo 慢性信息
     * @return 结果
     */
    @Override
    public int insertTChronicinfo(TChronicinfo tChronicinfo)
    {
        return tChronicinfoMapper.insertTChronicinfo(tChronicinfo);
    }

    /**
     * 修改慢性信息
     * 
     * @param tChronicinfo 慢性信息
     * @return 结果
     */
    @Override
    public int updateTChronicinfo(TChronicinfo tChronicinfo)
    {
        return tChronicinfoMapper.updateTChronicinfo(tChronicinfo);
    }

    /**
     * 删除慢性信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTChronicinfoByIds(String ids)
    {
        return tChronicinfoMapper.deleteTChronicinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除慢性信息信息
     * 
     * @param id 慢性信息ID
     * @return 结果
     */
    @Override
    public int deleteTChronicinfoById(String id)
    {
        return tChronicinfoMapper.deleteTChronicinfoById(id);
    }
}
