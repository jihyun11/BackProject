package com.example.backproject.controller;

import com.example.backproject.dto.MemberDto;
import com.example.backproject.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MyinfoController {

    @Autowired
    private SignService signService;

    @GetMapping("/myinfo")
    public ModelAndView myinfo(HttpSession session) {
        MemberDto memberDto = (MemberDto) session.getAttribute("member");

        ModelAndView mav = new ModelAndView("myinfo");
        mav.addObject("member", memberDto);

        return mav;
    }

    @PostMapping("/myinfo")
    public String myinfoUp(HttpSession session) {
        System.out.println(session.toString());
        signService.myinfoUpdate((MemberDto) session);
        return "redirect:/myinfo";
    }


}
