package com.gxuwz.medical.service;

import com.gxuwz.medical.domain.TArea;

import java.util.List;


/**
 * 行政区域信息Service接口
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
public interface ITAreaService 
{
    /**
     * 查询行政区域信息
     * 
     * @param areacode 行政区域信息ID
     * @return 行政区域信息
     */
    public TArea selectTAreaById(String areacode);

    /**
     * 查询行政区域信息列表
     * 
     * @param tArea 行政区域信息
     * @return 行政区域信息集合
     */
    public List<TArea> selectTAreaList(TArea tArea);

    /**
     * 新增行政区域信息
     * 
     * @param tArea 行政区域信息
     * @return 结果
     */
    public int insertTArea(TArea tArea);

    /**
     * 修改行政区域信息
     * 
     * @param tArea 行政区域信息
     * @return 结果
     */
    public int updateTArea(TArea tArea);

    /**
     * 批量删除行政区域信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTAreaByIds(String ids);

    /**
     * 删除行政区域信息信息
     * 
     * @param areacode 行政区域信息ID
     * @return 结果
     */
    public int deleteTAreaById(String areacode);
}
