package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.domain.ConferenceSession;
import com.twu.thoughtconf.repositories.ConferenceSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


// Responsible for creating and displaying conference sessions
@Controller
@RequestMapping("conference-session")
public class ConferenceSessionController {

    @Autowired
    private ConferenceSessionRepository repository;


    public ConferenceSessionController() {
    }

    public ConferenceSessionController(ConferenceSessionRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/display/{sessionId}", method = RequestMethod.GET)
    public ModelAndView display(@PathVariable("sessionId") String sessionId) {
        ModelAndView mv = new ModelAndView("viewConferenceSession");
        ModelMap map = mv.getModelMap();
        map.put("session", repository.findById(sessionId));
        return mv;
    }


    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newConferenceSession() {
        ModelAndView mv = new ModelAndView("newConferenceSession");
        mv.getModelMap().put("formAction", "/app/conference-session/create");
        return mv;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam(value = "conferenceSessionName") String conferenceSessionName) {
        ConferenceSession conferenceSession = new ConferenceSession(conferenceSessionName);
        ConferenceSession conferenceSessionWithId = repository.save(conferenceSession);
        return "redirect:confirmation/" + conferenceSessionWithId.getId();
    }
}
