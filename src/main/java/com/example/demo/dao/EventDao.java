package com.example.demo.dao;

import com.example.demo.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventDao extends CrudRepository<Event, Long> {

    @Query(value = "SELECT e FROM Event e JOIN FETCH e.members")
    List<Event> getAllWithMembers();

}
