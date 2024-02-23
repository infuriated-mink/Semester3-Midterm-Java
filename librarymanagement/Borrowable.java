package librarymanagement;

public interface Borrowable {
    void borrowBook(int numCopies);

    void returnBook(int numCopies);
}
