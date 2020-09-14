package com.microFian.prac.web.controller;


import com.microFian.prac.web.DTO.CClassifyDTO;
import com.microFian.prac.web.request.ReqClassify;
import com.microFian.prac.web.response.Result;
import com.microFian.prac.web.service.CClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
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
        map.put("data", cClassifyService.selClassifyByGroup(cClassifyDTO));
        return map;
    }

    @PostMapping(value = "/getByIdOrParentId")
    public Object getByIdOrParentId(@RequestBody ReqClassify reqClassify) {

        try {
            return cClassifyService.getByIdOrParentId(reqClassify);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success();
    }

    /**
     * 增加分类
     * @param reqClassify
     * @return
     */
    @PostMapping(value = "/addClassify")
    public Object listAccount(@RequestBody ReqClassify reqClassify) {

        try {
            return cClassifyService.addClassify(reqClassify);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success();
    }


}
