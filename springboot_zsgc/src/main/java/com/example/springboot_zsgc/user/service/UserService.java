package com.example.springboot_zsgc.user.service;

import com.example.springboot_zsgc.user.Entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserEntity> getAll(Map map);

    void delById(Integer id);

    // 保存用户
    public void save(UserEntity userEntity);
}
