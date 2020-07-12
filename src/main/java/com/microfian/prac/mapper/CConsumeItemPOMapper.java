package com.microfian.prac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.DTO.CConsumeItemReturnDTO;
import com.microfian.prac.entity.ConsumeItem;
import com.microfian.prac.request.ReqClassify;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CConsumeItemPOMapper extends BaseMapper<ConsumeItem> {
    int deleteByPrimaryKey(String id);

    int insert(ConsumeItem record);

    int insertSelective(ConsumeItem record);

    ConsumeItem selectByPrimaryKey(String id);

    List<CConsumeItemReturnDTO> selByCondition(CConsumeItemDTO cConsumeItemDTO);

    List<ConsumeItem> selByParentId(ReqClassify reqClassify);

    List<ConsumeItem> selById(ReqClassify reqClassify);

    int updateByPrimaryKeySelective(ConsumeItem record);

    int updateByPrimaryKey(ConsumeItem record);
}