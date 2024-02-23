package librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Author> authors;
    private List<Patron> patrons;

    public Library() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
        Author author = book.getAuthor();
        if (!authors.contains(author)) {
            authors.add(author);
        }
    }

    // Method to add a patron to the library
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    // Method to search for books by title
    public List<Book> searchBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

// Method to search for books by author
public List<Book> searchBooksByAuthor(String authorName) {
    List<Book> foundBooks = new ArrayList<>();
    for (Book book : books) {
        Author author = book.getAuthor();
        if (author != null && author.getAuthorName() != null && author.getAuthorName().equalsIgnoreCase(authorName)) {
            foundBooks.add(book);
        }
    }
    return foundBooks;
}

    // Method to search for books by ISBN
    public Book searchBooksByISBN(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Method to remove a patron from the library
    public void removePatron(Patron patron) {
        patrons.remove(patron);
    }

    // Method to remove a book from the library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Method to borrow a book
    public void borrowBook(Book book, Patron patron) {
        patron.borrowBook(book);
    }

    // Method to return a book
    public void returnBook(Book book, Patron patron) {
        patron.returnBook(book);
    }

    // Method to add an author to the library
    public void addAuthor(Author author) {
        if (!authors.contains(author)) {
            authors.add(author);
        }
    }
}
