package com.example.interceptor;


import com.example.utils.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
简介
SpringWebMVC的处理器拦截器，类似于Servlet开发中的过滤器Filter，用于处理器进行预处理和后处理。
应用场景
1、日志记录，可以记录请求信息的日志，以便进行信息监控、信息统计等。
2、权限检查：如登陆检测，进入处理器检测是否登陆，如果没有直接返回到登陆页面。
3、性能监控：典型的是慢日志。
 */
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("start");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        RequestHandler.remove();
        log.info("finish");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        RequestHandler.remove();

        log.info("completion");
    }
}
