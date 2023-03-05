package com.example.cat.dto.request;

import com.example.cat.dto.PaginationInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GetEventsFilterRequest {
    private EventFilter eventFilter;
    private PaginationInfo paginationInfo;

    @Data
    @Accessors(chain = true)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EventFilter {
        private String title;
        private LocalDateTime eventDateFrom;
        private LocalDateTime eventDateTo;
        private Double latitude;
        private Double longitude;
        private Integer radius;
        private String creatorName;
        private List<String> tags;
    }

    public GetEventsFilterRequest() {
        this.eventFilter = new EventFilter();
        this.paginationInfo = new PaginationInfo()
                .setPage(0)
                .setSize(1);
    }
}
