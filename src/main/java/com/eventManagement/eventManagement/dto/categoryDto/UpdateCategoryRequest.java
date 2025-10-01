package com.eventManagement.eventManagement.dto.categoryDto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateCategoryRequest {

    private Long id;
    private String name;
}
