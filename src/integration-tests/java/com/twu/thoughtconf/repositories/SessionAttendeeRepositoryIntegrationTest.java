package com.twu.thoughtconf.repositories;

import com.twu.thoughtconf.dao.SessionAttendeeMapper;
import com.twu.thoughtconf.domain.SessionAttendee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"/mapper-context.xml"})
public class SessionAttendeeRepositoryIntegrationTest {

    public static final String attendeeEmail = "test.twu";

    @Autowired
    private SessionAttendeeMapper mapper;

    @Before
    public void cleanTable() {
        mapper.cleanTable();
    }

    @Test
    public void shouldSaveSessionAttendee() throws Exception {
        SessionAttendee expectedSessionAttendee = new SessionAttendee(attendeeEmail, 1);

        SessionAttendeeRepository sessionAttendeeRepository = new SessionAttendeeRepository(mapper);
        mapper.save(expectedSessionAttendee.getAttendeeEmail(), String.valueOf(expectedSessionAttendee.getSessionId()));
        SessionAttendee foundSessionAttendee = sessionAttendeeRepository.findByEmail(attendeeEmail);

        assertThat(expectedSessionAttendee, is(foundSessionAttendee));
    }

    @Test
    public void shouldReturnFalseForNonExistantBasedOnEmailAndSessionId() throws Exception {
        SessionAttendeeRepository repository = new SessionAttendeeRepository(mapper);

        assertFalse(repository.findSessionAttendee(attendeeEmail, 1));
    }

    @Test
    public void shouldReturnTrueForExistingSessionAttendee() throws Exception {
        SessionAttendee expectedSessionAttendee = new SessionAttendee(attendeeEmail, 1);

        SessionAttendeeRepository repository = new SessionAttendeeRepository(mapper);
        repository.save(expectedSessionAttendee);

        assertTrue(repository.findSessionAttendee(expectedSessionAttendee.getAttendeeEmail(), expectedSessionAttendee.getSessionId()));
    }

}
