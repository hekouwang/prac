package com.microfian.prac.service;

import com.microfian.prac.DTO.CAccountDTO;
import com.microfian.prac.entity.CAccountPO;

import java.util.List;

public interface CAccountService {

    int addAccount(CAccountPO cAccountPO);

    CAccountPO selAccountById(String  id);

    List<CAccountPO> selAccount(CAccountDTO cAccountDTO);

    int updateAccount();

    List<CAccountPO> listAccount();
}
