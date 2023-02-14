package com.example.cat.dao;

import com.example.cat.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventDao extends CrudRepository<Event, Long> {

    List<Event> getEventsByTitle(String title);


    // List<Event> getEventsByTagsContains(List<Tag> tags);

}
