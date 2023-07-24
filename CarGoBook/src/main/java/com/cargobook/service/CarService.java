package com.cargobook.service;

import com.cargobook.exception.CarNotFoundException;
import com.cargobook.model.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);

    void updateCar(Car car);

    void deleteCar(Long carId) throws CarNotFoundException;

    Car getCarById(Long carId) throws CarNotFoundException;

    List<Car> getAllCars();

    List<Car> getCarsByAvailability(boolean availability);
}