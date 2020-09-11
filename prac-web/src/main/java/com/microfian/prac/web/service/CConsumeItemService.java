package com.microfian.prac.web.service;



import com.microfian.prac.web.DTO.CConsumeItemDTO;
import com.microfian.prac.web.DTO.ClassifyAndConsumeReturnDTO;
import com.microfian.prac.web.DTO.ResCConsumeItem;
import com.microfian.prac.web.request.ReqClassify;

import java.util.List;

public interface CConsumeItemService {

    List<ResCConsumeItem> listCConsumeItem(CConsumeItemDTO cConsumeItemDTO);

    List<ResCConsumeItem> listCConsumeItemBrokenLine(CConsumeItemDTO cConsumeItemDTO);

    List<ClassifyAndConsumeReturnDTO> listConsumeItemGroupAndOrder(ReqClassify reqClassify);
 }
