package com.eventManagement.eventManagement.dto.categoryDto;


import com.eventManagement.eventManagement.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryResponse {

    private Long id;
    private String name;


}
