package librarymanagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        this.authorID = nextID++;
        this.authorName = authorName;
        this.dateOfBirth = dateOfBirth;
        this.books = new ArrayList<>();
    }

    // Constructor for the case where dateOfBirth is a string in format "dd/MM/yyyy"
    public Author(String authorName, String dateString) {
        this.authorID = nextID++;
        this.authorName = authorName;
        this.dateOfBirth = parseDateString(dateString);
        this.books = new ArrayList<>();
    }

    // Constructor for the case where dateOfBirth is a LocalDate
    public Author(String authorName, LocalDate dateOfBirth) {
        this.authorID = nextID++;
        this.authorName = authorName;
        this.dateOfBirth = convertToDate(dateOfBirth);
        this.books = new ArrayList<>();
    }

    private Date parseDateString(String dateString) {
        // Assuming the date string is in format "dd/MM/yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return convertToDate(localDate);
    }

    private Date convertToDate(LocalDate localDate) {
        return java.sql.Date.valueOf(localDate);
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
