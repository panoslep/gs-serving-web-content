package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroController {

    @Autowired
    IntroService introService;

    @RequestMapping("/intro")
    public String CoffeeLovers(Model model){
        model.addAttribute("news", coffeeService.getRandomHeadline());
        model.addAttribute("people", coffeeService.getPeople());
        model.addAttribute("image_ppl", coffeeService.getImageUrl());
        return "intro";
    }
}


