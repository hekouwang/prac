package com.microFian.prac.web.controller;

import com.microFian.prac.common.api.CommonResult;
import com.microFian.prac.web.request.UmsAdminLoginParam;
import com.microFian.prac.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UserService userService;

//    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
    @ResponseBody
    public CommonResult login(@Validated @RequestBody UmsAdminLoginParam umsAdminLoginParam) {

        String token = userService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);

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