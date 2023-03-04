package com.example.cat.dto.request;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EditEventRequest {
    private Info data;

    @Data
    public static class Info {
        private long id;
        private String title;
        private LocalDateTime eventDate;
        private double latitude;
        private double longitude;
        private List<String> members;
        private List<String> tags;
    }
}
