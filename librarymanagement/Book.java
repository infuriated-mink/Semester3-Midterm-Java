package librarymanagement;

import java.util.Date;

public class Book implements Borrowable {
    private String title;
    private Author author;
    private String ISBN;
    private String publisher;
    private int numCopies;
    private Status status;
    private Date dueDate;

    public Book(String title, Author author, String ISBN, String publisher, int numCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numCopies = numCopies;
        this.status = Status.AVAILABLE;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumCopies() {
        return numCopies;
    }

    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    // Method to decrement the number of copies available
    public void decrementCopies() {
        numCopies--;
    }

    public double calculateFine() {
        double fine = 0.0;
        // Check if the book is overdue
        if (status == Status.CHECKED_OUT && dueDate != null && dueDate.before(new Date())) {
            long daysOverdue = (new Date().getTime() - dueDate.getTime()) / (1000 * 60 * 60 * 24);
            double finePerDay = 0.50;
            fine = finePerDay * daysOverdue;
        }
        return fine;
    }

    @Override
    public void returnBook(int numCopies) {
        if (status == Status.CHECKED_OUT) {
            status = Status.AVAILABLE;
            dueDate = null;
        } else {
            System.out.println("This book is not checked out.");
        }
    }

    @Override
    public void borrowBook(int numCopies) {
        if (status == Status.AVAILABLE) {
            status = Status.CHECKED_OUT;
        } else {
            System.out.println("This book is not available for borrowing.");
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Author: " + author.getAuthorName() + "\n" +
                "ISBN: " + ISBN + "\n" +
                "Publisher: " + publisher + "\n" +
                "Number of Copies: " + numCopies + "\n" +
                "Status: " + status + "\n";
    }
}
