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


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam String conferenceSessionName) {
        ModelAndView mv = new ModelAndView();
        ConferenceSession newConferenceSession = new ConferenceSession(conferenceSessionName);
        repository.save(newConferenceSession);
        mv.setViewName("redirect:conference-session/display/" + newConferenceSession.getId());
        return mv;
    }
}
