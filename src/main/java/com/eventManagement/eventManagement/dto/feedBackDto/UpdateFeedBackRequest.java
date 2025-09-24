package com.eventManagement.eventManagement.dto.feedBackDto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateFeedBackRequest {

    private Long id;
    private Long rating;
    private String comment;
}
