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

   private EventService eventService;
   private UserService userService;

    public Demo1Application(EventService eventService,UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @PostConstruct
    public void doStuff() {

        User userA = new User();
        userA.setLogin("A");
        userA.setPassword("aaa");

        userService.saveUser(userA);

        Event eventA = new Event();
        eventA.setTitle("event A");
        eventA.setLatitude(11);
        eventA.setLongitude(11);
        eventA.setCreator(userA);

        eventService.saveEvent(eventA);

        User userC = new User();
        userC.setLogin("C");
        userC.setPassword("ccc");

        userService.saveUser(userC);
        userService.followEvent(userC.getId(),eventA.getId());

        System.out.println(userService.getUserById(1L));
        User uzzzer = userService.getUserByLogin("C");
        System.out.println(uzzzer);

        System.out.println("-----\n");
        for (User user :
                userService.getFullUsers()) {
            System.out.println(user.fullString());
        }
        System.out.println("-----\n");
        for (Event event :
                eventService.getFullEvent()) {
            System.out.println(event.fullString());
        }
        System.out.println("-----");
    }
}
