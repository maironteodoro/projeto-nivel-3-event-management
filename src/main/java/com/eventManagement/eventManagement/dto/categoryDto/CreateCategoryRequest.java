package com.eventManagement.eventManagement.dto.categoryDto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateCategoryRequest {

    @NotBlank(message = "O nome da categoria é obrigatório.")
    private String name;


}
