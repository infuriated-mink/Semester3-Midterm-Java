package librarymanagement;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private int numCopies;

    public Book(String title, String author, String isbn, String publisher, int numCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.numCopies = numCopies;
    }

    public void borrow(int numCopies) {
        if (this.numCopies >= numCopies) {
            this.numCopies -= numCopies;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Sorry, the book is not available for borrowing.");
        }
    }

    public void returnBook(int numCopies) {
        this.numCopies += numCopies;
        System.out.println("Book returned successfully.");
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumCopies() {
        return numCopies;
    }
}
