package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.domain.ConferenceSession;
import com.twu.thoughtconf.repositories.ConferenceSessionRepository;
import com.twu.thoughtconf.repositories.SessionAttendeeRepository;
import org.hamcrest.Matchers;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@Controller
public class ConferenceSessionControllerTest {

    @Test
    public void shouldReturnViewToCreatConferenceSession() {
        ModelAndView mv = new ConferenceSessionController(new ConferenceSessionRepository(), mock(SessionAttendeeRepository.class)).newConferenceSession();
        assertThat(mv.getModelMap(), hasKey("formAction"));
        assertThat(mv.getViewName(), is("newConferenceSession"));
    }

    @Test
    public void shouldRetrieveAllConferenceSessions() {
        ConferenceSessionRepository repository = mock(ConferenceSessionRepository.class);
        List sessionList = new ArrayList();
        when(repository.getAllSessions()).thenReturn(sessionList);
        ModelAndView mv = new ConferenceSessionController(repository, mock(SessionAttendeeRepository.class)).displayAllSessions();

        assertThat(mv.getViewName(), Matchers.is("attendeeHomepage"));
        assertThat(mv.getModelMap(), hasKey("sessions"));
        assertThat((List) mv.getModelMap().get("sessions"), Matchers.sameInstance(sessionList));
    }

    @Test
    public void shouldReturnTheConferenceSessionView() {
        ConferenceSessionRepository repository = mock(ConferenceSessionRepository.class);
        SessionAttendeeRepository sessionAttendeeRepository = mock(SessionAttendeeRepository.class);
        ConferenceSessionController conferenceSessionController = new ConferenceSessionController(repository, sessionAttendeeRepository);
        ModelAndView mv = conferenceSessionController.displaySession("1", new MockHttpServletRequest());
        assertThat(mv.getViewName(), is("viewConferenceSession"));
    }

    @Test
    public void shouldAddSessionToTheView() {
        ModelAndView mv = new ConferenceSessionController(mock(ConferenceSessionRepository.class), mock(SessionAttendeeRepository.class)).displaySession("1", new MockHttpServletRequest());
        assertThat(mv.getModelMap(), hasKey("session"));
    }

    @Test
    public void shouldRetrieveTheConferenceSessionFromASessionId() {
        String sessionId = "1";
        ConferenceSessionRepository repository = mock(ConferenceSessionRepository.class);
        when(repository.findById(sessionId)).thenReturn(new ConferenceSession("Javascript"));

        ConferenceSessionController controller = new ConferenceSessionController(repository, mock(SessionAttendeeRepository.class));
        ModelAndView mv = controller.displaySession(sessionId, new MockHttpServletRequest());

        ConferenceSession session = (ConferenceSession) mv.getModelMap().get("session");
        assertThat(session.getName(), is("Javascript"));
    }

    @Test
    public void shouldRetrieveTheGoingStatus() {
        String sessionId = "1";
        ConferenceSessionRepository conferenceSessionRepository = mock(ConferenceSessionRepository.class);
        when(conferenceSessionRepository.findById(sessionId)).thenReturn(new ConferenceSession("Javascript"));

        SessionAttendeeRepository sessionAttendeeRepository = mock(SessionAttendeeRepository.class);
        when(sessionAttendeeRepository.hasSessionAttendee("test@thoughtworks.com", Integer.parseInt(sessionId))).thenReturn(true);

        ConferenceSessionController controller = new ConferenceSessionController(conferenceSessionRepository, sessionAttendeeRepository);
        MockHttpServletRequest httpRequest = new MockHttpServletRequest();
        httpRequest.setRemoteUser("test@thoughtworks.com");
        ModelAndView mv = controller.displaySession(sessionId, httpRequest);

        Boolean going = (Boolean) mv.getModelMap().get("going");
        assertThat(going, is(true));
    }

    @Test
    public void shouldMapToSessionConfirmationViewNameWhenCallingConfirm() {
        ConferenceSessionRepository repository = mock(ConferenceSessionRepository.class);
        ConferenceSessionController controller = new ConferenceSessionController(repository, mock(SessionAttendeeRepository.class));
        ModelAndView mv = controller.confirm(123);
        assertThat(mv.getViewName(), is("sessionConfirmation"));
    }

    @Test
    public void shouldIncludeSessionInModelWhenCallingConfirm() {
        ConferenceSessionRepository repository = mock(ConferenceSessionRepository.class);
        ConferenceSessionController controller = new ConferenceSessionController(repository, mock(SessionAttendeeRepository.class));
        ConferenceSession expectedSession = new ConferenceSession(123);
        when(repository.getSessionById(123)).thenReturn(expectedSession);

        ModelAndView mv = controller.confirm(123);
        assertThat((ConferenceSession) mv.getModel().get("session"), sameInstance(expectedSession));
    }

    @Test
    public void shouldCreateAConferenceSessionForHappyPathValue() throws Exception {
        // Arrange
        ConferenceSessionRepository repository = mock(ConferenceSessionRepository.class);
        ConferenceSession expectedConferenceSession = mock(ConferenceSession.class);
        when(expectedConferenceSession.getId()).thenReturn(12345);
        when(repository.save(any(ConferenceSession.class))).thenReturn(expectedConferenceSession);

        // Act
        ConferenceSessionController controller = new ConferenceSessionController(repository, mock(SessionAttendeeRepository.class));
        String viewName = controller.create("JavaConference","Javascript", "Nalanda", "2012-12-25", "08:30-09:30", "Javascript Things", "Nigel", "Dances like a Panda");

        // Assert
        assertThat(viewName, is("redirect:confirmation/12345"));
    }

    @Test
    public void shouldReturnJodaTime() {
        DateTime expectedDateTime = new DateTime(2012, 9, 10, 8, 30, 0);
        String dateString = "2012-9-10";
        String timeString = "8:30";

        ConferenceSessionController controller = new ConferenceSessionController();
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss");
        assertThat(controller.parseToJodaTime(dateString, dateTimeFormatter, timeString), is(expectedDateTime));
    }

    @Test
    public void shouldSaveConferenceSessionWithCorrectParameter() {
        String conferenceName="confAkriti";
        String name = "Akriti";
        String location = "Bengaluru";
        DateTime startTime = new DateTime(2012, 9, 10, 8, 30, 0);
        DateTime endTime = new DateTime(2012, 9, 10, 9, 30, 0);
        String sessionAbstract = "Javascript";
        String presenterName = "Yaxuan";
        String aboutPresenter = "Come from Xi'an";
        ConferenceSession expectedConferenceSession = new ConferenceSession(conferenceName,name, location, startTime, endTime, sessionAbstract, presenterName, aboutPresenter);

        ConferenceSessionRepository conferenceSessionRepository = mock(ConferenceSessionRepository.class);

        when(conferenceSessionRepository.save(any(ConferenceSession.class))).thenReturn(expectedConferenceSession);
        ConferenceSessionController controller = new ConferenceSessionController(conferenceSessionRepository, mock(SessionAttendeeRepository.class));
        controller.create(conferenceName,name, location, "2012-9-10", "08:30-09:30", sessionAbstract, presenterName, aboutPresenter);
        verify(conferenceSessionRepository).save(expectedConferenceSession);
    }

    @Test
    public void shouldViewSessionNameOnHomePage() throws Exception {
        ConferenceSessionRepository conferenceSessionRepository = mock(ConferenceSessionRepository.class);
        List sessionList = new ArrayList();
        when(conferenceSessionRepository.getAllSessions()).thenReturn(sessionList);

        ModelAndView mv = new ConferenceSessionController(conferenceSessionRepository,mock(SessionAttendeeRepository.class)).displayAllSessionsOnOrganiser();
        assertThat(mv.getViewName(), Matchers.is("organiserHomepage"));
        assertThat(mv.getModelMap(), hasKey("sessions"));
        assertThat((List) mv.getModelMap().get("sessions"), Matchers.sameInstance(sessionList));
    }

    @Test
    public void shouldUpdateShowFlag() throws Exception {
        ConferenceSessionRepository conferenceSessionRepository = mock(ConferenceSessionRepository.class);
        String sessionId = "1";
        ConferenceSession expectedConferenceSession = new ConferenceSession(1);
        expectedConferenceSession.setShowFlag(0);

        ConferenceSessionController controller = new ConferenceSessionController(conferenceSessionRepository, mock(SessionAttendeeRepository.class));

        when(conferenceSessionRepository.updateShowFlag(sessionId)).thenReturn(expectedConferenceSession);
        assertThat(controller.updateShowFlag(sessionId), Matchers.is("0"));
    }
}
