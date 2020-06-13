package com.gxuwz.medical.mapper;

import com.gxuwz.medical.domain.TPolicy;

import java.util.List;

/**
 * 政策Mapper接口
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
public interface TPolicyMapper 
{
    /**
     * 查询政策
     * 
     * @param runyear 政策ID
     * @return 政策
     */
    public TPolicy selectTPolicyById(String runyear);

    /**
     * 查询政策列表
     * 
     * @param tPolicy 政策
     * @return 政策集合
     */
    public List<TPolicy> selectTPolicyList(TPolicy tPolicy);

    /**
     * 新增政策
     * 
     * @param tPolicy 政策
     * @return 结果
     */
    public int insertTPolicy(TPolicy tPolicy);

    /**
     * 修改政策
     * 
     * @param tPolicy 政策
     * @return 结果
     */
    public int updateTPolicy(TPolicy tPolicy);

    /**
     * 删除政策
     * 
     * @param runyear 政策ID
     * @return 结果
     */
    public int deleteTPolicyById(String runyear);

    /**
     * 批量删除政策
     * 
     * @param runyears 需要删除的数据ID
     * @return 结果
     */
    public int deleteTPolicyByIds(String[] runyears);
}
