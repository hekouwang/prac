package com.microfian.prac.web.service;


import com.microfian.prac.web.DTO.CClassifyDTO;
import com.microfian.prac.web.entity.Classify;
import com.microfian.prac.web.request.ReqClassify;
import com.microfian.prac.web.response.ResClassifyVo;
import com.microfian.prac.web.response.Result;

import java.util.List;

public interface CClassifyService {

    List<Classify> selClassify(CClassifyDTO cClassifyDTO);

    List<ResClassifyVo>  selClassifyByGroup(CClassifyDTO cClassifyDTO);

    Result<List<Classify>> getByIdOrParentId(ReqClassify reqClassify);

    Result addClassify (ReqClassify reqClassify);

    Result forbidClassify (ReqClassify reqClassify);

}
