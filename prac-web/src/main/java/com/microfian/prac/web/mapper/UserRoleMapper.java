package com.microFian.prac.web.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.microFian.prac.web.entity.UserMenu;
import com.microFian.prac.web.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hekouwang
 * @since 2020-09-24
 */

@Component
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<UserMenu> getMenuList(@Param("adminId") Long adminId);

}