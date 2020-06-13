package com.gxuwz.medical.service.impl;

import java.util.List;

import com.gxuwz.medical.domain.TRecordfree;
import com.gxuwz.medical.mapper.TRecordfreeMapper;
import com.gxuwz.medical.service.ITRecordfreeService;
import com.gxuwz.medical.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 记录Service业务层处理
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Service
public class TRecordfreeServiceImpl implements ITRecordfreeService
{
    @Autowired
    private TRecordfreeMapper tRecordfreeMapper;

    /**
     * 查询记录
     * 
     * @param perscode 记录ID
     * @return 记录
     */
    @Override
    public TRecordfree selectTRecordfreeById(String perscode)
    {
        return tRecordfreeMapper.selectTRecordfreeById(perscode);
    }

    /**
     * 查询记录列表
     * 
     * @param tRecordfree 记录
     * @return 记录
     */
    @Override
    public List<TRecordfree> selectTRecordfreeList(TRecordfree tRecordfree)
    {
        return tRecordfreeMapper.selectTRecordfreeList(tRecordfree);
    }

    /**
     * 新增记录
     * 
     * @param tRecordfree 记录
     * @return 结果
     */
    @Override
    public int insertTRecordfree(TRecordfree tRecordfree)
    {
        return tRecordfreeMapper.insertTRecordfree(tRecordfree);
    }

    /**
     * 修改记录
     * 
     * @param tRecordfree 记录
     * @return 结果
     */
    @Override
    public int updateTRecordfree(TRecordfree tRecordfree)
    {
        return tRecordfreeMapper.updateTRecordfree(tRecordfree);
    }

    /**
     * 删除记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTRecordfreeByIds(String ids)
    {
        return tRecordfreeMapper.deleteTRecordfreeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除记录信息
     * 
     * @param perscode 记录ID
     * @return 结果
     */
    @Override
    public int deleteTRecordfreeById(String perscode)
    {
        return tRecordfreeMapper.deleteTRecordfreeById(perscode);
    }
}
