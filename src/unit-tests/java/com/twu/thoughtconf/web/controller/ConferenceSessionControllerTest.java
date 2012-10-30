package com.twu.thoughtconf.web.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.assertThat;

@Controller
public class ConferenceSessionControllerTest {

    @Test
    public void shouldReturnAModelAndViewWithAViewNameOfviewConferenceSession() {
        ModelAndView mv = new ConferenceSessionController().display(null);
        assertThat(mv.getViewName(), is("viewConferenceSession"));
    }

    @Test
    public void shouldPopulateTheModelMapWithAnObjectCalledSession() {
        String sessionId = "1";
        ModelAndView mv = new ConferenceSessionController().display(sessionId);
        assertThat(mv.getModelMap(), hasKey("session"));
    }


}
