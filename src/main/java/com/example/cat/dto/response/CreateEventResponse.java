package com.example.cat.dto.response;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateEventResponse {
    private long id;
    private String title;
    private LocalDateTime dateTime;
    private double latitude;
    private double longitude;
    private List<String> tags;
}
