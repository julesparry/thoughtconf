package com.twu.thoughtconf.domain;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SessionAttendeeTest {

    @Test
    public void two_session_attendees_with_same_userId_and_sessionId_should_be_equal() {
        SessionAttendee attendee1 = new SessionAttendee("1", 2);
        SessionAttendee attendee2 = new SessionAttendee("1", 2);
        assertThat(attendee1, is(attendee2));
    }

    @Test
    public void shouldReturnGoingIsTrueWhenUserAttendanceChanged() {

        SessionAttendee attendee = new SessionAttendee("1",2);

        attendee.toggleAttendance();

        assertTrue(attendee.isGoing());
    }

    @Test
    public void shouldReturnGoingIsFalseWhenUserAttendanceChanged() {

        SessionAttendee attendee = new SessionAttendee("1",2);

        attendee.toggleAttendance();
        attendee.toggleAttendance();

        assertFalse(attendee.isGoing());
    }


}
