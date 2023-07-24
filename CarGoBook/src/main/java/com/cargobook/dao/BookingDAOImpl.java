package com.cargobook.dao;

import com.cargobook.exception.BookingNotFoundException;
import com.cargobook.model.Booking;
import com.cargobook.util.ConnectionManager;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class BookingDAOImpl implements BookingDAO {
    @Override
    public void addBooking(Booking booking) {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(booking);
            em.getTransaction().commit();
        }
    }

    @Override
    public void updateBooking(Booking booking) {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            em.getTransaction().begin();
            em.merge(booking);
            em.getTransaction().commit();
        }
    }

    @Override
    public void deleteBooking(Long bookingId) throws BookingNotFoundException {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            Booking booking = em.find(Booking.class, bookingId);
            if (booking == null) {
                throw new BookingNotFoundException("Booking not found with ID: " + bookingId);
            }
            em.getTransaction().begin();
            em.remove(booking);
            em.getTransaction().commit();
        }
    }

    @Override
    public Booking findBookingById(Long bookingId) throws BookingNotFoundException {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            Booking booking = em.find(Booking.class, bookingId);
            if (booking == null) {
                throw new BookingNotFoundException("Booking not found with ID: " + bookingId);
            }
            return booking;
        }
    }

    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            return em.createQuery("SELECT b FROM Booking b WHERE b.user.id = :userId", Booking.class)
                    .setParameter("userId", userId)
                    .getResultList();
        }
    }

    @Override
    public List<Booking> getBookingsByCar(Long carId) {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            return em.createQuery("SELECT b FROM Booking b WHERE b.car.id = :carId", Booking.class)
                    .setParameter("carId", carId)
                    .getResultList();
        }
    }

    @Override
    public List<Booking> getBookingsByDateRange(LocalDate startDate, LocalDate endDate) {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            return em.createQuery("SELECT b FROM Booking b WHERE b.startDate >= :startDate AND b.endDate <= :endDate", Booking.class)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .getResultList();
        }
    }

    @Override
    public List<Booking> getAllBookings() {
        try (EntityManager em = ConnectionManager.getEntityManager()) {
            return em.createQuery("SELECT b FROM Booking b", Booking.class).getResultList();
        }
    }
}