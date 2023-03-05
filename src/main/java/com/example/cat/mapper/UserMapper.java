package com.example.cat.mapper;


import com.example.cat.dto.UserDto;
import com.example.cat.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring", uses = {EventMapper.class})
public interface UserMapper {

//    UserDto userToUserDto(User user);

//    List<UserDto> usersToUsersDto(List<User> users);
}
