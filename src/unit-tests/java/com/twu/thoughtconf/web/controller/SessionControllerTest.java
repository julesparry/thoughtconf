package com.twu.thoughtconf.web.controller;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.assertThat;

@Controller
public class SessionControllerTest {

    @Test
    public void shouldReturnAModelAndViewWithAViewNameOfViewSessionDetail() {
        ModelAndView mv = new SessionController().display(null);
        assertThat(mv.getViewName(), is("viewSessionDetail"));
    }

    @Test
    public void shouldPopulateTheModelMapWithAnObjectCalledSession() {
        String sessionId = "1";
        ModelAndView mv = new SessionController().display(sessionId);
        assertThat(mv.getModelMap(), hasKey("session"));
    }


}
