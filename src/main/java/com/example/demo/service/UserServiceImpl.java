package com.example.demo.service;

import com.example.demo.dao.EventDao;
import com.example.demo.dao.UserDao;
import com.example.demo.exception.NoSuchEntryException;
import com.example.demo.model.Event;
import com.example.demo.model.User;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//TODO Get methods for uni user throws LazyInitExcp -> decide where need to initialize
@Service
public class UserServiceImpl implements UserService {

    private final EventDao eventDao;
    private final UserDao userDao;

    public UserServiceImpl(EventDao eventDao, UserDao userDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
        System.out.println("---- \n User [" + user.getLogin() + "] has been saved");
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Transactional
    @Override
    public void edit(User editUser) {
        Optional<User> userOptional = userDao.getUserById(editUser.getId());
        if (userOptional.isEmpty()) {
            throw new NoSuchEntryException();
        }

        User user = userOptional.get();
        if (editUser.getLogin() != null) user.setLogin(editUser.getLogin());
        if (editUser.getPassword() != null) user.setPassword(editUser.getPassword());
        if (editUser.getUserPicture() != null) user.setUserPicture(editUser.getUserPicture());
        if (editUser.getFavouriteTags() != null) user.setFavouriteTags(editUser.getFavouriteTags());
        userDao.save(user);
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userDao.findAll();
    }

    @Transactional
    @Override
    public List<User> getFullUsers() {
        List<User> result = (List<User>) userDao.findAll();
        for (User user : result) {
            Hibernate.initialize(user.getCreatedEvents());
            Hibernate.initialize(user.getAddedEvents());
            Hibernate.initialize(user.getFavouriteTags());
        }
        return result;
    }

    @Transactional
    @Override
    public List<User> getUsersWithAddedEvents() {
        List<User> result = (List<User>) userDao.findAll();
        for (User user : result) {
            Hibernate.initialize(user.getAddedEvents());
        }
        return result;
    }

    @Transactional
    @Override
    public List<User> getUsersWithCreatedEvents() {
        List<User> result = (List<User>) userDao.findAll();
        for (User user : result) {
            Hibernate.initialize(user.getCreatedEvents());
        }
        return result;
    }

    @Transactional
    @Override
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
    @Override
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

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id).orElseThrow(NoSuchEntryException::new);
    }

    @Override
    public User getUserByLogin(String name) {
        return userDao.getUserByLogin(name);
    }


}
