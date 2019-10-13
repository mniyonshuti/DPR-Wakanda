package edu.mum.cs.cs425.dprwakanda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home", "/wakandadpr/home"})
    public String getHomePage(){
        return "home/index";
    }
}
