package com.example.controller;


import com.example.utils.RequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RequestController {
    @RequestMapping("/display")
        public String display(){


            //RequestHandler.get().getPathInfo()这个方法返回请求的实际URL相对于请求的serlvet的url的路径。
           //getRequestURI:获取根路径到地址结尾
        return RequestHandler.get().getRequestURI()+RequestHandler.get().getPathInfo();

        }
}
