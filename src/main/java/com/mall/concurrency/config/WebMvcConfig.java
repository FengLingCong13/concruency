package com.mall.concurrency.config;

import com.mall.concurrency.HttpInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfig class
 *
 * @author Flc
 * @date 2019/7/9
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器
        registry.addInterceptor(new HttpInterceptor2()).addPathPatterns("/**");
    }
}
