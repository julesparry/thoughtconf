package com.twu.thoughtconf.repositories;

import com.twu.thoughtconf.dao.SessionMapper;
import com.twu.thoughtconf.domain.ConferenceSession;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ConferenceSessionRepositoryTest {

    @Test
    public void shouldReturnConferenceSessionByGivenSessionId() {
        String sessionId = "1";

        SessionMapper sessionMapper = mock(SessionMapper.class);
        ConferenceSession expectConferenceSession = mock(ConferenceSession.class);
        when(sessionMapper.findSessionByID(sessionId)).thenReturn(expectConferenceSession);

        ConferenceSessionRepository conferenceSessionRepository = new ConferenceSessionRepository();
        conferenceSessionRepository.setMapper(sessionMapper);

        ConferenceSession actualConferenceSession = conferenceSessionRepository.findById(sessionId);

        assertThat(actualConferenceSession, sameInstance(expectConferenceSession));
    }

    @Test
    public void shouldReturnAllSessions() {
        List conferenceSessions = new ArrayList<ConferenceSession>();
        SessionMapper sessionMapper = createMapper(conferenceSessions);

        ConferenceSessionRepository conferenceSessionRepository = new ConferenceSessionRepository();
        conferenceSessionRepository.setMapper(sessionMapper);

        assertThat(conferenceSessionRepository.getAllSessions(), sameInstance(conferenceSessions));

    }

    @Test
    public void shouldReturnSessionsFromToday() {
        List conferenceSessions = new ArrayList<ConferenceSession>();
        conferenceSessions.add(createConferenceSession(2011, 12, 11, 9, 30, 0));
        conferenceSessions.add(createConferenceSession(2013, 12, 11, 9, 30, 0));

        ConferenceSessionRepository conferenceSessionRepository = new ConferenceSessionRepository();
        conferenceSessionRepository.setMapper(createMapper(conferenceSessions));

        List<ConferenceSession> sessionsFromToday = conferenceSessionRepository.getSessionsFromToday();

        assertThat(sessionsFromToday.size(), is(1));
        assertThat(sessionsFromToday.get(0).getStartTime(), is(new DateTime(2013, 12, 11, 9, 30, 0)));
    }

    private ConferenceSession createConferenceSession(int year, int month, int day, int hour, int minute, int second) {
        ConferenceSession conferenceSession = new ConferenceSession("session");
        conferenceSession.setStartTime(new DateTime(year, month, day, hour, minute, second));
        return conferenceSession;
    }

    private SessionMapper createMapper(List conferenceSessions) {
        SessionMapper sessionMapper = mock(SessionMapper.class);
        when(sessionMapper.getAllSessions()).thenReturn(conferenceSessions);
        return sessionMapper;
    }

    @Test
    public void shouldReturnAllConferences() {
        //Arrange
        SessionMapper mapper = mock(SessionMapper.class);
        ConferenceSessionRepository repository = new ConferenceSessionRepository();
        repository.setMapper(mapper);

        //Act
        repository.getAllConferenceNames();

        //Assert: Make sure that the repository delegates the getAllConferenceNames to the mapper.
        verify(mapper).getAllConferenceNames();
    }
}
