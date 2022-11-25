package com.example.backproject.controller;

import com.example.backproject.dto.LetterDto;
import com.example.backproject.dto.MemberDto;
import com.example.backproject.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LetterController {
    @Autowired
    LetterService letterService;

    @PostMapping("/letter/send_letter")
    public ModelAndView sendLetter(@ModelAttribute LetterDto letterDto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        letterService.insertLetter(letterDto);
        return modelAndView;
    }

    @GetMapping("/letterlist")
    public ModelAndView letterlist() {
        ModelAndView mav = new ModelAndView("letterlist");
        return mav;
    }

    @PostMapping("/letter/receive_letter") // 세션의 username 값을 이용하여, 세션에서 모든 정보를 불러오는 것이 아닌 애초부터 db에서 정보를 빼내오도록 수정
    public ModelAndView receiveLetter(@ModelAttribute LetterDto letterDto) {
        ModelAndView mav = new ModelAndView("redirect:/letterlist");
        letterService.receiveLetter(letterDto);
        return mav;


    }

}
