package com.example.backproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FindController {

    @GetMapping("/findid")
    public ModelAndView findid() {
        ModelAndView mav = new ModelAndView("findid");
        return mav;
    }

    @GetMapping("/findpw")
    public ModelAndView findpw() {
        ModelAndView mav = new ModelAndView("findpw");
        return mav;
    }
}
