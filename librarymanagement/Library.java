package librarymanagement;

import java.util.ArrayList;
import java.util.List;


public class Library {
    private List<Book> books;
    private List<Author> authors;
    private List<Patron> patrons;

    public Library() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        Author author = findOrCreateAuthor(book.getAuthor());
        author.addBook(book);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    private Author findOrCreateAuthor(String authorName) {
        for (Author author : authors) {
            if (author.getName().equals(authorName)) {
                return author;
            }
        }
        Author newAuthor = new Author(authorName, null);
        authors.add(newAuthor);
        return newAuthor;
    }

    public List<Book> searchBooks(String searchQuery) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchQuery.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(searchQuery.toLowerCase()) ||
                    book.getIsbn().toLowerCase().equals(searchQuery.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
}
