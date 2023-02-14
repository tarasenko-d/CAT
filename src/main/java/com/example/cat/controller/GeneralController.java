package com.example.cat.controller;


import com.example.cat.dto.EventDto;
import com.example.cat.mapper.EventMapper;
import com.example.cat.mapper.TagMapper;
import com.example.cat.mapper.UserMapper;
import com.example.cat.model.Event;
import com.example.cat.service.EventService;
import com.example.cat.service.TagService;
import com.example.cat.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GeneralController {

    private EventService eventService;
    private UserService userService;
    private TagService tagService;
    private TagMapper tagMapper;
    private EventMapper eventMapper;
    private UserMapper userMapper;

    public GeneralController(EventService eventService, UserService userService, TagService tagService, TagMapper tagMapper, EventMapper eventMapper, UserMapper userMapper) {
        this.eventService = eventService;
        this.userService = userService;
        this.tagService = tagService;
        this.tagMapper = tagMapper;
        this.eventMapper = eventMapper;
        this.userMapper = userMapper;
    }

    @GetMapping("/rest/events")
    public List<EventDto> getEventList() {
        return  eventMapper.lazyEventsToEventsDto(eventService.getEvents());
    }

    /* @GetMapping("/rest/events")
    public List<EventDto> getEventListByTag() {
    }*/

    @GetMapping("/rest/events/{id}")
    public EventDto getEvent(@PathVariable(name = "id") long eventId) {
        EventDto eventDto = eventMapper.eventToEventDto( eventService.getEventById(eventId));
        return eventDto;
    }

    @PostMapping("/rest/events/")
    public void createEvent(@RequestBody EventDto eventDto){
        Event event = eventMapper.eventDtoToEvent(eventDto);
        eventService.saveEvent(event);
    }

    @PutMapping("/rest/events/{id}")
    public void editEvent(@RequestBody EventDto eventDto){
        Event event = eventMapper.eventDtoToEvent(eventDto);
        eventService.saveEvent(event);
    }




}
