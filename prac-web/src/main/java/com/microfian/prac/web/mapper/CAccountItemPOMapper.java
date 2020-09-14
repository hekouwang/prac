package com.microFian.prac.web.mapper;


import com.microFian.prac.web.entity.CAccountItemPO;
import org.springframework.stereotype.Repository;

@Repository
public interface CAccountItemPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CAccountItemPO record);

    int insertSelective(CAccountItemPO record);

    CAccountItemPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CAccountItemPO record);

    int updateByPrimaryKey(CAccountItemPO record);
}