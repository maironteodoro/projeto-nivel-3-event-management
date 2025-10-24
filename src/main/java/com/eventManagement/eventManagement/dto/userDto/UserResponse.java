package com.eventManagement.eventManagement.dto.userDto;

import com.eventManagement.eventManagement.entity.enums.UserEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserResponse {

    private Long id;
    private String userName;
    private UserEnum role;
    private Boolean active;


}
