package com.cargobook.userInterface;

import com.cargobook.exception.BookingNotFoundException;
import com.cargobook.exception.CarNotFoundException;
import com.cargobook.model.Booking;
import com.cargobook.model.Car;
import com.cargobook.model.Report;
import com.cargobook.service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AdminUI {
    private static final CarService carService = new CarServiceImpl();
    private static final BookingService bookingService = new BookingServiceImpl();
    private static final AdminService adminService = new AdminServiceImpl();
    private static final ReportService reportService = new ReportServiceImpl();
    private static final Scanner sc = new Scanner(System.in);

    public static void adminLogin() {
        System.out.println("\n===== Admin Login =====");
        System.out.print("Enter your username: ");
        String username = sc.next();

        // Password for admin is hardcoded as "admin"
        System.out.print("Enter your password: ");
        String password = sc.next();

        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("Admin login successful!");
            showAdminMenu();
        } else {
            System.out.println("Incorrect username or password. Please try again.");
        }
    }

    private static void showAdminMenu() {
        while (true) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Add Car");
            System.out.println("2. Update Car Details");
            System.out.println("3. Delete Car");
            System.out.println("4. Confirm Booking");
            System.out.println("5. Reject Booking");
            System.out.println("6. View All Bookings");
            System.out.println("7. Generate Reports");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            switch (sc.nextInt()) {
                case 1 -> addCar();
                case 2 -> updateCar();
                case 3 -> deleteCar();
                case 4 -> confirmBooking();
                case 5 -> rejectBooking();
                case 6 -> viewAllBookings();
                case 7 -> generateReports();
                case 0 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCar() {
        System.out.println("\n===== Add Car =====");
        System.out.print("Enter car model: ");
        String carModel = sc.nextLine();
        sc.nextLine();

        System.out.print("Enter car brand: ");
        String brand = sc.nextLine();

        System.out.print("Enter car price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Is the car available? (true/false): ");
        boolean availability = sc.nextBoolean();
        sc.nextLine();

        Car car = new Car();
        car.setCarModel(carModel);
        car.setBrand(brand);
        car.setPrice(price);
        car.setAvailability(availability);

        carService.addCar(car);
        System.out.println("Car added successfully!");
    }

    private static void updateCar() {
        System.out.println("\n===== Update Car Details =====");
        System.out.print("Enter the ID of the car to update: ");
        Long carId = sc.nextLong();
        sc.nextLine();

        try {
            Car car = carService.getCarById(carId);

            System.out.print("Enter new car model: ");
            String carModel = sc.nextLine();

            System.out.print("Enter new car brand: ");
            String brand = sc.nextLine();

            System.out.print("Enter new car price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.print("Is the car available? (true/false): ");
            boolean availability = sc.nextBoolean();
            sc.nextLine();

            car.setCarModel(carModel);
            car.setBrand(brand);
            car.setPrice(price);
            car.setAvailability(availability);

            carService.updateCar(car);
            System.out.println("Car details updated successfully!");
        } catch (CarNotFoundException e) {
            System.out.println("Car not found with ID: " + carId);
        }
    }

    private static void deleteCar() {
        System.out.println("\n===== Delete Car =====");
        System.out.print("Enter the ID of the car to delete: ");
        Long carId = sc.nextLong();
        sc.nextLine();

        try {
            carService.deleteCar(carId);
            System.out.println("Car deleted successfully!");
        } catch (CarNotFoundException e) {
            System.out.println("Car not found with ID: " + carId);
        }
    }

    private static void confirmBooking() {
        System.out.println("\n===== Confirm Booking =====");
        System.out.print("Enter the ID of the booking to confirm: ");
        Long bookingId = sc.nextLong();
        sc.nextLine();

        try {
            adminService.confirmBooking(bookingId);
            System.out.println("Booking confirmed successfully!");
        } catch (BookingNotFoundException e) {
            System.out.println("Booking not found with ID: " + bookingId);
        }
    }

    private static void rejectBooking() {
        System.out.println("\n===== Reject Booking =====");
        System.out.print("Enter the ID of the booking to reject: ");
        Long bookingId = sc.nextLong();
        sc.nextLine();

        try {
            adminService.rejectBooking(bookingId);
            System.out.println("Booking rejected successfully!");
        } catch (BookingNotFoundException e) {
            System.out.println("Booking not found with ID: " + bookingId);
        }
    }

    private static void viewAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();

        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            System.out.println("\n===== All Bookings =====");
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    private static void generateReports() {
        System.out.println("\n===== Generate Reports =====");
        System.out.print("Enter start date (yyyy-MM-dd): ");
        String startDateStr = sc.next();
        LocalDate startDate = LocalDate.parse(startDateStr);

        System.out.print("Enter end date (yyyy-MM-dd): ");
        String endDateStr = sc.next();
        LocalDate endDate = LocalDate.parse(endDateStr);

        List<Report> reports = reportService.generateReports(startDate, endDate);

        if (reports.isEmpty()) {
            System.out.println("No reports found for the specified date range.");
        } else {
            System.out.println("\n===== Reports =====");
            for (Report report : reports) {
                System.out.println(report);
            }
        }
    }
}