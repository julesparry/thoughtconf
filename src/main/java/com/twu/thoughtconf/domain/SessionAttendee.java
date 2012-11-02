package com.twu.thoughtconf.domain;

public class SessionAttendee {
    private int userId;
    private int sessionId;

    public SessionAttendee(int userId, int sessionId) {
        this.userId = userId;
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionAttendee that = (SessionAttendee) o;

        if (sessionId != that.sessionId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + sessionId;
        return result;
    }
}
