package com.wg.controller;

import com.wg.dao.UserDao;
import com.wg.entity.Users;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "用户管理")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserDao userDao;
    @GetMapping("/")
    @ApiOperation(value="获取用户信息", notes="获取全量用户列表")
    public List<Users> getAllUsers() {
        return userDao.getUserList2();
    }
    @PostMapping("/")
    @ApiOperation(value="创建用户", notes = "根据post消息创建用户")
    public int addUser(@RequestBody Users user) {
        return userDao.createUser(user.getUsername(), user.getAge());
    }
    @GetMapping("/id/{id}")
    @ApiOperation(value="查询用户", notes = "根据id查询用户")
    public Users getUserById(@PathVariable Long id) {
        return userDao.getUserById(id);
    }
    @GetMapping("/name/{name}")
    @ApiOperation(value = "查询用户", notes="根据用户名查询用户信息")
    public Users getUserByName(@PathVariable String name) {
        return userDao.getUserByName(name);
    }
}
