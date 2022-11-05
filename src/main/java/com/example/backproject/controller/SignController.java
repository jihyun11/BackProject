package com.example.backproject.controller;

import com.example.backproject.dto.MemberDto;
import com.example.backproject.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class SignController {

    @Autowired
    private SignService signService;

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

    @PostMapping("/signup")
    public String signupPost(@ModelAttribute MemberDto md) {
        System.out.println(md.toString());
        signService.signup(md);
        return "redirect:/signin";
    }

    @PostMapping("/signin")
    public String signinPost(@ModelAttribute MemberDto md, HttpServletRequest req) {
        System.out.println(md.getUsername() + md.getPassword());
        MemberDto memberDto = signService.signin(md);
        System.out.println(memberDto);
        HttpSession session = req.getSession();
        if (memberDto != null) {
            session.setAttribute("member", memberDto);
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.invalidate();
        return "redirect:/";
    }
}


