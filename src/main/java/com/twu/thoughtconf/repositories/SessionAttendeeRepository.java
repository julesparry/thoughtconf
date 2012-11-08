package com.twu.thoughtconf.repositories;

import com.twu.thoughtconf.dao.SessionAttendeeMapper;
import com.twu.thoughtconf.domain.SessionAttendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SessionAttendeeRepository {

    @Autowired
    private SessionAttendeeMapper mapper;

    public SessionAttendeeRepository() {
    }

    public SessionAttendeeRepository(SessionAttendeeMapper mapper) {
        this.mapper = mapper;
    }

    public SessionAttendee save(SessionAttendee sessionAttendee) {

        mapper.save(sessionAttendee.getAttendeeEmail(), String.valueOf( sessionAttendee.getSessionId()));
        return sessionAttendee;
    }

    public SessionAttendee findByEmail(String attendeeEmail) {
        return mapper.getSessionAttendee(attendeeEmail);
    }

    public SessionAttendeeMapper setSessionAttendeeMapper(SessionAttendeeMapper sessionAttendeeMapper) {
        return mapper;
    }
}
