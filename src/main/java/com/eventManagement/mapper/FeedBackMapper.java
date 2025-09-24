package com.eventManagement.mapper;


import com.eventManagement.eventManagement.dto.eventDto.UpdateEventRequest;
import com.eventManagement.eventManagement.dto.feedBackDto.CreateFeedBackRequest;
import com.eventManagement.eventManagement.dto.feedBackDto.FeedBackResponse;
import com.eventManagement.eventManagement.dto.feedBackDto.UpdateFeedBackRequest;
import com.eventManagement.eventManagement.entity.Event;
import com.eventManagement.eventManagement.entity.FeedBack;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FeedBackMapper {

    FeedBackMapper INSTANCE = Mappers.getMapper(FeedBackMapper.class);

    @Mapping(target = "user.id", source = "authorId")
    @Mapping(target = "event.id", source = "eventId")
    FeedBack toEntity(CreateFeedBackRequest createFeedBackRequest);

    FeedBackResponse toResponse(FeedBack feedBack);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(UpdateFeedBackRequest feedBackRequest, @MappingTarget FeedBack feedBack);

}
