package com.example.cat.mapper;


import com.example.cat.dto.EventDto;
import com.example.cat.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, TagMapper.class})
public interface EventMapper {

    @Mapping(target = "creatorName", source = "creator.login")
    @Mapping(target = "creatorExternalId", source = "creator.externalId")
    EventDto eventToEventDto(Event event);
}

