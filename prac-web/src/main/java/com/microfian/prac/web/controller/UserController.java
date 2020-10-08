package com.microFian.prac.web.controller;

import cn.hutool.core.collection.CollUtil;
import com.microFian.prac.common.api.CommonResult;
import com.microFian.prac.web.entity.UserAdmin;
import com.microFian.prac.web.entity.UserRole;
import com.microFian.prac.web.request.UmsAdminLoginParam;
import com.microFian.prac.web.service.UserRoleService;
import com.microFian.prac.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

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
    public Object info(Principal principal){
        if(principal==null){
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        UserAdmin umsAdmin = userService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("menus", userRoleService.getMenuList(umsAdmin.getId().longValue()));
//        data.put("icon", umsAdmin.getIcon());
        List<UserRole> roleList = userService.getRoleList(umsAdmin.getId());
        if(CollUtil.isNotEmpty(roleList)){
            List<String> roles = roleList.stream().map(UserRole::getRolename).collect(Collectors.toList());
            data.put("roles",roles);
        }
        return CommonResult.success(data);
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