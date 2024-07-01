# Flight Booking System

## Overview

This project is a flight booking system developed in Java. It allows users to book flights, manage reservations, and handle various airline-related operations. The system includes several classes such as `Airplane`, `Airport`, `Flight`, `OneWayFlight`, `Ticket`, and more to represent different aspects of the booking process.

## Features

- **Flight Management**: Add, remove, and update flight details.
- **Reservation System**: Book, cancel, and view flight reservations.
- **User Management**: Handle user registration, login, and session management.
- **Payment Processing**: Integrate different payment methods like credit cards and PayPal.
- **Seat Management**: Assign seats and manage seat availability.
- **Flight Status**: Check and update the status of flights.

## Classes

- **Airplane**: Represents an airplane with its properties and methods.
- **Airport**: Represents an airport with its details.
- **Flight**: Manages flight information.
- **OneWayFlight**: Extends the `Flight` class for one-way trips.
- **Ticket**: Manages ticket details and passenger information.
- **Passenger**: Represents a passenger with relevant details.
- **Payment**: Handles payment processing for reservations.
- **Reservation**: Manages flight reservations.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. **Clone the repository:**
    ```bash
    git clone https://github.com/lucasmr19/FlightBookingSystem.git
    ```

2. **Navigate to the project directory:**
    ```bash
    cd FlightBookingSystem
    ```

3. **Open the project in your preferred Java IDE.**

4. **Build and run the project:**
    - Use your IDE's build and run features to compile and start the application.

## Usage

1. **Add a new flight:**
    - Use the `Flight` class to create a new flight object and add it to the system.

2. **Book a flight:**
    - Create a new `Reservation` object and associate it with a passenger and flight.

3. **Process payment:**
    - Use the `Payment` class to handle payment transactions.

4. **View reservations:**
    - Retrieve and display reservation details using the `Reservation` class.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes. Ensure your code follows the project's coding standards and includes appropriate tests.
