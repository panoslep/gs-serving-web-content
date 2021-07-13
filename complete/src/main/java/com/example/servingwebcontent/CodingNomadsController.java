package com.example.servingwebcontent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
public class CodingNomadsController {

    @Autowired
    RestTemplate restTemplate;

//    //get all users
    @GetMapping("/users")
    public ArrayList<CodingNomadsUser> getCodingNomadsUsers() {
        CodingNomadsResponse<ArrayList<CodingNomadsUser>> allUsersResponse = restTemplate.getForObject("http://demo.codingnomads.co:8080/tasks_api/users", CodingNomadsResponse.class);
        return allUsersResponse.data;
    }

    @GetMapping("/users/{id}")
    public CodingNomadsUser getCodingNomadsUser(@PathVariable(name="id") int id) {
        String url =  "http://demo.codingnomads.co:8080/tasks_api/users/" + id;

        CodingNomadsResponse<CodingNomadsUser> usersResponse = restTemplate.getForObject(url, CodingNomadsResponse.class);

        // Because the coingnomadsresponse is generic we need to force the data mapping
        ObjectMapper mapper = new ObjectMapper();
        CodingNomadsUser pojo = mapper.convertValue(usersResponse.data, CodingNomadsUser.class);

        // or:
       // List<POJO> pojos = mapper.convertValue(listOfObjects, new TypeReference<List<POJO>>() { });

        return pojo;
    }






//    @GetMapping("/tasks")
//    public CodingNomadsTask codingNomadsTask() {
//        String url = "http://demo.codingnomads.co:8080/tasks_api/users/";
//        CodingNomadsTask allTasksResponse = restTemplate.getForObject(url, CodingNomadsTask.class);
//        return allTasksResponse;
//    }






    //this should be in task controller class
    @GetMapping("/tasks/{id}")
    public CodingNomadsTask getCodingNomadsTask(@PathVariable(name="id") int id) {
        String url =  "http://demo.codingnomads.co:8080/tasks_api/tasks/" + id;

        CodingNomadsTask taskResponse = restTemplate.getForObject(url, CodingNomadsTask.class);
        return taskResponse;
    }



    @PostMapping("/users")
    public CodingNomadsUser postCodingNomadsUser(@RequestBody CodingNomadsUser user) {
        String url =  "http://demo.codingnomads.co:8080/tasks_api/users/";
        //use getForEntity() to access the Location header instead of getForLocation()
        CodingNomadsResponse<CodingNomadsUser> postObject = restTemplate.postForObject(url, user, CodingNomadsResponse.class);


        ObjectMapper mapper = new ObjectMapper();
        CodingNomadsUser myUser = mapper.convertValue(
                postObject.getData(),
                new TypeReference<CodingNomadsUser>(){}
        );

        return myUser;
    }

    @PostMapping("/tasks")
    public CodingNomadsTask postCodingNomadsTask(@RequestBody CodingNomadsTask task) {
        String url =  "http://demo.codingnomads.co:8080/tasks_api/tasks/";

        CodingNomadsResponse<CodingNomadsTask> postObject = restTemplate.postForObject(url, task, CodingNomadsResponse.class);

        ObjectMapper mapper = new ObjectMapper();
        CodingNomadsTask myTask = mapper.convertValue(postObject.getData(),
                new TypeReference<CodingNomadsTask>(){}
        );

        return myTask;
    }

    @DeleteMapping("/users/{id}")
    public void deleteCodingNomadsUser(@PathVariable(name="id") int id) {
        String url = "http://demo.codingnomads.co:8080/tasks_api/users/" + id;

        restTemplate.delete(url, CodingNomadsUser.class);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteCodingNomadsTask(@PathVariable(name="id") int id) {
        String url = "http://demo.codingnomads.co:8080/tasks_api/tasks/" + id;

        restTemplate.delete(url, CodingNomadsTask.class);
    }

}

