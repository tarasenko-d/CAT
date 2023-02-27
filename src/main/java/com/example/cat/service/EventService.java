package com.example.cat.service;

import com.example.cat.dao.EventDao;
import com.example.cat.dao.UserDao;
import com.example.cat.exception.NoSuchEntryException;
import com.example.cat.model.Event;
import com.example.cat.model.User;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventDao eventDao;
    private final UserDao userDao;

    public EventService(EventDao eventDao, UserDao userDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
    }


    @Transactional
    public void saveEvent(Event event) {

        System.out.println("---- \n Event [" + event.getTitle() + "] has been saved");

        Optional<User> userOptional = userDao.findById(event.getCreator().getId());
        if (userOptional.isEmpty()) {
            throw new NoSuchEntryException();
        }
        List<User> userList = new ArrayList<>();
        userList.add(userOptional.get());
        event.setMembers(userList);
        eventDao.save(event);
    }

    public void delete(Event event) {
        eventDao.delete(event);
    }

    public void edit(Event event) {
    }

    public List<Event> getEvents() {
        List<Event> events = (List<Event>) eventDao.findAll();
        for (Event event : events) {
            Hibernate.initialize(event.getCreator());
            Hibernate.initialize(event.getMembers());
            Hibernate.initialize(event.getTags());
        }
        return events;
    }

    public Event getEventById(long eventId) {
        Optional<Event> eventOptional = eventDao.findById(eventId);
        if (eventOptional.isEmpty()) {
            throw new NoSuchEntryException("No event with id=" + eventId + ";");
        }
        Event event = eventOptional.get();
        Hibernate.initialize(event.getMembers());
        Hibernate.initialize(event.getTags());
        return event;
    }

    @Transactional
    public List<Event> getFullInitializeEvents() {
        List<Event> result = new ArrayList<>();
        for (Event event : eventDao.findAll()) {
            Hibernate.initialize(event.getMembers());
            Hibernate.initialize(event.getTags());
            result.add(event);
        }
        return result;
    }

    public List<Event> getEventsByTitle(String title) {
        List<Event> events = eventDao.getEventsByTitle(title);
        if (events.isEmpty()) {
            throw new NoSuchEntryException();
        }
        return events;
    }

}
