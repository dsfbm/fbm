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
@TableName("hot_customer")
public class Customer extends BaseEntity {

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
     * 消费者联系电话
     */
    private String customerPhone;

    /**
     * 电子邮箱
     */
    private String customerEmail;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;




}
