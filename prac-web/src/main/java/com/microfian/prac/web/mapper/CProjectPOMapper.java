package com.microFian.prac.web.mapper;


import com.microFian.prac.web.entity.CProjectPO;
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