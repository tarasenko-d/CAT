package com.example.cat.dto;

import lombok.Data;

@Data
public class TagDto {
    private Long externalId;
    private String tagName;
    private String tagClass;
}
