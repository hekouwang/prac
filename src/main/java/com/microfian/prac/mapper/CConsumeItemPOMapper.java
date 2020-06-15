package com.microfian.prac.mapper;

import com.microfian.prac.entity.CConsumeItemPO;

public interface CConsumeItemPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(CConsumeItemPO record);

    int insertSelective(CConsumeItemPO record);

    CConsumeItemPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CConsumeItemPO record);

    int updateByPrimaryKey(CConsumeItemPO record);
}