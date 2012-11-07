package com.twu.thoughtconf.web.controller;


import com.twu.thoughtconf.domain.SessionAttendee;
import com.twu.thoughtconf.repositories.SessionAttendeeRepository;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Controller
public class SessionAttendeeControllerTest {

    @Test
    public void shouldCreateASessionAttendee() {

        // ARRANGE
        Integer conferenceSessionId = 1;
        String emailId = "emailId";

        HttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("remoteUser", emailId);

        SessionAttendeeRepository repository = mock(SessionAttendeeRepository.class);
        SessionAttendee createdConferenceSessionAttendee = new SessionAttendee(emailId, conferenceSessionId);
        when(repository.save(isA(SessionAttendee.class))).thenReturn(createdConferenceSessionAttendee);

        // ACT
        SessionAttendeeController controller = new SessionAttendeeController(repository);
        controller.attend(httpServletRequest, conferenceSessionId);

        // ASSERT
        assertThat(createdConferenceSessionAttendee.getSessionId(), is(conferenceSessionId));
        assertThat(createdConferenceSessionAttendee.getAttendeeEmail(), is(emailId));
    }

}
