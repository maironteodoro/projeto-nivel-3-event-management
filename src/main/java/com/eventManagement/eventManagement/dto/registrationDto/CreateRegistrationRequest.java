package com.eventManagement.eventManagement.dto.registrationDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CreateRegistrationRequest {

    private LocalDateTime registrationAt;
    private Long userId ;
    private Long eventId;

}

