package com.eventManagement.eventManagement.dto.eventDto;


import com.eventManagement.eventManagement.entity.Category;
import com.eventManagement.eventManagement.entity.enums.EventEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@Getter
@AllArgsConstructor
public class EventResponse {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private EventEnum status;
    private Integer capacity;
    private List<Category>categories;
}
