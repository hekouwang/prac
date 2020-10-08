package com.microFian.prac.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microFian.prac.web.entity.UserResource;
import com.microFian.prac.web.mapper.UserResourceMapper;
import com.microFian.prac.web.service.UserResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台资源表 服务实现类
 * </p>
 *
 * @author hekouwang
 * @since 2020-09-14
 */
@Service
public class UserResourceServiceImpl extends ServiceImpl<UserResourceMapper, UserResource> implements UserResourceService {

    @Override
    public List<UserResource> listAll() {
       return list();
    }
}
