package com.microFian.prac.web.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.microFian.prac.web.entity.UserResource;

import java.util.List;

/**
 * <p>
 * 后台资源表 服务类
 * </p>
 *
 * @author hekouwang
 * @since 2020-09-14
 */
public interface UserResourceService extends IService<UserResource> {

    /**
     * 查询全部资源
     */
    List<UserResource> listAll();

}
