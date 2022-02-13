package moe.shuvi.config;

import com.alibaba.fastjson.JSON;
import moe.shuvi.filter.JwtFilter;
import moe.shuvi.model.User;
import moe.shuvi.service.UserService;
import moe.shuvi.utils.JwtConstant;
import moe.shuvi.utils.JwtTokenUtil;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Author Administrator
 * @Date: 2022/1/7 17:09
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
//开启SpringSecurity注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;


    /**
     * 配置认证源
     * 来自于数据库
     *
     * @return
     */
    @Bean
    public UserDetailsService jdbcDaoImpl(@Autowired DataSource dataSource) {

        JdbcUserDetailsManager jdbcDao = new JdbcUserDetailsManager(dataSource);
        //按用户名查询UserDetails
        jdbcDao.setUsersByUsernameQuery("select loginCode,password,del from s_user where loginCode = ?");
        //查询所有权限
        jdbcDao.setAuthoritiesByUsernameQuery("select u.loginCode,r.roleName from s_user u left join s_role r on u.roleId=r.id where loginCode = ?");
        //查询权限的开关
        jdbcDao.setEnableAuthorities(true);

        return jdbcDao;
    }


    /**
     * 鉴权规则
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable().//关闭CSRF
                //所有请求都要认证，权限的过滤放在注解上
                        authorizeRequests().anyRequest().authenticated()
                //服务端无状态
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //安插认证自定义认证过滤器，目的把JWT中的认证主体添加到SecurityContext
                .and().addFilterBefore(new JwtFilter(this.authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                //登录设置(内置登录页，且请求的认证url为/login)
                .formLogin(form -> {

                    //前端登录时，向该/login提交表单
                    form
                            //.loginPage("/")
                            .loginProcessingUrl("/user/login")
                            .usernameParameter("loginCode")
                            .passwordParameter("password")
                            //认证成功后，向前端响应json数据
                            .successHandler((req, resp, auth) -> {
                                Result result = new Result();
                                result.setCode(Result.CODE_SUCCESS);
                                result.setMsg(Result.MSG_SUCCESS);
                                //签发token

                                SecurityContext context = SecurityContextHolder.getContext();
                                Authentication authentication = context.getAuthentication();
                                String username = authentication.getName();
                                Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                                String userId;
                                try {
                                    User user = userService.selectByLoginCode(username);
                                    userId = user.getId().toString();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    userId = "0";
                                }
                                //用户ID,用户名，用户权限
                                Map<String, Object> claim = new HashMap<>();
                                claim.put(JwtConstant.JWT_USER_NAME, username);
                                claim.put(JwtConstant.JWT_PERMISSIONS_KEY, authorities);
                                String token = new JwtTokenUtil().getAccessToken(userId, claim);
                                result.setToken(token);
                                resp.getWriter().write(JSON.toJSONString(result));
                            })
                            //认证失败向前端响应json数据
                            .failureHandler((req, resp, ex) -> {
                                Result result = new Result();
                                result.setCode(Result.CODE_LOGIN_FAILED);
                                result.setMsg(Result.MSG_LOGIN_FAILED);
                                resp.getWriter().write(JSON.toJSONString(result));
                            })
                            .permitAll();

                })
                //退出登录
                //logout进会退出登录
                .logout(withDefaults())
                //自定义403处理：向前端响应json数据
                .exceptionHandling(exceptionHandlingConfigurer -> {
                    exceptionHandlingConfigurer.accessDeniedHandler((req, resp, ex) -> {
                        Result result = new Result();
                        result.setCode(Result.CODE_403);
                        result.setMsg(Result.MSG_403);
                        resp.getWriter().write(JSON.toJSONString(result));
                    });
                });

    }

}
