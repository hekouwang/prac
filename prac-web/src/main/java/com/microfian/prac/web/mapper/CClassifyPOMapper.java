package com.microfian.prac.web.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.microfian.prac.web.DTO.CClassifyDTO;
import com.microfian.prac.web.entity.Classify;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CClassifyPOMapper extends BaseMapper<Classify> {
    int deleteByPrimaryKey(Integer id);

    int insert(Classify record);

    int insertSelective(Classify record);

    Classify selectByPrimaryKey(Integer id);

    List<Classify> selCClassify(CClassifyDTO cClassifyDTO);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);
}