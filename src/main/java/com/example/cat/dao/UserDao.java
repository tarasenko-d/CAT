package com.example.cat.dao;

import com.example.cat.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends CrudRepository<User, Long> {

    Optional<User> getUserById(Long id);

    User getUserByLogin(String login);

    List<User> findAllByLoginIn(List<String> names);

    List<User> findAll();
}
