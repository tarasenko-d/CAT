package com.example.cat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDtoOne {

    private long id;
    private String title;
    private LocalDateTime dateTime;
    private double latitude;
    private double longitude;
    private long creatorId;
    private String creatorName;
    private List<UserDto> members;
    private List<TagDto> tags;

}
