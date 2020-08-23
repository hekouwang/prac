package com.microfian.prac.service;

import com.microfian.prac.DTO.CClassifyDTO;
import com.microfian.prac.request.ReqClassify;
import com.microfian.prac.response.ResClassify;
import com.microfian.prac.response.ResClassifyVo;
import com.microfian.prac.entity.Classify;
import com.microfian.prac.response.Result;

import java.util.List;

public interface CClassifyService {

    List<Classify> selClassify(CClassifyDTO cClassifyDTO);

    List<ResClassifyVo>  selClassifyByGroup(CClassifyDTO cClassifyDTO);

    Result<List<Classify>> getByIdOrParentId(ReqClassify reqClassify);

    Result addClassify (ReqClassify reqClassify);

    Result forbidClassify (ReqClassify reqClassify);

}
