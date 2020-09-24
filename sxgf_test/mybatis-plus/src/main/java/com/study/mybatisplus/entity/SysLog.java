package com.study.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.annotations.Insert;

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
@TableName("sys_log")
public class SysLog extends Model<SysLog> {

    private static final long serialVersionUID=1L;

    @TableField("id")
    private Long id;

    @TableField("log_content")
    private String logContent;

    @TableField("user_id")
    private Long userId;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

}
