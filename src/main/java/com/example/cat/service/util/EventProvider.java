package com.example.cat.service.util;

import com.example.cat.dto.request.CreateEventRequest;
import com.example.cat.model.Event;
import com.example.cat.model.Tag;
import com.example.cat.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class EventProvider {

    public static Event generateEvent(CreateEventRequest.Info eventInfo, User creator, List<Tag> tags) {

        Event event = new Event();

        String externalId = eventInfo.hashCode()+"_"+creator.hashCode()+"_"+System.nanoTime();
        event.setExternalId(externalId);
        event.setCreator(creator);
        event.setTitle(eventInfo.getTitle());
        event.setEventDate(eventInfo.getEventDate());

        event.setLatitude(eventInfo.getLatitude());
        event.setLatitude(eventInfo.getLatitude());

        List<User> members = List.of(creator);
        event.setMembers(members);
        event.setTags(tags);

        return event;
    }

}
