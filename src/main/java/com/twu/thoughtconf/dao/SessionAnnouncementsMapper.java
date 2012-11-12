package com.twu.thoughtconf.dao;


import com.twu.thoughtconf.domain.SessionAnnouncements;
import org.apache.ibatis.annotations.*;

public interface SessionAnnouncementsMapper {



    @Insert("INSERT INTO session_announcements(announcement, session_id) VALUES (#{announcements}, #{sessionId})")
    public void save(@Param("sessionId") int sessionId, @Param("announcements") String announcements);

    @Select ("SELECT * FROM session_announcements WHERE session_id=#{sessionId}")
    @Results(value = {
            @Result(property = "sessionId", column = "session_id"),
            @Result(property = "announcements", column = "announcement")
    })
    public SessionAnnouncements getAnnouncementByAnnouncementAndSessionId(@Param("sessionId") int sessionId, @Param("announcements")String announcements);

    @Delete("DELETE FROM session_announcements")
    public void cleanTable();
}


