package com.example.service;
import com.example.dao.UserDao;
import com.example.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserSerice {



    @Autowired
    private UserDao userDao;
    //插入一个用户
    public User addUser(User user){

        return userDao.save(user);
    }

    //修改一个用户
    public User updateUser(User user){

        return userDao.save(user);
    }
    //根据id删除一条数据
    public void deleteUserById(Integer id){
        userDao.deleteById(id);
    }

    //查询所有
    public  List<User> findAll(){
        return userDao.findAll();
    }
    //根据id查询一条数据
    public User findUserById(Integer id){
        return userDao.findById(id).get();
    }



}
