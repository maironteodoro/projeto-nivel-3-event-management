package com.eventManagement.eventManagement.dto.eventDto;


import com.eventManagement.eventManagement.entity.Category;
import com.eventManagement.eventManagement.entity.enums.EventStateEnum;
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
public class EventResponse {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private EventStateEnum status;
    private Integer capacity;
    private List<Category>categories;
}
