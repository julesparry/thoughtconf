package com.twu.thoughtconf.web.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Controller
public class SessionControllerTest {

    @Test
    public void shouldReturnAModelAndViewWithAViewNameOfViewSessionDetail() {
        ModelAndView mv = new SessionController().display();
        assertThat(mv.getViewName(), is("viewSessionDetail"));
    }

}
