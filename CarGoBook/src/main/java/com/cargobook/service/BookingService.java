package com.cargobook.service;

import com.cargobook.exception.BookingNotFoundException;
import com.cargobook.model.Booking;

import java.util.List;

public interface BookingService {
    void addBooking(Booking booking);

    void updateBooking(Booking booking);

    void deleteBooking(Long bookingId) throws BookingNotFoundException;

    Booking getBookingById(Long bookingId) throws BookingNotFoundException;

    List<Booking> getAllBookings();

    List<Booking> getBookingsByUser(Long userId);
}