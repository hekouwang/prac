package com.microfian.prac.service;

import com.microfian.prac.DTO.CAccountDTO;
import com.microfian.prac.DTO.CClassifyDTO;
import com.microfian.prac.DTO.ClassifyVo;
import com.microfian.prac.entity.CClassifyPO;

import java.util.List;

public interface CClassifyService {

    List<CClassifyPO> selClassify(CClassifyDTO cClassifyDTO);

    List<ClassifyVo>  selClassifyByGroup(CClassifyDTO cClassifyDTO);
}
