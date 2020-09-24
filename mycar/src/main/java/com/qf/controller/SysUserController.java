package com.qf.controller;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.dto.UserDTO;
import com.qf.pojo.SysMenu;
import com.qf.pojo.SysUser;
import com.qf.service.SysUserService;
import com.qf.service.impi.SysUserServiceImpi;
import com.qf.utils1.R;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;


    @RequestMapping("/findall")
    @ResponseBody
    @RequiresRoles("qf/exception")
    public List<SysUser> findAll(){
        return sysUserService.findAll();

    }


}
