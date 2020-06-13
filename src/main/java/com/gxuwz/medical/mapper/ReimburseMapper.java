package com.gxuwz.medical.mapper;

import com.gxuwz.medical.domain.Reimburse;

import java.util.List;


/**
 * 报销Mapper接口
 * 
 * @author ruoyi
 * @date 2020-06-06
 */
public interface ReimburseMapper 
{
    /**
     * 查询报销
     * 
     * @param reiNo 报销ID
     * @return 报销
     */
    public Reimburse selectReimburseById(String reiNo);

    /**
     * 查询报销列表
     * 
     * @param reimburse 报销
     * @return 报销集合
     */
    public List<Reimburse> selectReimburseList(Reimburse reimburse);

    /**
     * 新增报销
     * 
     * @param reimburse 报销
     * @return 结果
     */
    public int insertReimburse(Reimburse reimburse);

    /**
     * 修改报销
     * 
     * @param reimburse 报销
     * @return 结果
     */
    public int updateReimburse(Reimburse reimburse);

    /**
     * 删除报销
     * 
     * @param reiNo 报销ID
     * @return 结果
     */
    public int deleteReimburseById(String reiNo);

    /**
     * 批量删除报销
     * 
     * @param reiNos 需要删除的数据ID
     * @return 结果
     */
    public int deleteReimburseByIds(String[] reiNos);
}
