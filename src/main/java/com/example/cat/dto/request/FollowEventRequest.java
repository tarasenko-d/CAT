package com.example.cat.dto.request;

import lombok.Data;

@Data
public class FollowEventRequest {

    private Long eventId;
    private Long userId;
}
