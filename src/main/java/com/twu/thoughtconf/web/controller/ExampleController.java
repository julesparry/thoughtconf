package com.twu.thoughtconf.web.controller;

import com.twu.thoughtconf.services.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("something")
public class ExampleController {

    @Qualifier("exampleService")
    @Autowired
    private ExampleService exampleService;


    public void setExampleService(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    public ExampleController() {
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage( ) {
        return "viewName";
    }

    @RequestMapping(value = "/setup", method = RequestMethod.GET)
    public ModelAndView setup(@PathVariable("entityId") String entityId) {

        return new ModelAndView("viewName");
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public ModelAndView display(@PathVariable("entityId") String entityId) {

        ModelAndView mv = new ModelAndView("viewName");
        mv.addObject("thing", null);
        return mv;
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String process(@PathVariable("entityId") String entityId,
                          @ModelAttribute("conversation") ExampleConversation conversation) {
        return "viewName";
    }


}