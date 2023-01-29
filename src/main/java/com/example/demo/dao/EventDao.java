package com.example.demo.dao;

import com.example.demo.model.Event;
import com.example.demo.model.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventDao extends CrudRepository<Event, Long> {

    List<Event> getEventsByTitle(String title);

    List<Event> getEventsByTagsContains(List<Tag> tags);
}
