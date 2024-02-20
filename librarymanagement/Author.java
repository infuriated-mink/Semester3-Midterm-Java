package librarymanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import librarymanagement.Book;

public class Author {

    private static int nextID = 1;
    private int authorID;
    private String authorName;
    private Date dateOfBirth;
    private List<Book> books;

    public Author(String authorName, Date dateOfBirth) {
        this.authorID = nextID++; // Assign a unique author ID
        this.authorName = authorName;
        this.dateOfBirth = dateOfBirth;
        this.books = new ArrayList<>();
    }

    public int getAuthorID() {
        return authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getDateOfBirth() {
        return new Date(dateOfBirth.getTime()); // Return a copy of the date to prevent external modification
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = new Date(dateOfBirth.getTime()); // Store a copy of the date to prevent external modification
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books); // Return a copy of the list to prevent external modification
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorID=" + authorID +
                ", authorName='" + authorName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", books=" + books +
                '}';
    }
}
