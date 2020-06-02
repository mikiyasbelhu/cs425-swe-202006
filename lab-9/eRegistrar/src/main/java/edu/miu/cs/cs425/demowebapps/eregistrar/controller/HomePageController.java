package edu.miu.cs.cs425.demowebapps.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = {"/","/index","/home","/eregistrar/home"})
    public String displayHomePage() {
        return "home/index";
    }
}
