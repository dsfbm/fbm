package com.qf.dao;

import com.qf.dto.QueryDTO;
import com.qf.pojo.SysMenu;
import com.qf.pojo.SysMenuExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysMenuMapper {
    int countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    int deleteByPrimaryKey(Long menuId);
    int deleteMenu(List<Long> ids);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Long menuId);

    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
    List<SysMenu> findMenuByPage(QueryDTO query);

    List<SysMenu> findMenu();
    // 根据用户id查询用户菜单权限  @Param 用于传递参数
    List<String> findPermsByUserId(@Param("userId") Long userId);
    //查询用户一级目录  因为返回的是map类型 所以使用List来封装map集合
    List<Map<String,Object>> findDirMenuByUserId(Long userId);
    //查询用户一级目录所对应的菜单
    List<Map<String,Object>> findMenuNotButtonByUserId(@Param("userId") Long userId,@Param("parentId") Long parentId);



}