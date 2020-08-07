package com.microfian.prac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microfian.prac.entity.User;
import com.microfian.prac.mapper.UserMapper;
import com.microfian.prac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hekouwang
 * @since 2020-08-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectByName(String name) {

        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        queryWrapper.eq("username", name);
        User user = userMapper.selectOne(queryWrapper);
        return user;

    }
}
