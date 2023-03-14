package com.example.demo;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO UserToUserDTO(User user);
    User UserDTOToUser(User userDto);
}
