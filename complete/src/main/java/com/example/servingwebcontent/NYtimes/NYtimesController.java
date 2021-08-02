package com.example.servingwebcontent.NYtimes;

import com.example.servingwebcontent.CodingNomadsResponse;
import com.example.servingwebcontent.CodingNomadsUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
public class NYtimesController {

        @Autowired
        RestTemplate restTemplate;

        @GetMapping("/nyTimes")
        public NYtimesResponse searchNYtimesAPI(@RequestParam(name = "query", required = false, defaultValue = "Miami") String query, Model model){
            model.addAttribute("query", query);
            String url = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=" + query +"&api-key=Y4FXGPerVU07dTdIkFGZ65C72K2KAJHh";
            NYtimesResponse responseNYtimes = restTemplate.getForObject(url, NYtimesResponse.class);
            return responseNYtimes;
        }

}



