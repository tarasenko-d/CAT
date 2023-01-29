package com.example.demo.service;

import com.example.demo.dao.EventDao;
import com.example.demo.dao.UserDao;
import com.example.demo.exception.NoSuchEntryException;
import com.example.demo.model.Event;
import com.example.demo.model.Tag;
import com.example.demo.model.User;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventDao eventDao;
    private final UserDao userDao;

    public EventServiceImpl(EventDao eventDao, UserDao userDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
    }


    @Transactional
    @Override
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
    @Override
    public void delete(Event event) {
        eventDao.delete(event);
    }

    @Override
    public void edit(Event event) {

    }


    @Override
    public List<Event> getEvents() {
        return (List<Event>) eventDao.findAll();
    }

    @Transactional
    @Override
    public List<Event> getFullEvent() {
        List<Event> result = new ArrayList<>();
        for (Event event : eventDao.findAll()) {
            Hibernate.initialize(event.getMembers());
            Hibernate.initialize(event.getTags());
            result.add(event);
        }
        return result;
    }

    @Override
    public List<Event> getEventsByTitle(String title) {
        List<Event> events = eventDao.getEventsByTitle(title);
        if (events.isEmpty()){
            throw new NoSuchEntryException();
        }
        return events;
    }

    @Override
    public List<Event> getEventsByTagsContains(List<Tag> tags) {
        return eventDao.getEventsByTagsContains(tags);
    }
}
