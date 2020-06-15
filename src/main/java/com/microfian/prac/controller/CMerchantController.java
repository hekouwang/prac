package com.microfian.prac.controller;

import com.microfian.prac.entity.CMerchantPO;
import com.microfian.prac.service.CMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("merchant")
public class CMerchantController {

    @Autowired
    private CMerchantService cMerchantService;

    @PostMapping(value = "/addMerchant")
    public Object addMerant(@RequestBody CMerchantPO cMerchantPO){
        return cMerchantService.addMerchant(cMerchantPO);
    }
}
