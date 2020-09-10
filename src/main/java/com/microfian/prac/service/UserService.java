package com.microfian.prac.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.microfian.prac.entity.User;
import com.microfian.prac.entity.UserPermission;

import java.util.List;

/**
 * @author hekouwang
 * @since 2020-08-07
 */
public interface UserService extends IService<User> {

   User selectByName(String name);

   List<UserPermission> getPermissionList(Integer adminId);

}
