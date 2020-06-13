package com.gxuwz.medical.service.impl;

import java.util.List;

import com.gxuwz.medical.domain.TArea;
import com.gxuwz.medical.mapper.TAreaMapper;
import com.gxuwz.medical.service.ITAreaService;
import com.gxuwz.medical.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 行政区域信息Service业务层处理
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Service
public class TAreaServiceImpl implements ITAreaService
{
    @Autowired
    private TAreaMapper tAreaMapper;

    /**
     * 查询行政区域信息
     * 
     * @param areacode 行政区域信息ID
     * @return 行政区域信息
     */
    @Override
    public TArea selectTAreaById(String areacode)
    {
        return tAreaMapper.selectTAreaById(areacode);
    }

    /**
     * 查询行政区域信息列表
     * 
     * @param tArea 行政区域信息
     * @return 行政区域信息
     */
    @Override
    public List<TArea> selectTAreaList(TArea tArea)
    {
        return tAreaMapper.selectTAreaList(tArea);
    }

    /**
     * 新增行政区域信息
     * 
     * @param tArea 行政区域信息
     * @return 结果
     */
    @Override
    public int insertTArea(TArea tArea)
    {
        return tAreaMapper.insertTArea(tArea);
    }

    /**
     * 修改行政区域信息
     * 
     * @param tArea 行政区域信息
     * @return 结果
     */
    @Override
    public int updateTArea(TArea tArea)
    {
        return tAreaMapper.updateTArea(tArea);
    }

    /**
     * 删除行政区域信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTAreaByIds(String ids)
    {
        return tAreaMapper.deleteTAreaByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除行政区域信息信息
     * 
     * @param areacode 行政区域信息ID
     * @return 结果
     */
    @Override
    public int deleteTAreaById(String areacode)
    {
        return tAreaMapper.deleteTAreaById(areacode);
    }
}
