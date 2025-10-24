package com.eventManagement.mapper;

import com.eventManagement.eventManagement.dto.categoryDto.CategoryResponse;
import com.eventManagement.eventManagement.dto.categoryDto.CreateCategoryRequest;
import com.eventManagement.eventManagement.dto.categoryDto.UpdateCategoryRequest;
import com.eventManagement.eventManagement.dto.eventDto.UpdateEventRequest;
import com.eventManagement.eventManagement.entity.Category;
import com.eventManagement.eventManagement.entity.Event;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);




    Category toEntity (CreateCategoryRequest categoryRequest);

    CategoryResponse toResponse(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(UpdateCategoryRequest categoryRequest, @MappingTarget Category category);
}
