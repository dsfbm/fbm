package com.example.controller;

import com.example.entity.User;
import com.example.service.UserSerice;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserSerice userSerice;

    //添加一个用户
    @ApiOperation(value="添加一个用户", notes="输入信息即可添加成功")
    @PostMapping( "/addUser")
    @ResponseBody
    public User addUser(String name, String sea,Integer age,String class1,String tel) {
        User user1=new User();
        user1.setName(name);
        user1.setSex(sea);
        user1.setAge(age);
        user1.setClass1(class1);
        user1.setTel(tel);
        return userSerice.addUser(user1);

    }



    //根据id删除一条数据
    @ApiOperation(value="根据id删除一条数据", notes="")
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUserById(@PathVariable(name = "id", required = true) Integer id) {
            userSerice.deleteUserById(id);
    }

    @ApiOperation(value="根据id查询一条数据", notes="")
    @GetMapping("/findUserById/{id}")
    @ResponseBody
    public User findUserById(@PathVariable(name = "id") Integer id) {
        return userSerice.findUserById(id);

    }


    @ApiOperation(value="查看所有的用户", notes="")
    @GetMapping("/findAll")
    @ResponseBody
    public List<User> findAll() {

        return userSerice.findAll();

    }


    //修改一个用户
    @ApiOperation(value="修改一个用户", notes="可先查看所有用户的信息，然后在根据id进行修改")
    @PutMapping("/updateUser")
    @ResponseBody
    public User updateUserById(Integer id, String name, String sea,Integer age,String class1,String tel) {
        User user1=new User();
        user1.setId(id);
        user1.setName(name);
        user1.setSex(sea);
        user1.setAge(age);
        user1.setClass1(class1);
        user1.setTel(tel);

        return userSerice.updateUser(user1);

    }







}
