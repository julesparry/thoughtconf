package com.twu.thoughtconf.dao;

import com.twu.thoughtconf.domain.SessionAttendee;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"/mapper-context.xml"})
public class SessionAttendeeMapperTest {

    @Autowired
    private SessionAttendeeMapper sessionAttendeeMapper;

    @After
    public void cleanSessionAttendeeTable() {
        sessionAttendeeMapper.cleanTable();
    }

    @Test
    public void saveTest_should_insert_new_record_into_session_attendee_table(){
        sessionAttendeeMapper.save("eseleme",  "1");
        SessionAttendee sessionAttendee = sessionAttendeeMapper.getSessionAttendee("eseleme");

        assertThat(sessionAttendee.getAttendeeEmail(), is("eseleme"));
    }

    @Test
    public void should_return_session_attendee()
    {
        sessionAttendeeMapper.save("eseleme", "1");
        SessionAttendee sessionAttendee = sessionAttendeeMapper.getSessionAttendee("eseleme");
        assertThat(sessionAttendee.getAttendeeEmail(), is("eseleme"));
        assertThat(sessionAttendee.getSessionId(), is(1));
    }

    @Before
    public void clean()
    {
        sessionAttendeeMapper.cleanTable();
    }
}
