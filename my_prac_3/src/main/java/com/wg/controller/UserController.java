package com.wg.controller;

import com.wg.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api("用户操作")
@RestController
@RequestMapping("/users")
public class UserController {

    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @GetMapping("/")
    @ApiOperation(value = "获取用户列表信息")
    public List<User> getUserList() {
        return new ArrayList<User>(users.values());
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新", notes = "更新用户列表中ID对应的属性值")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "ok";
    }

    @PostMapping("/")
    @ApiOperation(value = "创建", notes = "创建用户信息")
    public String createUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "ok";
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户", notes = "删除用户列表中对应ID对应的用户信息")
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "ok";
    }
}
