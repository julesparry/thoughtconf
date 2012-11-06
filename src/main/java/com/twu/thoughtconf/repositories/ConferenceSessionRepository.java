package com.twu.thoughtconf.repositories;

import com.twu.thoughtconf.dao.SessionMapper;
import com.twu.thoughtconf.domain.ConferenceSession;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConferenceSessionRepository {

    @Autowired
    private SessionMapper sessionMapper;

    public ConferenceSession findById(String sessionId) {
        return sessionMapper.findSessionByID(sessionId);
    }

    public void setMapper(SessionMapper sessionMapper) {
        this.sessionMapper = sessionMapper;
    }


    public ConferenceSession save(ConferenceSession conferenceSession) {
        sessionMapper.save(conferenceSession);
        return conferenceSession;
    }
}
