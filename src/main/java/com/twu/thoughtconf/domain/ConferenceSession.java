package com.twu.thoughtconf.domain;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;

public class ConferenceSession {
    public String getSessionAbstract() {
        return sessionAbstract;
    }

    public void setSessionAbstract(String sessionAbstract) {
        this.sessionAbstract = sessionAbstract;
    }

    private String conferenceName;
    private String name;
    private DateTime startTime;
    private DateTime endTime;
    private String location;
    private String type;
    private String sessionAbstract;
    private String speaker;
    private String speakerIntro;
    private Integer sessionId;


    public ConferenceSession() {
    }


    public ConferenceSession(String name) {
        this.name = name;
    }

    public ConferenceSession(int id) {
        this.sessionId = id;
    }

    public ConferenceSession( String conferenceName, String name, String location, DateTime startTime, DateTime endTime, String sessionAbstract, String presenterName, String aboutPresenter) {
        this.conferenceName = conferenceName;
        this.name = name;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.sessionAbstract = sessionAbstract;
        this.speaker = presenterName;
        this.speakerIntro = aboutPresenter;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getId() {
        return sessionId;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public String getName() {
        return name;
    }

    public DateTime getStartTime() {
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

    public Integer getSessionId() {
        return sessionId;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMMM yyyy");
        return dateFormat.format(startTime.toDate());
    }

    public String getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm aaa");
        return String.format("%s - %s", dateFormat.format(startTime.toDate()), dateFormat.format(endTime.toDate()));
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConferenceSession that = (ConferenceSession) o;


        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sessionAbstract != null ? !sessionAbstract.equals(that.sessionAbstract) : that.sessionAbstract != null)
            return false;
        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;
        if (speaker != null ? !speaker.equals(that.speaker) : that.speaker != null) return false;
        if (speakerIntro != null ? !speakerIntro.equals(that.speakerIntro) : that.speakerIntro != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (conferenceName != null ? !conferenceName.equals(that.conferenceName) : that.conferenceName != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (sessionAbstract != null ? sessionAbstract.hashCode() : 0);
        result = 31 * result + (speaker != null ? speaker.hashCode() : 0);
        result = 31 * result + (speakerIntro != null ? speakerIntro.hashCode() : 0);
        result = 31 * result + (conferenceName != null ? conferenceName.hashCode() : 0);
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        return result;
    }
}
