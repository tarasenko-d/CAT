package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService{


    void saveUser(User user);
    void delete(User user);
    void edit(User user);

    List<User> getUsers();
    List<User> getFullUsers();
    List<User> getUsersWithAddedEvents();
    List<User> getUsersWithCreatedEvents();

    void followEvent(Long userId, Long eventId);
    void unfollowEvent(Long userId, Long eventId);

    User getUserById(Long id);
    User getUserByLogin(String name);


}
