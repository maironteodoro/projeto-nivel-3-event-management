package com.eventManagement.eventManagement.dto.categoryDto;


import com.eventManagement.eventManagement.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CategoryResponse {

    private Long id;
    private String name;


}
