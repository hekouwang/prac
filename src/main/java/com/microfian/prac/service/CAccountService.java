package com.microfian.prac.service;

import com.microfian.prac.DTO.CAccountDTO;
import com.microfian.prac.entity.Account;
import com.microfian.prac.request.ReqAccount;
import com.microfian.prac.response.ResAccount;
import com.microfian.prac.response.Result;

import java.util.List;

public interface CAccountService {

    int addAccount(Account Account);

    Account selAccountById(String  id);

    List<Account> selAccount(CAccountDTO cAccountDTO);

    int updateAccount();

    List<Account> listAccount();

    Result listWishAccount();

    Result listAccountByGroup();

    Result<List<ResAccount>> getByIdOrParentId(ReqAccount reqAccount);


}
