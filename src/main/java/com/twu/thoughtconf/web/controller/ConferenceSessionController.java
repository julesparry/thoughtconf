package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.domain.ConferenceSession;
import com.twu.thoughtconf.repositories.ConferenceSessionRepository;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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

    @RequestMapping(value = "/display/castest", method = RequestMethod.GET)
    public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView modelAndView = new ModelAndView("homepage");
        System.out.println("***----------User is still:" + request.getUserPrincipal() + "------------*****");
        modelAndView.addObject("username", request.getRemoteUser());
        System.out.println("request.getRemoteUser() returns ---->" + request.getRemoteUser());

        return modelAndView;
    }



    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newConferenceSession() {
        ModelAndView mv = new ModelAndView("newConferenceSession");
        mv.getModelMap().put("formAction", "/app/conference-session/create");
        return mv;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam("name") String name, @RequestParam("location") String location,@RequestParam("date") String date,@RequestParam("time") String time, @RequestParam("abstract") String sessionAbstract, @RequestParam("presenterName") String presenterName, @RequestParam("aboutPresenter") String aboutPresenter) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("YYYY-MM-DD HH:mm");
        String[] timeStrs = time.split("-");
        String startTimeString = timeStrs[0];
        String endTimeString = timeStrs[1];
        String startDateTimeString = date + " " + startTimeString;
        String endDateTimeString = date + " " + endTimeString;
        DateTime startTime = dateTimeFormatter.parseDateTime(startDateTimeString);
        DateTime endTime = dateTimeFormatter.parseDateTime(endDateTimeString);
        ConferenceSession conferenceSession = new ConferenceSession(name, location, startTime, endTime, sessionAbstract, presenterName, aboutPresenter);
        ConferenceSession conferenceSessionWithId = repository.save(conferenceSession);
        return "redirect:confirmation/" + conferenceSessionWithId.getId();
    }

    @RequestMapping(value = "/confirmation/{sessionId}", method= RequestMethod.GET)
    public ModelAndView confirm(@PathVariable("sessionId") int sessionId) {
        return new ModelAndView("sessionConfirmation", "session", repository.get(sessionId));
    }
}
