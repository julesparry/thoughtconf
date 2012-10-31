package com.twu.thoughtconf.domain;

import java.util.Calendar;
import java.util.UUID;

// Represents a session at a Conference
public class ConferenceSession {

    private UUID id = UUID.randomUUID();
    private String trackType;
    private String sessionName;
    private String conferenceType;
    private String location;
    private String timeStart;
    private String timeEnd;
    private String sessionAbstract;
    private String speakerName;
    private String aboutSpeaker;
    private Calendar date;

    private String name;

    public String getId() {
        return id.toString();
    }

    public ConferenceSession(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return name;
    }

    public String getTrackType() {
        return trackType;
    }

    public void setTrackType(String trackType) {
        this.trackType = trackType;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getConferenceType() {
        return conferenceType;
    }

    public void setConferenceType(String conferenceType) {
        this.conferenceType = conferenceType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getSessionAbstract() {
        return sessionAbstract;
    }

    public void setSessionAbstract(String sessionAbstract) {
        this.sessionAbstract = sessionAbstract;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getAboutSpeaker() {
        return aboutSpeaker;
    }

    public void setAboutSpeaker(String aboutSpeaker) {
        this.aboutSpeaker = aboutSpeaker;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConferenceSession that = (ConferenceSession) o;

        if (aboutSpeaker != null ? !aboutSpeaker.equals(that.aboutSpeaker) : that.aboutSpeaker != null) return false;
        if (conferenceType != null ? !conferenceType.equals(that.conferenceType) : that.conferenceType != null)
            return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sessionAbstract != null ? !sessionAbstract.equals(that.sessionAbstract) : that.sessionAbstract != null)
            return false;
        if (sessionName != null ? !sessionName.equals(that.sessionName) : that.sessionName != null) return false;
        if (speakerName != null ? !speakerName.equals(that.speakerName) : that.speakerName != null) return false;
        if (timeEnd != null ? !timeEnd.equals(that.timeEnd) : that.timeEnd != null) return false;
        if (timeStart != null ? !timeStart.equals(that.timeStart) : that.timeStart != null) return false;
        if (trackType != null ? !trackType.equals(that.trackType) : that.trackType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trackType != null ? trackType.hashCode() : 0;
        result = 31 * result + (sessionName != null ? sessionName.hashCode() : 0);
        result = 31 * result + (conferenceType != null ? conferenceType.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (timeStart != null ? timeStart.hashCode() : 0);
        result = 31 * result + (timeEnd != null ? timeEnd.hashCode() : 0);
        result = 31 * result + (sessionAbstract != null ? sessionAbstract.hashCode() : 0);
        result = 31 * result + (speakerName != null ? speakerName.hashCode() : 0);
        result = 31 * result + (aboutSpeaker != null ? aboutSpeaker.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

