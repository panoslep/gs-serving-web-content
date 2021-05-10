package com.example.servingwebcontent;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.soap.SAAJResult;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/panos")
	public String demo(@RequestParam(name = "name",  required=false, defaultValue="World") String name,
					   @RequestParam(name = "weather",  required=false, defaultValue="Sunny") String weather,
					   Model model) {
		model.addAttribute("name", name);
		model.addAttribute("weather", weather);
		String emotion = ":)";
		if (!weather.equalsIgnoreCase("Sunny")) {
			emotion = ":(";
		}
		model.addAttribute("emotion", emotion);
		return "greeting";
	}

	@GetMapping("/play")
	public String demo2(@RequestParam(name = "name",  required=false, defaultValue="One") String name,
					   @RequestParam(name = "weather",  required=false, defaultValue="Sunny") String weather,
					   Model model) {
		model.addAttribute("name", name);
		model.addAttribute("weather", weather);
		String emotion = ":)";
		if (!weather.equalsIgnoreCase("Sunny")) {
			emotion = ":(";
		}
		model.addAttribute("emotion", emotion);
		return "greeting";
	}

	@GetMapping("/party")
	public String party(@RequestParam(name="name", required=true, defaultValue="Ryan") String name, Model model) {
		model.addAttribute("name", name);
        String[] continents = {
                "Africa", "Antarctica", "Asia", "Australia",
                "Europe", "North America", "South America"
        };
        model.addAttribute("continents", continents);
		return "party";
	}


}
