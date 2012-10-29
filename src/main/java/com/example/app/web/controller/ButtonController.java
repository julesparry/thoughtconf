package com.example.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ButtonController{

    @RequestMapping("/going-button")
    public String index(ModelMap modelMap) {
        return "goingButton";
    }
}
