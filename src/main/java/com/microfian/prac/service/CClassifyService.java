package com.microfian.prac.service;

import com.microfian.prac.DTO.CClassifyDTO;
import com.microfian.prac.DTO.ClassifyVo;
import com.microfian.prac.entity.Classify;

import java.util.List;

public interface CClassifyService {

    List<Classify> selClassify(CClassifyDTO cClassifyDTO);

    List<ClassifyVo>  selClassifyByGroup(CClassifyDTO cClassifyDTO);

}
