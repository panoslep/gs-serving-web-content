package com.example.servingwebcontent;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Data;

@Data
public class CodingNomadsUser {

    public int id;
    public String first_name;
    public String last_name;
    public String email;
    public int createdAt;
    public int updatedAt;

}
