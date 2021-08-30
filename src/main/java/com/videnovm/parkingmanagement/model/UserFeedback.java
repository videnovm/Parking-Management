package com.videnovm.parkingmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class UserFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parkingSeqGenFeedback")
    @SequenceGenerator(name="parkingSeqGenFeedback", sequenceName = "parking_sequence_Feedback", allocationSize = 1)
    private Long id;

    @CreationTimestamp
    private Date feedbackLeftDate;

    @Column(nullable = false)
    private String feedback;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long parkingId;
}
