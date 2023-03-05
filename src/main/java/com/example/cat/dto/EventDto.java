package com.example.cat.dto;

import com.example.cat.model.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventDto {
    private EventInfo eventInfo;

    @Data
    public static class EventInfo {
        private long id;
        private String title;
        private LocalDateTime eventDate;
        private double latitude;
        private double longitude;
        private User creator;
        private List<User> members;
        private List<String> tags;
    }
}
