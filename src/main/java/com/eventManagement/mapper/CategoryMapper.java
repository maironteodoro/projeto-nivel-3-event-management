package com.eventManagement.mapper;

import com.eventManagement.eventManagement.dto.categoryDto.CategoryResponse;
import com.eventManagement.eventManagement.dto.categoryDto.CreateCategoryRequest;
import com.eventManagement.eventManagement.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toEntity (CreateCategoryRequest categoryRequest);

    CategoryResponse toResponse(Category category);

}
