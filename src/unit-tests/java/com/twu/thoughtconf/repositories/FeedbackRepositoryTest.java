package com.twu.thoughtconf.repositories;

import com.twu.thoughtconf.dao.FeedbackMapper;
import com.twu.thoughtconf.domain.Feedback;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FeedbackRepositoryTest {
    
    @Test
    public void shouldSaveFeedBack() {
        
        FeedbackMapper  feedbackMapper = mock(FeedbackMapper.class);
        Feedback feedback = mock(Feedback.class);
        FeedbackRepository feedbackRepository = new FeedbackRepository();
        feedbackRepository.setMapper(feedbackMapper);

        feedbackRepository.save(feedback);

        verify(feedbackMapper).save(feedback);
    }
}
