package com.microfian.prac.service.impl;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.DTO.CConsumeItemReturnDTO;
import com.microfian.prac.mapper.CConsumeItemPOMapper;
import com.microfian.prac.service.CConsumeItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CConsumeItemServiceImpl implements CConsumeItemService {

    @Autowired
    private CConsumeItemPOMapper cConsumeItemPOMapper;

    @Override
    public List<CConsumeItemReturnDTO> listCConsumeItem(CConsumeItemDTO cConsumeItemDTO) {
        return cConsumeItemPOMapper.selByCondition(cConsumeItemDTO);
    }
}
