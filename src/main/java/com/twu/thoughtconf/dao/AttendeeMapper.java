package com.twu.thoughtconf.dao;

import com.twu.thoughtconf.domain.Attendee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface AttendeeMapper {
    @Select("SELECT * FROM users WHERE id = #{userId}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "email", column = "email")
    })
    Attendee getUser(@Param("userId") String userId);
}
