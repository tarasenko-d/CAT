package com.example.cat.dto.request;

import com.example.cat.dto.EventDto;
import lombok.Data;

@Data
public class CreateEventRequest {
    private EventDto.EventInfo eventInfo;

}
