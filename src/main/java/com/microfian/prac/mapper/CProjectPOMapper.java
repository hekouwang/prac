package com.microfian.prac.mapper;


import com.microfian.prac.entity.CProjectPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CProjectPOMapper {

    int deleteByPrimaryKey(String id);

    int insert(CProjectPO record);

    int insertSelective(CProjectPO record);

    CProjectPO selectByPrimaryKey(String id);

    List<CProjectPO> selectProject(CProjectPO cProjectPO);

    int updateByPrimaryKeySelective(CProjectPO record);

    int updateByPrimaryKey(CProjectPO record);
}