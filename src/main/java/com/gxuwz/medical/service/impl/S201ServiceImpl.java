package com.gxuwz.medical.service.impl;

import java.util.List;

import com.gxuwz.medical.domain.S201;
import com.gxuwz.medical.mapper.S201Mapper;
import com.gxuwz.medical.service.IS201Service;
import com.gxuwz.medical.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 隶属关系Service业务层处理
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Service
public class S201ServiceImpl implements IS201Service
{
    @Autowired
    private S201Mapper s201Mapper;

    /**
     * 查询隶属关系
     * 
     * @param id 隶属关系ID
     * @return 隶属关系
     */
    @Override
    public S201 selectS201ById(Long id)
    {
        return s201Mapper.selectS201ById(id);
    }

    /**
     * 查询隶属关系列表
     * 
     * @param s201 隶属关系
     * @return 隶属关系
     */
    @Override
    public List<S201> selectS201List(S201 s201)
    {
        return s201Mapper.selectS201List(s201);
    }

    /**
     * 新增隶属关系
     * 
     * @param s201 隶属关系
     * @return 结果
     */
    @Override
    public int insertS201(S201 s201)
    {
        return s201Mapper.insertS201(s201);
    }

    /**
     * 修改隶属关系
     * 
     * @param s201 隶属关系
     * @return 结果
     */
    @Override
    public int updateS201(S201 s201)
    {
        return s201Mapper.updateS201(s201);
    }

    /**
     * 删除隶属关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteS201ByIds(String ids)
    {
        return s201Mapper.deleteS201ByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除隶属关系信息
     * 
     * @param id 隶属关系ID
     * @return 结果
     */
    @Override
    public int deleteS201ById(Long id)
    {
        return s201Mapper.deleteS201ById(id);
    }
}
