package com.example.controller;

import com.example.entity.UserInfo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
1) 如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，或者html，配置的视图解析器
 InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。

2) 如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
    如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
 */
@RestController
@RequestMapping("/")
public class DemoRestController {

    @RequestMapping("/rest")
    public String sayHello(){
        return "你好";
    }

    @RequestMapping("/path/{phone}/{token}")       //像这样写的可以看成是占位符:/路径/值1/值2.....
    public String path(@PathVariable String phone,@PathVariable String token){
        return "phone="+ phone + "==token"+ token;
    }


    @RequestMapping("/path1")  //这样写/路径?phone=值1
    public String path1(String phone){

        return "phone=" +phone;
    }

    @RequestMapping("/path2")  //这个地方当不传值的时候会默认写11
    public String path2(@RequestParam(defaultValue = "11") String phone){

        return "phone=" +phone;
    }

    @RequestMapping("/path3")
    public String path3(@Validated({UserInfo.Add.class}) UserInfo userInfo, BindingResult result){
        if(result.hasErrors()){
            StringBuilder stringBuilder = new StringBuilder();
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error: errors){
                FieldError fieldError = (FieldError) error;
                stringBuilder.append(fieldError.getField()).append(fieldError.getDefaultMessage());
                return stringBuilder.toString();
            }
        }
        return userInfo.toString();
    }




    @RequestMapping(value = "/path4",consumes ="application/json" )
    public String path4(){
        return "this is consmoasdf";
    }


    @RequestMapping(value = "/path5",produces ="application/json" )
    public String path5(){
        return "this is consmoasdf";
    }



}
