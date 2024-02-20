package librarymanagement;

public interface Borrowable {
    boolean borrow(int numCopies);

    boolean returnBook(int numCopies);
}
