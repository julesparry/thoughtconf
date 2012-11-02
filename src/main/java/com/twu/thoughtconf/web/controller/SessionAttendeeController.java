package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.domain.SessionAttendee;
import com.twu.thoughtconf.repositories.SessionAttendeeRepository;

public class SessionAttendeeController {
    private SessionAttendeeRepository sessionAttendeeRepository;


    public SessionAttendeeController(SessionAttendeeRepository sessionAttendeeRepository) {
        this.sessionAttendeeRepository = sessionAttendeeRepository;
    }

    public void handleGoing(Integer sessionId) {
        sessionAttendeeRepository.save(new SessionAttendee(100, sessionId));
    }
}
