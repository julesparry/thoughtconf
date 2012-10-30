package com.twu.thoughtconf.domain;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class AttendeeTest {

    @Test
    public void shouldReturnGoingIsTrueWhenUserAttendanceChanged() {

        Attendee attendee = new Attendee();

        attendee.toggleAttendance();

        assertTrue(attendee.isGoing());
    }

    @Test
    public void shouldReturnGoingIsFalseWhenUserAttendanceChanged() {

        Attendee attendee = new Attendee();

        attendee.toggleAttendance();
        attendee.toggleAttendance();

        assertFalse(attendee.isGoing());
    }

}
