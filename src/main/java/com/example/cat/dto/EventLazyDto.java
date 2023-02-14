package com.example.cat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

////TODO ADD FIELD WITH MEMBER COUNT

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventLazyDto {

    private long id;
    private String title;
    private float latitude;
    private float longitude;
    private UserDto creator;
    ////TODO MEMBERS OR MEMBERS COUNT
    private List<TagDto> tags;

}
