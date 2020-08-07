package com.microfian.prac.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.microfian.prac.entity.User;

/**
 * @author hekouwang
 * @since 2020-08-07
 */
public interface UserService extends IService<User> {

   User selectByName(String name);

}
