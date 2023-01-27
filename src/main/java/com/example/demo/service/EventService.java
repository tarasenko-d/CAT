package com.example.demo.service;

import com.example.demo.model.Event;

import java.util.List;

public interface EventService {
    public void save(Event event);
    public List<Event> getAllWithMembers();
}
