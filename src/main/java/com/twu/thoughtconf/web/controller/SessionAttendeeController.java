package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.domain.SessionAttendee;
import com.twu.thoughtconf.repositories.SessionAttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class SessionAttendeeController {

    @Autowired
    private SessionAttendeeRepository repository;

    public SessionAttendeeController(SessionAttendeeRepository repository) {
        this.repository = repository;
    }

    public void attend(HttpServletRequest httpServletRequest, Integer conferenceSessionId) {
        repository.save(new SessionAttendee(httpServletRequest.getRemoteUser(), conferenceSessionId));
    }
}
