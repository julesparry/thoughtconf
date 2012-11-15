package com.twu.thoughtconf.web.controller;


import com.twu.thoughtconf.domain.ConferenceSession;
import com.twu.thoughtconf.domain.Feedback;
import com.twu.thoughtconf.repositories.ConferenceSessionRepository;
import com.twu.thoughtconf.repositories.FeedbackRepository;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FeedbackControllerTest {

    public static final int FEEDBACK_ID = 12;
    public static final int SESSION_ID = 1;
    public static final int PRESENTER_RATING = 3;
    public static final int CONTENT_RATING = 4;
    public static final int OVERALL_RATING = 5;
    public static final String USER = "kaly";

    @Test
    public void shouldReturnViewToShowFeedbackPage() {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRemoteUser()).thenReturn(USER);

        Feedback feedback = mock(Feedback.class);
        when(feedback.getFeedbackId()).thenReturn(FEEDBACK_ID);

        FeedbackRepository feedbackRepository = mock(FeedbackRepository.class);
        when(feedbackRepository.save(any(Feedback.class))).thenReturn(feedback);

        FeedbackController feedbackController = new FeedbackController();
        feedbackController.setFeedbackRepository(feedbackRepository);

        String viewName = feedbackController.saveFeedback(SESSION_ID, PRESENTER_RATING, CONTENT_RATING, OVERALL_RATING, httpServletRequest);

        verify(feedbackRepository).save(new Feedback(SESSION_ID, USER, PRESENTER_RATING, CONTENT_RATING, OVERALL_RATING));
        assertThat(viewName, is("confirmation/" + FEEDBACK_ID));
    }
    
   @Test
   public void shouldReturnConfirmView() {
       Feedback expectFeedBack = mock(Feedback.class);
       FeedbackRepository feedbackRepository = mock(FeedbackRepository.class);
       when(feedbackRepository.getFeedbackByID(FEEDBACK_ID)).thenReturn(expectFeedBack);

       ConferenceSession expectSession = mock(ConferenceSession.class);
       ConferenceSessionRepository sessionRepository = mock(ConferenceSessionRepository.class);
       when(sessionRepository.getSessionById(SESSION_ID)).thenReturn(expectSession);


       FeedbackController feedbackController = new FeedbackController();
       feedbackController.setFeedbackRepository(feedbackRepository);
       feedbackController.setConferenceSessionRepository(sessionRepository);

       ModelAndView modelAndView = feedbackController.ConfirmFeedback(SESSION_ID,FEEDBACK_ID);

       Feedback actualFeedback = (Feedback) modelAndView.getModelMap().get("feedback");
       assertThat(modelAndView.getViewName(), is("feedbackConfirmation"));
       assertThat(actualFeedback, sameInstance(expectFeedBack));

       ConferenceSession actualSession = (ConferenceSession) modelAndView.getModelMap().get("session");
       assertThat(actualSession, sameInstance(expectSession));

   }

    @Test
    public void shouldReturnFeedbackViewForASession() {
        ConferenceSession conferenceSession = mock(ConferenceSession.class);
        ConferenceSessionRepository conferenceSessionRepository = mock(ConferenceSessionRepository.class);
        when(conferenceSessionRepository.getSessionById(SESSION_ID)).thenReturn(conferenceSession);

        FeedbackController feedbackController = new FeedbackController();
        feedbackController.setConferenceSessionRepository(conferenceSessionRepository);

        ModelAndView modelAndView = feedbackController.newFeedback(SESSION_ID);

        ConferenceSession actualConferenceSession = (ConferenceSession) modelAndView.getModelMap().get("session");
        assertThat(modelAndView.getViewName(), is("newFeedbackPage"));
        assertThat(actualConferenceSession, sameInstance(conferenceSession));
    }
}
