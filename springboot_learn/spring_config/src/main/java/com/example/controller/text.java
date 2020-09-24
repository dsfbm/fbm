package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class text {
    @RequestMapping("/text")
    public String text(){
        return "这是一个测试类";
    }


}
