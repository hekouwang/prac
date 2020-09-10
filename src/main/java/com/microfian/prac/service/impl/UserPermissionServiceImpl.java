package com.microfian.prac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microfian.prac.entity.UserPermission;
import com.microfian.prac.mapper.UserPermissionMapper;
import com.microfian.prac.service.UserPermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户权限表 服务实现类
 * </p>
 *
 * @author hekouwang
 * @since 2020-09-10
 */
@Service
public class UserPermissionServiceImpl extends ServiceImpl<UserPermissionMapper, UserPermission>
        implements UserPermissionService {

}
