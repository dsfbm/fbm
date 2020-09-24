package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class DemoController {
    @RequestMapping("/sayHello")
    public String sayHello(Model model){
        model.addAttribute("success","你好"); //这里向success传了个值“你好”


        return "sayHello.jsp";  //通过这个进行跳转，返回的名字必须与跳转的页面名字一致
    }


    @RequestMapping("/sayHello1")
    public ModelAndView sayHello1(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sayHello.jsp");
        modelAndView.addObject("success","我是新的");
        return modelAndView;
    }

   @RequestMapping("/file")
  public String file(MultipartFile file){

        /*
        StringBuffer对象则代表一个字符序列可变的字符串，当一个StringBuffer被创建以后，
        通过StringBuffer提供的append()、insert()、reverse()、setCharAt()、
        setLength()等方法可以改变这个字符串对象的字符序列。
        一旦通过StringBuffer生成了最终想要的字符串，就可以调用它的toString()方法将其转换为一个String对象。
         */
        StringBuilder stringBuilder=new StringBuilder();
        if(!file.isEmpty()){
            stringBuilder.append(file.getContentType()).append("=").append(file.getOriginalFilename()).append("==").append(file.getSize());
            return stringBuilder.toString();
        }
        return "上传失败";

  }

}
