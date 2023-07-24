package com.cargobook.userInterface;

import com.cargobook.exception.CarNotFoundException;
import com.cargobook.exception.UserNotFoundException;
import com.cargobook.model.Booking;
import com.cargobook.model.Car;
import com.cargobook.model.User;
import com.cargobook.service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainUI {
    private static final UserService userService = new UserServiceImpl();
    private static final CarService carService = new CarServiceImpl();
    private static final BookingService bookingService = new BookingServiceImpl();
    private static final Scanner sc = new Scanner(System.in);

    public static void runApplication() {
        System.out.println("\nWelcome to the CarGoBook !");

        while (true) {
            showMenu();
            switch (sc.nextInt()) {
                case 1 -> userSignup();
                case 2 -> userLogin();
                case 3 -> AdminUI.adminLogin();
                case 4 -> {
                    System.out.println("Thank you for using the Car Booking Portal. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. User Signup");
        System.out.println("2. User Login");
        System.out.println("3. Admin Login");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void userSignup() {
        System.out.println("\n===== User Signup =====");
        System.out.print("Enter your username: ");
        String username = sc.next();

        System.out.print("Enter your password: ");
        String password = sc.next();

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);

        userService.addUser(newUser);
        System.out.println("User signed up successfully!");
    }

    private static void userLogin() {
        System.out.println("\n===== User Login =====");
        System.out.print("Enter your username: ");
        String username = sc.next();

        System.out.print("Enter your password: ");
        String password = sc.next();

        try {
            User user = userService.getUserByUsername(username);

            if (user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                showUserMenu(user);
            } else {
                System.out.println("Incorrect password. Please try again.");
            }
        } catch (UserNotFoundException e) {
            System.out.println("User not found. Please try again or register as a new user.");
        }
    }

    private static void showUserMenu(User user) {
        while (true) {
            System.out.println("\n===== User Menu =====");
            System.out.println("Hello, " + user.getUsername() + "!");
            System.out.println("1. Browse Cars");
            System.out.println("2. Book a Car");
            System.out.println("3. View My Bookings");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            switch (sc.nextInt()) {
                case 1 -> browseCars();
                case 2 -> bookCar(user);
                case 3 -> viewUserBookings(user.getId());
                case 0 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void browseCars() {
        List<Car> cars = carService.getAllCars();

        if (cars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            System.out.println("\n===== Available Cars =====");
            for (Car car : cars) {
                System.out.println(car);
            }
        }
    }

    private static void bookCar(User user) {
        browseCars();
        System.out.print("Enter the ID of the car you want to book: ");
        Long carId = sc.nextLong();
        sc.nextLine(); // Consume the newline character

        System.out.print("Enter start date (yyyy-MM-dd): ");
        String startDateStr = sc.nextLine();
        LocalDate startDate = LocalDate.parse(startDateStr);

        System.out.print("Enter end date (yyyy-MM-dd): ");
        String endDateStr = sc.nextLine();
        LocalDate endDate = LocalDate.parse(endDateStr);

        try {
            Car car = carService.getCarById(carId);
            Booking booking = new Booking();
            booking.setUser(user);
            booking.setCar(car);
            booking.setStartDate(startDate);
            booking.setEndDate(endDate);
            booking.setConfirmed(false);

            bookingService.addBooking(booking);
            System.out.println("Car booking successful!");
        } catch (CarNotFoundException e) {
            System.out.println("Car not found with ID: " + carId);
        } catch (Exception e) {
            System.out.println("Booking conflict. The car is not available for the selected dates.");
        }
    }

    private static void viewUserBookings(Long userId) {
        List<Booking> bookings = bookingService.getBookingsByUser(userId);

        if (bookings.isEmpty()) {
            System.out.println("You have no bookings.");
        } else {
            System.out.println("\n===== Your Bookings =====");
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }
}