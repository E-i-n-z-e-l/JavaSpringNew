package com.example.Practical_04_Task_01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/message")
    public String hello(Model model) {
        model.addAttribute("message", "Привет, мир!");
        return "hello";
    }
}
