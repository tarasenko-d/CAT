package com.example.demo.service;

import com.example.demo.model.Event;
import com.example.demo.model.Tag;

import java.util.List;

public interface EventService {

    void saveEvent(Event event);
    void delete(Event event);
    void edit(Event event);
    List<Event> getEvents();
    List<Event> getFullEvent();
    List<Event> getEventsByTitle(String title);
    List<Event> getEventsByTagsContains(List<Tag> tags);


}
