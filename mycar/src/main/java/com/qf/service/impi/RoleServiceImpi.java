package com.qf.service.impi;

import com.qf.dao.SysRoleMapper;
import com.qf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpi implements RoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Override
    public List<String> findRolsByUserID(Long userId) {
        return sysRoleMapper.findRolesByUserId(userId);
    }
}
