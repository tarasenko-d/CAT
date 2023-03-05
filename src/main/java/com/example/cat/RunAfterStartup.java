package com.example.cat;

import com.example.cat.service.EventService;
import com.example.cat.service.TagService;
import com.example.cat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RunAfterStartup {

    private final EventService eventService;
    private final UserService userService;
    private final TagService tagService;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
//
//        Tag coffeeTag = new Tag(1, "Кофе", Tag.TagClass.PASTIME);
//        Tag gamesTag = new Tag(2, "Игры", Tag.TagClass.HOBBY);
//        Tag filmTag = new Tag(3, "Фильмы", Tag.TagClass.POP_CULTURE);
//        List<String> tags = List.of(coffeeTag.getTagName(), gamesTag.getTagName());
//
//        tagService.saveTag(coffeeTag);
//        tagService.saveTag(gamesTag);
//        tagService.saveTag(filmTag);
//
//        //
//        User userA = new User();
//        userA.setLogin("A");
//        userA.setPassword("aaa");
//
//        userService.saveUser(userA);
//
//        //
//        CreateEventRequest.Info eventA = new CreateEventRequest.Info();
//        eventA.setTitle("event A");
//        eventA.setLatitude(11);
//        eventA.setLongitude(11);
//        eventA.setEventDate(LocalDateTime.of(LocalDate.of(2023, 04, 05), LocalTime.of(10, 0, 0)));
//        eventA.setTags(tags);
//
//        Event savedEvent = eventService.saveEvent(eventA, userA);
//
//        //
//        User userC = new User();
//        userC.setLogin("C");
//        userC.setPassword("ccc");
//
//        User savedUserC = userService.saveUser(userC);
//        userService.followEvent(savedUserC.getId(), savedEvent.getId());
//
//        System.out.println(userService.getUsers());
//        System.out.println(eventService.getEvents(new PaginationInfo().setSize(1).setPage(0)));
    }
}
