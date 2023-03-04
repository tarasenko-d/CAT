package com.example.cat.dao;

import com.example.cat.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EventDao extends CrudRepository<Event, Long> {

    List<Event> getEventsByTitle(String title);

    Page<Event> findAll(Pageable pageable);
}
