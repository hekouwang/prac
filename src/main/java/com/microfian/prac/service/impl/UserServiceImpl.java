package com.microfian.prac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microfian.prac.entity.User;
import com.microfian.prac.mapper.UserMapper;
import com.microfian.prac.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author hekouwang
 * @since 2020-08-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
