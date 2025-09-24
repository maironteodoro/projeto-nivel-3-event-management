package com.eventManagement.eventManagement.dto.feedBackDto;


import lombok.AllArgsConstructor;
import lombok.Getter;



 @Getter
 @AllArgsConstructor
public class CreateFeedBackRequest{

private Long rating;
private String comment;

private Long authorId;
private Long eventId;




}
