//package com.microfian.prac.config;
//
//import com.microfian.prac.handler.CustomUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder() {
////            @Override
////            public String encode(CharSequence charSequence) {
////                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
////                return encoder.encode(charSequence);
////            }
////
////            @Override
////            public boolean matches(CharSequence charSequence, String s) {
////                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
////                return encoder.matches(charSequence,s);
////            }
//        });
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bcryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    public static void main(String[] args) {
//        String s=new BCryptPasswordEncoder().encode("123");
//        System.out.println(s);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                // 如果有允许匿名的url，填在下面
////                .antMatchers().permitAll()
//                .anyRequest().authenticated()
//                .and()
//                // 设置登陆页
//                .formLogin().loginPage("/login").loginProcessingUrl("/login")
//                // 设置登陆成功页
//                .defaultSuccessUrl("/home").permitAll()
//                // 登录失败Url
//                .failureUrl("/login/error")
//                // 自定义登陆用户名和密码参数，默认为username和password
////                .usernameParameter("username")
////                .passwordParameter("password")
//                .and()
//                .logout().permitAll();
//
//        // 关闭CSRF跨域
//        http.csrf().disable();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // 设置拦截忽略文件夹，可以对静态资源放行
//        web.ignoring().antMatchers("/css/**", "/js/**");
//    }
//}
