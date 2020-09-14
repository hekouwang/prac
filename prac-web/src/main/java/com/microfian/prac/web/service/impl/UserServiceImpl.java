package com.microFian.prac.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microFian.prac.common.exception.Asserts;
import com.microFian.prac.security.util.JwtTokenUtil;
import com.microFian.prac.web.bo.AdminUserDetails;
import com.microFian.prac.web.entity.UserAdmin;
import com.microFian.prac.web.entity.UserResource;
import com.microFian.prac.web.mapper.UserMapper;
import com.microFian.prac.web.mapper.UserRoleRelationMapper;
import com.microFian.prac.web.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**

 * @author hekouwang
 * @since 2020-09-14
 */
@Service
@ComponentScan(value="com.microFian.prac.security.util")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserAdmin> implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRoleRelationMapper userRoleRelationMapper;

    @Override
    public UserAdmin getAdminByUsername(String username) {

        QueryWrapper<UserAdmin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        List<UserAdmin> userAdmins = userMapper.selectList(queryWrapper);
        if(CollectionUtils.isNotEmpty(userAdmins)){
            return userAdmins.get(0);
        }
        return null;
    }

    @Override
    public String login(String username, String password) {

        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                Asserts.fail("密码不正确");
            }
            if(!userDetails.isEnabled()){
                Asserts.fail("帐号已被禁用");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
            //TODO 暂时不加入日志
//            insertLoginLog(username);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;

    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        //获取用户信息
        UserAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<UserResource> resourceList = getResourceList((long)admin.getId());
            return new AdminUserDetails(admin,resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");

    }

    @Override
    public List<UserResource> getResourceList(Long adminId) {

        return userRoleRelationMapper.getResourceList(adminId);

    }

}
