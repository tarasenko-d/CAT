package com.example.cat.dto.request;

import lombok.Data;

@Data
public class UnfollowEventRequest {

    private Long eventId;
    private Long userId;

}
