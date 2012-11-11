package com.twu.thoughtconf.domain;

public class Feedback {
    Integer sessionAttendeeId;

    int presenterRating;
    int contentRating;
    int overallRating;


    public Feedback(Integer sessionAttendeeId,
                    int presenterRating,
                    int contentRating,
                    int overallRating){
        this.sessionAttendeeId = sessionAttendeeId;
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

    public Integer getSessionAttendeeId() {
        return sessionAttendeeId;
    }

}
