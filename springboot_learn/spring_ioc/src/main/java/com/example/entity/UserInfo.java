package com.example.entity;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UserInfo {

    public @interface Add{}
    @NotNull(message = "ID不能为空")
    private Integer id;
    private String username;

    @Min(groups = {Add.class},value = 20,message = "年龄必须大于等于20")
    private Integer age;
}
