package com.tom.chapter01_02.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * WebSecurityConfig
 *
 * @author Tom on 2021/2/18
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public CustomUserService customUserService(){
        return new CustomUserService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //路由策略和访问权限的简单配置
        http
//                .authorizeRequests()
                //要求有管理员的权限
//                .antMatchers("/shutdown","/metrics","/health").access("hasRole('ADMIN')")
//                .antMatchers("/**").permitAll()
//                .and()
                .formLogin()                      //启用默认登陆页面
                .failureUrl("/login?error")     //登陆失败返回URL:/login?error
                .defaultSuccessUrl("/ayUser/test")  //登陆成功跳转URL，这里调整到用户首页
                .permitAll();                    //登陆页面全部权限可访问
        super.configure(http);
    }
    /**
     * 配置内存用户
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserService()).passwordEncoder(new MyPasswordEncoder());

                // #########################
                // 内存中的验证
//            .inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
//            .withUser("Tom1").password("1").roles("ADMIN")
//            .and()
//            .withUser("Tom2").password("2").roles("USER");
        // 内存中的验证
        // #########################

    }
}
