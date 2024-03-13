// User.java
// User class represents library users

import java.util.ArrayList;

public class User {
    private int userID;                     // Unique identifier for the user
    private String name;                    // Name of the user
    private String contactInfo;             // Contact information of the user
    private ArrayList<Book> borrowedBooks;  // List of books borrowed by the user

    // Constructor to initialize a User object
    public User(int userID, String name, String contactInfo) {
        this.userID = userID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowedBooks = new ArrayList<>();     // Initialize an empty list of borrowed books
    }

    // Getter and setter methods for User attributes
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    public void setBorrowedBooks(ArrayList<Book> b) {
        this.borrowedBooks = b;
    }

    // toString method for displaying User information
    @Override
    public String toString() {
        return "User {" +
                "User ID = " + userID +
                ", Name = '" + name + '\'' +
                ", Contact Info = '" + contactInfo + '\'' +
                ", Borrowed Books = " + borrowedBooks +
                '}';
    }

}