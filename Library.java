import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private final String dataFilePath = "library_data.txt";
    private boolean dataLoaded;
    

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.dataLoaded = false;

        if (!dataLoaded) {
            loadDataFromFile();
            dataLoaded = true;
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addBook(Book book) {
        int bookID = book.getBookID();
        boolean bookExists = books.stream().anyMatch(b -> b.getBookID() == bookID);
    
        if (!bookExists) {
            books.add(book);
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Book with ID " + bookID + " already exists. Duplicate entry ignored.");
        }
    }
    
    public void addUser(User user) {
        int userID = user.getUserID();
        boolean userExists = users.stream().anyMatch(u -> u.getUserID() == userID);
    
        if (!userExists) {
            users.add(user);
            System.out.println("User added successfully!");
        } else {
            System.out.println("User with ID " + userID + " already exists. Duplicate entry ignored.");
        }
    }

    public void checkOutBook(User user, Book book) {
        if (book.getAvailability()) {
            user.getBorrowedBooks().add(book);
            book.setAvailable(false);
            System.out.println("Book checked out successfully!");
        } else {
            // Handle unavailable book
            System.out.println("Book not available for checkout.");
        }
    }

    public void returnBook(User user, Book book) {
        if (user.getBorrowedBooks().contains(book)) {
            user.getBorrowedBooks().remove(book);
            book.setAvailable(true);
            System.out.println("Book returned successfully!");
        } else {
            // Handle book not borrowed by the user
            System.out.println("User did not borrow this book.");
        }
    }

    public ArrayList<Book> searchBooksByTitle(String title) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Book> searchBooksByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public void saveDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dataFilePath))) {
            // Save books
            for (Book book : books) {
                writer.println("Book," + book.getBookID() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getGenre() + "," + book.getAvailability());
            }

            // Save users
            for (User user : users) {
                writer.println("User," + user.getUserID() + "," + user.getName() + "," + user.getContactInfo());
            }

            System.out.println("Data saved to file successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while saving data to file.");
            e.printStackTrace();
        }
    }

    public void loadDataFromFile() {
        if (dataLoaded || !books.isEmpty() || !users.isEmpty()) {
            return;
        }

        try (Scanner scanner = new Scanner(new File(dataFilePath))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length > 0) {
                    String type = parts[0].trim();
                    switch (type) {
                        case "Book":
                            if (parts.length == 6) {
                                int bookID = Integer.parseInt(parts[1].trim());
                                String title = parts[2].trim();
                                String author = parts[3].trim();
                                String genre = parts[4].trim();
                                boolean availability = Boolean.parseBoolean(parts[5].trim());
                                Book book = new Book(bookID, title, author, genre);
                                book.setAvailable(availability);
                                books.add(book);
                            }
                            break;
                        case "User":
                            if (parts.length == 4) {
                                int userID = Integer.parseInt(parts[1].trim());
                                String name = parts[2].trim();
                                String contactInfo = parts[3].trim();
                                User user = new User(userID, name, contactInfo);
                                users.add(user);
                            }
                            break;
                        default:
                            System.out.println("Unknown data type: " + type);
                    }
                }
            }

            System.out.println("Data loaded from file successfully.");
            dataLoaded = true;

        } catch (FileNotFoundException e) {
            System.out.println("No existing data file found. Initializing with empty data.");
        }
    }
}