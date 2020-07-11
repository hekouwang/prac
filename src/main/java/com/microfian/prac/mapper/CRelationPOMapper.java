package com.microfian.prac.mapper;

import com.microfian.prac.entity.CRelationPO ;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CRelationPOMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CRelationPO record);

    int insertSelective(CRelationPO record);

    CRelationPO selectByPrimaryKey(Integer id);

    List<CRelationPO> selectByUserId(CRelationPO cRelationPO);

    int updateByPrimaryKeySelective(CRelationPO record);

    int updateByPrimaryKey(CRelationPO record);
}