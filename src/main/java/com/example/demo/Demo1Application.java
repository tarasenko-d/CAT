package com.example.demo;

import com.example.demo.model.Event;
import com.example.demo.model.User;
import com.example.demo.service.EventService;
import com.example.demo.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

    final UserService userService;
    final EventService eventService;

    @Autowired
    public Demo1Application(UserService userService, EventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
    }


    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @PostConstruct
    public void doStuff() {

        User userA = new User();
        userA.setLogin("A");
        userA.setPassword("aaa");

        Event eventA = new Event();
        eventA.setTitle("event A");
        eventA.setLatitude(11);
        eventA.setLongitude(11);

        userA.addCreatedEvent(eventA);

        userService.save(userA);
        eventService.save(eventA);

        System.out.println("------\n" + userService.getAllWithEvents() + "\n -----");
        System.out.println("------\n" + eventService.getAllWithMembers() + "\n -----");
    }
}
