package com.example.backproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignController {

    @GetMapping("/signin")
    public ModelAndView signin() {
        ModelAndView mav = new ModelAndView("signin1");
        return mav;
    }

    @GetMapping("/signup")
    public ModelAndView signup() {
        ModelAndView mav = new ModelAndView("signup");
        return mav;
    }
}
