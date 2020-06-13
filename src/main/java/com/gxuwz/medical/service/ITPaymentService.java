package com.gxuwz.medical.service;

import com.gxuwz.medical.domain.TPayment;

import java.util.List;

/**
 * 付款Service接口
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
public interface ITPaymentService 
{
    /**
     * 查询付款
     * 
     * @param payno 付款ID
     * @return 付款
     */
    public TPayment selectTPaymentById(Long payno);

    /**
     * 查询付款列表
     * 
     * @param tPayment 付款
     * @return 付款集合
     */
    public List<TPayment> selectTPaymentList(TPayment tPayment);

    /**
     * 新增付款
     * 
     * @param tPayment 付款
     * @return 结果
     */
    public int insertTPayment(TPayment tPayment);

    /**
     * 修改付款
     * 
     * @param tPayment 付款
     * @return 结果
     */
    public int updateTPayment(TPayment tPayment);

    /**
     * 批量删除付款
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTPaymentByIds(String ids);

    /**
     * 删除付款信息
     * 
     * @param payno 付款ID
     * @return 结果
     */
    public int deleteTPaymentById(Long payno);
}
