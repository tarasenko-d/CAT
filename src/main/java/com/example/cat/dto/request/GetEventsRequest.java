package com.example.cat.dto.request;

import lombok.Data;


@Data
public class GetEventsRequest {
    private PaginationInfo paginationInfo;

    @Data
    public static class PaginationInfo {
        private int page;
        private int size;
    }

}
