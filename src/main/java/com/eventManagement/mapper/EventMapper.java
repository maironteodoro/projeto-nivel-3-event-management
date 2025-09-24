package com.eventManagement.mapper;


import com.eventManagement.eventManagement.dto.eventDto.CreateEventRequest;
import com.eventManagement.eventManagement.dto.eventDto.EventResponse;
import com.eventManagement.eventManagement.dto.eventDto.UpdateEventRequest;
import com.eventManagement.eventManagement.dto.userDto.UpdateUserRequest;
import com.eventManagement.eventManagement.entity.Event;
import com.eventManagement.eventManagement.entity.User;
import com.eventManagement.eventManagement.service.EventService;
import com.sun.jdi.request.EventRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    EventResponse toResponse(Event event);


    Event toEntity(CreateEventRequest eventRequest);

    Event toEntity(EventRequest eventRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(UpdateEventRequest userRequest, @MappingTarget Event event);
}
