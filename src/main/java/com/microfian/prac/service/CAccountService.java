package com.microfian.prac.service;

import com.microfian.prac.entity.CAccountPO;

import java.util.List;

public interface CAccountService {

    int addAccount(CAccountPO cAccountPO);

    CAccountPO selAccountById(String  id);

    int updateAccount();

    List<CAccountPO> listAccount();
}
