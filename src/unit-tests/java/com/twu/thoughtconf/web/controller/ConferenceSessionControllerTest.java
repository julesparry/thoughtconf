package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.domain.ConferenceSession;
import com.twu.thoughtconf.repositories.ConferenceSessionRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Controller
public class ConferenceSessionControllerTest {

    @Test
    public void shouldReturnAModelAndViewWithAViewNameOfviewConferenceSession() {
        ModelAndView mv = new ConferenceSessionController(new ConferenceSessionRepository()).display(null);
        assertThat(mv.getViewName(), is("viewConferenceSession"));
    }

    @Test
    public void shouldPopulateTheModelMapWithAnObjectCalledSession() {
        String sessionId = "1";
        ModelAndView mv = new ConferenceSessionController(new ConferenceSessionRepository()).display(sessionId);
        assertThat(mv.getModelMap(), hasKey("session"));
    }

    @Test
    public void shouldDelegateToTheConferenceSessionServiceToFindTheConferenceSession() {
        String sessionId = "1";
        ConferenceSessionRepository repository = mock(ConferenceSessionRepository.class);
        when(repository.findById(sessionId)).thenReturn(new ConferenceSession("Javascript"));

        ConferenceSessionController controller = new ConferenceSessionController(repository);
        ModelAndView mv = controller.display(sessionId);

        ConferenceSession session = (ConferenceSession) mv.getModelMap().get("session");
        assertThat(session.getDisplayName(), is("Javascript"));
    }


}
