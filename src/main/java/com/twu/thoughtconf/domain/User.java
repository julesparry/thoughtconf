package com.twu.thoughtconf.domain;

public class User {

    private boolean going;

    public User() {
        going = false;
    }

    public void toggleAttendance() {
        if (!going) {
            going = true;
        } else {
            going = false;
        }
    }

    public boolean isGoing() {
        return going;
    }

}
