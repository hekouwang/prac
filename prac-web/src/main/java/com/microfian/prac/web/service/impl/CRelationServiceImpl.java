package com.microfian.prac.web.service.impl;


import com.microfian.prac.web.entity.CRelationPO;
import com.microfian.prac.web.mapper.CRelationPOMapper;
import com.microfian.prac.web.service.CRelationService;
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
