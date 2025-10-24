package com.eventManagement.mapper;

import com.eventManagement.eventManagement.dto.eventDto.CreateEventRequest;
import com.eventManagement.eventManagement.dto.eventDto.EventResponse;
import com.eventManagement.eventManagement.dto.eventDto.UpdateEventRequest;
import com.eventManagement.eventManagement.entity.Event;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventResponse toResponse(Event event);


    Event toEntity(CreateEventRequest eventRequest);



    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(UpdateEventRequest eventRequest, @MappingTarget Event event);
}
