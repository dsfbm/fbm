package com.study.mybatisplus.service.impl;

import com.study.mybatisplus.entity.SysUser;
import com.study.mybatisplus.mapper.SysUserMapper;
import com.study.mybatisplus.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-04-10
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;


    @Override
    public SysUser login(String userName, String passWord) {

        return sysUserMapper.login(userName,passWord);
    }

    @Override
    public List<SysUser> selectAll(String userName, String passWord) {

        return sysUserMapper.selectAll(userName,passWord);
    }
}
