package com.twu.thoughtconf.domain;

public class SessionAnnouncements {
   private int sessionId;

    private String announcements;

    private SessionAnnouncements() {
    }

    public SessionAnnouncements(int sessionId, String announcements) {
        this.sessionId = sessionId;
        this.announcements = announcements;
    }

    public int getSessionId()
    {
        return sessionId;
    }

    public String getAnnouncements() {
        return announcements;
    }

}
