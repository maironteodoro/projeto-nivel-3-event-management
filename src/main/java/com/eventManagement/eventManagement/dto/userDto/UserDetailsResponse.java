package com.eventManagement.eventManagement.dto.userDto;

import com.eventManagement.eventManagement.entity.enums.UserEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsResponse {

    private Long id;
    private String userName;
    private UserEnum role;
    private String password;
    private Boolean active;
}
