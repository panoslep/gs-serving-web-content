package com.example.servingwebcontent.NYtimes;
import lombok.Data;

import java.util.ArrayList;

@Data
public class NYtimesResponse {

    public String status;
    public String copyright;
    public Response response;

}
