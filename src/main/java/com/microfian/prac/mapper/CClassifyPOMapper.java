package com.microfian.prac.mapper;

import com.microfian.prac.DTO.CClassifyDTO;
import com.microfian.prac.entity.CClassifyPO ;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CClassifyPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CClassifyPO record);

    int insertSelective(CClassifyPO record);

    CClassifyPO selectByPrimaryKey(Integer id);

    List<CClassifyPO> selCClassify(CClassifyDTO cClassifyDTO);

    int updateByPrimaryKeySelective(CClassifyPO record);

    int updateByPrimaryKey(CClassifyPO record);
}