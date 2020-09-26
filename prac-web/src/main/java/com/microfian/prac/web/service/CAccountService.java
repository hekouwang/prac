package com.microFian.prac.web.service;


import com.microFian.prac.common.api.CommonResult;
import com.microFian.prac.web.DTO.CAccountDTO;
import com.microFian.prac.web.entity.Account;
import com.microFian.prac.web.request.ReqAccount;
import com.microFian.prac.web.response.ResAccount;
import com.microFian.prac.web.response.Result;

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


    CommonResult getTotalMoney();


}
