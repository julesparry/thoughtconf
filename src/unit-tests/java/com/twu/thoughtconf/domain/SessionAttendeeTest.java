package com.twu.thoughtconf.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SessionAttendeeTest {

    @Test
    public void two_session_attendees_with_same_userId_and_sessionId_should_be_equal() {
        SessionAttendee attendee1 = new SessionAttendee(1, 2);
        SessionAttendee attendee2 = new SessionAttendee(1, 2);
        assertThat(attendee1, is(attendee2));
    }
}
