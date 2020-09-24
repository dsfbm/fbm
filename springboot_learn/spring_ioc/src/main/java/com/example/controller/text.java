package com.example.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class text {


    /*
    如果改成@RestController就无法进行跳转，跳转出来的是字符串 @Controller就可以
     */
    @RequestMapping("/test")
    public String sayHello(Model model) {
        model.addAttribute("success", "你好"); //这里向success传了个值“你好”

        return "index";  //通过这个进行跳转，返回的名字必须与跳转的页面名字一致
    }


    @RequestMapping("/test1")
    public ModelAndView sayHello1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sayHello.jsp");
        modelAndView.addObject("success", "我是新的");
        return modelAndView;
    }


    @RequestMapping("/aaa1")
    public String aaa1() {

        return "redirect:/test";

    }

    @RequestMapping("/aaa2")
    public String aaa2() {

        return "forword:/test";

    }

    /*
    树遍历
     */

    @Autowired
    ObjectMapper mapper;

    @GetMapping("readtree.json")
    public String readtree() throws JsonProcessingException {
        String json = "{\"id\":1,\"name\":\"tom\"}";
        JsonNode node = mapper.readTree(json);
        String name = node.get("name").asText();
        int id = node.get("id").asInt();
        return "name=" + name + "id=" + id;

    }



    /*
    流式解析json
     */
    @GetMapping
    public String parser() throws IOException {
        String json="{\"id\":1,\"name\":\"tom\"}";
        JsonFactory f = mapper.getFactory();
        JsonParser parser = f.createParser(json);
        JsonToken token = parser.nextToken();//忽略第一个Token{=》 START_ _OBJECT
        token=parser.nextToken();//获取name
        String key="";
        if(token==JsonToken.FIELD_NAME){
            key = parser.getCurrentName();
        }
        token=parser.nextToken();//获取name的value
        String value=parser.getValueAsString();
        parser.close();
        return key+"="+value;
    }


}