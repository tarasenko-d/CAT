package com.example.cat.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetEventsFilterResponse {
    private List<EventData> events;

    @Data
    public class EventData{
        private Long externalId;
        private String title;
        private LocalDateTime eventTime;
        private Double latitude;
        private Double longitude;
        private Long creatorExternalId;
        private String creator;
    }
}
