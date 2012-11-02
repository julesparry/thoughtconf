package com.twu.thoughtconf.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConferenceSessionTest {

    @Test
    public void shouldProvideAToStringRepresentation() {
        ConferenceSession session = new ConferenceSession("Nigels Awesome Javascript");
        assertThat(session.getSessionName(), is("Nigels Awesome Javascript"));
    }

}
