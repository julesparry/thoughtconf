package com.twu.thoughtconf.repositories;

import com.twu.thoughtconf.domain.ConferenceSession;
import org.springframework.stereotype.Repository;

@Repository
public class ConferenceSessionRepository {

    public ConferenceSession findById(String sessionId) {
        return new ConferenceSession("Javascript FROM th REPO");
    }

    public ConferenceSession save(ConferenceSession conferenceSession) {
        return conferenceSession;
    }
}
