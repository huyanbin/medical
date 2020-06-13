package com.gxuwz.medical.service.impl;

import java.util.List;

import com.gxuwz.medical.domain.Reimburse;
import com.gxuwz.medical.mapper.ReimburseMapper;
import com.gxuwz.medical.service.IReimburseService;
import com.gxuwz.medical.utils.Convert;
import com.gxuwz.medical.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 报销Service业务层处理
 * 
 * @author
 * @date 2020-06-06
 */
@Service
public class ReimburseServiceImpl implements IReimburseService
{
    @Autowired
    private ReimburseMapper reimburseMapper;

    /**
     * 查询报销
     * 
     * @param reiNo 报销ID
     * @return 报销
     */
    @Override
    public Reimburse selectReimburseById(String reiNo)
    {
        return reimburseMapper.selectReimburseById(reiNo);
    }

    /**
     * 查询报销列表
     * 
     * @param reimburse 报销
     * @return 报销
     */
    @Override
    public List<Reimburse> selectReimburseList(Reimburse reimburse)
    {
        return reimburseMapper.selectReimburseList(reimburse);
    }

    /**
     * 新增报销
     * 
     * @param reimburse 报销
     * @return 结果
     */
    @Override
    public int insertReimburse(Reimburse reimburse)
    {
        return reimburseMapper.insertReimburse(reimburse);
    }

    /**
     * 修改报销
     * 
     * @param reimburse 报销
     * @return 结果
     */
    @Override
    public int updateReimburse(Reimburse reimburse)
    {
        reimburse.setUpdateTime(DateUtils.getNowDate());
        return reimburseMapper.updateReimburse(reimburse);
    }

    /**
     * 删除报销对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteReimburseByIds(String ids)
    {
        return reimburseMapper.deleteReimburseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除报销信息
     * 
     * @param reiNo 报销ID
     * @return 结果
     */
    @Override
    public int deleteReimburseById(String reiNo)
    {
        return reimburseMapper.deleteReimburseById(reiNo);
    }
}
