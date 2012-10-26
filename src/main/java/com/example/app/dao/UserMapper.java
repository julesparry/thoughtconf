package com.example.app.dao;

import com.example.app.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{userId}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "email", column = "email")
    })
    User getUser(@Param("userId") String userId);
}
