package com.gxuwz.medical.service.impl;

import java.util.List;

import com.gxuwz.medical.domain.TPolicy;
import com.gxuwz.medical.mapper.TPolicyMapper;
import com.gxuwz.medical.service.ITPolicyService;
import com.gxuwz.medical.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 政策Service业务层处理
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Service
public class TPolicyServiceImpl implements ITPolicyService
{
    @Autowired
    private TPolicyMapper tPolicyMapper;

    /**
     * 查询政策
     * 
     * @param runyear 政策ID
     * @return 政策
     */
    @Override
    public TPolicy selectTPolicyById(String runyear)
    {
        return tPolicyMapper.selectTPolicyById(runyear);
    }

    /**
     * 查询政策列表
     * 
     * @param tPolicy 政策
     * @return 政策
     */
    @Override
    public List<TPolicy> selectTPolicyList(TPolicy tPolicy)
    {
        return tPolicyMapper.selectTPolicyList(tPolicy);
    }

    /**
     * 新增政策
     * 
     * @param tPolicy 政策
     * @return 结果
     */
    @Override
    public int insertTPolicy(TPolicy tPolicy)
    {
        return tPolicyMapper.insertTPolicy(tPolicy);
    }

    /**
     * 修改政策
     * 
     * @param tPolicy 政策
     * @return 结果
     */
    @Override
    public int updateTPolicy(TPolicy tPolicy)
    {
        return tPolicyMapper.updateTPolicy(tPolicy);
    }

    /**
     * 删除政策对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTPolicyByIds(String ids)
    {
        return tPolicyMapper.deleteTPolicyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除政策信息
     * 
     * @param runyear 政策ID
     * @return 结果
     */
    @Override
    public int deleteTPolicyById(String runyear)
    {
        return tPolicyMapper.deleteTPolicyById(runyear);
    }
}
