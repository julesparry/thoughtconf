package com.twu.thoughtconf.web.controller;


import com.twu.thoughtconf.domain.Feedback;
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
        assertThat(viewName, is("redirect:confirmation/" + FEEDBACK_ID));
    }
    
   @Test
   public void shouldReturnConfirmView() {
       FeedbackRepository feedbackRepository = mock(FeedbackRepository.class);
       Feedback expectFeedBack = mock(Feedback.class);
       when(feedbackRepository.getFeedbackByID(FEEDBACK_ID)).thenReturn(expectFeedBack);

       FeedbackController feedbackController = new FeedbackController();
       feedbackController.setFeedbackRepository(feedbackRepository);

       ModelAndView modelAndView = feedbackController.ConfirmFeedback(FEEDBACK_ID);

       Feedback actualFeedback = (Feedback) modelAndView.getModelMap().get("feedback");
       assertThat(modelAndView.getViewName(), is("feedbackConfirmation"));
       assertThat(actualFeedback, sameInstance(expectFeedBack));

   }

}