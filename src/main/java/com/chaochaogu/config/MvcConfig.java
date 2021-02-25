package com.chaochaogu.config;

import com.chaochaogu.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chaochao gu
 * @date 2021/2/25
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 对来自/api/** 链接的请求进行拦截，对登录请求/api/login不进行拦截
        registry.addInterceptor(new LoginInterceptor()).
                addPathPatterns("/api/**").
                excludePathPatterns("/api/login");
    }
}
