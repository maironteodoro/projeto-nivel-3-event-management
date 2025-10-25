package com.eventManagement.mapper;


import com.eventManagement.eventManagement.dto.userDto.CreateUserRequest;
import com.eventManagement.eventManagement.dto.userDto.UpdateUserRequest;
import com.eventManagement.eventManagement.dto.userDto.UserDetailsResponse;
import com.eventManagement.eventManagement.dto.userDto.UserResponse;
import com.eventManagement.eventManagement.entity.User;
import com.eventManagement.eventManagement.entity.enums.UserEnum;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserResponse toResponse(User user);


    @Mapping(target = "role", expression = "java(userEnum)")
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(createUserRequest.getPassword()))")
    User toEntity(CreateUserRequest createUserRequest, @Context PasswordEncoder passwordEncoder, UserEnum userEnum);


    UserDetailsResponse toDetails(User user);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(UpdateUserRequest userRequest, @MappingTarget User user);
}
