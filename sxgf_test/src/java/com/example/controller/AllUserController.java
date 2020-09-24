package com.example.controller;


import com.example.entity.User;
import com.example.service.UserSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@RestController
@RequestMapping("/")
public class AllUserController {
    @Autowired
    private UserSerice userSerice;
    //显示所有用户
    @ResponseBody
    @RequestMapping( "/alluser_01")

    public ModelAndView AllUser_01() {
        List<User> list=userSerice.findAll();
        ModelAndView modelAndView=new ModelAndView("index_01");

        modelAndView.addObject("users",list);

        return modelAndView;
    }


//
    @RequestMapping( "/alluser")
    public List<User> AllUser() {
        List<User> aa=userSerice.findAll();


        for (User aa1:aa) {

            System.out.print(aa1.getName());
        }



        return userSerice.findAll();
    }


    @RequestMapping("/delById/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        userSerice.deleteUserById(id);
        return "删除成功";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateUserById(@RequestBody User user) {

        userSerice.updateUser(user);
        return "添加成功";

    }
}
