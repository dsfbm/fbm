package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 作者: xhd
 创建时间: 2020/3/10 20:26
 版本: V1.0
 */
@Controller
@RequestMapping("/")
public class BookConroller1 {


    @PostMapping("/save")
    @ResponseBody
    public void save(Long id, String name, Integer age){

    }

    @RequestMapping("/get")
    @ResponseBody
    public void findByAge(Integer age){

    }



}
