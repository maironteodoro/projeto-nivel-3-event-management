package com.eventManagement.eventManagement.dto.registrationDto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class CreateRegistrationRequest {

    private LocalDateTime registrationAt;
    private Long userId ;
    private Long eventId;

}

