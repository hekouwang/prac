package com.microfian.prac.controller;

import com.microfian.prac.DTO.CAccountDTO;
import com.microfian.prac.entity.Account;
import com.microfian.prac.entity.CMerchantPO;
import com.microfian.prac.response.Result;
import com.microfian.prac.service.CAccountService;
import com.microfian.prac.service.CMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class CAccountController {

    @Autowired
    private CAccountService cAccountService;

    @PostMapping(value = "/addAccount")
    public Object addAccount(@RequestBody Account Account){
        return cAccountService.addAccount(Account);
    }

    @PostMapping(value = "/listAccount")
    public Object listAccount(@RequestBody CAccountDTO cAccountDTO) {
        Map map = new HashMap<>();
        map.put("code",20000);
        map.put("data", cAccountService.selAccount(cAccountDTO));
        return map;
    }

    @PostMapping(value = "/listWishAccount")
    public Object listWishAccount(@RequestBody CAccountDTO cAccountDTO) {

        try {
            return cAccountService.listWishAccount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success();

    }

}
