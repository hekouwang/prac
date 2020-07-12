package com.microfian.prac.service;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.DTO.ClassifyAndConsumeReturnDTO;
import com.microfian.prac.DTO.ResCConsumeItem;
import com.microfian.prac.request.ReqClassify;

import java.util.List;

public interface CConsumeItemService {

    List<ResCConsumeItem> listCConsumeItem(CConsumeItemDTO cConsumeItemDTO);

    List<ClassifyAndConsumeReturnDTO> listConsumeItemGroupAndOrder(ReqClassify reqClassify);
 }
