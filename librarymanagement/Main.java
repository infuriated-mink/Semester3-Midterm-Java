package librarymanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        Patron patron = library.searchPatronByName("Carol");
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
        displayPatronInfo(newPatron);

        // Test adding a new book
        System.out.println("\nAdding a new book:");
        Author newAuthor = new Author("Emily Brown", "15/02/1990");
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Author author1 = null;
        Author author2 = null;
        Author author3 = null;
        try {
            author1 = new Author("John Doe", dateFormat.parse("01/01/1970"));
            author2 = new Author("Jane Smith", dateFormat.parse("05/12/1985"));
            author3 = new Author("Michael Johnson", dateFormat.parse("10/08/1963"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Book book1 = new Book("Java Basics", author1, "978-3-16-148410-0", "Publisher A", 5);
        Book book2 = new Book("Advanced Java", author1, "978-3-16-148411-0", "Publisher B", 3);
        Book book3 = new Book("Python Essentials", author2, "978-3-16-148412-0", "Publisher C", 7);
        Book book4 = new Book("Python Data Science Handbook", author2, "978-1491912058", "O'Reilly Media", 4);
        Book book5 = new Book("C++ Primer", author3, "978-0321714114", "Addison-Wesley Professional", 6);
        Book book6 = new Book("C++ Primer Plus", author3, "978-0321776402", "Addison-Wesley Professional", 2);
        Book book7 = new Book("C++ Programming", author3, "978-0672326974", "Sams Publishing", 3);
        Book book8 = new Book("C++ for Dummies", author3, "978-0764557696", "For Dummies", 5);
        Book book9 = new Book("C++ in One Hour a Day", author3, "978-0789757745", "Sams Publishing", 4);

        Patron patron1 = new Patron("Carol", "789 Elm St", "555-6789");
        Patron patron2 = new Patron("Daniel", "101 Pine St", "555-7890");
        Patron patron3 = new Patron("Emma", "456 Oak St", "555-1234");
        Patron patron4 = new Patron("Frank", "321 Maple St", "555-5678");
        Patron patron5 = new Patron("Grace", "654 Birch St", "555-2345");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);
        library.addBook(book9);

        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addAuthor(author3);

        library.addPatron(patron1);
        library.addPatron(patron2);
        library.addPatron(patron3);
        library.addPatron(patron4);
        library.addPatron(patron5);
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
