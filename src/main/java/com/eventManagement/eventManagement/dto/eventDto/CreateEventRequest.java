package com.eventManagement.eventManagement.dto.eventDto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class EventRequest {

    @NotNull
    private String title;
    private String description;
   @NotNull
    private LocalDateTime startDate;
   @NotNull
   private LocalDateTime endDate;

}
