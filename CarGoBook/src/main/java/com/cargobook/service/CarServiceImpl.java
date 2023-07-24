package com.cargobook.service;

import com.cargobook.dao.CarDAO;
import com.cargobook.dao.CarDAOImpl;
import com.cargobook.exception.CarNotFoundException;
import com.cargobook.model.Car;

import java.util.List;

public class CarServiceImpl implements CarService {
    private final CarDAO carDAO = new CarDAOImpl();

    @Override
    public void addCar(Car car) {
        carDAO.addCar(car);
    }

    @Override
    public void updateCar(Car car) {
        carDAO.updateCar(car);
    }

    @Override
    public void deleteCar(Long carId) throws CarNotFoundException {
        carDAO.deleteCar(carId);
    }

    @Override
    public Car getCarById(Long carId) throws CarNotFoundException {
        return carDAO.findCarById(carId);
    }

    @Override
    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    @Override
    public List<Car> getCarsByAvailability(boolean availability) {
        return carDAO.getCarsByAvailability(availability);
    }
}