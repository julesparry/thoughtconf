package com.twu.thoughtconf.dao;

import com.twu.thoughtconf.domain.SessionAttendee;
import org.apache.ibatis.annotations.*;

public interface SessionAttendeeMapper {

    @Insert("INSERT INTO session_attendee(attendee_email, session_id) VALUES (#{attendeeEmail}, #{sessionId})")
    public void save(@Param("attendeeEmail") String attendeeEmail, @Param("sessionId") String sessionId);

    @Select("SELECT * FROM session_attendee WHERE attendee_email = #{attendeeEmail}")
    @Results(value = {
            @Result(property = "attendeeEmail", column = "attendee_email"),
            @Result(property = "sessionId", column = "session_id")
    })
    public SessionAttendee getSessionAttendee(@Param("attendeeEmail") String attendeeEmail);

    @Delete("DELETE FROM session_attendee WHERE attendee_email = 'test.twu'")
    public void cleanTable();

    @Select("SELECT * FROM session_attendee WHERE attendee_email = #{attendeeEmail} AND session_id = #{sessionId}")
    @Results(value ={
            @Result(property = "attendeeEmail", column = "attendee_email"),
            @Result(property = "sessionId", column = "session_id")
    })
    public SessionAttendee getSessionAttendeeUsingEmailAndSessionId(@Param("attendeeEmail") String attendeeEmail,
                                                                    @Param("sessionId") String sessionId);
}
