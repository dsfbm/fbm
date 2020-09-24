package com.study.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author administrator
 * @since 2020-04-10
 */
@Setter
@Getter
@ToString
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID=1L;

    //@TableField(value = "id")
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("user_name")
    private String userName;

    @TableField("pass_word")
    private String passWord;

    @TableField("real_name")
    private String realName;

    @TableField("user_remark")
    private String userRemark;

    @TableField("user_salt")
    private String userSalt;

    @TableField("create_time")
    private LocalDateTime createTime;

}
