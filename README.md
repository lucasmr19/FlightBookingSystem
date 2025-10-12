# Flight Booking System

## Overview

This project is a flight booking system developed in Java. It allows users to book flights, manage reservations, and handle various airline-related operations. The system includes several classes such as `Airplane`, `Airport`, `Flight`, `OneWayFlight`, `Ticket`, and more to represent different aspects of the booking process.

## Class Diagram

The following diagram illustrates the main classes and their relationships within the system:

![Class Diagram](https://github.com/lucasmr19/FlightBookingSystem/blob/main/diagrams/class_diagram.jpg?raw=true)

*(Figure 1: System class structure)*

---

## Features

* **Flight Management**: Add, remove, and update flight details.
* **Reservation System**: Book, cancel, and view flight reservations.
* **User Management**: Handle user registration, login, and session management.
* **Payment Processing**: Integrate different payment methods like credit cards and PayPal.
* **Seat Management**: Assign seats and manage seat availability.
* **Flight Status**: Check and update the status of flights.

---

## Classes

* **Airplane**: Represents an airplane with its properties and methods.
* **Airport**: Represents an airport with its details.
* **Flight**: Manages flight information.
* **OneWayFlight**: Extends the `Flight` class for one-way trips.
* **Ticket**: Manages ticket details and passenger information.
* **Passenger**: Represents a passenger with relevant details.
* **Payment**: Handles payment processing for reservations.
* **Reservation**: Manages flight reservations.

---

## Getting Started

### Prerequisites

* Java Development Kit (JDK) 8 or higher
* Any Java IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation

```bash
git clone https://github.com/lucasmr19/FlightBookingSystem.git
cd FlightBookingSystem
```

Open the project in your preferred Java IDE and build/run the application.

---

## Usage

1. **Add a new flight** using the `Flight` class.
2. **Book a flight** by creating a `Reservation` for a passenger.
3. **Process payment** using the `Payment` class.
4. **View reservations** with the `Reservation` class.

---

## Contributing

Contributions are welcome!
Please fork the repository and submit a pull request with your improvements. Ensure that all code follows the established style and includes appropriate tests.
