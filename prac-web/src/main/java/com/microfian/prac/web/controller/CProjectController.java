package com.microfian.prac.web.controller;

import com.microfian.prac.web.entity.CProjectPO;
import com.microfian.prac.web.service.CProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("project")
public class CProjectController {

    @Autowired
    private CProjectService cProjectService;


    @PostMapping(value = "/listProject")
    public Object listProject(@RequestBody CProjectPO cProjectPO){
        Map map = new HashMap<>();
        map.put("code",20000);
        map.put("data",cProjectService.selectProject(cProjectPO));
        return map;
    }

}
