package com.gxuwz.medical.mapper;

import com.gxuwz.medical.domain.TChronicinfo;

import java.util.List;

/**
 * 慢性信息Mapper接口
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
public interface TChronicinfoMapper 
{
    /**
     * 查询慢性信息
     * 
     * @param id 慢性信息ID
     * @return 慢性信息
     */
    public TChronicinfo selectTChronicinfoById(String id);

    /**
     * 查询慢性信息列表
     * 
     * @param tChronicinfo 慢性信息
     * @return 慢性信息集合
     */
    public List<TChronicinfo> selectTChronicinfoList(TChronicinfo tChronicinfo);

    /**
     * 新增慢性信息
     * 
     * @param tChronicinfo 慢性信息
     * @return 结果
     */
    public int insertTChronicinfo(TChronicinfo tChronicinfo);

    /**
     * 修改慢性信息
     * 
     * @param tChronicinfo 慢性信息
     * @return 结果
     */
    public int updateTChronicinfo(TChronicinfo tChronicinfo);

    /**
     * 删除慢性信息
     * 
     * @param id 慢性信息ID
     * @return 结果
     */
    public int deleteTChronicinfoById(String id);

    /**
     * 批量删除慢性信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTChronicinfoByIds(String[] ids);
}
