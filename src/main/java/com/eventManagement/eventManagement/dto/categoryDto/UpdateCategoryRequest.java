package com.eventManagement.eventManagement.dto.categoryDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {

    private Long id;
    private String name;
}
