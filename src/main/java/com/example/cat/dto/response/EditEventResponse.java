package com.example.cat.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EditEventResponse {

        private long id;
        private String title;
        private LocalDateTime eventTime;
        private double latitude;
        private double longitude;
        private List<String> members;
        private List<String> tags;

}
