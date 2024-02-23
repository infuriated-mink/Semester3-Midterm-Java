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

    // Method to search for books by title
    public List<Book> searchBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }
        return result;
    }

    // Method to search for books by author
    public List<Book> searchBooksByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getAuthorName().equals(authorName)) {
                result.add(book);
            }
        }
        return result;
    }

    // Method to search for a book by ISBN
    public Book searchBooksByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Method to borrow a book
    public void borrowBook(Book book, Patron patron) {
        if (book.getStatus() == Status.AVAILABLE) {
            book.setStatus(Status.CHECKED_OUT);
            patron.addBorrowedBook(book);
        } else {
            System.out.println("This book is not available for borrowing.");
        }
    }

    // Method to return a book
    public void returnBook(Book book, Patron patron) {
        if (patron.getBorrowedBooks().contains(book)) {
            book.setStatus(Status.AVAILABLE);
            patron.removeBorrowedBook(book);
        } else {
            System.out.println("This book was not borrowed by the patron.");
        }
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Method to add an author to the library
    public void addAuthor(Author author) {
        authors.add(author);
    }

    // Method to remove an author from the library
    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    // Method to add a patron to the library
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    // Method to remove a patron from the library
    public void removePatron(Patron patron) {
        patrons.remove(patron);
    }

    // Method to search for a patron by name
    public Patron searchPatronByName(String name) {
        for (Patron patron : patrons) {
            if (patron.getName().equals(name)) {
                return patron;
            }
        }
        return null; // Patron not found
    }
}
