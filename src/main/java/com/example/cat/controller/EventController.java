package com.example.cat.controller;


import com.example.cat.dto.EventDto;
import com.example.cat.mapper.EventMapper;
import com.example.cat.model.Event;
import com.example.cat.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    private EventService eventService;
    private EventMapper eventMapper;

    public EventController(EventService eventService, EventMapper eventMapper) {
        this.eventService = eventService;
        this.eventMapper = eventMapper;
    }

    @GetMapping("/rest/events")
    public List<EventDto> getEventList() {
        return eventMapper.eventsToEventsDto(eventService.getEvents());
    }

    @GetMapping("/rest/events/{id}")
    public EventDto getEvent(@PathVariable(name = "id") long eventId) {
        EventDto eventDto = eventMapper.eventToEventDto(eventService.getEventById(eventId));
        return eventDto;
    }

    @PostMapping("/rest/events/")
    public void createEvent(@RequestBody EventDto eventDto) {
        Event event = eventMapper.eventDtoToEvent(eventDto);
        eventService.saveEvent(event);
    }

    @PutMapping("/rest/events/{id}")
    public void editEvent(@RequestBody EventDto eventDto) {
        Event event = eventMapper.eventDtoToEvent(eventDto);
        eventService.saveEvent(event);
    }

   /* @GetMapping("/rest/events")
    public List<EventDto> getEventListByTag() {
    }*/


}
