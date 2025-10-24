package com.eventManagement.eventManagement.dto.feedBackDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackResponse {


    private Long id;
    private Long rating;
    private String comment;
    private LocalDateTime createdAt;
}
