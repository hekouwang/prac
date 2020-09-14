package com.microFian.prac.web.service;

import com.microFian.prac.web.DTO.CConsumeItemDTO;
import com.microFian.prac.web.entity.Account;

public interface CBussinessService {

    Object addOneExpand(CConsumeItemDTO cConsumeItemDTO, Account Account);

    Object tranferAccount(CConsumeItemDTO cConsumeItemDTO,Account sourceAccount,Account targetAccount);

    Object addOneIncome(CConsumeItemDTO cConsumeItemDTO,Account Account);

}
