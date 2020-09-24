package com.qf.service;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.SysMenu;
import com.qf.utils1.R;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService {

    public  DataGridResult findMenu(QueryDTO queryDTO);
    public R deleteMenu(List<Long> ids);
    public R selectMenu();
    public R saveMenu(SysMenu sysMenu);
    public R findMenuById(Long menuId);

    public  R updateMenu(SysMenu sysMenu);
    List<String> findPermsByUserId(@Param("userId") Long userId);

    public R findUserMenu(Long userId);


}
