package com.example.servingwebcontent.KanyeAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class KanyeController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/quote")
    public KanyeQuote getKanyeQuote(){
        //faking web browser request
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<KanyeQuote> response = restTemplate.exchange("https://api.kanye.rest", HttpMethod.GET,entity,KanyeQuote.class);

        //KanyeQuote quote = restTemplate.getForObject("https://api.kanye.rest", KanyeQuote.class);
        return response.getBody();
    }

}