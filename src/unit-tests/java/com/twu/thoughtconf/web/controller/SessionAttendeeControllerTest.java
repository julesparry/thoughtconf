package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.domain.SessionAttendee;
import com.twu.thoughtconf.repositories.SessionAttendeeRepository;
import org.junit.Test;
import org.springframework.stereotype.Controller;

import static org.mockito.Mockito.*;

@Controller
public class SessionAttendeeControllerTest {

    @Test
    public void shouldTestSaveMethod(){
        int sessionId = 1;
        String attendeeEmail = "eseleme@thoughtworks.com";

        SessionAttendeeRepository sessionAttendeeRepository = mock(SessionAttendeeRepository.class);

    }

}
