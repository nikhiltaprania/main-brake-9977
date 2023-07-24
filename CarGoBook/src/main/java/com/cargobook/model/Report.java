package com.cargobook.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    @Column(name = "number_of_bookings", nullable = false)
    private int numberOfBookings;
    @Column(name = "revenue_generated", nullable = false)
    private double revenueGenerated;

    public Report(LocalDate startDate, LocalDate endDate, int numberOfBookings, double revenueGenerated) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfBookings = numberOfBookings;
        this.revenueGenerated = revenueGenerated;
    }

    public Report() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getNumberOfBookings() {
        return numberOfBookings;
    }

    public void setNumberOfBookings(int numberOfBookings) {
        this.numberOfBookings = numberOfBookings;
    }

    public double getRevenueGenerated() {
        return revenueGenerated;
    }

    public void setRevenueGenerated(double revenueGenerated) {
        this.revenueGenerated = revenueGenerated;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", numberOfBookings=" + numberOfBookings +
                ", revenueGenerated=" + revenueGenerated +
                '}';
    }
}