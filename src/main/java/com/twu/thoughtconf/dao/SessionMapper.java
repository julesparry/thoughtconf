package com.twu.thoughtconf.dao;

import com.twu.thoughtconf.domain.ConferenceSession;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface SessionMapper {

    @Select("SELECT * FROM session WHERE session_id = #{sessionId}")
    @Results(value = {
            @Result(property = "sessionId", column = "session_id"),
            @Result(property = "name", column = "session_name"),
            @Result(property = "description", column = "session_description"),
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

}
