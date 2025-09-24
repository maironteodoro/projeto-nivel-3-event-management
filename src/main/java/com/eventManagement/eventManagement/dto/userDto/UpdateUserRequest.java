package com.eventManagement.eventManagement.dto.userDto;

import com.eventManagement.eventManagement.entity.enums.UserEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@AllArgsConstructor
public class UpdateUserRequest {

    private Long id;
    private String userName;
    private UserEnum role;
    private String password;
    private Boolean active;


}
