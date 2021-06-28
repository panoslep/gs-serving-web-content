package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class DemoCodingnomadsController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/users/3")
    public DemoCodingnomadsUsers getCodinomadsUser() {
        DemoCodingnomadsUsers user = restTemplate.getForObject("http://demo.codingnomads.co:8080/tasks_api/users/3", DemoCodingnomadsUsers, Object);
        //return user;

        //faking web browser request
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        //ResponseEntity<String> response = restTemplate.exchange("http://demo.codingnomads.co:8080/tasks_api/users/3",
        //        HttpMethod.GET,entity,DemoCodingnomadsUsers.class);
        ResponseEntity<String> response = restTemplate.getForEntity("http://demo.codingnomads.co:8080/tasks_api/users/3", String.class);

        return response.getBody();
    }
}


