package com.cargobook.dao;

import com.cargobook.exception.UserNotFoundException;
import com.cargobook.model.User;
import com.cargobook.util.ConnectionManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public void addUser(User user) {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
    }

    @Override
    public void updateUser(User user) {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }
    }

    @Override
    public void deleteUser(Long userId) throws UserNotFoundException {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            User user = em.find(User.class, userId);
            if (user == null) {
                throw new UserNotFoundException("User not found with ID: " + userId);
            }
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }
    }

    @Override
    public User findUserById(Long userId) throws UserNotFoundException {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            User user = em.find(User.class, userId);
            if (user == null) {
                throw new UserNotFoundException("User not found with ID: " + userId);
            }
            return user;
        }
    }

    @Override
    public User findUserByUsername(String username) throws UserNotFoundException {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            User user;
            try {
                user = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                        .setParameter("username", username)
                        .getSingleResult();
            } catch (NoResultException e) {
                throw new UserNotFoundException("User not found with username: " + username, e.getCause());
            }
            return user;
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            return em.createQuery("SELECT u FROM User u", User.class).getResultList();
        }
    }
}