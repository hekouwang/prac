package com.microFian.prac.web.service;


import com.microFian.prac.web.entity.CRelationPO;

import java.util.List;

public interface CRelationService {

    List<CRelationPO>  selectByUserId(CRelationPO cRelationPO);
}
