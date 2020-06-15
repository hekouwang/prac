package com.microfian.prac.mapper;


import com.microfian.prac.entity.CAccountItemPO;

public interface CAccountItemPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CAccountItemPO record);

    int insertSelective(CAccountItemPO record);

    CAccountItemPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CAccountItemPO record);

    int updateByPrimaryKey(CAccountItemPO record);
}