package librarymanagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Author {
    private static int nextID = 1;
    private int authorID;
    private String authorName;
    private Date dateOfBirth;
    private List<Book> books;

    public Author(String authorName, Date string) {
        this.authorID = nextID++;
        this.authorName = authorName;
        this.dateOfBirth = string;
        this.books = new ArrayList<>();
    }

    public Author(String authorName2, String string) {
        // TODO Auto-generated constructor stub
    }

    public Author(String authorName2, LocalDate now) {
        // TODO Auto-generated constructor stub
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
        return dateOfBirth != null ? new Date(dateOfBirth.getTime()) : null;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
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
