package com.example.cat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private long id;
    private String login;
    private String userPicture;
    private List<EventInfo> createdEvents;
    private List<TagDto> favouriteTags;
    private List<EventInfo> addedEvents;

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
