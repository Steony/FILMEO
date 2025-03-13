package fr.doranco.filmeo_back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("base");
        mav.addObject("content", "home/index");
        return mav;
    }
}
