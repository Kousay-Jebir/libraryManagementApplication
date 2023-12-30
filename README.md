# Library Management Application

## Overview

The Library Management Application is a Java-based system designed to efficiently manage books, users, and library administration. The application follows Object-Oriented Programming (OOP) principles to provide a modular and maintainable structure. It includes features such as book check-out, return, viewing, and advanced operations for administrators.

## Folder Structure

The project follows a clean and organized folder structure:

- **src/main/java/com/library/model**: Contains classes representing the core model of the application.
- **src/main/java/com/library/service**: Contains services for library and stock management.
- **src/main/java/com/library/ui**: Contains the interactive menu and application entry point.

## Design Decisions

### Object-Oriented Design

The application adopts OOP principles, including inheritance, encapsulation, and polymorphism, to model entities such as books, users, and administrators. This design promotes code reuse, modularity, and a clear representation of real-world entities.

### Separation of Concerns

The code is organized into distinct packages for models, services, and the user interface. This separation of concerns enhances maintainability by isolating different aspects of the application.

## OOP Implementation

### Book and BookDatabase

- The `Book` class represents a book with attributes such as title, author, ISBN, and checked-out status.
- The `BookDatabase` class simulates a database-like system for storing books with additional functionality for book management.

### User and Admin

- The `User` class represents a regular user with a username and password.
- The `Admin` class extends the `User` class and introduces additional methods for administrative functionalities.

### LibraryService

- Manages advanced library operations, including book check-out, return, and user authentication.
- Utilizes the `BookDatabase` for efficient book management.

### Menu

- Provides an interactive menu for users to perform various actions.
- Customized for regular users and administrators, displaying different options based on the user's role.

## Features Implementation

### Authentication

- Users need to authenticate before accessing certain actions, ensuring security and user-specific functionality.

### BookDatabase

- Introduces a database-like system for storing books with a checked-out status.
- Supports functionalities such as adding, removing, and querying books.

### LibraryService

- Manages the check-out and return of books, including user authentication.
- Provides functionalities for retrieving all books, checked-out books, and library statistics.

## Interactive Menu

The interactive menu provides users with the following options:

1. **Check Out a Book**: Allows users to check out a book after authentication.
2. **Return a Book**: Enables users to return a previously checked-out book.
3. **View All Books**: Displays a list of all books in the library.
4. **View Checked Out Books**: Shows a list of currently checked-out books.
5. **View Library Statistics**: Provides statistics such as total books and available books.
6. **Exit**: Exits the application.

Additional options for administrators:

7. **Add Book to Database**: Adds a new book to the library database.
8. **Remove Book from Database**: Removes a book from the library database.

Choose the option by entering the corresponding number.

Feel free to expand upon and modify the code based on your specific requirements. This is a starting point for a feature-rich library management application.
