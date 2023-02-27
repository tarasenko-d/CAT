package com.example.cat.dto.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GetEventsFilterRequest {
    private EventFilter eventFilter;
    private PageInfo pageInfo;

    @Data
    public static class EventFilter {

        private String title;
        private LocalDateTime dateTimeFrom;
        private LocalDateTime dateTimeTo;
        private Double latitude;
        private Double longitude;
        private Integer radius;
        private String creatorName;
        private List<String> tags;

    }

    @Data
    public static class PageInfo {
        private int page;
        private int size;
    }

}
