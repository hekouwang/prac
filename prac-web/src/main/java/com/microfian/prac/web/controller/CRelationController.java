package com.microfian.prac.web.controller;


import com.microfian.prac.web.entity.CRelationPO;
import com.microfian.prac.web.service.CRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/relation")
public class CRelationController {

    @Autowired
    private CRelationService cRelationService;


    @PostMapping(value = "/listRelation")
    public Object listAccount(@RequestBody CRelationPO cRelationPO) {

        Map map = new HashMap<>();
        map.put("code",20000);
        map.put("data", cRelationService.selectByUserId(cRelationPO));
        return map;

    }

}
