package com.twu.thoughtconf.repositories;

import com.twu.thoughtconf.dao.SessionAttendeeMapper;
import com.twu.thoughtconf.domain.SessionAttendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SessionAttendeeRepository {

    @Autowired
    private SessionAttendeeMapper sessionAttendeeMapper;

    public SessionAttendeeRepository() {
    }

    public SessionAttendeeRepository(SessionAttendeeMapper sessionAttendeeMapper) {
        this.sessionAttendeeMapper = sessionAttendeeMapper;
    }

    public void save(SessionAttendee sessionAttendee) {
        sessionAttendeeMapper.save(sessionAttendee.getAttendeeEmail(), null);
    }
}
