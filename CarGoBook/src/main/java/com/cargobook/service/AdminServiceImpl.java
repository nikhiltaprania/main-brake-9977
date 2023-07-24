package com.cargobook.service;

import com.cargobook.dao.*;
import com.cargobook.exception.BookingNotFoundException;
import com.cargobook.exception.CarNotFoundException;
import com.cargobook.model.Booking;
import com.cargobook.model.Car;
import com.cargobook.model.Report;

import java.time.LocalDate;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private final CarDAO carDAO = new CarDAOImpl();
    private final BookingDAO bookingDAO = new BookingDAOImpl();
    private final ReportDAO reportDAO = new ReportDAOImpl();

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
    public void confirmBooking(Long bookingId) throws BookingNotFoundException {
        Booking booking = bookingDAO.findBookingById(bookingId);
        booking.setConfirmed(true);
        bookingDAO.updateBooking(booking);
    }

    @Override
    public void rejectBooking(Long bookingId) throws BookingNotFoundException {
        Booking booking = bookingDAO.findBookingById(bookingId);
        booking.setConfirmed(false);
        bookingDAO.updateBooking(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

    @Override
    public List<Report> generateReports(LocalDate startDate, LocalDate endDate) {
        return reportDAO.getReportsByDateRange(startDate, endDate);
    }
}