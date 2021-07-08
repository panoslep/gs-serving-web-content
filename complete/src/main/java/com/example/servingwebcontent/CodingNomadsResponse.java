package com.example.servingwebcontent;

import lombok.Data;

@Data
public class CodingNomadsResponse<T> {
    public T data;
    public String error;
    public int status;
}
