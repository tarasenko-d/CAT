package com.example.cat.controller;


import com.example.cat.dto.EventDtoOne;
import com.example.cat.dto.EventDto;
import com.example.cat.dto.IntegrationMessage;
import com.example.cat.dto.request.*;
import com.example.cat.mapper.EventMapper;
import com.example.cat.model.Event;
import com.example.cat.service.EventService;
import org.springframework.web.bind.annotation.*;

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
                return IntegrationMessage.errorResponse("Payload is not present");
            }

            List<Event> events = eventService.getEvents(paginationInfo);

            return IntegrationMessage.successGetResponse(events);
        } catch (Exception exception) {
            return IntegrationMessage.exceptionResponse(exception.getMessage());
        }
    }

    @PostMapping("/rest/events/eventById")
    public EventDtoOne getEvent(@RequestBody IntegrationMessage<GetEventByIdRequest> getMessage) {
        EventDtoOne eventDtoOne = eventMapper.eventToEventDto(eventService.getEventById(eventId));
        return eventDtoOne;
    }

    @PostMapping("/rest/events/newEvent")
    public void createEvent(@RequestBody IntegrationMessage<CreateEventRequest> createMessage) {
        Event event = eventMapper.eventDtoToEvent(eventDto);
        eventService.saveEvent(event);
    }

    @PostMapping("/rest/events/editEvent")
    public void editEvent(@RequestBody IntegrationMessage<DeleteEventByIdRequest> deleteMessage) {
        Event event = eventMapper.eventDtoToEvent(eventDto);
        eventService.saveEvent(event);
    }

    @PostMapping("/rest/events/deleteEvent")
    public void deleteEvent(@RequestBody IntegrationMessage<DeleteEventByIdRequest> deleteMessage) {
        Event event = eventMapper.eventDtoToEvent(eventDto);
        eventService.saveEvent(event);
    }



}
