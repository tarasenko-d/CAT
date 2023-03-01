package com.example.cat.dto.request;

import lombok.Data;

public class GetTagsRequest {
    private PaginationInfo paginationInfo;

    public GetTagsRequest() {
        this.paginationInfo = new PaginationInfo()
                .setPage(0)
                .setSize(1);
    }
}
