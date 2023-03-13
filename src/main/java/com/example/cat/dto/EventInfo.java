package com.example.cat.dto;

import com.example.cat.model.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventInfo {
    private Long id;
    private Long externalId;
    private String title;
    private LocalDateTime eventDate;
    private Double latitude;
    private Double longitude;
    private User creator;
    private List<User> members;
    private List<String> tags;
}
