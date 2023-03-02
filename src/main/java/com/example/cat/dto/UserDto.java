package com.example.cat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private long id;
    private String login;
    private String password;
    private String userPicture;
    private List<EventDto.EventInfo> createdEvents;
    private List<TagDto> favouriteTags;
    private List<EventDto.EventInfo> addedEvents;

}
