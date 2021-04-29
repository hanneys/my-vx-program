package com.eve.config;

import com.eve.interceptor.JWTInterceptor;
import com.eve.interceptor.ResponseResultInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author hanneys
 * @Date 2021/4/27 15:14
 * @Version 1.0
 */
@Configuration
@Slf4j
public class WebAppConfig implements WebMvcConfigurer {

    @Value("${exclude.path}")
    private String url;

    @Bean
    public JWTInterceptor jwtInterceptor(){
        return new JWTInterceptor();
    }

    // SpringMVC 需要手动添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                //拦截的路径
                .addPathPatterns("/**")
                //排除登录接口
                .excludePathPatterns(url.split(","));
        log.info("excludePathPatterns:{}",url);
        ResponseResultInterceptor interceptor = new ResponseResultInterceptor();
        registry.addInterceptor(interceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/background/**").addResourceLocations("file:D:/background/");
    }
}
