package com.cargobook.service;

import com.cargobook.dao.UserDAO;
import com.cargobook.dao.UserDAOImpl;
import com.cargobook.exception.UserNotFoundException;
import com.cargobook.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDAO userDAO = new UserDAOImpl();

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(Long userId) throws UserNotFoundException {
        userDAO.deleteUser(userId);
    }

    @Override
    public User getUserById(Long userId) throws UserNotFoundException {
        return userDAO.findUserById(userId);
    }

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException {
        return userDAO.findUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}