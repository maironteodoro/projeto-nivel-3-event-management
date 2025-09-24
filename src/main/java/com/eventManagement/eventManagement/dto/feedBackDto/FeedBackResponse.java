package com.eventManagement.eventManagement.dto.feedBackDto;


import lombok.AllArgsConstructor;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class FeedBackResponse {


    private Long id;
    private Long rating;
    private String comment;
    private LocalDateTime createdAt;
}
