package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.domain.ConferenceSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConferenceSessionController {

    @RequestMapping("/view-session")
    public ModelAndView display(String sessionId) {
        ModelAndView mv = new ModelAndView("viewSessionDetail");
        ModelMap map = mv.getModelMap();
        map.put("session", new ConferenceSession("name"));
        return mv;
    }
}
