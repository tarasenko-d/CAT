package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    Optional<User> findById(Long id);

    @Query(value = "SELECT u FROM User u JOIN FETCH u.addedEvents added " +
            "JOIN FETCH added.members members ")
    List<User> getAllWithEvents();

}
