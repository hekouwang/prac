package com.microfian.prac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microfian.prac.entity.UserRole;
import com.microfian.prac.mapper.UserRoleMapper;
import com.microfian.prac.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hekouwang
 * @since 2020-08-07
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> listByUserId(Integer userId) {

        QueryWrapper<UserRole> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        return userRoleMapper.selectList(queryWrapper);

    }
}
