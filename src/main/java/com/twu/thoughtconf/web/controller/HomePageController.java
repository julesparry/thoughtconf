package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.services.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
    
    @Autowired
    private AttendeeService attendeeService;

    @RequestMapping("/home")
    public String index(ModelMap modelMap) {
        String name = "lee";
        modelMap.put("name",name);
        return "homepage";
    }

}
