package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
        System.out.println("---- \n User ["+user.getLogin()+"] has been saved");
    }

    @Override
    public List<User> getAllWithEvents() {
        return userDao.getAllWithEvents();
    }

}
