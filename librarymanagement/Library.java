package librarymanagement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
            book.decrementCopies(); // Decrement the number of copies available
            System.out.println("Book '" + book.getTitle() + "' has been borrowed successfully.");
        } else {
            System.out.println("This book is not available for borrowing.");
        }
    }

    // Method to return a book
    public void returnBook(Book book, Patron patron) {
        returnBook(book, patron, LocalDate.now());
    }

    // Method to return a book with a specified return date
    public void returnBook(Book book, Patron patron, LocalDate returnDate) {
        if (patron.getBorrowedBooks().contains(book)) {
            book.setStatus(Status.AVAILABLE);
            patron.removeBorrowedBook(book);

            // Calculate fines for overdue books
            LocalDate dueDate = LocalDate.now().minusDays(7); // Assuming books are due in 7 days
            long daysOverdue = ChronoUnit.DAYS.between(dueDate, returnDate);
            double fineRatePerDay = 0.50; // Define your fine rate per day

            if (daysOverdue > 0) {
                double fines = daysOverdue * fineRatePerDay;
                patron.addFines(fines);
                System.out.println("Book returned overdue. Fines incurred: $" + fines);
            } else {
                System.out.println("Book returned on time. No fines incurred.");
            }
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
