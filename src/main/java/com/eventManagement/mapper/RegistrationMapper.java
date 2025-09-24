package com.eventManagement.mapper;


import com.eventManagement.eventManagement.dto.registrationDto.CreateRegistrationRequest;
import com.eventManagement.eventManagement.dto.registrationDto.RegistrationResponse;
import com.eventManagement.eventManagement.entity.Registration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel =  "string")
public interface RegistrationMapper {

    RegistrationMapper INSTANCE = Mappers.getMapper(RegistrationMapper.class);

    Registration toEntity(CreateRegistrationRequest registrationRequest);

    RegistrationResponse toResponse(Registration registration);


}
