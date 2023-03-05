package com.example.cat.dto.request;

import lombok.Data;

@Data
// TODO: user -> principal
public class FollowEventRequest {
    private Long eventId;
    private Long userId;
}
