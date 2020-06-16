package com.microfian.prac.service;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.DTO.CConsumeItemReturnDTO;

import java.util.List;

public interface CConsumeItemService {

    List<CConsumeItemReturnDTO> listCConsumeItem(CConsumeItemDTO cConsumeItemDTO);
 }
