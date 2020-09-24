package com.example.hot.controller;


import com.example.hot.entity.Menu;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.example.hot.base.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-04-25
 */
@Controller
@RequestMapping("/hot/menu")
public class MenuController extends BaseController {
    
    /*
    新增菜品
     */
    @RequestMapping("/create_Menu")
    public Menu create_Menu(Menu menu){
        
        return menu;
        
    }

}

