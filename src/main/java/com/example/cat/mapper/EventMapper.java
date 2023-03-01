package com.example.cat.mapper;

import com.example.cat.dto.EventDtoOne;
import com.example.cat.dto.TagDto;
import com.example.cat.model.Event;
import com.example.cat.model.Tag;
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
    default EventDtoOne eventToEventDto(Event event) {
        if (event == null) {
            return null;
        }

        EventDtoOne eventDtoOne = new EventDtoOne();

        eventDtoOne.setId(event.getId());
        eventDtoOne.setTitle(event.getTitle());
        eventDtoOne.setLatitude(event.getLatitude());
        eventDtoOne.setLongitude(event.getLongitude());
        eventDtoOne.setCreatorId(event.getCreator().getId());
        eventDtoOne.setCreatorName(event.getCreator().getLogin());
        eventDtoOne.setMembers(event.getMembers());

        List<TagDto> dtoList = new ArrayList<>();
        for (Tag tag : event.getTags()) {
            TagDto tagDto = new TagDto(tag.getTagName(), tag.getTagClass().name());
            dtoList.add(tagDto);
        }

        eventDtoOne.setTags(dtoList);

        return eventDtoOne;

    }


    @Named("eventDtoToEvent")
    Event eventDtoToEvent(EventDtoOne eventDtoOne);

    @IterableMapping(qualifiedByName = "eventDtoToEvent")
    List<Event> eventsDtoToEvents(List<EventDtoOne> usersDto);

    @IterableMapping(qualifiedByName = "eventToEventDto")
    List<EventDtoOne> eventsToEventsDto(List<Event> users);

    @IterableMapping(qualifiedByName = "lazyEventToEventDto")
    List<Event> lazyEventsToEventsDto(List<Event> events);


}
