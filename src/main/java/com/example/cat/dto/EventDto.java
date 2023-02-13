package com.example.cat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {


    private long id;
    private String title;
    private float latitude;
    private float longitude;
    private UserDto creator;
    private List<UserDto> members;
    private List<TagDto> tags;

}
