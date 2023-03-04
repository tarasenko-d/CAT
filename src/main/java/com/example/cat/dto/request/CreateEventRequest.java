package com.example.cat.dto.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateEventRequest {
    private Info data;

    @Data
    public static class Info {
        private String title;
        private LocalDateTime dateTime;
        private double latitude;
        private double longitude;
        private long creatorId;
        private List<String> tags;
    }
}
