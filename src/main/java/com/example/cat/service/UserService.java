package com.example.cat.service;

import com.example.cat.dao.EventDao;
import com.example.cat.dao.UserDao;
import com.example.cat.exception.NoSuchEntryException;
import com.example.cat.model.Event;
import com.example.cat.model.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final EventDao eventDao;
    private final UserDao userDao;

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    @Transactional
    public void edit(User editUser) {
        Optional<User> userOptional = userDao.getUserById(editUser.getId());

        if (userOptional.isEmpty()) {
            throw new NoSuchEntryException();
        }

        User user = userOptional.get();

        if (editUser.getLogin() != null) {
            user.setLogin(editUser.getLogin());
        }
        if (editUser.getPassword() != null) {
            user.setPassword(editUser.getPassword());
        }
        if (editUser.getUserPicture() != null) {
            user.setUserPicture(editUser.getUserPicture());
        }
        if (editUser.getFavouriteTags() != null) {
            user.setFavouriteTags(editUser.getFavouriteTags());
        }

        userDao.save(user);
    }


    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Transactional
    public List<User> getFullUsers() {
        List<User> result = userDao.findAll();
        for (User user : result) {
            Hibernate.initialize(user.getCreatedEvents());
            Hibernate.initialize(user.getAddedEvents());
            Hibernate.initialize(user.getFavouriteTags());
        }
        return result;
    }

    @Transactional
    public List<User> getUsersWithAddedEvents() {
        List<User> result = userDao.findAll();

        for (User user : result) {
            Hibernate.initialize(user.getAddedEvents());
        }

        return result;
    }

    @Transactional
    public List<User> getUsersWithCreatedEvents() {
        List<User> result = userDao.findAll();

        for (User user : result) {
            Hibernate.initialize(user.getCreatedEvents());
        }

        return result;
    }

    @Transactional
    public void followEvent(Long userId, Long eventId) {
        Optional<User> userOptional = userDao.findById(userId);
        Optional<Event> eventOptional = eventDao.findById(eventId);

        if (userOptional.isEmpty() || eventOptional.isEmpty()) {
            throw new NoSuchEntryException();
        }

        User user = userOptional.get();
        Event event = eventOptional.get();
        user.getAddedEvents().add(event);

        userDao.save(user);
    }

    @Transactional
    public void unfollowEvent(Long userId, Long eventId) {
        Optional<User> userOptional = userDao.findById(userId);
        Optional<Event> eventOptional = eventDao.findById(eventId);

        if (userOptional.isEmpty() || eventOptional.isEmpty()) {
            throw new NoSuchEntryException();
        }

        User user = userOptional.get();
        Event event = eventOptional.get();
        user.getAddedEvents().remove(event);

        userDao.save(user);
    }

    public User getUserById(Long id) {
        return userDao.findById(id).orElseThrow(NoSuchEntryException::new);
    }

    public User getUserByLogin(String name) {
        return userDao.getUserByLogin(name);
    }
}
