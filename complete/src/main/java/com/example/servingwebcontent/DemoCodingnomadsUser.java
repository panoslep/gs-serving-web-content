package com.example.servingwebcontent;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Data;

@Data
public class DemoCodingnomadsUser {
    // public JSONPObject data;
    public int id;
    public String first_name;
    public String last_name;
    public String email;
    public int createdAt;
    public int updatedAt;


}

//"data": {
//        "id": 3,
//        "first_name": "Caden6",
//        "last_name": "MacKenzie5",
//        "email": "caden@email.com",
//        "createdAt": 1549560964000,
//        "updatedAt": 1611257403000
//        },
//        "error": null,
//        "statusCode": 200