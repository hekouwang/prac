package com.microfian.prac.service.impl;

import com.microfian.prac.entity.CProjectPO;
import com.microfian.prac.mapper.CProjectPOMapper;
import com.microfian.prac.service.CProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CProjectServiceImpl implements CProjectService {

    @Autowired
    private CProjectPOMapper cProjectPOMapper;

    @Override
    public List<CProjectPO> selectProject(CProjectPO cProjectPO) {

        return cProjectPOMapper.selectProject(cProjectPO);

    }

}
