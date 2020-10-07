package com.microFian.prac.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microFian.prac.web.entity.UserMenu;
import com.microFian.prac.web.entity.UserRole;
import com.microFian.prac.web.mapper.UserRoleMapper;
import com.microFian.prac.web.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hekouwang
 * @since 2020-09-24
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    public List<UserMenu> getMenuList(Long adminId) {


        return null;
    }
}
