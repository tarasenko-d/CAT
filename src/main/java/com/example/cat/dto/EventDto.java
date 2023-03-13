package com.example.cat.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class EventDto {
    private Long externalId;
    private String title;
    private LocalDateTime eventDate;
    private Double latitude;
    private Double longitude;
    private Long creatorExternalId;
    private String creatorName;
    private List<Member> members;
    private List<TagDto> tags;

}
