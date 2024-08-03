package com.example.user_service.mapper;

import com.example.userservice.model.User;
import com.example.apidefinitions.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);
}
