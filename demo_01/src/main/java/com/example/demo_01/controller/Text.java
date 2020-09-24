package com.example.demo_02.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Text {
//    @Value("${fbm.msg}")
//    private String msg;
//    @GetMapping("msg")
//    public String getMsg() {
//        return msg;
//    }

    @GetMapping("/home")
    public String home() {
        return "hello world";
    }
}
