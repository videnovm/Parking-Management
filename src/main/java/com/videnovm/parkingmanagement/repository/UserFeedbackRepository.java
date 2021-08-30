package com.videnovm.parkingmanagement.repository;

import com.videnovm.parkingmanagement.model.UserFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFeedbackRepository extends JpaRepository<UserFeedback, Long> {
}
