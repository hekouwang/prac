package com.microfian.prac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microfian.prac.entity.UserRole;
import com.microfian.prac.mapper.UserRoleMapper;
import com.microfian.prac.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author hekouwang
 * @since 2020-08-07
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
