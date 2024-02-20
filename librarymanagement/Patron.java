package librarymanagement;

import java.util.ArrayList;
import java.util.List;

// import Status;

public class Patron {

    // Patron's name
    private String name;

    // Patron's address
    private String address;

    // Patron's phone number
    private String phoneNumber;

    // List of books borrowed by the patron
    private List<Book> borrowedBooks;

    // Constructor
    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and setters

    // Method to borrow a book
    public void borrowBook(Book book) {
        if (book.getStatus() == Status.AVAILABLE) { // Assuming Status enum is defined
            book.setStatus(Status.CHECKED_OUT);
            borrowedBooks.add(book);
        } else {
            System.out.println("Sorry, the book is currently checked out.");
        }
    }

    // Method to return a book
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setStatus(Status.AVAILABLE);
        } else {
            System.out.println("Sorry, you have not borrowed this book.");
        }
    }

    // Method to display the patron's information
    public void displayPatronInfo() {
        System.out.println("Patron Name: " + name);
        System.out.println("Patron Address: " + address);
        System.out.println("Patron Phone Number: " + phoneNumber);
        System.out.println("Patron Borrowed Books:");
        for (Book book : borrowedBooks) {
            System.out.println(" - " + book.getTitle());
        }
    }
}
