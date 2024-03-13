# Library Management System

## Brief Description
This Java application serves as a Library Management System, allowing librarians to perform various tasks, including managing books, users, and handling book transactions. The application supports features such as adding books and users, checking out and returning books, displaying books, and searching for books by title or author.

## Project Structure
The project is organized into three main classes:
1. **Book Class**: Represents the attributes and methods related to a book, such as book ID, title, author, genre, and availability status.
2. **User Class**: Defines the attributes and methods for a user, including user ID, name, contact information, and a list of borrowed books.
3. **Library Class**: Manages the library system, storing books and users. It provides methods for adding new books and users, handling book transactions, and searching for books.

## Prerequisites
To run this project locally, you need the following:
- Java Development Kit (JDK) installed on your machine.
- A Java IDE (Integrated Development Environment) such as IntelliJ IDEA or Eclipse.

## Setup and Running
Open the project in your Java IDE.

Run the LibraryManagementSystem class as the main entry point.

## Key Features and Functionalities Implemented
Adding Books and Users: Librarians can add new books and users to the system, preventing duplicate entries.
Checking Out and Returning Books: Users can check out books, and librarians can process returns. The system tracks book availability.
Displaying Books: Librarians can view the list of available books in the library.
Searching for Books: Librarians can search for books by title or author, providing a convenient way to find specific books.

## File Handling
The application implements simple file-based data persistence to store book and user information between runs. The data is saved to and loaded from a file (library_data.txt).

## Error Handling
The application includes error handling to gracefully handle invalid user inputs and edge cases.
