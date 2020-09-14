package com.microFian.prac.web.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.microFian.prac.web.DTO.CConsumeItemDTO;
import com.microFian.prac.web.DTO.CConsumeItemReturnDTO;
import com.microFian.prac.web.entity.ConsumeItem;
import com.microFian.prac.web.request.ReqClassify;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CConsumeItemPOMapper extends BaseMapper<ConsumeItem> {
    int deleteByPrimaryKey(String id);

    int insert(ConsumeItem record);

    int insertSelective(ConsumeItem record);

    ConsumeItem selectByPrimaryKey(String id);

    List<CConsumeItemReturnDTO> selByCondition(CConsumeItemDTO cConsumeItemDTO);

    List<CConsumeItemReturnDTO> selByConditionAsc(CConsumeItemDTO cConsumeItemDTO);

    List<ConsumeItem> selByParentId(ReqClassify reqClassify);

    List<ConsumeItem> selById(ReqClassify reqClassify);

    int updateByPrimaryKeySelective(ConsumeItem record);

    int updateByPrimaryKey(ConsumeItem record);
}