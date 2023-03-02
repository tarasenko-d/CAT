package com.example.cat.controller;


import com.example.cat.dto.EventDto;
import com.example.cat.dto.IntegrationMessage;
import com.example.cat.dto.request.*;
import com.example.cat.mapper.EventMapper;
import com.example.cat.model.Event;
import com.example.cat.service.EventService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
public class EventController {

    private EventService eventService;
    private EventMapper eventMapper;

    public EventController(EventService eventService, EventMapper eventMapper) {
        this.eventService = eventService;
        this.eventMapper = eventMapper;
    }

    @PostMapping("/rest/events")
    public IntegrationMessage getEventList(@RequestBody IntegrationMessage<GetEventsFilterRequest> filterMessage) {
        try {
            PaginationInfo paginationInfo = Optional.ofNullable(filterMessage)
                    .map(IntegrationMessage::getData)
                    .map(GetEventsFilterRequest::getPaginationInfo)
                    .orElse(null);

            if (isNull(paginationInfo)) {
                return IntegrationMessage.errorResponse("Не введена информация о пагинации");
            }

            List<Event> events = eventService.getEvents(paginationInfo);

            return IntegrationMessage.successGetResponse(events);
        } catch (Exception exception) {
            return IntegrationMessage.exceptionResponse(exception.getMessage());
        }
    }

    @PostMapping("/rest/events/eventById")
    public IntegrationMessage getEvent(@RequestBody IntegrationMessage<GetEventByIdRequest> getMessage) {
        try {
            Long eventId = Optional.ofNullable(getMessage)
                    .map(IntegrationMessage::getData)
                    .map(GetEventByIdRequest::getEventId)
                    .orElse(null);

            if (isNull(eventId)) {
                return IntegrationMessage.errorResponse("Событие не найдено");
            }

            Event event = eventService.getEventById(eventId);

            return IntegrationMessage.successGetResponse(event);
        } catch (Exception exception) {
            return IntegrationMessage.exceptionResponse(exception.getMessage());
        }
    }

    @PostMapping("/rest/events/newEvent")
    public IntegrationMessage createEvent(@RequestBody IntegrationMessage<CreateEventRequest> createMessage) {
        try {
            EventDto.EventInfo eventInfo = Optional.ofNullable(createMessage)
                    .map(IntegrationMessage::getData)
                    .map(CreateEventRequest::getEventInfo)
                    .orElse(null);

            if (isNull(eventInfo)) {
                return IntegrationMessage.errorResponse("Данные события не введены");
            }

            Event event = eventService.saveEvent(eventInfo);

            return IntegrationMessage.successGetResponse(event);
        } catch (Exception exception) {
            return IntegrationMessage.exceptionResponse(exception.getMessage());
        }
    }

    @PostMapping("/rest/events/deleteEvent")
    public IntegrationMessage deleteEvent(@RequestBody IntegrationMessage<DeleteEventByIdRequest> deleteMessage) {
        try {
            Long eventId = Optional.ofNullable(deleteMessage)
                    .map(IntegrationMessage::getData)
                    .map(DeleteEventByIdRequest::getEventId)
                    .orElse(null);

            if (isNull(eventId)) {
                return IntegrationMessage.errorResponse("Событие не найдено");
            }

            eventService.deleteEvent(eventId);

            return IntegrationMessage.successDeleteResponse(eventId);
        } catch (Exception exception) {
            return IntegrationMessage.exceptionResponse(exception.getMessage());
        }
    }


    @PostMapping("/rest/events/editEvent")
    public IntegrationMessage editEvent(@RequestBody IntegrationMessage<EditEventRequest> editMessage) {
        try {
            EventDto.EventInfo eventInfo = Optional.ofNullable(editMessage)
                    .map(IntegrationMessage::getData)
                    .map(EditEventRequest::getEventInfo)
                    .orElse(null);

            if (isNull(eventInfo)) {
                return IntegrationMessage.errorResponse("Данные события не введены");
            }

            Event editEvent = eventService.editEvent(eventInfo);

            return IntegrationMessage.successEditResponse(editEvent);
        } catch (Exception exception) {
            return IntegrationMessage.exceptionResponse(exception.getMessage());
        }
    }

}
