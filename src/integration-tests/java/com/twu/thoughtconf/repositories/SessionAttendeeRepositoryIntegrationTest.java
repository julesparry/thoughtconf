package com.twu.thoughtconf.repositories;

import com.twu.thoughtconf.domain.SessionAttendee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SessionAttendeeRepositoryIntegrationTest {


    @Autowired
    SessionAttendeeRepository repository;

    @Test
    public void shouldSaveSessionAttendee() throws Exception {
//        SessionAttendee savedSessionAttendee = repository.save(new SessionAttendee("emailId", 12345));
//        SessionAttendee foundSessionAttendee = repository.findByEmail(savedSessionAttendee.getAttendeeEmail());
//        assertThat(foundSessionAttendee.getAttendeeEmail(), is(savedSessionAttendee.getAttendeeEmail()));
    }

}
