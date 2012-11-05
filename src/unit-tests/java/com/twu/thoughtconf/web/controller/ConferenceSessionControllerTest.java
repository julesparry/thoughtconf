package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.domain.ConferenceSession;
import com.twu.thoughtconf.repositories.ConferenceSessionRepository;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@Controller
public class ConferenceSessionControllerTest {

    @Test
    public void shouldReturnViewToCreatConferenceSession() {
        ModelAndView mv = new ConferenceSessionController(new ConferenceSessionRepository()).newConferenceSession();
        assertThat(mv.getModelMap(), hasKey("formAction"));
        assertThat(mv.getViewName(), is("newConferenceSession"));
    }

    @Test
    public void shouldReturnTheConferenceSessionView() {
        ConferenceSessionRepository repository = mock(ConferenceSessionRepository.class);
        ModelAndView mv = new ConferenceSessionController(repository).display(null);
        assertThat(mv.getViewName(), is("viewConferenceSession"));
    }

    @Test
    public void shouldAddSessionToTheView() {
        ModelAndView mv = new ConferenceSessionController(mock(ConferenceSessionRepository.class)).display("1");
        assertThat(mv.getModelMap(), hasKey("session"));
    }

    @Test
    public void shouldRetrieveTheConferenceSessionFromASessionId() {
        String sessionId = "1";
        ConferenceSessionRepository repository = mock(ConferenceSessionRepository.class);
        when(repository.findById(sessionId)).thenReturn(new ConferenceSession("Javascript"));

        ConferenceSessionController controller = new ConferenceSessionController(repository);
        ModelAndView mv = controller.display(sessionId);

        ConferenceSession session = (ConferenceSession) mv.getModelMap().get("session");
        assertThat(session.getSessionName(), is("Javascript"));
    }

    @Test
    public void shouldCreateAConferenceSession() throws Exception {
        // Arrange
        ConferenceSessionRepository repository = mock(ConferenceSessionRepository.class);
        ConferenceSession expectedConferenceSession = mock(ConferenceSession.class);
        when(expectedConferenceSession.getId()).thenReturn("12345");
        when(repository.save(any(ConferenceSession.class))).thenReturn(expectedConferenceSession);

        // Act
        ConferenceSessionController controller = new ConferenceSessionController(repository);
        ModelAndView mv = controller.create("Awesome JS");

        // Assert
        assertThat(mv.getViewName(), startsWith("redirect:confirmation/12345"));

    }


}
