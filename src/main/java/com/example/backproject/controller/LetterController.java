package com.example.backproject.controller;

import com.example.backproject.dto.LetterDto;
import com.example.backproject.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
