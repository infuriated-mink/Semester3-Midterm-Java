package librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class Patron {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Book> borrowedBooks;

    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book.getStatus().equals(Status.AVAILABLE)) {
            book.setStatus(Status.CHECKED_OUT);
            borrowedBooks.add(book);
        } else {
            System.out.println("Sorry, the book is currently checked out.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setStatus(Status.AVAILABLE);
        } else {
            System.out.println("Sorry, you have not borrowed this book.");
        }
    }

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
