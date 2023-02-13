package com.example.cat.mapper;

import com.example.cat.dto.EventDto;
import com.example.cat.model.Event;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring", uses = {UserMapper.class, TagMapper.class})
public interface EventMapper {

        @Named("eventToEventDto")
        EventDto eventToEventDto(Event event);

        @Named("eventDtoToEvent")
        Event eventDtoToEvent(EventDto eventDto);

        @IterableMapping(qualifiedByName = "eventToEventDto")
        List<EventDto> eventsToEventsDto(List<Event> events);

        @IterableMapping(qualifiedByName = "eventDtoToEvent")
        List<Event> eventsDtoToEvents(List<EventDto> usersDto);

}
