package com.example.cat.dao;

import com.example.cat.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDao extends CrudRepository<User, Long> {

    Optional<User> getUserById(Long id);

    User getUserByLogin(String login);

}
