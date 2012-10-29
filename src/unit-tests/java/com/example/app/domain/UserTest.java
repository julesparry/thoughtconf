package com.example.app.domain;

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: lwyglend
 * Date: 29/10/2012
 * Time: 12:12
 * To change this template use File | Settings | File Templates.
 */
public class UserTest {

    @Test
    public void shouldReturnGoingIsTrueWhenUserAttendanceChanged(){

        User user = new User();

        user.toggleAttendance();

        assertTrue(user.isGoing());
    }

    @Test
    public void shouldReturnGoingIsFalseWhenUserAttendanceChanged(){

        User user = new User();

        user.toggleAttendance();
        user.toggleAttendance();

        assertFalse(user.isGoing());
    }




}
