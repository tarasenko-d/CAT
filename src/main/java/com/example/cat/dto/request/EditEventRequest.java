package com.example.cat.dto.request;

import com.example.cat.dto.EventDto;
import lombok.Data;

@Data
public class EditEventRequest {

    private EventDto.EventInfo eventInfo;

}
