// LibraryManagementSystem.java
// LibraryManagementSystem class serves as the entry point for the program

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static Library library;                             // Instance of the Library class
    private static Scanner scanner = new Scanner(System.in);    // Scanner for user input

    // Main method - Entry point of the Library Management System
    public static void main(String[] args) {
        library = new Library();

        // Display menu and execute user choices in a loop until the user chooses to exit
        System.out.println("\nWelcome to Library Management System");
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();
            executeChoice(choice);
        } while (choice != 7);

        // Save data to file before exiting
        library.saveDataToFile();
        System.out.println("Exiting Library Management System. Data saved.");
    }

    // Methods for displaying menu, getting user choice, and executing user choices
    private static void displayMenu() {
        System.out.println("\nSystem Menu:");
        System.out.println("1. Add Book");
        System.out.println("2. Add User");
        System.out.println("3. Display Books");
        System.out.println("4. Check Out Book");
        System.out.println("5. Return Book");
        System.out.println("6. Search Book by Title or Author");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
        } catch (Exception e) {
            choice = -1; // invalid choice
        }
        return choice;
    }

    private static void executeChoice(int choice) {
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                addUser();
                break;
            case 3:
                displayBooks();
                break;
            case 4:
                checkOutBook();
                break;
            case 5:
                returnBook();
                break;
            case 6:
                searchBooks();
                break;
            case 7:
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    // Methods for adding books, users, displaying books, checking out and returning books, and searching
    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int bookID = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();

        Book newBook = new Book(bookID, title, author, genre);
        library.addBook(newBook);
    }

    private static void addUser() {
        System.out.print("Enter User ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Contact Information: ");
        String contactInfo = scanner.nextLine();

        User newUser = new User(userID, name, contactInfo);
        library.addUser(newUser);
    }

    private static void displayBooks() {
        System.out.println("\nLibrary Books:");
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }
    }

    private static void checkOutBook() {
        System.out.print("Enter User ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Enter Book ID to check out: ");
        int bookID = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        User user = findUser(userID);
        Book book = findBook(bookID);

        if (user != null && book != null) {
            library.checkOutBook(user, book);
        } else {
            System.out.println("User or Book not found.");
        }
    }

    private static void returnBook() {
        System.out.print("Enter User ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Enter Book ID to return: ");
        int bookID = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        User user = findUser(userID);
        Book book = findBook(bookID);

        if (user != null && book != null) {
            library.returnBook(user, book);
        } else {
            System.out.println("User or Book not found.");
        }
    }

    private static void searchBooks() {
        System.out.print("Enter the title or author to search for: ");
        String query = scanner.nextLine();

        ArrayList<Book> result = new ArrayList<>();
        result.addAll(library.searchBooksByTitle(query));
        result.addAll(library.searchBooksByAuthor(query));

        if (result.isEmpty()) {
            System.out.println("No books found matching the query: " + query);
        } else {
            System.out.println("Search results for books with title or author '" + query + "':");
            for (Book book : result) {
                System.out.println(book);
            }
        }
    }

    // Additional methods for finding users and books
    private static User findUser(int userID) {
        for (User user : library.getUsers()) {
            if (user.getUserID() == userID) {
                return user;
            }
        }
        return null;
    }

    private static Book findBook(int bookID) {
        for (Book book : library.getBooks()) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null;
    }
}