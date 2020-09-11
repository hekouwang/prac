package com.microfian.prac.web.service;


import com.microfian.prac.web.entity.CRelationPO;

import java.util.List;

public interface CRelationService {

    List<CRelationPO>  selectByUserId(CRelationPO cRelationPO);
}
