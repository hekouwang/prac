package com.microfian.prac.service;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.entity.Account;

public interface CBussinessService {

    Object addOneExpand(CConsumeItemDTO cConsumeItemDTO, Account Account);

    Object tranferAccount(CConsumeItemDTO cConsumeItemDTO,Account sourceAccount,Account targetAccount);

    Object addOneIncome(CConsumeItemDTO cConsumeItemDTO,Account Account);

}
