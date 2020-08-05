package com.microfian.prac.controller;


import com.microfian.prac.DTO.CAccountDTO;
import com.microfian.prac.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hekouwang
 * @since 2020-08-01
 */
@RestController
@RequestMapping("/wish")
public class WishController {

    @Autowired
    private WishService wishService;

    @PostMapping(value = "/listAccount")
    public Object listAccount(@RequestBody CAccountDTO cAccountDTO) {

//        wishService.page()
        Map map = new HashMap<>();
        map.put("code",20000);
//        map.put("data", cAccountService.selAccount(cAccountDTO));
        return map;
    }
}
