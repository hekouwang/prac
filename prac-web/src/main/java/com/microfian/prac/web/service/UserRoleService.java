package com.microFian.prac.web.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.microFian.prac.web.entity.UserMenu;
import com.microFian.prac.web.entity.UserRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hekouwang
 * @since 2020-09-24
 */
public interface UserRoleService extends IService<UserRole> {

    /**
     * 根据管理员ID获取对应菜单
     */
    List<UserMenu> getMenuList(Long adminId);


}

