package com.study.mybatisplus.controller;

import com.study.mybatisplus.entity.SysUser;
import com.study.mybatisplus.service.impl.SysUserServiceImpl;
import com.study.mybatisplus.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-04-10
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    SysUserServiceImpl sysUserService;

    @PostMapping("/reg")
    public String reg(SysUser sysUser){
        String salt = ToolUtil.getRandomString(6);
        sysUser.setUserSalt(salt);
        sysUser.setPassWord(ToolUtil.md5Hex(sysUser.getPassWord(),salt));
        return sysUserService.save(sysUser)?sysUser.getPassWord():"注册失败";
    }

    @RequestMapping("/login")
    public String login(SysUser sysUser){

        sysUser =  sysUserService.login(sysUser.getUserName(),sysUser.getPassWord());
        return sysUser!=null?"登陆成功":"登录失败";

    }

    @RequestMapping("/selectAll")
    public List<SysUser> selectAll(@RequestHeader("token") String token){
        SysUser sysUser = sysUserService.login("",token);
        if(sysUser!=null){
            return sysUserService.selectAll(sysUser.getUserName(),sysUser.getPassWord());
        }
        return null;
    }
}

