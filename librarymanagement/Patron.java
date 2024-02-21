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

    // Method to calculate fines for the patron
    public double calculateFines() {
        double totalFines = 0.0;
        for (Book book : borrowedBooks) {
            // Calculate fine for each overdue book and add to total fines
            double fine = book.calculateFine();
            if (fine > 0) {
                totalFines += fine;
            }
        }
        return totalFines;
    }

    // Method to borrow a book
    public void borrowBook(Book book) {
        if (book.getStatus() == Status.AVAILABLE) {
            book.setStatus(Status.CHECKED_OUT);
            borrowedBooks.add(book);
            System.out.println("Book '" + book.getTitle() + "' has been borrowed successfully.");
        } else {
            System.out.println("Sorry, the book '" + book.getTitle() + "' is currently checked out.");
        }
    }

    // Method to return a book
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setStatus(Status.AVAILABLE);
            System.out.println("Book '" + book.getTitle() + "' has been returned successfully.");
        } else {
            System.out.println("Sorry, you have not borrowed the book '" + book.getTitle() + "'.");
        }
    }

    @Override
    public String toString() {
        StringBuilder borrowedBooksInfo = new StringBuilder();
        borrowedBooksInfo.append("Patron Name: ").append(name).append("\n");
        borrowedBooksInfo.append("Patron Address: ").append(address).append("\n");
        borrowedBooksInfo.append("Patron Phone Number: ").append(phoneNumber).append("\n");
        borrowedBooksInfo.append("Patron Borrowed Books:\n");
        for (Book book : borrowedBooks) {
            borrowedBooksInfo.append(" - ").append(book.getTitle()).append("\n");
        }
        return borrowedBooksInfo.toString();
    }
}
