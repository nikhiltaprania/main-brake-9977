package com.cargobook.dao;

import com.cargobook.exception.BookingNotFoundException;
import com.cargobook.model.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingDAO {
    void addBooking(Booking booking);

    void updateBooking(Booking booking);

    void deleteBooking(Long bookingId) throws BookingNotFoundException;

    Booking findBookingById(Long bookingId) throws BookingNotFoundException;

    List<Booking> getBookingsByUserId(Long userId);

    List<Booking> getBookingsByCar(Long carId);

    List<Booking> getBookingsByDateRange(LocalDate startDate, LocalDate endDate);

    List<Booking> getAllBookings();
}