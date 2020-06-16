package com.microfian.prac.controller;

import com.microfian.prac.entity.CAccountPO;
import com.microfian.prac.entity.CMerchantPO;
import com.microfian.prac.service.CAccountService;
import com.microfian.prac.service.CMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class CAccountController {

    @Autowired
    private CAccountService cAccountService;

    @PostMapping(value = "/addAccount")
    public Object addAccount(@RequestBody CAccountPO cAccountPO){
        return cAccountService.addAccount(cAccountPO);
    }
}
