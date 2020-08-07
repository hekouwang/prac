package com.microfian.prac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microfian.prac.entity.Role;
import com.microfian.prac.mapper.RoleMapper;
import com.microfian.prac.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @author hekouwang
 * @since 2020-08-07
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
