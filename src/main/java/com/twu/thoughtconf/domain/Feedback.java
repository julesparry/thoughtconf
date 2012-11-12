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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feedback feedback = (Feedback) o;

        if (attendeeEmail != null ? !attendeeEmail.equals(feedback.attendeeEmail) : feedback.attendeeEmail != null)
            return false;
        if (contentRating != null ? !contentRating.equals(feedback.contentRating) : feedback.contentRating != null)
            return false;
        if (feedbackId != null ? !feedbackId.equals(feedback.feedbackId) : feedback.feedbackId != null) return false;
        if (overallRating != null ? !overallRating.equals(feedback.overallRating) : feedback.overallRating != null)
            return false;
        if (presenterRating != null ? !presenterRating.equals(feedback.presenterRating) : feedback.presenterRating != null)
            return false;
        if (sessionId != null ? !sessionId.equals(feedback.sessionId) : feedback.sessionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = feedbackId != null ? feedbackId.hashCode() : 0;
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        result = 31 * result + (attendeeEmail != null ? attendeeEmail.hashCode() : 0);
        result = 31 * result + (presenterRating != null ? presenterRating.hashCode() : 0);
        result = 31 * result + (contentRating != null ? contentRating.hashCode() : 0);
        result = 31 * result + (overallRating != null ? overallRating.hashCode() : 0);
        return result;
    }
}
