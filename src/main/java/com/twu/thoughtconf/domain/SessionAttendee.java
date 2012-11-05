package com.twu.thoughtconf.domain;

public class SessionAttendee {
    private String attendeeEmail;
    private int sessionId;
    private boolean going;

    public SessionAttendee()
    {}

    public SessionAttendee(String attendeeEmail, int sessionId) {
        this.attendeeEmail = attendeeEmail;
        this.sessionId = sessionId;
        this.going = false;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionAttendee that = (SessionAttendee) o;

        if (going != that.going) return false;
        if (sessionId != that.sessionId) return false;
        if (attendeeEmail != null ? !attendeeEmail.equals(that.attendeeEmail) : that.attendeeEmail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attendeeEmail != null ? attendeeEmail.hashCode() : 0;
        result = 31 * result + sessionId;
        result = 31 * result + (going ? 1 : 0);
        return result;
    }

    public String getAttendeeEmail() {
        return attendeeEmail;
    }
}
