package com.eventManagement.mapper;


import com.eventManagement.eventManagement.dto.registrationDto.CreateRegistrationRequest;
import com.eventManagement.eventManagement.dto.registrationDto.RegistrationResponse;
import com.eventManagement.eventManagement.entity.Registration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel =  "spring")
public interface RegistrationMapper {



    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "event.id", source = "eventId")
    Registration toEntity(CreateRegistrationRequest registrationRequest);


    RegistrationResponse toResponse(Registration registration);


}
