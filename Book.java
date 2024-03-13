// Book.java
// Book class represents individual books in the library
public class Book {
    private int bookID;             // Unique identifier for the book
    private String title;           // Title of the book
    private String author;          // Author of the book
    private String genre;           // Genre of the book
    private boolean availability;   // Availability status of the book

    // Constructor to initialize a Book object
    public Book (int bookID, String title, String author, String genre) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = true;   // Newly added books are available by default
    }

    // Getter and setter methods for Book attributes
    public int getBookID() {
        return bookID;
    }
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean getAvailability() {
        return availability;
    }
    public void setAvailable(boolean availability) {
        this.availability = availability;
    }

    // toString method for displaying Book information
    @Override
    public String toString() {
        return "Book {" +
                "Book ID = " + bookID +
                ", Title = '" + title + '\'' +
                ", Author = '" + author + '\'' +
                ", Genre = '" + genre + '\'' +
                ", Available = " + availability +
                '}';
    }

}