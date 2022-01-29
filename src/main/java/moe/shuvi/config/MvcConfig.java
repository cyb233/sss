package moe.shuvi.config;

import moe.shuvi.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MvcConfig
 * @Description TODO
 * @Author Administrator
 * @Date: 2021/12/30 16:05
 * @Version 1.0
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration Registration = registry.addInterceptor(tokenInterceptor);
        Registration.addPathPatterns("/**").excludePathPatterns("/user/login",
                "/swagger-resources/**",
                "/webjars/**",
                "/favicon.ico",
                "/**/*.html");
    }

}
