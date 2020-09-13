package com.microfian.prac.web.service;


import com.microfian.parc.common.api.CommonResult;
import com.microfian.prac.web.DTO.CAccountDTO;
import com.microfian.prac.web.entity.Account;
import com.microfian.prac.web.request.ReqAccount;
import com.microfian.prac.web.response.ResAccount;
import com.microfian.prac.web.response.Result;

import java.util.List;

public interface CAccountService {

    int addAccount(Account Account);

    Account selAccountById(String  id);

    List<Account> selAccount(CAccountDTO cAccountDTO);

    int updateAccount();

    List<Account> listAccount();

    Result listWishAccount();

    Result listAccountByGroup();

    CommonResult listAccountByGroupSelect();

    Result<List<ResAccount>> getByIdOrParentId(ReqAccount reqAccount);


}
