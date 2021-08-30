package com.videnovm.parkingmanagement.service.implementation;

import com.videnovm.parkingmanagement.model.UserFeedback;
import com.videnovm.parkingmanagement.repository.UserFeedbackRepository;
import com.videnovm.parkingmanagement.service.UserFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFeedbackServiceImpl implements UserFeedbackService {

    private UserFeedbackRepository userFeedbackRepository;

    @Autowired
    public void setUserFeedbackRepository(UserFeedbackRepository userFeedbackRepository){
        this.userFeedbackRepository = userFeedbackRepository;
    }

    @Override
    public List<UserFeedback> getUserFeedback() {
        return userFeedbackRepository.findAll();
    }

    @Override
    public UserFeedback createUserFeedback(UserFeedback userFeedback) {
        return userFeedbackRepository.save(userFeedback);
    }

    @Override
    public void deleteUserFeedback(Long id) {
        userFeedbackRepository.deleteById(id);
    }
}
