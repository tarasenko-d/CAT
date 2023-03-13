package com.example.cat.dto.response;

import com.example.cat.dto.EventDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetEventByIdResponse {
    private EventDto data;
}
