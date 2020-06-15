package com.microfian.prac.mapper;


import com.microfian.prac.entity.CAccountPO;

public interface CAccountPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(CAccountPO record);

    int insertSelective(CAccountPO record);

    CAccountPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CAccountPO record);

    int updateByPrimaryKey(CAccountPO record);
}