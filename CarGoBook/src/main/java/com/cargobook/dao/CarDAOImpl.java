package com.cargobook.dao;

import com.cargobook.exception.CarNotFoundException;
import com.cargobook.model.Car;
import com.cargobook.util.ConnectionManager;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CarDAOImpl implements CarDAO {
    @Override
    public void addCar(Car car) {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
        }
    }

    @Override
    public void updateCar(Car car) {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            em.getTransaction().begin();
            em.merge(car);
            em.getTransaction().commit();
        }
    }

    @Override
    public void deleteCar(Long carId) throws CarNotFoundException {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            Car car = em.find(Car.class, carId);
            if (car == null) {
                throw new CarNotFoundException("Car not found with ID: " + carId);
            }
            em.getTransaction().begin();
            em.remove(car);
            em.getTransaction().commit();
        }
    }

    @Override
    public Car findCarById(Long carId) throws CarNotFoundException {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            Car car = em.find(Car.class, carId);
            if (car == null) {
                throw new CarNotFoundException("Car not found with ID: " + carId);
            }
            return car;
        }
    }

    @Override
    public List<Car> getAllCars() {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            return em.createQuery("SELECT c FROM Car c", Car.class).getResultList();
        }
    }

    @Override
    public List<Car> getCarsByAvailability(boolean availability) {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            return em.createQuery("SELECT c FROM Car c WHERE c.availability = :availability", Car.class)
                    .setParameter("availability", availability)
                    .getResultList();
        }
    }
}