package com.example.cat.dto.response;

import com.example.cat.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserByIdResponse {
    private UserDto data;
}
