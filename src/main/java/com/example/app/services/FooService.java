package com.example.app.services;

import com.example.app.dao.UserMapper;
import com.example.app.domain.User;

class FooService {
    private UserMapper userMapper;

    public void setMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User doSomeBusinessStuff(String userId) {
        return this.userMapper.getUser(userId);
    }

}
