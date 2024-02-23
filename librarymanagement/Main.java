package librarymanagement;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create library instance
        Library library = new Library();

        // Load data
        loadData(library);

        // Test searching for books by title
        System.out.println("Searching for books by title:");
        List<Book> booksByTitle = library.searchBooksByTitle("Java Basics");
        displayBooks(booksByTitle);

        // Test searching for books by author
        System.out.println("\nSearching for books by author:");
        List<Book> booksByAuthor = library.searchBooksByAuthor("John Doe");
        displayBooks(booksByAuthor);

        // Test searching for books by ISBN
        System.out.println("\nSearching for book by ISBN:");
        Book bookByISBN = library.searchBooksByISBN("978-3-16-148410-0");
        displayBook(bookByISBN);

        // Test borrowing a book
        System.out.println("\nBorrowing a book:");
        Patron patron = new Patron("Alice", "123 Main St", "555-1234");
        Book bookToBorrow = library.searchBooksByTitle("Java Basics").get(0);
        library.borrowBook(bookToBorrow, patron);
        displayPatronInfo(patron);

        // Test returning a book
        System.out.println("\nReturning a book:");
        library.returnBook(bookToBorrow, patron);
        displayPatronInfo(patron);

        // Test adding a new patron
        System.out.println("\nAdding a new patron:");
        Patron newPatron = new Patron("Bob", "456 Elm St", "555-5678");
        library.addPatron(newPatron);
        displayPatronInfo(newPatron);

        // Test removing a patron
        System.out.println("\nRemoving a patron:");
        library.removePatron(newPatron);
        displayPatronInfo(newPatron); // Should show as null

        // Test adding a new book
        System.out.println("\nAdding a new book:");
        Author newAuthor = new Author("Emily Brown", LocalDate.now()); // Provide a specific date for the author's
                                                                       // birthdate
        Book newBook = new Book("New Book", newAuthor, "978-3-16-148420-0", "New Publisher", 2);
        library.addBook(newBook);
        displayBook(newBook);

        // Test removing a book
        System.out.println("\nRemoving a book:");
        library.removeBook(newBook);
        displayBook(newBook);
    }

    // Method to load data
    private static void loadData(Library library) {
        Author author1 = new Author("John Doe", "01/01/1970");
        Author author2 = new Author("Jane Smith", "05/12/1985");
        Author author3 = new Author("Michael Johnson", "10/08/1963");

        // Adding books
        Book book1 = new Book("Java Basics", author1, "978-3-16-148410-0", "Publisher A", 5);
        Book book2 = new Book("Advanced Java", author1, "978-3-16-148411-0", "Publisher B", 3);
        Book book3 = new Book("Python Essentials", author2, "978-3-16-148412-0", "Publisher C", 7);
        Book book4 = new Book("Python Data Science Handbook", author2, "978-1491912058", "O'Reilly Media", 4);
        Book book5 = new Book("C++ Primer", author3, "978-0321714114", "Addison-Wesley Professional", 6);

        Patron patron1 = new Patron("Carol", "789 Elm St", "555-6789");
        Patron patron2 = new Patron("Daniel", "101 Pine St", "555-7890");
        Patron patron3 = new Patron("Emma", "456 Oak St", "555-1234");
        Patron patron4 = new Patron("Frank", "321 Maple St", "555-5678");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addAuthor(author3);

        library.addPatron(patron1);
        library.addPatron(patron2);
        library.addPatron(patron3);
        library.addPatron(patron4);
    }

    // Method to display information about a list of books
    private static void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : books) {
                displayBook(book);
            }
        }
    }

    // Method to display information about a single book
    private static void displayBook(Book book) {
        if (book == null) {
            System.out.println("Book not found.");
        } else {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor().getAuthorName());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Publisher: " + book.getPublisher());
            System.out.println("Number of Copies: " + book.getNumCopies());
            System.out.println("Status: " + book.getStatus());
            System.out.println();
        }
    }

    // Method to display patron information
    private static void displayPatronInfo(Patron patron) {
        if (patron == null) {
            System.out.println("Patron not found.");
        } else {
            System.out.println("Patron Name: " + patron.getName());
            System.out.println("Address: " + patron.getAddress());
            System.out.println("Phone Number: " + patron.getPhoneNumber());
            System.out.println("Borrowed Books: " + patron.getBorrowedBooks());
            System.out.println("Fines: $" + patron.calculateFines());
            System.out.println();
        }
    }
}
