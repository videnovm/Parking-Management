package com.videnovm.parkingmanagement.controller;

import com.videnovm.parkingmanagement.dto.UserFeedbackDto;
import com.videnovm.parkingmanagement.mapper.UserFeedbackMapper;
import com.videnovm.parkingmanagement.model.UserFeedback;
import com.videnovm.parkingmanagement.service.UserFeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Blacklist Controller")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserFeedbackController {

    @Autowired
    private final UserFeedbackService userFeedbackService;

    private final UserFeedbackMapper userFeedbackMapper;

    @ApiOperation(value = "Get all feedbacks", notes = "returns all feedbacks")
    @GetMapping("/feedback")
    public ResponseEntity<List<UserFeedbackDto>> getUserFeedback(){
        List<UserFeedback> feedback = userFeedbackService.getUserFeedback();
        return ResponseEntity.ok(userFeedbackMapper.toUserFeedbackDtos(feedback));
    }

    @ApiOperation(value = "Create a feedback", notes = "Creates a feedback and returns it")
    @PostMapping("/feedback")
    public ResponseEntity<UserFeedbackDto> createUserFeedback(@RequestBody UserFeedbackDto userFeedbackDto){
        try{
            UserFeedback createdUserFeedback = userFeedbackService.createUserFeedback(userFeedbackMapper.toUserFeedback(userFeedbackDto));
            return ResponseEntity.ok(userFeedbackMapper.toUserFeedbackDto(createdUserFeedback));
        } catch (ConstraintViolationException ex){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "Delete a feedback", notes = "Deletes a feedback by given id")
    @DeleteMapping("/feedback/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id){
        try{
            userFeedbackService.deleteUserFeedback(id);
        } catch (Exception ex) {
            return new ResponseEntity<>("Feedback not found by id: " + id, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Feedback successfully deleted by id: " + id, HttpStatus.OK);
    }
}