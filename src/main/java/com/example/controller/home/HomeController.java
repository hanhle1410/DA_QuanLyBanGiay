package com.example.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String viewLogin() {
        return "login/home";
    }
    @RequestMapping(value = "/layout",method = RequestMethod.GET)
    public String viewlayout() {
        return "login/layout";
    }
}
