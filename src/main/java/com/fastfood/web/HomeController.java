package com.fastfood.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    private String homePage(){
        return "index";
    }

    @GetMapping("/contact-us")
    private String contactPage(){
        return "contact";
    }
}
