package com.twu.thoughtconf.repositories;

import com.twu.thoughtconf.dao.SessionMapper;
import com.twu.thoughtconf.domain.ConferenceSession;
import org.junit.Test;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConferenceSessionRepositoryTest{
    @Test
    public void should_return_conference_session_by_given_session_id() {
        String sessionId = "1";

        SessionMapper sessionMapper = mock(SessionMapper.class);
        ConferenceSession expectConferenceSession = mock(ConferenceSession.class);
        when(sessionMapper.findSessionByID(sessionId)).thenReturn(expectConferenceSession);

        ConferenceSessionRepository conferenceSessionRepository = new ConferenceSessionRepository();
        conferenceSessionRepository.setMapper(sessionMapper);

        ConferenceSession actualConferenceSession = conferenceSessionRepository.findById(sessionId);
        
        assertThat(actualConferenceSession, sameInstance(expectConferenceSession));



    }

    
}
