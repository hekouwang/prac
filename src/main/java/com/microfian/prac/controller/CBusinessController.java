package com.microfian.prac.controller;

import com.microfian.prac.DTO.CConsumeItemDTO;
import com.microfian.prac.entity.CAccountPO;
import com.microfian.prac.service.CAccountService;
import com.microfian.prac.service.CBussinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;

@RestController
@RequestMapping("bussiness")
public class CBusinessController {

    @Autowired
    private CBussinessService cBussinessService;

    @Autowired
    private CAccountService cAccountService;

    @PostMapping(value = "/addOneExpand")
    public Object addOneExpand(@RequestBody CConsumeItemDTO cConsumeItemDTO){

        if(null ==cConsumeItemDTO){
            return null;
        }
        if(StringUtils.isEmpty(cConsumeItemDTO.getSourceAccount())){
            return null;
        }

        CAccountPO cAccountPO = checkAccount(cConsumeItemDTO.getSourceAccount());

        if(null ==cAccountPO){
            return null;
        }
        return cBussinessService.addOneExpand(cConsumeItemDTO,cAccountPO);

    }

    @PostMapping(value = "/tranferAccount")
    public Object tranferAccount(@RequestBody CConsumeItemDTO cConsumeItemDTO){

        if(null ==cConsumeItemDTO){
            return null;
        }
        if(StringUtils.isEmpty(cConsumeItemDTO.getSourceAccount())){
            return null;
        }

        CAccountPO cAccountPO = checkAccount(cConsumeItemDTO.getSourceAccount());
        CAccountPO cAccountPO1 = checkAccount(cConsumeItemDTO.getTargetAccount());

        if(null ==cAccountPO){
            return null;
        }
        return cBussinessService.tranferAccount(cConsumeItemDTO,cAccountPO,cAccountPO1);

    }

    @PostMapping(value = "/addOneIncome")
    public Object addOneIncome(@RequestBody CConsumeItemDTO cConsumeItemDTO){

        if(null ==cConsumeItemDTO){
            return null;
        }
        if(StringUtils.isEmpty(cConsumeItemDTO.getSourceAccount())){
            return null;
        }

        CAccountPO cAccountPO = checkAccount(cConsumeItemDTO.getSourceAccount());

        if(null ==cAccountPO){
            return null;
        }
        return cBussinessService.addOneIncome(cConsumeItemDTO,cAccountPO);

    }

    private CAccountPO checkAccount(String  accountId){

        return cAccountService.selAccountById(accountId);

    }

}
