package com.eventManagement.eventManagement.dto.feedBackDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFeedBackRequest {

    private Long id;
    private Long rating;
    private String comment;
}
