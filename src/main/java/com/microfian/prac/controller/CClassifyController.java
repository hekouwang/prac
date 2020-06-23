package com.microfian.prac.controller;

import com.microfian.prac.DTO.CAccountDTO;
import com.microfian.prac.DTO.CClassifyDTO;
import com.microfian.prac.entity.CAccountPO;
import com.microfian.prac.mapper.CClassifyPOMapper;
import com.microfian.prac.service.CAccountService;
import com.microfian.prac.service.CClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/classify")
public class CClassifyController {

    @Autowired
    private CClassifyService cClassifyService;


    @PostMapping(value = "/listClassify")
    public Object listAccount(@RequestBody CClassifyDTO cClassifyDTO) {
        Map map = new HashMap<>();
        map.put("code",20000);
        map.put("data", cClassifyService.selClassify(cClassifyDTO));
        return map;
    }

    @PostMapping(value = "/listClassifyByGroup")
    public Object listClassifyByGroup(@RequestBody CClassifyDTO cClassifyDTO) {
        Map map = new HashMap<>();
        map.put("code",20000);
        map.put("data", cClassifyService.selClassify(cClassifyDTO));
        return map;
    }


}
