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

    @GetMapping("/myinfo") // 세션의 username 값을 이용하여, 세션에서 모든 정보를 불러오는 것이 아닌 애초부터 db에서 정보를 빼내오도록 수정
    public ModelAndView myinfo(HttpSession session) {
        MemberDto memberDto = (MemberDto) session.getAttribute("member");
        MemberDto member = signService.getMember(memberDto.getUsername());

        ModelAndView mav = new ModelAndView("myinfo");
        mav.addObject("member", member);

        return mav;
    }

    @PostMapping("/myinfo")
    public String myinfoUp(@ModelAttribute MemberDto md) {
        signService.myinfoUpdate(md);
        return "redirect:/";
    }


}
