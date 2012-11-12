package com.twu.thoughtconf.dao;

import com.twu.thoughtconf.domain.Feedback;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"/mapper-context.xml"})
public class FeedbackMapperTest {
    @Autowired
    private FeedbackMapper feedbackMapper;

    private int sessionId = 11;
    private String attendeeEmail = "Kaly";
    private int presenterRating = 3;
    private int contentRating = 5;
    private int overallRating = 4;


    @Before
    @After
    public void removeAllTestEntriesBefore(){
        feedbackMapper.cleanTable();
    }

    @Test
    public void shouldSaveFeedback(){
        Feedback feedback = new Feedback(sessionId, attendeeEmail, presenterRating, contentRating, overallRating);
        feedbackMapper.save(feedback);

        Feedback expectedFeedback = feedbackMapper.getFeedbackById(feedback.getFeedbackId());

        assertThat(expectedFeedback.getSessionId(), is(feedback.getSessionId()));
        assertThat(expectedFeedback.getAttendeeEmail(), is(feedback.getAttendeeEmail()));
        assertThat(expectedFeedback.getPresenterRating(), is(feedback.getPresenterRating()));
        assertThat(expectedFeedback.getContentRating(), is(feedback.getContentRating()));
        assertThat(expectedFeedback.getOverallRating(), is(feedback.getOverallRating()));
    }

}
