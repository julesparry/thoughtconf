package com.twu.thoughtconf.domain;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class UserTest {

    @Test
    public void shouldReturnGoingIsTrueWhenUserAttendanceChanged() {

        User user = new User();

        user.toggleAttendance();

        assertTrue(user.isGoing());
    }

    @Test
    public void shouldReturnGoingIsFalseWhenUserAttendanceChanged() {

        User user = new User();

        user.toggleAttendance();
        user.toggleAttendance();

        assertFalse(user.isGoing());
    }

}
