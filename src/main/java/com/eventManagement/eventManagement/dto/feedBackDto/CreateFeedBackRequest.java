package com.eventManagement.eventManagement.dto.feedBackDto;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateFeedBackRequest{

private Long rating;
private String comment;
private Long authorId;

private Long eventId;

public Long getAuthorId() {
    return this.authorId;
     }
     public Long getEventId() {
        return this.eventId;
    }

}
