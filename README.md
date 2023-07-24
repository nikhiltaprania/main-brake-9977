# CarGoBook

![CarGoBook Logo](https://example.com/car_booking_logo.png)

The Car Booking Portal is an online platform designed to facilitate the process of booking cars for users. The portal provides users with the ability to register, log in, and browse available cars. Users can apply filters and sorting options to refine their search for car details. They can also book a car and view the status of their bookings. Additionally, an admin user has additional functionalities to manage car details, confirm or reject car bookings, and generate reports on bookings.

## Features

- User Registration: Users can register for an account by providing necessary information.
- User Login: Registered users can log in to the car booking portal using their credentials.
- Browse Available Cars: Users can view available cars with details such as car model, brand, price, and availability.
- Car Booking: Users can book a car by selecting the desired car and providing booking details.
- View Booking Status: Users can view the status of their car bookings, including confirmation or rejection status.
- Admin Functionality: Admin users can add new car details, update existing car details, and delete car details from the portal.
- Confirm or Reject Bookings: Admin users can confirm or reject car bookings made by users.
- Generate Reports: Admin users can generate reports on car bookings, including the number of bookings and revenue generated.

## Technologies Used

- Java
- Maven
- Jakarta (Java EE)
- Hibernate (ORM Framework)
- MySQL (Database)
- JPA (Java Persistence API)

## Getting Started

1. Clone the repository to your local machine.
2. Create a MySQL database and update the database configuration in the `persistence.xml` file.
3. Run the Maven project to build and deploy the application.
4. Launch the application and access it via the provided URL.

## Project Structure

car-booking-portal/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── carbookingportal/
│ │ │ ├── domain/
│ │ │ │ ├── Car.java
│ │ │ │ ├── User.java
│ │ │ │ ├── Booking.java
│ │ │ │ └── Report.java
│ │ │ ├── dao/
│ │ │ │ ├── CarDAO.java
│ │ │ │ ├── UserDAO.java
│ │ │ │ ├── BookingDAO.java
│ │ │ │ └── ReportDAO.java
│ │ │ ├── service/
│ │ │ │ ├── CarService.java
│ │ │ │ ├── UserService.java
│ │ │ │ ├── BookingService.java
│ │ │ │ ├── ReportService.java
│ │ │ │ └── AdminService.java
│ │ │ ├── util/
│ │ │ │ ├── ConnectionManager.java
│ │ │ │ └── EntityManagerUtil.java
│ │ │ └── MainApplication.java
│ │ └── resources/
│ │ └── META-INF/
│ │ └── persistence.xml
│ └── test/
│ └── java/
│ └── com/
│ └── carbookingportal/
│ └── TestCases.java
├── pom.xml
├── LICENSE
└── README.md


## Usage

1. Sign up as a new user or log in with your existing credentials.
2. Browse available cars, apply filters and sorting options to find your desired car.
3. Book a car by selecting the car and providing booking details.
4. View your booking status to check if it's confirmed or rejected.
5. Admin users can log in using the provided admin credentials to access admin functionalities.
6. Admin users can manage car details, confirm or reject bookings, and generate reports.

## Contributors

- [Nikhil Kumar](https://github.com/nikhiltaprania)

## License

This project is licensed under the Masai School License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

This is an individual project and in the beta stage.