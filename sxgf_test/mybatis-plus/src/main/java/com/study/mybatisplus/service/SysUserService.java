package com.study.mybatisplus.service;

import com.study.mybatisplus.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author administrator
 * @since 2020-04-10
 */
public interface SysUserService extends IService<SysUser> {

    SysUser login(String userName, String passWord);
    List<SysUser> selectAll(String userName, String passWord);
}
