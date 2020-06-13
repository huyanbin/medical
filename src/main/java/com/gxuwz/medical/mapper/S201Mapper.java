package com.gxuwz.medical.mapper;

import com.gxuwz.medical.domain.S201;

import java.util.List;


/**
 * 隶属关系Mapper接口
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
public interface S201Mapper 
{
    /**
     * 查询隶属关系
     * 
     * @param id 隶属关系ID
     * @return 隶属关系
     */
    public S201 selectS201ById(Long id);

    /**
     * 查询隶属关系列表
     * 
     * @param s201 隶属关系
     * @return 隶属关系集合
     */
    public List<S201> selectS201List(S201 s201);

    /**
     * 新增隶属关系
     * 
     * @param s201 隶属关系
     * @return 结果
     */
    public int insertS201(S201 s201);

    /**
     * 修改隶属关系
     * 
     * @param s201 隶属关系
     * @return 结果
     */
    public int updateS201(S201 s201);

    /**
     * 删除隶属关系
     * 
     * @param id 隶属关系ID
     * @return 结果
     */
    public int deleteS201ById(Long id);

    /**
     * 批量删除隶属关系
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteS201ByIds(String[] ids);
}
