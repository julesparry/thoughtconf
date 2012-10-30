package com.twu.thoughtconf.domain;

// Represents a session at a Conference
public class ConferenceSession {

    private String name;

    public ConferenceSession(String name) {
        this.name=name;
    }

    public String getDisplayName() {
        return name;
    }
}
