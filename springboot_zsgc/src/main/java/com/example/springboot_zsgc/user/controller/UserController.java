package com.example.springboot_zsgc.user.controller;

import com.example.springboot_zsgc.user.Entity.UserEntity;
import com.example.springboot_zsgc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getAll")
    public List<UserEntity> getAll(Map map) {
        return userService.getAll(map);

    }

    @RequestMapping("/login")
    public String login(){

        return "login";
    }
    @RequestMapping("/loginUser")
    public String loginUser(String username,String password,Map map){
        List<UserEntity> aa =userService.getAll(map);
        for (UserEntity userEntity:aa){



            if (userEntity.getUsername().equals(username)&&userEntity.getPassword().equals(password)){

                return "login";
            }

        }

        return "login";
    }
    @RequestMapping("/delById")
    public String delById(Integer id) {

        userService.delById(id);
        return "redirect:/index.html";
    }

    // 保存用户
    @RequestMapping("/save")
    @ResponseBody
    public String save(@RequestBody UserEntity userEntity) {

        System.out.println("用户注册 - " + userEntity.toString());
        userService.save(userEntity);
        return "success";
    }

}
