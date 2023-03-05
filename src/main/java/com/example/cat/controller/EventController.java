package com.example.cat.controller;


import com.example.cat.dto.IntegrationMessage;
import com.example.cat.dto.PaginationInfo;
import com.example.cat.dto.request.*;
import com.example.cat.model.Event;
import com.example.cat.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@SuppressWarnings("rawtypes")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping("/getFilterEvents")
    public IntegrationMessage getFilterEvents(@RequestBody IntegrationMessage<GetEventsFilterRequest> request) {
        try {
            Optional<PaginationInfo> paginationInfo = Optional.ofNullable(request)
                    .map(IntegrationMessage::getPayload)
                    .map(GetEventsFilterRequest::getPaginationInfo);

            if (paginationInfo.isEmpty()) {
                return IntegrationMessage.errorResponse("Не введена информация о пагинации", request);
            }

            List<Event> events = eventService.getEvents(paginationInfo.get());

            return IntegrationMessage.successResponse(events, request);
        } catch (Exception exception) {
            return IntegrationMessage.exceptionResponse(exception.getMessage(), request);
        }
    }

    @PostMapping("/getEventsById")
    public IntegrationMessage getEventsById(@RequestBody IntegrationMessage<GetEventByIdRequest> request) {
        try {
            Optional<Long> eventId = Optional.ofNullable(request)
                    .map(IntegrationMessage::getPayload)
                    .map(GetEventByIdRequest::getEventId);

            if (eventId.isEmpty()) {
                return IntegrationMessage.errorResponse("Событие не найдено", request);
            }

            Event event = eventService.getEventById(eventId.get());

            return IntegrationMessage.successResponse(event, request);
        } catch (Exception exception) {
            return IntegrationMessage.exceptionResponse(exception.getMessage(), request);
        }
    }

    @PostMapping("/events/creat")
    public IntegrationMessage createEvent(@RequestBody IntegrationMessage<CreateEventRequest> request) {
        try {
            Optional<CreateEventRequest.Info> data = Optional.ofNullable(request)
                    .map(IntegrationMessage::getPayload)
                    .map(CreateEventRequest::getData);

            if (data.isEmpty()) {
                return IntegrationMessage.errorResponse("Данные события не введены", request);
            }

            Event event = eventService.saveEvent(data.get());

            return IntegrationMessage.successResponse(event, request);
        } catch (Exception exception) {
            return IntegrationMessage.exceptionResponse(exception.getMessage(), request);
        }
    }

    @PostMapping("/deleteEvent")
    public IntegrationMessage deleteEvent(@RequestBody IntegrationMessage<DeleteEventByIdRequest> request) {
        try {
            Optional<Long> eventId = Optional.ofNullable(request)
                    .map(IntegrationMessage::getPayload)
                    .map(DeleteEventByIdRequest::getEventId);

            if (eventId.isEmpty()) {
                return IntegrationMessage.errorResponse("Событие не найдено", request);
            }

            eventService.deleteEvent(eventId.get());

            return IntegrationMessage.successResponse(eventId, request);
        } catch (Exception exception) {
            return IntegrationMessage.exceptionResponse(exception.getMessage(), request);
        }
    }

    @PostMapping("/editEvent")
    public IntegrationMessage editEvent(@RequestBody IntegrationMessage<EditEventRequest> request) {
        try {
            Optional<EditEventRequest.Info> eventInfo = Optional.ofNullable(request)
                    .map(IntegrationMessage::getPayload)
                    .map(EditEventRequest::getData);

            if (eventInfo.isEmpty()) {
                return IntegrationMessage.errorResponse("Данные события не введены", request);
            }

            Event editEvent = eventService.editEvent(eventInfo.get());

            return IntegrationMessage.successResponse(editEvent, request);
        } catch (Exception exception) {
            return IntegrationMessage.exceptionResponse(exception.getMessage(), request);
        }
    }
}
