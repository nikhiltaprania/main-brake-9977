package com.cargobook.service;

import com.cargobook.exception.UserNotFoundException;
import com.cargobook.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId) throws UserNotFoundException;

    User getUserById(Long userId) throws UserNotFoundException;

    User getUserByUsername(String username) throws UserNotFoundException;

    List<User> getAllUsers();
}