package com.videnovm.parkingmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFeedbackDto {

    private Long id;

    private Date feedbackLeft;

    private String feedback;

    private Long userId;

    private Long parkingId;

}
