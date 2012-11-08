package com.twu.thoughtconf.repositories;

import com.twu.thoughtconf.dao.SessionMapper;
import com.twu.thoughtconf.domain.ConferenceSession;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConferenceSessionRepository {

    @Autowired
    private SessionMapper sessionMapper;

    public ConferenceSessionRepository() {

    }

    public ConferenceSessionRepository(SessionMapper sessionMapper) {
        this.sessionMapper = sessionMapper;
    }

    public void setMapper(SessionMapper sessionMapper) {
        this.sessionMapper = sessionMapper;
    }

    public ConferenceSession findById(String sessionId) {
        return sessionMapper.findSessionByID(sessionId);
    }

    public ConferenceSession save(ConferenceSession conferenceSession) {
        sessionMapper.save(conferenceSession);
        return conferenceSession;
    }

    public ConferenceSession get(int id) {
        return findById(String.valueOf(id));
    }

    public List<ConferenceSession> getAllSessions() {
        return sessionMapper.getAllSessions();
    }

    public List<ConferenceSession> getSessionsFromToday() {
        List<ConferenceSession> sessions = getAllSessions();
        for (ConferenceSession session : sessions) {
            if (session.getStartTime().toLocalDate().isBefore(new DateTime().now().toLocalDate())) {
                sessions.remove(session);
            }
        }
        return sessions;
    }
}
