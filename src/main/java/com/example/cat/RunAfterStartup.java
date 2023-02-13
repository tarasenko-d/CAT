package com.example.cat;


import com.example.cat.model.Event;
import com.example.cat.model.User;
import com.example.cat.service.EventService;
import com.example.cat.service.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RunAfterStartup {

    private EventService eventService;
    private UserService userService;

    public RunAfterStartup(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
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
                eventService.getFullInitializeEvents()) {
            System.out.println(event.fullString());
        }
        System.out.println("-----");
    }

}
