package com.twu.thoughtconf.dao;

import com.twu.thoughtconf.domain.ConferenceSession;
import com.twu.thoughtconf.domain.Feedback;
import org.apache.ibatis.annotations.*;

public interface FeedbackMapper {

    @Delete("DELETE FROM feedback WHERE session_attendee_id = 911")
    public void cleanTable();

    @Select("SELECT * FROM feedback WHERE session_attendee_id = #{sessionAttendeeId}")
    @Results(value = {
            @Result(property = "presenterRating", column = "presenter_rating"),
            @Result(property = "contentRating", column = "content_rating"),
            @Result(property = "overallRating", column = "overall_rating"),
            @Result(property = "sessionAttendeeId", column = "session_attendee_id")
    })
    Feedback getFeedbackBySessionAttendeeId(@Param("sessionAttendeeId") Integer sessionAttendeeId);

//
//    @Insert("INSERT INTO feedback(session_attendee_id, presenter_rating,content_rating, overall_rating) VALUES (#{feedback.sessionAttendeeId},#{feedback.presenterRating},#{feedback.contentRating},#{feedback.overallRating})")
//    @Options(useGeneratedKeys = true, keyProperty = "Feedback.sessionAttendeeId")
//    void save(@Param("feedback") Feedback feedback);

//    void delete(Feedback feedback);
}
