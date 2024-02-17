package librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String dob;
    private List<Book> booksWritten;

    public Author(String name, String dob) {
        this.name = name;
        this.dob = dob;
        this.booksWritten = new ArrayList<>();
    }

    public void addBook(Book book) {
        booksWritten.add(book);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public List<Book> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(List<Book> booksWritten) {
        this.booksWritten = booksWritten;
    }
}
