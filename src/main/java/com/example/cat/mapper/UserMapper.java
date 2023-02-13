package com.example.cat.mapper;


import com.example.cat.dto.UserDto;
import com.example.cat.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring", uses = {EventMapper.class})
public interface UserMapper {

    @Named("userToUserDto")
    UserDto userToUserDto(User user);

    @Named("userDtoToUser")
    User userDtoToUser(UserDto userDto);

    @IterableMapping(qualifiedByName = "userToUserDto")
    List<UserDto> usersToUsersDto(List<User> users);

    @IterableMapping(qualifiedByName = "userDtoToUser")
    List<User> usersDtoToUsers(List<UserDto> usersDto);

}
