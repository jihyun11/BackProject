package com.example.backproject.controller;

import com.example.backproject.dto.MemberDto;
import com.example.backproject.service.SignService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class IndexController {
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
    @GetMapping("/myinfo")
    public ModelAndView myinfo() {
        ModelAndView mav = new ModelAndView("myinfo");
        return mav;
    }
}
