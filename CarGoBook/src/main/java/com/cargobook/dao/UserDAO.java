package com.cargobook.dao;

import com.cargobook.exception.UserNotFoundException;
import com.cargobook.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId) throws UserNotFoundException;

    User findUserById(Long userId) throws UserNotFoundException;

    User findUserByUsername(String username) throws UserNotFoundException;

    List<User> getAllUsers();
}