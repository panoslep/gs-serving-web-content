package com.example.servingwebcontent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoCodingnomadsController {

    @Autowired
    RestTemplate restTemplate;

    //get user 3
    @GetMapping("/users/3")
    public DemoCodingnomadsUser getCodinomadsUser3() {
        DemoCodingnomadsUser user3Response = restTemplate.getForObject("http://demo.codingnomads.co:8080/tasks_api/users/3", DemoCodingnomadsUser.class);
        return user3Response;
    }

//    // get all users
//   @GetMapping("/users")
//    public DemoCodingnomadsUsers getCodinomadsUser() {
//        DemoCodingnomadsUsers usersResponse = restTemplate.getForObject("http://demo.codingnomads.co:8080/tasks_api/users", DemoCodingnomadsUsers.class);
//        return usersResponse;
//    }



    @GetMapping("/users/{id}")
    public DemoCodingnomadsUser getCodinomadsUser(@PathVariable(name="id") int id) { //no model involved
        String url =  "http://demo.codingnomads.co:8080/tasks_api/users/" + id;

        DemoCodingnomadsUser usersResponse = restTemplate.getForObject(url, DemoCodingnomadsUser.class);
        return usersResponse;
    }

    //this should be in task controller class
    @GetMapping("/tasks/{id}")
    public DemoCodingnomadsUser getCodinomadsTask(@PathVariable(name="id") int id) { //no model involved
        String url =  "http://demo.codingnomads.co:8080/tasks_api/tasks/" + id;

        DemoCodingnomadsUser tasksResponse = restTemplate.getForObject(url, DemoCodingnomadsUser.class);
        return tasksResponse;
    }

    @PostMapping("/users")
    public DemoCodingnomadsUser postCodingnomadsUser(@RequestBody DemoCodingnomadsUser user) {
        String url =  "http://demo.codingnomads.co:8080/tasks_api/users/";
        //use getForEntity() to access the Location header instead of getForLocation()
        CodingnomadsResponse<DemoCodingnomadsUser> postObject = restTemplate.postForObject(url, user, CodingnomadsResponse.class);

        //
        ObjectMapper mapper = new ObjectMapper();
        DemoCodingnomadsUser myUser = mapper.convertValue(
                postObject.getData(),
                new TypeReference<DemoCodingnomadsUser>(){}
        );

        return myUser;
    }
}

