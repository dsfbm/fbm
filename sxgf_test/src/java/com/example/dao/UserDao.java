package com.example.dao;

import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


//泛型中第一个参数是实体类，第二个是id类型

public interface UserDao extends JpaRepository<User,Integer> {



}

