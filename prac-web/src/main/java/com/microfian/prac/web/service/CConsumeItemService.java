package com.microFian.prac.web.service;



import com.microFian.prac.web.DTO.CConsumeItemDTO;
import com.microFian.prac.web.DTO.ClassifyAndConsumeReturnDTO;
import com.microFian.prac.web.DTO.ResCConsumeItem;
import com.microFian.prac.web.request.ReqClassify;

import java.util.List;

public interface CConsumeItemService {

    List<ResCConsumeItem> listCConsumeItem(CConsumeItemDTO cConsumeItemDTO);

    List<ResCConsumeItem> listCConsumeItemBrokenLine(CConsumeItemDTO cConsumeItemDTO);

    List<ClassifyAndConsumeReturnDTO> listConsumeItemGroupAndOrder(ReqClassify reqClassify);
 }
