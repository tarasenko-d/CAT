package com.example.cat.service.util;

import com.example.cat.dto.EventDto;
import com.example.cat.model.Event;
import com.example.cat.model.Tag;
import com.example.cat.model.User;

import java.util.List;

import static java.util.Objects.nonNull;

public class EventChanger {
    public static Event changeEvent(EventDto.EventInfo eventInfo, List<User> members, List<Tag> tags, Event event) {

        if(nonNull(eventInfo.getTitle())){
            event.setTitle(eventInfo.getTitle());
        }
        if(nonNull(eventInfo.getLatitude())){
            event.setLatitude(eventInfo.getLatitude());
        }
        if(nonNull(eventInfo.getLongitude())){
            event.setLongitude(eventInfo.getLongitude());
        }
        if(nonNull(eventInfo.getDateTime())){
            event.setDateTime(eventInfo.getDateTime());
        }
        if(nonNull(members)){
            event.setMembers(members);
        }
        if(nonNull(tags)){
            event.setTags(tags);
        }


        return event;
    }
}
