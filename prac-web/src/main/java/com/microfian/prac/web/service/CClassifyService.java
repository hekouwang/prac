package com.microFian.prac.web.service;


import com.microFian.prac.web.DTO.CClassifyDTO;
import com.microFian.prac.web.entity.Classify;
import com.microFian.prac.web.request.ReqClassify;
import com.microFian.prac.web.response.ResClassifyVo;
import com.microFian.prac.web.response.Result;

import java.util.List;

public interface CClassifyService {

    List<Classify> selClassify(CClassifyDTO cClassifyDTO);

    List<ResClassifyVo>  selClassifyByGroup(CClassifyDTO cClassifyDTO);

    Result<List<Classify>> getByIdOrParentId(ReqClassify reqClassify);

    Result addClassify (ReqClassify reqClassify);

    Result forbidClassify (ReqClassify reqClassify);

}
