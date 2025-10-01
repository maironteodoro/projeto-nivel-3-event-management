package com.eventManagement.eventManagement.dto.eventDto;

import com.eventManagement.eventManagement.entity.Category;
import com.eventManagement.eventManagement.entity.enums.EventEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class UpdateEventRequest {


    private Long id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer capacity;
    private List<Long> categoriesIds;

}
