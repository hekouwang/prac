package com.microfian.prac.service.impl;

import com.microfian.prac.entity.CAccountPO;
import com.microfian.prac.mapper.CAccountPOMapper;
import com.microfian.prac.service.CAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CAccountServiceImpl implements CAccountService {


    @Autowired
    CAccountPOMapper cAccountPOMapper;


    @Override
    public int addAccount(CAccountPO cAccountPO) {
        return 0;
    }

    @Override
    public CAccountPO selAccountById(String id) {
        return cAccountPOMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateAccount() {
        return 0;
    }

    @Override
    public List<CAccountPO> listAccount() {
        return null;
    }
}
