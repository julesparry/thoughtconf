package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.domain.SessionAttendee;
import com.twu.thoughtconf.repositories.SessionAttendeeRepository;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SessionAttendeeControllerTest {

    private SessionAttendeeRepository mockSessionAttendeeRepository;

    @Test
    public void should_create_a_session_attendee_record_after_receiving_going_request() {
        String userId = "100";
        int sessionId = 99;
        mockSessionAttendeeRepository = mock(SessionAttendeeRepository.class);
        SessionAttendeeController controller = new SessionAttendeeController(mockSessionAttendeeRepository);

        controller.handleGoing(sessionId);

        verify(mockSessionAttendeeRepository).save(new SessionAttendee(userId, sessionId));
    }
}
