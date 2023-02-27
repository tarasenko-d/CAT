package com.example.cat.dto.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateEventRequest {
    private EventInfo eventInfo;


    @Data
    public static class EventInfo {
        private String title;
        private LocalDateTime dateTime;
        private double latitude;
        private double longitude;
        private long creatorId;
        private String creatorLogin;
        private List<String> members;
        private List<String> tags;
    }


}
