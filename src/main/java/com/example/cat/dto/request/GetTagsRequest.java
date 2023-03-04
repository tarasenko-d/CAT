package com.example.cat.dto.request;

import com.example.cat.dto.PaginationInfo;

public class GetTagsRequest {
    private PaginationInfo paginationInfo;

    public GetTagsRequest() {
        this.paginationInfo = new PaginationInfo()
                .setPage(0)
                .setSize(1);
    }
}
