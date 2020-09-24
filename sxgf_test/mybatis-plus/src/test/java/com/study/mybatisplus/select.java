package com.study.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.mybatisplus.entity.SysUser;
import com.study.mybatisplus.service.SysUserService;
import com.study.mybatisplus.service.impl.SysLogServiceImpl;
import com.study.mybatisplus.service.impl.SysUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class select {

    @Autowired
    SysLogServiceImpl sysLogService;

    @Autowired
    SysUserServiceImpl sysUserService;

    @Test
    public void login(){
        System.out.println(sysUserService.login("",""));
    }

    @Test
    public void selectAll(){
        List<SysUser> sysUsers = sysUserService.selectAll("","");
        sysUsers.forEach(System.out::print);
    }

    @Test
    public void select1(){
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","real_name").like("real_name","一");
        List<SysUser> users = sysUserService.list(queryWrapper);
        users.forEach(System.out::println);
    }
}
