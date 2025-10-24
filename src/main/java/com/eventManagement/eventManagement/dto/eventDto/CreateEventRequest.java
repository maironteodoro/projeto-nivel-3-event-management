package com.eventManagement.eventManagement.dto.eventDto;


import com.eventManagement.eventManagement.entity.enums.EventStateEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CreateEventRequest {

    @NotNull
    private String title;

    private String description;
   @NotNull
    private LocalDateTime startDate;
   @NotNull
   private LocalDateTime endDate;
   private EventStateEnum status;

   @NotNull
   private  Integer capacity;

   private List<Long> categoriesId;


}
