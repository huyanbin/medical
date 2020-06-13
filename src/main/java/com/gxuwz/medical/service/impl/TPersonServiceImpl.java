package com.gxuwz.medical.service.impl;

import java.util.List;

import com.gxuwz.medical.domain.TPerson;
import com.gxuwz.medical.mapper.TPersonMapper;
import com.gxuwz.medical.service.ITPersonService;
import com.gxuwz.medical.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 人Service业务层处理
 * 
 * @author 麦奇
 * @date 2020-06-04
 */
@Service
public class TPersonServiceImpl implements ITPersonService
{
    @Autowired
    private TPersonMapper tPersonMapper;

    /**
     * 查询人
     * 
     * @param perscode 人ID
     * @return 人
     */
    @Override
    public TPerson selectTPersonById(String perscode)
    {
        return tPersonMapper.selectTPersonById(perscode);
    }

    @Override
    public TPerson selectTPersonByCardId(String cardId) {

        return tPersonMapper.selectTPersonByCardId(cardId);
    }

    /**
     * 查询人列表
     * 
     * @param tPerson 人
     * @return 人
     */
    @Override
    public List<TPerson> selectTPersonList(TPerson tPerson)
    {
        return tPersonMapper.selectTPersonList(tPerson);
    }

    /**
     * 新增人
     * 
     * @param tPerson 人
     * @return 结果
     */
    @Override
    public int insertTPerson(TPerson tPerson)
    {
        return tPersonMapper.insertTPerson(tPerson);
    }

    /**
     * 修改人
     * 
     * @param tPerson 人
     * @return 结果
     */
    @Override
    public int updateTPerson(TPerson tPerson)
    {
        return tPersonMapper.updateTPerson(tPerson);
    }

    /**
     * 删除人对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTPersonByIds(String ids)
    {
        return tPersonMapper.deleteTPersonByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人信息
     * 
     * @param perscode 人ID
     * @return 结果
     */
    @Override
    public int deleteTPersonById(String perscode)
    {
        return tPersonMapper.deleteTPersonById(perscode);
    }
}
