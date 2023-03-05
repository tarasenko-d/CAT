package com.example.cat;

import com.example.cat.dto.PaginationInfo;
import com.example.cat.dto.request.CreateEventRequest;
import com.example.cat.model.Event;
import com.example.cat.model.Tag;
import com.example.cat.model.User;
import com.example.cat.service.EventService;
import com.example.cat.service.TagService;
import com.example.cat.service.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
public class RunAfterStartup {

    private EventService eventService;
    private UserService userService;
    private TagService tagService;

    public RunAfterStartup(EventService eventService, UserService userService, TagService tagService) {
        this.eventService = eventService;
        this.userService = userService;
        this.tagService = tagService;
    }


    @EventListener(ContextStartedEvent.class)
    public void runAfterContextStart() {
        System.out.println("Context has been started");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {

        Tag coffeeTag = new Tag(1, "Кофе", Tag.TagClass.PASTIME);
        Tag gamesTag = new Tag(2, "Игры", Tag.TagClass.HOBBY);
        Tag filmTag = new Tag(3, "Фильмы", Tag.TagClass.POP_CULTURE);
        List<String> tags = List.of(coffeeTag.getTagName(), gamesTag.getTagName());

        tagService.saveTag(coffeeTag);
        tagService.saveTag(gamesTag);
        tagService.saveTag(filmTag);

        //
        User userA = new User();
        userA.setLogin("A");
        userA.setPassword("aaa");

        userService.saveUser(userA);

        //
        CreateEventRequest.Info eventA = new CreateEventRequest.Info();
        eventA.setTitle("event A");
        eventA.setLatitude(11);
        eventA.setLongitude(11);
        eventA.setEventDate(LocalDateTime.of(LocalDate.of(2023, 04, 05), LocalTime.of(10, 0, 0)));
        eventA.setTags(tags);

        Event savedEvent = eventService.saveEvent(eventA, userA);

        //
        User userC = new User();
        userC.setLogin("C");
        userC.setPassword("ccc");

        User savedUserC = userService.saveUser(userC);
        userService.followEvent(savedUserC.getId(), savedEvent.getId());

        System.out.println(userService.getUsers());
        System.out.println(eventService.getEvents(new PaginationInfo().setSize(1).setPage(0)));
    }
}
