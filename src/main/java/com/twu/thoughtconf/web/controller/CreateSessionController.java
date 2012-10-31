package com.twu.thoughtconf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateSessionController {

    @RequestMapping("/create-session")
    public String index(ModelMap modelMap) {

        return "createSession";
    }

}
