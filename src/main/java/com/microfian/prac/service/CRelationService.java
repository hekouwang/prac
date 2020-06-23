package com.microfian.prac.service;

import com.microfian.prac.entity.CRelationPO;

import java.util.List;

public interface CRelationService {

    List<CRelationPO>  selectByUserId(CRelationPO cRelationPO);
}
