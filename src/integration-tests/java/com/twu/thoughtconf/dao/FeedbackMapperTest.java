package com.twu.thoughtconf.dao;

import com.twu.thoughtconf.domain.Feedback;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"/mapper-context.xml"})
public class FeedbackMapperTest {
    @Autowired
    private FeedbackMapper feedbackMapper;

    protected final Integer sessionAttendeeId = 911;
//    private int presenterRating = 3;
//    private int contentRating = 5;
//    private int overallRating = 4;


//    @Before
//    public void removeAllTestEntriesBefore(){
//        feedbackMapper.cleanTable();
//    }
//
    @Test
    public void shouldReturnNullForSessionAttendeeId911(){
//        Feedback feedback = feedbackMapper.getFeedbackBySessionAttendeeId(sessionAttendeeId);
//        assertNull(feedback);
    }

//
//    @Test
//    public void shouldSaveFeedback(){
//        Feedback feedback = new Feedback(sessionAttendeeId,presenterRating, contentRating, overallRating);
//        feedbackMapper.save(feedback);
//
//
//        Feedback expectedFeedback = feedbackMapper.getFeedbackBySessionAttendeeId(sessionAttendeeId);
//
//        assertThat(expectedFeedback.getPresenterRating(), is(feedback.getPresenterRating()));
//        assertThat(expectedFeedback.getContentRating(), is(feedback.getContentRating()));
//        assertThat(expectedFeedback.getOverallRating(), is(feedback.getOverallRating()));
//
//        feedbackMapper.cleanTable();
//    }
//
//    @Test
//    public void shouldRemoveFeedbackBySessionAttendeeId(){
//        Feedback feedback = new Feedback(sessionAttendeeId,presenterRating, contentRating, overallRating);
//        feedbackMapper.save(feedback);
//        feedbackMapper.delete(feedback);
//        Feedback expectedFeedback = feedbackMapper.getFeedbackBySessionAttendeeId(sessionAttendeeId);
//        assertNull(expectedFeedback);
//
//    }
//
//    @Test
//    public void getFeebackBySessionAttendeeId(){
//
//    }

}
