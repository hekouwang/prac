package com.microFian.prac.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping(value = "/login")
    public Object addAccount(){
        Map<String, Object> map=new HashMap<String ,Object>();
        map.put("code",20000);
        Map<String, String> map1=new HashMap<String,String>();
        map1.put("token","admin-token");
        map.put("data",map1);
        return map;
    }

    @GetMapping(value = "/info")
    public Object info(){
        Map<String, Object> map=new HashMap<String ,Object>();
        map.put("code",20000);
        Map<String, Object> map1=new HashMap<String,Object>();
        map1.put("token","admin-token");
        map1.put("introduction","I am a super administrator");
        map1.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map1.put("name","Super Admin");
        String[] arg={"admin"};
        map.put("data",map1);
        map1.put("roles",arg);
        return map;
    }
}

//{
//        "code": 20000,
//        "data": {
//        "roles": [
//        "admin"
//        ],
//        "introduction": "I am a super administrator",
//        "avatar": "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
//        "name": "Super Admin"
//        }