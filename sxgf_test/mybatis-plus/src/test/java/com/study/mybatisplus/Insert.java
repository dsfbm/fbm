package com.study.mybatisplus;

import com.study.mybatisplus.entity.SysLog;
import com.study.mybatisplus.entity.SysUser;
import com.study.mybatisplus.mail.MailUtil;
import com.study.mybatisplus.service.impl.SysLogServiceImpl;
import com.study.mybatisplus.service.impl.SysUserServiceImpl;
import com.study.mybatisplus.util.ToolUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Insert {

    @Autowired
    SysLogServiceImpl sysLogService;

    @Autowired
    SysUserServiceImpl sysUserService;

    @Autowired
    MailUtil mailUtil;

    @Test
    public void insertLog(){
        SysLog sysLog = new SysLog();
        sysLog.setLogContent("测试");
        sysLog.setUserId(12345678L);
        sysLog.setCreateTime(LocalDateTime.now());
        sysLogService.save(sysLog);

        mailUtil.send("日志",sysLog.toString());

    }

    @Test
    public void insertUser(){
        String salt = ToolUtil.getRandomString(6);
        SysUser sysUser = new SysUser();
        sysUser.setCreateTime(LocalDateTime.now());
        sysUser.setPassWord(ToolUtil.md5Hex("123456",salt));
        sysUser.setRealName("第四个");
        sysUser.setUserName("test");
        sysUser.setUserRemark("测试");
        sysUser.setUserSalt(salt);
        sysUserService.save(sysUser);
    }

}
