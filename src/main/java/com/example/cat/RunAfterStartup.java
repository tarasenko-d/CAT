package com.example.cat;


import com.example.cat.service.EventService;
import com.example.cat.service.TagService;
import com.example.cat.service.UserService;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

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
    public void runAfterContextStart(){
        System.out.println("Context has been started");
    }

  /*  @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {

        Tag coffeeTag = new Tag("Кофе",Tag.TagClass.PASTIME);
        Tag gamesTag = new Tag("Игры",Tag.TagClass.HOBBY);
        Tag filmTag = new Tag("Фильмы",Tag.TagClass.POPCULTURE);
        List<Tag> tags = List.of(coffeeTag,gamesTag);

        tagService.saveTag(coffeeTag);
        tagService.saveTag(gamesTag);
        tagService.saveTag(filmTag);

        User userA = new User();
        userA.setLogin("A");
        userA.setPassword("aaa");

        userService.saveUser(userA);

        Event eventA = new Event();
        eventA.setTitle("event A");
        eventA.setLatitude(11);
        eventA.setLongitude(11);
        eventA.setCreator(userA);
        eventA.setTags(tags);

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
*/
}
