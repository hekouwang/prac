package com.microFian.prac.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.microFian.prac.web.entity.UserAdmin;
import com.microFian.prac.web.entity.UserResource;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author hekouwang
 * @since 2020-09-14
 */
public interface UserService extends IService<UserAdmin> {


    /**
     * 根据用户名获取后台管理员
     */
    UserAdmin getAdminByUsername(String username);


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

    /**
     * 获取指定用户的可访问资源
     */
    List<UserResource> getResourceList(Long adminId);

}
