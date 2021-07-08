package com.example.servingwebcontent;

import lombok.Data;

@Data
public class CodingNomadsTask {
    public int id;
    public int userId;
    public String name;
    public String description;
    public int createdAt;
    public int updatedAt;
    public boolean completed;
}


