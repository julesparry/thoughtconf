package com.twu.thoughtconf.dao;

import com.twu.thoughtconf.domain.SessionAttendee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"/mapper-context.xml"})
public class SessionAttendeeMapperTest {

    @Autowired
    private SessionAttendeeMapper sessionAttendeeMapper;
    protected final String attendeeEmail = "test.twu";
    protected final String sessionId = "1";

    @After
    public void cleanSessionAttendeeTable() {
        sessionAttendeeMapper.cleanTable();
    }

    @Test
    public void saveTest_should_insert_new_record_into_session_attendee_table(){
        sessionAttendeeMapper.save(attendeeEmail, sessionId);
        SessionAttendee sessionAttendee = sessionAttendeeMapper.getSessionAttendee(attendeeEmail);

        assertThat(sessionAttendee.getAttendeeEmail(), is(attendeeEmail));
    }

    @Test
    public void should_return_session_attendee()
    {
        sessionAttendeeMapper.save(attendeeEmail, sessionId);
        SessionAttendee sessionAttendee = sessionAttendeeMapper.getSessionAttendee(attendeeEmail);
        assertThat(sessionAttendee.getAttendeeEmail(), is(attendeeEmail));
        assertThat(sessionAttendee.getSessionId(), is(1));
    }

    @Test
    public void should_return_session_attending_status_using_attendeeEmail_and_sessionId() throws Exception {
        sessionAttendeeMapper.save(attendeeEmail, sessionId);
        SessionAttendee sessionAttendee = sessionAttendeeMapper.getSessionAttendeeUsingEmailAndSessionId(attendeeEmail, sessionId);
        assertThat(sessionAttendee.getAttendeeEmail(), is(attendeeEmail));
        assertThat(sessionAttendee.getSessionId(), is(1));
    }

    @Test
    public void shouldTestEmptyResultSetAndReturnNull() throws Exception {
        SessionAttendee sessionAttendee = sessionAttendeeMapper.getSessionAttendeeUsingEmailAndSessionId("test", "4");
        assertNull(sessionAttendee);
    }

    @Before
    public void clean()
    {
        sessionAttendeeMapper.cleanTable();
    }
}
