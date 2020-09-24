package com.example.config;

import com.example.filter.RequestFilter;
import com.example.interceptor.RequestInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.*;
/*
WebMvcConfigurer配置类其实是Spring内部的一种配置方式，
采用JavaBean的形式来代替传统的xml配置文件形式进行针对框架个性化定制，
可以自定义一些Handler，Interceptor，ViewResolver，MessageConverter。
基于java-based方式的spring mvc配置，需要创建一个配置类并实现WebMvcConfigurer 接口；

在Spring Boot 1.5版本都是靠重写WebMvcConfigurerAdapter的方法来添加自定义拦截器，
消息转换器等。SpringBoot 2.0 后，该类被标记为@Deprecated（弃用）。
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");


    }
    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/**");
    }
    @Bean
    public FilterRegistrationBean addResquestFilter(){

       FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
       filterRegistrationBean.setFilter(new RequestFilter());
       List<String> urls=new ArrayList<>();
       urls.add("/*");
       filterRegistrationBean.setUrlPatterns(urls);
       filterRegistrationBean.setName("requestFilter");
       filterRegistrationBean.setOrder(1);
       return filterRegistrationBean;
}

}
