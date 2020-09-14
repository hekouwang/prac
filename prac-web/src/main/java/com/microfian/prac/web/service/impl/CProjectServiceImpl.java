package com.microFian.prac.web.service.impl;


import com.microFian.prac.web.entity.CProjectPO;
import com.microFian.prac.web.mapper.CProjectPOMapper;
import com.microFian.prac.web.service.CProjectService;
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
