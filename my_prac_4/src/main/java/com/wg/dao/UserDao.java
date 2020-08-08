package com.wg.dao;

import com.wg.entity.Users;

import java.util.List;

public interface UserDao {
    //获取用户列表, demo1
    public List<Users> getUserList();
    //获取用户列表，demo2
    public List<Users> getUserList2();
    //添加用户
    public int createUser(String username, Integer age);
    //根据Id查用户信息
    public Users getUserById(Long id);
    //根据名字查找用户
    public Users getUserByName(String name);
}
