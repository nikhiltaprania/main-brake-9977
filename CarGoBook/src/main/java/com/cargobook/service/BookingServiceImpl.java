package com.cargobook.service;

import com.cargobook.dao.BookingDAO;
import com.cargobook.dao.BookingDAOImpl;
import com.cargobook.exception.BookingNotFoundException;
import com.cargobook.model.Booking;

import java.util.List;

public class BookingServiceImpl implements BookingService {
    private final BookingDAO bookingDAO = new BookingDAOImpl();

    @Override
    public void addBooking(Booking booking) {
        bookingDAO.addBooking(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingDAO.updateBooking(booking);
    }

    @Override
    public void deleteBooking(Long bookingId) throws BookingNotFoundException {
        bookingDAO.deleteBooking(bookingId);
    }

    @Override
    public Booking getBookingById(Long bookingId) throws BookingNotFoundException {
        return bookingDAO.findBookingById(bookingId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

    @Override
    public List<Booking> getBookingsByUser(Long userId) {
        return bookingDAO.getBookingsByUserId(userId);
    }
}