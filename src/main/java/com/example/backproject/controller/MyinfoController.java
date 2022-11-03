package com.example.backproject.controller;

import com.example.backproject.dto.MemberDto;
import com.example.backproject.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MyinfoController {

    @GetMapping("/myinfo")
    public ModelAndView myinfo() {
        ModelAndView mav = new ModelAndView("myinfo");
        return mav;
    }

    @GetMapping("/myinfo/username")
    public String myinfoUsername(@ModelAttribute MemberDto md, HttpServletRequest req) {

        System.out.println(md.getUsername() + md.getPassword());
        String memberDto = md.getUsername();
        System.out.println(memberDto);
        HttpSession session = req.getSession();
        return md.getUsername();
    }


}
