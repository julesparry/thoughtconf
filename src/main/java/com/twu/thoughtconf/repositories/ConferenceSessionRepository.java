package com.twu.thoughtconf.repositories;

import com.twu.thoughtconf.domain.ConferenceSession;

public class ConferenceSessionRepository {

    public ConferenceSession findById(String sessionId) {
        return new ConferenceSession("Javascript FROM th REPO");
    }
}
