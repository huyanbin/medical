package com.gxuwz.medical.mapper;

import com.gxuwz.medical.domain.TChronicdis;

import java.util.List;

/**
 * 慢性病Mapper接口
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
public interface TChronicdisMapper 
{
    /**
     * 查询慢性病
     * 
     * @param illcode 慢性病ID
     * @return 慢性病
     */
    public TChronicdis selectTChronicdisById(String illcode);

    /**
     * 查询慢性病列表
     * 
     * @param tChronicdis 慢性病
     * @return 慢性病集合
     */
    public List<TChronicdis> selectTChronicdisList(TChronicdis tChronicdis);

    /**
     * 新增慢性病
     * 
     * @param tChronicdis 慢性病
     * @return 结果
     */
    public int insertTChronicdis(TChronicdis tChronicdis);

    /**
     * 修改慢性病
     * 
     * @param tChronicdis 慢性病
     * @return 结果
     */
    public int updateTChronicdis(TChronicdis tChronicdis);

    /**
     * 删除慢性病
     * 
     * @param illcode 慢性病ID
     * @return 结果
     */
    public int deleteTChronicdisById(String illcode);

    /**
     * 批量删除慢性病
     * 
     * @param illcodes 需要删除的数据ID
     * @return 结果
     */
    public int deleteTChronicdisByIds(String[] illcodes);
}
