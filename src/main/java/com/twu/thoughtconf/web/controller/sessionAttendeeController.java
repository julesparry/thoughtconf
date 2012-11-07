package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.repositories.SessionAttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class sessionAttendeeController {

    @Autowired
    private SessionAttendeeRepository sessionAttendeeRepository;

    public void goingToSession(HttpServletRequest request, int sessionId){
//         String userName = String.format("%s@%s",request.getRemoteUser(), "thoughtworks.com");
    }
}
