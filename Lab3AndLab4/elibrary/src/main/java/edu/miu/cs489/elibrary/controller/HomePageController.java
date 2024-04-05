package edu.miu.cs489.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

    @RequestMapping(value = {"/", "/home/", "/elibrary"})
    public String homePage() {
        return "/home/index";
    }
}
