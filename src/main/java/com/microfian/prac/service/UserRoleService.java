package com.microfian.prac.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.microfian.prac.entity.UserRole;

import java.util.List;

/**
 * @author hekouwang
 * @since 2020-08-07
 */
public interface UserRoleService extends IService<UserRole> {

   List<UserRole> listByUserId(Integer userId);

}
