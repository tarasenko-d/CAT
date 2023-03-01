package com.example.cat.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventDto {

    @Data
    public static class EventInfo {
        private long id;
        private String title;
        private LocalDateTime dateTime;
        private double latitude;
        private double longitude;
        private long creatorId;
        private String creatorName;
        private List<String> members;
        private List<String> tags;

    }
}
