package com.videnovm.parkingmanagement.mapper;

import com.videnovm.parkingmanagement.dto.UserDto;
import com.videnovm.parkingmanagement.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @IterableMapping(qualifiedByName = "toUserDto")
    List<UserDto> toUserDtos(List<User> users);

    @Named("toUser")
    User toUser(UserDto userDto);

    @Named("toUserDto")
    UserDto toUserDto(User user);
}
