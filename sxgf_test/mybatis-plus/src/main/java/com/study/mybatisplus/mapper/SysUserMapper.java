package com.study.mybatisplus.mapper;

import com.study.mybatisplus.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2020-04-10
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser login(@Param("userName") String userName,@Param("passWord") String passWord);
    List<SysUser> selectAll(@Param("userName") String userName,@Param("passWord") String passWord);
}
