package com.microfian.prac.mapper;


import com.microfian.prac.entity.CProjectPO;
import org.springframework.stereotype.Repository;

@Repository
public interface CProjectPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(CProjectPO record);

    int insertSelective(CProjectPO record);

    CProjectPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CProjectPO record);

    int updateByPrimaryKey(CProjectPO record);
}