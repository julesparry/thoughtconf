package com.twu.thoughtconf.repositories;

import com.twu.thoughtconf.dao.FeedbackMapper;
import com.twu.thoughtconf.domain.Feedback;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FeedbackRepositoryTest {

    @Test
    public void shouldSaveFeedBack() {

        FeedbackMapper feedbackMapper = mock(FeedbackMapper.class);
        Feedback feedback = mock(Feedback.class);

        FeedbackRepository feedbackRepository = new FeedbackRepository();
        feedbackRepository.setMapper(feedbackMapper);

        feedbackRepository.save(feedback);

        verify(feedbackMapper).save(feedback);
    }

    @Test
    public void shouldGetFeedbackByID() {
        Feedback expectedFeedback = mock(Feedback.class);
        FeedbackMapper feedbackMapper = mock(FeedbackMapper.class);
        when(feedbackMapper.getFeedbackById(1)).thenReturn(expectedFeedback);

        FeedbackRepository feedbackRepository = new FeedbackRepository();
        feedbackRepository.setMapper(feedbackMapper);

        Feedback feedback = feedbackRepository.getFeedbackByID(1);

        verify(feedbackMapper).getFeedbackById(1);
        assertThat(feedback, sameInstance(expectedFeedback));
    }


}
