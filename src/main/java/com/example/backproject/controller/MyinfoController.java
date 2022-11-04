package com.example.backproject.controller;

import com.example.backproject.dto.MemberDto;
import com.example.backproject.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("/username")
    @ResponseBody
    public String myinfoUsername(Principal principal) {
        return principal.getName();
    }


}
