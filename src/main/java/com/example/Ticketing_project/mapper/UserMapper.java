package com.example.Ticketing_project.mapper;

import com.example.Ticketing_project.DTO.UserDTO;
import com.example.Ticketing_project.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);

    User toEntity(UserDTO userDto);

    List<UserDTO> toDtoList(List<User> userList);

    List<User> toEntityList(List<UserDTO> userDtoList);
}
