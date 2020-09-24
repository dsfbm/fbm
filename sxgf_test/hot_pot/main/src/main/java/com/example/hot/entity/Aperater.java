package com.example.hot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.hot.base.BaseEntity;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author administrator
 * @since 2020-04-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("hot_aperater")
public class Aperater extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 登录用户名
     */
    private String account;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 密码加密盐
     */
    private String salt;

    /**
     * 真实姓名
     */
    private String reaName;

    /**
     * 火锅店名称
     */
    private String storeName;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 火锅店地址
     */
    private String storeAddress;

    /**
     * 火锅店照片
     */
    private String storePic;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;




}
