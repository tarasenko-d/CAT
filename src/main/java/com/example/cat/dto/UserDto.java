package com.example.cat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long externalId;
    private String login;
    private String userPicture;
    private List<EventDto> createdEvents;
    private List<TagDto> favouriteTags;
    private List<EventDto> addedEvents;

}
