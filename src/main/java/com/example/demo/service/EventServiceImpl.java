package com.example.demo.service;

import com.example.demo.dao.EventDao;
import com.example.demo.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventDao eventDao;

    public EventServiceImpl(EventDao eventDao) {
        this.eventDao = eventDao;
    }


    @Override
    public void save(Event event) {
        eventDao.save(event);
        System.out.println("---- \n Event ["+event.getTitle()+"] has been saved");
    }

    @Override
    public List<Event> getAllWithMembers() {
        return eventDao.getAllWithMembers();
    }
}
