package com.videnovm.parkingmanagement.mapper;

import com.videnovm.parkingmanagement.dto.UserFeedbackDto;
import com.videnovm.parkingmanagement.model.UserFeedback;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserFeedbackMapper {

    @IterableMapping(qualifiedByName = "toUserFeedbackDto")
    List<UserFeedbackDto> toUserFeedbackDtos(List<UserFeedback> UserFeedbacks);

    @Named("toUserFeedback")
    UserFeedback toUserFeedback(UserFeedbackDto UserFeedbackDto);

    @Named("toUserFeedbackDto")
    UserFeedbackDto toUserFeedbackDto(UserFeedback UserFeedback);
}
