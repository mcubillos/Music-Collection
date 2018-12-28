package com.example.music_collection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/elements")
    public String elements(Model model) {
        return "elements";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }
}
