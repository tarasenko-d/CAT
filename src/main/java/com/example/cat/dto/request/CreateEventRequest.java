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
        private LocalDateTime eventDate;
        private Double latitude;
        private Double longitude;
        private List<String> tags;
    }
}
