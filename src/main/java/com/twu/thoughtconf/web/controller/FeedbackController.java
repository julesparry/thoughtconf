package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.domain.Feedback;
import com.twu.thoughtconf.repositories.ConferenceSessionRepository;
import com.twu.thoughtconf.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/attendee/session/{sessionId}")
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private ConferenceSessionRepository conferenceSessionRepository;

    public void setFeedbackRepository(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void setConferenceSessionRepository(ConferenceSessionRepository conferenceSessionRepository) {
        this.conferenceSessionRepository = conferenceSessionRepository;
    }

   @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public ModelAndView newFeedback(@PathVariable("sessionId") Integer sessionId){
       return new ModelAndView("newFeedbackPage", "session", conferenceSessionRepository.getSessionById(sessionId));
   }

   @RequestMapping(value = "/feedback/create", method = RequestMethod.POST)
    public String saveFeedback(@RequestParam("sessionId") Integer sessionId,
                               @RequestParam("presenterRating")Integer presenterRating,
                               @RequestParam("contentRating") Integer contentRating,
                               @RequestParam("overallRating") Integer overallRating,
                               HttpServletRequest httpServletRequest) {
        Feedback feedback = new Feedback(sessionId,httpServletRequest.getRemoteUser(),presenterRating,contentRating,overallRating);
        Feedback savedFeedback = feedbackRepository.save(feedback);
        return  "redirect:confirmation/" + savedFeedback.getFeedbackId();
    }

    @RequestMapping(value = "/feedback/confirmation/{feedbackId}", method= RequestMethod.GET)
    public ModelAndView ConfirmFeedback(@PathVariable("feedbackId") int feedbackId) {
        return new ModelAndView("feedbackConfirmation", "feedback", feedbackRepository.getFeedbackByID(feedbackId));
    }
}
