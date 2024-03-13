public class Book {
    private int bookID;
    private String title;
    private String author;
    private String genre;
    private boolean availability;

    public Book (int bookID, String title, String author, String genre) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = true;
    }

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