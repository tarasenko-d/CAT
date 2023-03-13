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

    public User saveUser(User user) {
        String externalId = user.getLogin().hashCode()+"_"+user.getPassword().hashCode()+"_"+System.nanoTime();
        user.setExternalId(externalId);
        userDao.save(user);
        return user;
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
    public User followEvent(Long userId, Long eventId) {
        User user = Optional.ofNullable(userDao.findById(userId))
                .orElseThrow(() -> new NoSuchEntryException("Пользователь с id=" + userId + " не найден"))
                .get();
        Event event = Optional.ofNullable(eventDao.findById(eventId))
                .orElseThrow(() -> new NoSuchEntryException("Событие с id=" + eventId + " не найден"))
                .get();

        user.getAddedEvents().add(event);

        return userDao.save(user);
    }

    @Transactional
    public User unfollowEvent(Long userId, Long eventId) {
        User user = Optional.ofNullable(userDao.findById(userId))
                .orElseThrow(() -> new NoSuchEntryException("Пользователь с id=" + userId + " не найден"))
                .get();
        Event event = Optional.ofNullable(eventDao.findById(eventId))
                .orElseThrow(() -> new NoSuchEntryException("Событие с id=" + eventId + " не найден"))
                .get();

        user.getAddedEvents().remove(event);

        return userDao.save(user);
    }

    public User getUserById(Long id) {
        return userDao.findById(id).orElseThrow(NoSuchEntryException::new);
    }

    public User getUserByExternalId(Long id) {
        return userDao.getUserByExternalId(id).orElseThrow(NoSuchEntryException::new);
    }

    public User getUserByLogin(String name) {
        return userDao.getUserByLogin(name);
    }

    public Boolean userExist(String login) {
        return userDao.existsUserByLogin(login);
    }
}
