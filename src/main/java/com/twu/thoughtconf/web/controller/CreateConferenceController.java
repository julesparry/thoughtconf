package com.twu.thoughtconf.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateConferenceController {


        @RequestMapping("/create-conference")
        public String index(ModelMap modelMap) {

            return "createConference";
        }
}
