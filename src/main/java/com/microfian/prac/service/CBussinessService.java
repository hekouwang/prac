package com.microfian.prac.service;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.entity.CAccountPO;

public interface CBussinessService {

    Object addOneExpand(CConsumeItemDTO cConsumeItemDTO, CAccountPO cAccountPO);

    Object tranferAccount(CConsumeItemDTO cConsumeItemDTO,CAccountPO sourceAccount,CAccountPO targetAccount);

    Object addOneIncome(CConsumeItemDTO cConsumeItemDTO,CAccountPO cAccountPO);

}
