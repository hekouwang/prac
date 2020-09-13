package com.microfian.prac.web.controller;

import com.microfian.prac.web.DTO.CConsumeItemDTO;
import com.microfian.prac.web.entity.Account;
import com.microfian.prac.web.service.CAccountService;
import com.microfian.prac.web.service.CBussinessService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/bussiness")
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

        Account account = checkAccount(cConsumeItemDTO.getSourceAccount());

        if(null ==account){
            return null;
        }
        Map map = new HashMap<>();
        map.put("code",20000);
        map.put("data", cBussinessService.addOneExpand(cConsumeItemDTO,account));
        return map;

    }

    @PostMapping(value = "/tranferAccount")
    public Object tranferAccount(@RequestBody CConsumeItemDTO cConsumeItemDTO){

        if(null ==cConsumeItemDTO){
            return null;
        }
        if(StringUtils.isEmpty(cConsumeItemDTO.getSourceAccount())){
            return null;
        }

        Account account = checkAccount(cConsumeItemDTO.getSourceAccount());
        Account account1 = checkAccount(cConsumeItemDTO.getTargetAccount());

        if(null ==account){
            return null;
        }
        Map map = new HashMap<>();
        map.put("code",20000);
        map.put("data", cBussinessService.tranferAccount(cConsumeItemDTO,account,account1));
        return map;

    }

    @PostMapping(value = "/addOneIncome")
    public Object addOneIncome(@RequestBody CConsumeItemDTO cConsumeItemDTO){

        if(null ==cConsumeItemDTO){
            return null;
        }
        if(StringUtils.isEmpty(cConsumeItemDTO.getSourceAccount())){
            return null;
        }

        Account account = checkAccount(cConsumeItemDTO.getSourceAccount());

        if(null ==account){
            return null;
        }
        Map map = new HashMap<>();
        map.put("code",20000);
        map.put("data", cBussinessService.addOneIncome(cConsumeItemDTO,account));
        return map;

    }

    private Account checkAccount(String  accountId){

        return cAccountService.selAccountById(accountId);

    }

}
