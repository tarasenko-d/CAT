package com.example.cat.dao;

import com.example.cat.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventDao extends CrudRepository<Event, Long> {

    List<Event> getEventsByTitle(String title);

}
