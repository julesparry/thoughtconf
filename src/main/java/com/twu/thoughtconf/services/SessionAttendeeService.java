package com.twu.thoughtconf.services;

import com.twu.thoughtconf.dao.SessionAttendeeMapper;
import com.twu.thoughtconf.domain.SessionAttendee;
import org.springframework.beans.factory.annotation.Autowired;

public class SessionAttendeeService {
    @Autowired
    private SessionAttendeeMapper sessionAttendeeMapper;

    public void setMapper(SessionAttendeeMapper sessionAttendeeMapper) {
        this.sessionAttendeeMapper = sessionAttendeeMapper;
    }

//    public SessionAttendee doSomeBusinessStuff(String userId) {
//        return this.sessionAttendeeMapper.getUser(userId);
//    }

}
