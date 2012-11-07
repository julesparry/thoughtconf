package com.twu.thoughtconf.domain;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConferenceSessionTest {

    @Test
    public void shouldProvideAToStringRepresentation() {
        ConferenceSession session = new ConferenceSession("Nigels Awesome Javascript");
        assertThat(session.getName(), is("Nigels Awesome Javascript"));
    }

    @Test
    public void shouldCalculateDate() {
        DateTime startTime = DateTime.parse("2012-12-11T09:30:00");
        DateTime endTime = DateTime.parse("2012-12-11T10:30:00");
        ConferenceSession session = new ConferenceSession("name", "location", startTime, endTime, "abstract", "presenter", "about presenter");
        assertThat(session.getDate(), is("11 December 2012"));
    }

    @Test
    public void shouldCalculateTime() {
        DateTime startTime = DateTime.parse("2012-12-11T09:30:00");
        DateTime endTime = DateTime.parse("2012-12-11T10:30:00");
        ConferenceSession session = new ConferenceSession("name", "location", startTime, endTime, "abstract", "presenter", "about presenter");
        assertThat(session.getTime(), is("09:30 AM - 10:30 AM"));
    }

}
