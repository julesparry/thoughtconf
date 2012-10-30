package com.twu.thoughtconf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SessionController {

    @RequestMapping("/view-session")
    public ModelAndView display() {
        return new ModelAndView("viewSessionDetail");
    }
}
