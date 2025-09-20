package com.eventManagement.eventManagement.dto.userDto;

import com.eventManagement.eventManagement.entity.enums.UserEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class CreateUserResponse {

    private Long id;

    @NotNull
    private String userName;
    private UserEnum role;


}
