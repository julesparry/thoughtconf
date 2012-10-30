package com.twu.thoughtconf.services;

import com.twu.thoughtconf.dao.AttendeeMapper;
import com.twu.thoughtconf.domain.Attendee;

public class AttendeeService {
    private AttendeeMapper attendeeMapper;

    public void setMapper(AttendeeMapper attendeeMapper) {
        this.attendeeMapper = attendeeMapper;
    }

    public Attendee doSomeBusinessStuff(String userId) {
        return this.attendeeMapper.getUser(userId);
    }

}
