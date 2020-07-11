package com.microfian.prac.service.impl;

import com.microfian.prac.entity.CRelationPO;
import com.microfian.prac.mapper.CRelationPOMapper;
import com.microfian.prac.service.CRelationService;
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
