package com.twu.thoughtconf.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConferenceSession {

    private String name;
    private Date startTime;
    private Date endTime;
    private String location;
    private String type;
    private String sessionAbstract;
    private String speaker;
    private String speakerIntro;
    private Integer trackId;
    private Integer sessionId;

    public ConferenceSession() {
    }

    public ConferenceSession(String name) {
        this.name = name;
    }

    public String getId() {
        return sessionId.toString();
    }

    public String getSessionName() {
        return name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public String getAbstract() {
        return sessionAbstract;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getSpeakerIntro() {
        return speakerIntro;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getSessionDate() {
        return new SimpleDateFormat("dd MMM, yyyy").format(startTime);
    }

    public String getSessionDuration() {
        return new SimpleDateFormat("hh:mm a").format(startTime) + " - " + new SimpleDateFormat("hh:mm a").format(endTime);
    }
}
