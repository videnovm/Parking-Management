package com.videnovm.parkingmanagement.service;

import com.videnovm.parkingmanagement.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User createUser(User user);
}
