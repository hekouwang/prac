package com.microFian.prac.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.microFian.prac.web.entity.UserResource;
import com.microFian.prac.web.entity.UserRoleRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hekouwang
 * @since 2020-09-14
 */
@Component
public interface UserRoleRelationMapper extends BaseMapper<UserRoleRelation> {

    /**
     * 获取用户所有可访问资源
     */
    List<UserResource> getResourceList(@Param("adminId") Long adminId);

}
