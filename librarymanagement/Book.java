package librarymanagement;

public class Book implements Borrowable {

    private String title;
    private Author author;
    private String ISBN;
    private String publisher;
    private int numCopies;

    public Book(String title, Author author, String ISBN, String publisher, int numCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numCopies = numCopies;
    }

    // Getters and setters

    @Override
    public boolean borrow(int numCopies) {
        if (numCopies <= this.numCopies) {
            this.numCopies -= numCopies;
            return true;
        }
        return false;
    }

    @Override
    public boolean returnBook(int numCopies) {
        this.numCopies += numCopies;
        return true;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", ISBN='" + ISBN + '\'' +
                ", publisher='" + publisher + '\'' +
                ", numCopies=" + numCopies +
                '}';
    }
}
