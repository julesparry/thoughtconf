package com.twu.thoughtconf.dao;

import com.twu.thoughtconf.domain.Feedback;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface FeedbackMapper {

    @Delete("DELETE FROM feedback ")
    public void cleanTable();

    @Select("SELECT * FROM feedback WHERE feedback_id = #{feedbackId}")
    @Results(value = {
            @Result(property = "presenterRating", column = "presenter_rating"),
            @Result(property = "contentRating", column = "content_rating"),
            @Result(property = "overallRating", column = "overall_rating"),
            @Result(property = "sessionId", column = "session_id"),
            @Result(property = "attendeeEmail", column = "attendee_email")
    })
    Feedback getFeedbackById(@Param("feedbackId") Integer feedbackId);


    @Insert("INSERT INTO feedback(session_id, attendee_email, presenter_rating,content_rating, overall_rating) VALUES (#{feedback.sessionId},#{feedback.attendeeEmail},#{feedback.presenterRating},#{feedback.contentRating},#{feedback.overallRating})")
    @Options(useGeneratedKeys = true, keyProperty = "feedback.feedbackId")
    void save(@Param("feedback") Feedback feedback);


}
