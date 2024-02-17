package librarymanagement;

public interface Borrowable {
    void borrowBook(Patron patron, int numberOfCopies);

    void returnBook(Patron patron, int numberOfCopies);
}
