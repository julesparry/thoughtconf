package com.twu.thoughtconf.dao;

import com.twu.thoughtconf.domain.ConferenceSession;
import org.apache.ibatis.annotations.*;

public interface SessionMapper {

    @Select("SELECT * FROM session WHERE session_id = #{sessionId}")
    @Results(value = {
            @Result(property = "sessionId", column = "session_id"),
            @Result(property = "name", column = "session_name"),
            @Result(property = "startTime", column = "session_start_time"),
            @Result(property = "endTime", column = "session_end_time"),
            @Result(property = "location", column = "session_location"),
            @Result(property = "type", column = "session_type"),
            @Result(property = "sessionAbstract", column = "abstract"),
            @Result(property = "speaker", column = "session_speaker"),
            @Result(property = "speakerIntro", column = "about_speaker"),
            @Result(property = "trackId", column = "track_id")
    })
    ConferenceSession findSessionByID(@Param("sessionId") String sessionId);

    @Insert("INSERT INTO session(session_name) VALUES (#{name})")
    void save(@Param("conferenceSession") ConferenceSession name);
    
}
