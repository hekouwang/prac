package com.microfian.prac.mapper;


import com.microfian.prac.DTO.CAccountDTO;
import com.microfian.prac.entity.CAccountPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CAccountPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(CAccountPO record);

    int insertSelective(CAccountPO record);

    CAccountPO selectByPrimaryKey(String id);

    List<CAccountPO> selCAcount(CAccountDTO cAccountDTO);

    int updateByPrimaryKeySelective(CAccountPO record);

    int updateByPrimaryKey(CAccountPO record);
}