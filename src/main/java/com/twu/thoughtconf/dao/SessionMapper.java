package com.twu.thoughtconf.dao;

import com.twu.thoughtconf.domain.ConferenceSession;
import org.apache.ibatis.annotations.*;

import java.util.List;

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
            @Result(property = "conferenceName", column = "conference_name")
    })
    ConferenceSession findSessionByID(@Param("sessionId") String sessionId);


    @Insert("INSERT INTO session(conference_name,session_name,session_location,session_start_time, session_end_time,abstract, session_speaker, about_speaker) VALUES (#{conferenceSession.conferenceName},#{conferenceSession.name},#{conferenceSession.location},#{conferenceSession.startTime},#{conferenceSession.endTime},#{conferenceSession.sessionAbstract},#{conferenceSession.speaker},#{conferenceSession.speakerIntro})")
    @Options(useGeneratedKeys = true, keyProperty = "conferenceSession.sessionId")
    void save(@Param("conferenceSession") ConferenceSession conferenceSession);

    @Select("SELECT * FROM session ORDER BY session_start_time ASC")
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
            @Result(property = "conferenceName", column = "conference_name")
    })
    List<ConferenceSession> getAllSessions();

    @Delete("DELETE FROM session WHERE session_id = #{conferenceSession.sessionId}" )
    void delete(@Param("conferenceSession") ConferenceSession conferenceSession);

    @Select("SELECT * FROM session WHERE session_name = #{name.}")
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
            @Result(property = "conferenceName", column = "conference_name")
    })
    ConferenceSession getSessionByName(String anything);
}
