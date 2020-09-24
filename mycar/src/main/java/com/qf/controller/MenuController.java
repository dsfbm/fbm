package com.qf.controller;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.SysMenu;
import com.qf.service.MenuService;
import com.qf.utils1.R;
import com.qf.utils1.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("sys/menu/list")
    @ResponseBody
    public DataGridResult findMenu(QueryDTO queryDTO){
        return menuService.findMenu(queryDTO);

    }
    @RequestMapping("sys/menu/del")
    @ResponseBody
    public R deleteMenu(@RequestBody List<Long> ids){

        return menuService.deleteMenu(ids);

    }

    @RequestMapping("sys/menu/select")
    @ResponseBody
    public R selectMenu(){

        return menuService.selectMenu();

    }
    @RequestMapping("/sys/menu/save")
    @ResponseBody
    public R saveMenu(@RequestBody SysMenu sysMenu){
        return menuService.saveMenu(sysMenu);
    }
    //意义通过@PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中：
    //URL 中的 {xxx} 占位符可以通过@PathVariable("xxx") 绑定到操作方法的入参中。
    @RequestMapping("/sys/menu/info/{menuId}")
    @ResponseBody
    public R findMenuById(@PathVariable("menuId") Long menuId){
        return menuService.findMenuById(menuId);
    }
    @RequestMapping("/sys/menu/update")
    @ResponseBody
    public R updateMenu(@RequestBody SysMenu sysMenu){
        return menuService.updateMenu(sysMenu);



    }
    @RequestMapping("/sys/menu/user")
    @ResponseBody
    public R userMenu(){
        //从ShiroUtils这个工具类中获取userId 缓存
        long userId= ShiroUtils.getUserId();
        return menuService.findUserMenu(userId);
    }


}
