package com.example.cat.controller;

import com.example.cat.dto.IntegrationMessage;
import com.example.cat.dto.request.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/api")
@SuppressWarnings("rawtypes")
@RequiredArgsConstructor
public class CrutchController {
    private final EventController eventController;
    private final UserController userController;

    @PostMapping("/events/filter")
    public IntegrationMessage getEventList(@RequestBody IntegrationMessage<GetEventsFilterRequest> request) {
        return eventController.getFilterEvents(request);
    }

    @PostMapping("/events/id")
    public IntegrationMessage getEvent(@RequestBody IntegrationMessage<GetEventByIdRequest> request) {
        return eventController.getEventsById(request);
    }

    @PostMapping("/events/create")
    public IntegrationMessage createEvent(@RequestBody IntegrationMessage<CreateEventRequest> request) {
        return eventController.createEvent(request);
    }

    @PostMapping("/events/delete")
    public IntegrationMessage deleteEvent(@RequestBody IntegrationMessage<DeleteEventByIdRequest> request) {
        return eventController.deleteEvent(request);
    }

    @PostMapping("/events/edit")
    public IntegrationMessage editEvent(@RequestBody IntegrationMessage<EditEventRequest> request) {
        return eventController.editEvent(request);
    }

    @PostMapping("/users/id")
    public IntegrationMessage getUserById(@RequestBody IntegrationMessage<GetUserByIdRequest> request) {
        return userController.getUserById(request);
    }
}