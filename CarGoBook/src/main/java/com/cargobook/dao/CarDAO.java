package com.cargobook.dao;

import com.cargobook.exception.CarNotFoundException;
import com.cargobook.model.Car;

import java.util.List;

public interface CarDAO {
    void addCar(Car car);

    void updateCar(Car car);

    void deleteCar(Long carId) throws CarNotFoundException;

    Car findCarById(Long carId) throws CarNotFoundException;

    List<Car> getAllCars();

    List<Car> getCarsByAvailability(boolean availability);
}