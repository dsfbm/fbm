package com.qf.service;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.SysUser;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface SysUserService {
    public List<SysUser> findAll();
    public DataGridResult findUserByPage(QueryDTO queryDTO);
    //导出用户的所有信息
    public Workbook exportUser();
    //搜索用户信息
    public SysUser findByUsername(String username);



}
