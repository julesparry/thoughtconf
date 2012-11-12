package com.twu.thoughtconf.repositories;

import com.twu.thoughtconf.dao.FeedbackMapper;
import com.twu.thoughtconf.domain.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FeedbackRepository {
    @Autowired
    private FeedbackMapper feedbackMapper;

    public void setMapper(FeedbackMapper feedbackMapper) {
        this.feedbackMapper = feedbackMapper;
    }

    public void save(Feedback feedback) {
        feedbackMapper.save(feedback);
    }
}
