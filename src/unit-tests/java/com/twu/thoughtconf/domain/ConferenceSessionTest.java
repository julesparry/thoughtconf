package com.twu.thoughtconf.domain;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConferenceSessionTest {

    @Test
    public void shouldProvideAToStringRepresentation() {
        ConferenceSession session = new ConferenceSession("Nigels Awesome Javascript");
        assertThat(session.getName(), is("Nigels Awesome Javascript"));
    }
}
