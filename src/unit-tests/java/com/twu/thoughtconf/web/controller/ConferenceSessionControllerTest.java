package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.domain.ConferenceSession;
import com.twu.thoughtconf.repositories.ConferenceSessionRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.Matchers.hasKey;
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
    public void shouldRetrieveAllConferenceSessions() {
        ConferenceSessionRepository repository = mock(ConferenceSessionRepository.class);
        List sessionList = new ArrayList();
        when(repository.getSessionsFromToday()).thenReturn(sessionList);
        ModelAndView mv = new ConferenceSessionController(repository).displayAllSessions();

        assertThat(mv.getViewName(), Matchers.is("attendeeHomepage"));
        assertThat(mv.getModelMap(), hasKey("sessions"));
        assertThat((List) mv.getModelMap().get("sessions"), Matchers.sameInstance(sessionList));
    }

    @Test
    public void shouldReturnTheConferenceSessionView() {
        ConferenceSessionRepository repository = mock(ConferenceSessionRepository.class);
        ModelAndView mv = new ConferenceSessionController(repository).displaySession(null);
        assertThat(mv.getViewName(), is("viewConferenceSession"));
    }

    @Test
    public void shouldAddSessionToTheView() {
        ModelAndView mv = new ConferenceSessionController(mock(ConferenceSessionRepository.class)).displaySession("1");
        assertThat(mv.getModelMap(), hasKey("session"));
    }

    @Test
    public void shouldRetrieveTheConferenceSessionFromASessionId() {
        String sessionId = "1";
        ConferenceSessionRepository repository = mock(ConferenceSessionRepository.class);
        when(repository.findById(sessionId)).thenReturn(new ConferenceSession("Javascript"));

        ConferenceSessionController controller = new ConferenceSessionController(repository);
        ModelAndView mv = controller.displaySession(sessionId);

        ConferenceSession session = (ConferenceSession) mv.getModelMap().get("session");
        assertThat(session.getName(), is("Javascript"));
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
        String viewName = controller.create("Awesome JS", "", "2012-9-11", "08:10-10:20", "", "", "");

        // Assert
        assertThat(viewName, is("redirect:confirmation/12345"));

    }

    @Test
    public void shouldMapToSessionConfirmationViewNameWhenCallingConfirm() {
        ConferenceSessionRepository repository = mock(ConferenceSessionRepository.class);
        ConferenceSessionController controller = new ConferenceSessionController(repository);

        ModelAndView mv = controller.confirm(123);
        assertThat(mv.getViewName(), is("sessionConfirmation"));
    }


    @Test
    public void shouldIncludeSessionInModelWhenCallingConfirm() {
        ConferenceSessionRepository repository = mock(ConferenceSessionRepository.class);
        ConferenceSessionController controller = new ConferenceSessionController(repository);
        ConferenceSession expectedSession = new ConferenceSession(123);
        when(repository.get(123)).thenReturn(expectedSession);

        ModelAndView mv = controller.confirm(123);
        assertThat((ConferenceSession) mv.getModel().get("session"), sameInstance(expectedSession));
    }

}
