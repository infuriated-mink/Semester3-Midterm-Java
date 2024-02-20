package librarymanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    // No need for a setter for authorID as it is set in the constructor

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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
