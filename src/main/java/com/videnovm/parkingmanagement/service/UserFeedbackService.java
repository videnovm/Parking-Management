package com.videnovm.parkingmanagement.service;

import com.videnovm.parkingmanagement.model.UserFeedback;

import java.util.List;

public interface UserFeedbackService {
    List<UserFeedback> getUserFeedback();
    UserFeedback createUserFeedback(UserFeedback userFeedback);
    void deleteUserFeedback(Long id);
}
