package com.example.servingwebcontent.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IntroController {

    @Autowired
    IntroService introService;

    @RequestMapping("/intro")
    public String introPage(@RequestParam(value="value", required = true, defaultValue = "1") String value,
                            @RequestParam(name = "day",  required= true, defaultValue = "null") String day,
                            Model model){
        model.addAttribute("value", value);
        int index = Integer.parseInt(value);

        model.addAttribute("day", introService.getDay());
        model.addAttribute("greeting", introService.getHeadlineGreeting());
        model.addAttribute("hour", introService.getHour());
        model.addAttribute("minute", introService.getMinute());
        model.addAttribute("title", introService.getTitle(index));
        model.addAttribute("story", introService.getStory(index));
        model.addAttribute("time", introService.getTimeString());
        model.addAttribute("stories", introService.getStories());

        return "introPage";
    }
}


