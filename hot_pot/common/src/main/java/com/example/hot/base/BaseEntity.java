package com.example.hot.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import javax.xml.crypto.Data;
import java.io.Serializable;

public class BaseEntity implements Serializable {
    public String id;

    public  String  flag;


    /*
    创建时间
     */
    @TableField(value = "create_time",fill= FieldFill.INSERT)
    public Data createTime;
    /*
    修改时间
     */
    @TableField(value = "update_time",fill= FieldFill.UPDATE)
    public  Data updateTime;
}
