import java.util.ArrayList;

public class User {
    private int userID;
    private String name;
    private String contactInfo;
    private ArrayList<Book> borrowedBooks;

    public User(int userID, String name, String contactInfo) {
        this.userID = userID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowedBooks = new ArrayList<>();
    }

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