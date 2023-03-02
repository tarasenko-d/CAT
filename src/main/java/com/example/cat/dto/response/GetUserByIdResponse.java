package com.example.cat.dto.response;

import com.example.cat.dto.UserDto;
import lombok.Data;


@Data
public class GetUserByIdResponse {

    private UserDto userDto;
}
