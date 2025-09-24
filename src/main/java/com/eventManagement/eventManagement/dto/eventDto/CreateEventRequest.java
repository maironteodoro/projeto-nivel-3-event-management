package com.eventManagement.eventManagement.dto.eventDto;


import com.eventManagement.eventManagement.entity.enums.EventEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CreateEventRequest {

    @NotNull
    private String title;

    private String description;
   @NotNull
    private LocalDateTime startDate;
   @NotNull
   private LocalDateTime endDate;
   private EventEnum status;

   @NotNull
   private  Integer capacity;


}
