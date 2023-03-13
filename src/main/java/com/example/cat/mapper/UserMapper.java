package com.example.cat.mapper;

import com.example.cat.dto.Member;
import com.example.cat.dto.UserDto;
import com.example.cat.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EventMapper.class, TagMapper.class})
public interface UserMapper {

    UserDto userToUserDto(User user);

    Member userToMember(User user);
}
