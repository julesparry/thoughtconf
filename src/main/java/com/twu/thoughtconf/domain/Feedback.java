package com.twu.thoughtconf.domain;

public class Feedback {
    private Integer feedbackId;
    private Integer sessionId;
    private String attendeeEmail;
    private Integer presenterRating;
    private Integer contentRating;
    private Integer overallRating;

    public Feedback() {
    }

    public Feedback(Integer sessionId, String attendeeEmail, Integer presenterRating, Integer contentRating, Integer overallRating) {
        this.sessionId = sessionId;
        this.attendeeEmail = attendeeEmail;
        this.presenterRating = presenterRating;
        this.contentRating = contentRating;
        this.overallRating = overallRating;
    }

    public int getPresenterRating() {
        return presenterRating;
    }

    public int getContentRating() {
        return contentRating;
    }

    public int getOverallRating() {
        return overallRating;
    }

    public String getAttendeeEmail() {
        return attendeeEmail;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }
}
