package com.example.cat.service;

import com.example.cat.dao.EventDao;
import com.example.cat.dao.TagDao;
import com.example.cat.dao.UserDao;
import com.example.cat.dto.PaginationInfo;
import com.example.cat.dto.request.CreateEventRequest;
import com.example.cat.dto.request.EditEventRequest;
import com.example.cat.exception.NoSuchEntryException;
import com.example.cat.model.Event;
import com.example.cat.model.Tag;
import com.example.cat.model.User;
import com.example.cat.service.util.EventChanger;
import com.example.cat.service.util.EventProvider;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventDao eventDao;
    private final UserDao userDao;
    private final TagDao tagDao;

    @Transactional
    public Event saveEvent(CreateEventRequest.Info eventInfo) {

        long creatorId = eventInfo.getCreatorId();
        Optional<User> creator = userDao.findById(creatorId);

        if (creator.isEmpty()) {
            throw new NoSuchEntryException("Пользователя с id: " + creatorId + " не существует");
        }
        List<Tag> tagList = tagDao.findAllByTagNameIn(eventInfo.getTags());
        Event event = EventProvider.generateEvent(eventInfo, creator.get(), tagList);

        return eventDao.save(event);
    }

    @Transactional
    public void deleteEvent(long id) {
        Optional<Event> event = eventDao.findById(id);

        if (event.isEmpty()) {
            throw new NoSuchEntryException("Событие не найдено");
        }

        eventDao.delete(event.get());
    }

    @Transactional
    public Event editEvent(EditEventRequest.Info eventInfo) {
        Optional<Event> event = eventDao.findById(eventInfo.getId());

        if (event.isEmpty()) {
            throw new NoSuchEntryException("Событие не найдено");
        }

        List<Tag> tagList = tagDao.findAllByTagNameIn(eventInfo.getTags());
        List<User> userList = userDao.findAllByLoginIn(eventInfo.getMembers());

        Event updatedEvent = EventChanger.changeEvent(eventInfo, userList, tagList, event.get());

        return eventDao.save(updatedEvent);
    }

    @Transactional
    public List<Event> getEvents(PaginationInfo paginationInfo) {
        PageRequest pageable = PageRequest.of(paginationInfo.getPage(), paginationInfo.getSize());

        Page<Event> events = eventDao.findAll(pageable);
        for (Event event : events.getContent()) {
            Hibernate.initialize(event.getCreator());
            Hibernate.initialize(event.getMembers());
            Hibernate.initialize(event.getTags());
        }
        return events.getContent();
    }

    public Event getEventById(long eventId) {
        Optional<Event> eventOptional = eventDao.findById(eventId);

        if (eventOptional.isEmpty()) {
            throw new NoSuchEntryException("No event with id: " + eventId);
        }

        Event event = eventOptional.get();
        Hibernate.initialize(event.getMembers());
        Hibernate.initialize(event.getTags());

        return event;
    }

    public List<Event> getEventsByTitle(String title) {
        List<Event> events = eventDao.getEventsByTitle(title);

        if (events.isEmpty()) {
            throw new NoSuchEntryException();
        }

        return events;
    }
}
