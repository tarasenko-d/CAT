package com.example.cat.dto.response;


import com.example.cat.dto.EventDto;
import lombok.Data;

@Data
public class CreateEventResponse {

private EventDto.EventInfo eventInfo;
}
