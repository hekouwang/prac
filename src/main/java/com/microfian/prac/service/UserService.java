package com.microfian.prac.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.microfian.prac.entity.User;
import com.microfian.prac.entity.UserPermission;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author hekouwang
 * @since 2020-08-07
 */
public interface UserService extends IService<User> {



   User selectByName(String name);

   List<UserPermission> getPermissionList(Integer adminId);


   /**
    * 登录功能
    * @param username 用户名
    * @param password 密码
    * @return 生成的JWT的token
    */
   String login(String username,String password);


   /**
    * 获取用户信息
    */
   UserDetails loadUserByUsername(String username);

}
