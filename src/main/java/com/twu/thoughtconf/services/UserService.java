package com.twu.thoughtconf.services;

import com.twu.thoughtconf.dao.UserMapper;
import com.twu.thoughtconf.domain.User;

public class UserService {
    private UserMapper userMapper;

    public void setMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User doSomeBusinessStuff(String userId) {
        return this.userMapper.getUser(userId);
    }

}
