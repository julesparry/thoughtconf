package com.twu.thoughtconf.domain;

public class Attendee {

    private boolean going;

    public Attendee() {
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
