package com.example.servingwebcontent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CodingNomadsController {

    @Autowired
    RestTemplate restTemplate;

//    //get all users
//    @GetMapping("/users")
//    public CodingNomadsUser getCodingNomadsUsers() {
//        CodingNomadsUser allUsersResponse = restTemplate.getForObject("http://demo.codingnomads.co:8080/tasks_api/users", CodingNomadsUser.class);
//        return allUsersResponse;
//    }

    @GetMapping("/tasks")
    public CodingNomadsTask codingNomadsTask() {
        String url = "http://demo.codingnomads.co:8080/tasks_api/users/";
        CodingNomadsTask allTasksResponse = restTemplate.getForObject(url, CodingNomadsTask.class);
        return allTasksResponse;
    }

    @GetMapping("/users/{id}")
    public CodingNomadsUser getCodingNomadsUser(@PathVariable(name="id") int id) {
        String url =  "http://demo.codingnomads.co:8080/tasks_api/users/" + id;

        CodingNomadsUser usersResponse = restTemplate.getForObject(url, CodingNomadsUser.class);
        return usersResponse;
    }

    //this should be in task controller class
    @GetMapping("/tasks/{id}")
    public CodingNomadsUser getCodingNomadsTask(@PathVariable(name="id") int id) {
        String url =  "http://demo.codingnomads.co:8080/tasks_api/tasks/" + id;

        CodingNomadsUser tasksResponse = restTemplate.getForObject(url, CodingNomadsUser.class);
        return tasksResponse;
    }

    @PostMapping("/users")
    public CodingNomadsUser postCodingNomadsUser(@RequestBody CodingNomadsUser user) {
        String url =  "http://demo.codingnomads.co:8080/tasks_api/users/";
        //use getForEntity() to access the Location header instead of getForLocation()
        CodingNomadsResponse<CodingNomadsUser> postObject = restTemplate.postForObject(url, user, CodingNomadsResponse.class);

        //
        ObjectMapper mapper = new ObjectMapper();
        CodingNomadsUser myUser = mapper.convertValue(
                postObject.getData(),
                new TypeReference<CodingNomadsUser>(){}
        );

        return myUser;
    }

    @PostMapping("/tasks")
    public CodingNomadsTask postCodingnomadsTask(@RequestBody CodingNomadsTask task) {
        String url =  "http://demo.codingnomads.co:8080/tasks_api/tasks/";

        CodingNomadsResponse<CodingNomadsTask> postObject = restTemplate.postForObject(url, task, CodingNomadsResponse.class);

        //
        ObjectMapper mapper = new ObjectMapper();
        CodingNomadsTask myTask = mapper.convertValue(postObject.getData(),
                new TypeReference<CodingNomadsTask>(){}
        );

        return myTask;
    }
}

