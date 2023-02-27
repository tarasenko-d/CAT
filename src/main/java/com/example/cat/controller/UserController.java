package com.example.cat.controller;

import com.example.cat.mapper.UserMapper;
import com.example.cat.service.UserService;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {


    private UserService userService;
    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

}
