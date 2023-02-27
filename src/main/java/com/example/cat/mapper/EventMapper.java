package com.example.cat.mapper;

import com.example.cat.dto.EventDto;
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
    default EventDto eventToEventDto(Event event) {
        if (event == null) {
            return null;
        }

        EventDto eventDto = new EventDto();

        eventDto.setId(event.getId());
        eventDto.setTitle(event.getTitle());
        eventDto.setLatitude(event.getLatitude());
        eventDto.setLongitude(event.getLongitude());
        eventDto.setCreatorId(event.getCreator().getId());
        eventDto.setCreatorName(event.getCreator().getLogin());
        eventDto.setMembers(event.getMembers());

        List<TagDto> dtoList = new ArrayList<>();
        for (Tag tag : event.getTags()) {
            TagDto tagDto = new TagDto(tag.getTagName(), tag.getTagClass().name());
            dtoList.add(tagDto);
        }

        eventDto.setTags(dtoList);

        return eventDto;

    }


    @Named("eventDtoToEvent")
    Event eventDtoToEvent(EventDto eventDto);

    @IterableMapping(qualifiedByName = "eventDtoToEvent")
    List<Event> eventsDtoToEvents(List<EventDto> usersDto);

    @IterableMapping(qualifiedByName = "eventToEventDto")
    List<EventDto> eventsToEventsDto(List<Event> users);

    @IterableMapping(qualifiedByName = "lazyEventToEventDto")
    List<Event> lazyEventsToEventsDto(List<Event> events);


}
