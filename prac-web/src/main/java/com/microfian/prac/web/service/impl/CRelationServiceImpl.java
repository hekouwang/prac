package com.microFian.prac.web.service.impl;


import com.microFian.prac.web.entity.CRelationPO;
import com.microFian.prac.web.mapper.CRelationPOMapper;
import com.microFian.prac.web.service.CRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRelationServiceImpl implements CRelationService {

    @Autowired
    private CRelationPOMapper cRelationPOMapper;

    @Override
    public List<CRelationPO> selectByUserId(CRelationPO cRelationPO) {

        return cRelationPOMapper.selectByUserId(cRelationPO);

    }
}
