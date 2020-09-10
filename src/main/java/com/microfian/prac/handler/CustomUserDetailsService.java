//package com.microfian.prac.handler;
//
//import com.microfian.prac.entity.Role;
//import com.microfian.prac.entity.User;
//import com.microfian.prac.entity.UserEntity;
//import com.microfian.prac.entity.UserRole;
//import com.microfian.prac.service.RoleService;
//import com.microfian.prac.service.UserRoleService;
//import com.microfian.prac.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Service("userDetailsService")
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RoleService roleService;
//
//    @Autowired
//    private UserRoleService userRoleService;
//
//    @Override
//    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        // 从数据库中取出用户信息
//        User user = userService.selectByName(username);
//
//        // 判断用户是否存在
//        if (user == null) {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//
//        // 添加权限
//        List<UserRole> userRoles = userRoleService.listByUserId(user.getId());
//        for (UserRole userRole : userRoles) {
//            Role role = roleService.getById(userRole.getRoleId());
//            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
//        }
//
//        // 返回UserDetails实现类
//        return new UserEntity(user.getUsername(), user.getPassword(), authorities);
//
//    }
//}
