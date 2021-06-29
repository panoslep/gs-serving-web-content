package com.example.servingwebcontent;

import lombok.Data;

@Data
public class CodingnomadsResponse<T> {
    public T data;
    public String error;
    public int status;
}
