package com.example.cat.dto.request;

import lombok.Data;

@Data
// TODO: user -> principal
public class UnfollowEventRequest {
    private Long eventId;
    private Long userId;
}
