package com.fastfood.web;

import com.fastfood.Repository.InMemoryDB;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private final InMemoryDB inMemoryDB;

    public HomeController(InMemoryDB inMemoryDB) {
        this.inMemoryDB = inMemoryDB;
    }

    private String homePage() {
        return "index";
    }

    @GetMapping("/contact-us")
    private String contactPage() {
        return "contact";
    }

    @RequestMapping("/populate-db")
    private String populateDB() {
        inMemoryDB.populateDB();
        return "redirect:/";
    }

    @RequestMapping("/delete-db")
    private String deleteDB() {
        inMemoryDB.deleteDB();
        return "redirect:/";
    }
}
