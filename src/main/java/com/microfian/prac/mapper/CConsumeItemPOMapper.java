package com.microfian.prac.mapper;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.DTO.CConsumeItemReturnDTO;
import com.microfian.prac.entity.CConsumeItemPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CConsumeItemPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(CConsumeItemPO record);

    int insertSelective(CConsumeItemPO record);

    CConsumeItemPO selectByPrimaryKey(String id);

    List<CConsumeItemReturnDTO> selByCondition(CConsumeItemDTO cConsumeItemDTO);

    int updateByPrimaryKeySelective(CConsumeItemPO record);

    int updateByPrimaryKey(CConsumeItemPO record);
}