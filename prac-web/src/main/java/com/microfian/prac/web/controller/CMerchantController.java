package com.microFian.prac.web.controller;


import com.microFian.prac.web.entity.CMerchantPO;
import com.microFian.prac.web.service.CMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("merchant")
public class CMerchantController {

    @Autowired
    private CMerchantService cMerchantService;

    @PostMapping(value = "/addMerchant")
    public Object addMerant(@RequestBody CMerchantPO cMerchantPO){
        return cMerchantService.addMerchant(cMerchantPO);

    }

    @PostMapping(value = "/listMerchant")
    public Object listMerchant(@RequestBody CMerchantPO cMerchantPO){
        Map map = new HashMap<>();
        map.put("code",20000);
        map.put("data",cMerchantService.selectMerchant(cMerchantPO));
        return map;
    }

    public static void main(String[] args) {


    }
}
