package com.example.cat.mapper;

import com.example.cat.dto.EventDto;
import com.example.cat.dto.TagDto;
import com.example.cat.dto.UserDto;
import com.example.cat.model.Event;
import com.example.cat.model.Tag;
import com.example.cat.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Mapper(componentModel = "spring", uses = {UserMapper.class, TagMapper.class})
public interface EventMapper {


    @Named("eventToEventDto")
    EventDto eventToEventDto(Event event);

    @Named("eventDtoToEvent")
    Event eventDtoToEvent(EventDto eventDto);

    @Named("lazyEventToEventDto")
    default EventDto lazyEventToEventDto(Event event) {
        if (event == null) {
            return null;
        }

        EventDto eventDto = new EventDto();

        eventDto.setId(event.getId());
        eventDto.setTitle(event.getTitle());
        eventDto.setLatitude(event.getLatitude());
        eventDto.setLongitude(event.getLongitude());
        eventDto.setCreator(lazyUserToUserDto(event.getCreator()));
        List<TagDto> dtoList = new ArrayList<>();
        for (Tag tag : event.getTags()) {
          TagDto tagDto = new TagDto(tag.getTagName(),tag.getTagClass().name());
          dtoList.add(tagDto);
        }
        eventDto.setTags(dtoList);

        return eventDto;
    }


    @IterableMapping(qualifiedByName = "eventDtoToEvent")
    List<Event> eventsDtoToEvents(List<EventDto> usersDto);

    @IterableMapping(qualifiedByName = "lazyEventToEventDto")
    List<EventDto> lazyEventsToEventsDto(List<Event> events);


    default UserDto lazyUserToUserDto(User user) {
        if (user == null) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());

        return userDto;
    }

}
