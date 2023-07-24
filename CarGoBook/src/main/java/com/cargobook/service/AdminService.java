package com.cargobook.service;

import com.cargobook.exception.BookingNotFoundException;
import com.cargobook.exception.CarNotFoundException;
import com.cargobook.model.Booking;
import com.cargobook.model.Car;
import com.cargobook.model.Report;

import java.time.LocalDate;
import java.util.List;

public interface AdminService {
    void addCar(Car car);

    void updateCar(Car car);

    void deleteCar(Long carId) throws CarNotFoundException;

    void confirmBooking(Long bookingId) throws BookingNotFoundException;

    void rejectBooking(Long bookingId) throws BookingNotFoundException;

    List<Booking> getAllBookings();

    List<Report> generateReports(LocalDate startDate, LocalDate endDate);
}