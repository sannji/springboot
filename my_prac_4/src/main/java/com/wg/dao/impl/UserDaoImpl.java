package com.wg.dao.impl;

import com.wg.dao.UserDao;
import com.wg.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Users> getUserList() {
        List<Users> users = jdbcTemplate.query("select id, username, age from users", new BeanPropertyRowMapper<>(Users.class));
        return users;
    }
    @Override
    public List<Users> getUserList2() {
        List<Users> users = jdbcTemplate.query("select id, username, age from users", (ResultSet rs, int i) -> {
            Users user = new Users();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setAge(rs.getInt("age"));
            return user;
        });
        return users;
    }
    @Override
    public int createUser(String username, Integer age) {
       return jdbcTemplate.update("insert into users (username, age) values (?, ?)", username, age);
    }
    @Override
    public Users getUserById(Long id) {
        return jdbcTemplate.queryForObject("select id, username, age from users where id = ?", new Object[]{id},
        new BeanPropertyRowMapper<>(Users.class));
    }
    @Override
    public Users getUserByName(String name) {
        Users user = jdbcTemplate.queryForObject("select id, username, age from users where username = ?",
                new BeanPropertyRowMapper<>(Users.class), name);
        System.out.println(user);
        return user;
    }
}
