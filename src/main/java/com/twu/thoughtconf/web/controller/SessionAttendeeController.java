package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.domain.SessionAttendee;
import com.twu.thoughtconf.repositories.SessionAttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/api/session/{sessionId}/attendance")
public class SessionAttendeeController {

    public SessionAttendeeController() {
    }

    @Autowired
    private SessionAttendeeRepository repository;

    public SessionAttendeeController(SessionAttendeeRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String going(@PathVariable("sessionId") String sessionId, HttpServletRequest httpServletRequest) {
        repository.save(new SessionAttendee(httpServletRequest.getRemoteUser(), Integer.parseInt(sessionId)));
        return "going";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public String notGoing(@PathVariable("sessionId") String sessionId, HttpServletRequest httpServletRequest) {
        return "notGoing";
    }

}
