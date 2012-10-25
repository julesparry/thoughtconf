package com.example.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.app.services.FooService;

@Controller
public class HomePageController {
    
    @Autowired
    private FooService fooService ;

    @RequestMapping("/home")
    public String index(ModelMap modelMap) {
        String name = "lee";
        modelMap.put("name",name);
        return "homepage";
    }

}
