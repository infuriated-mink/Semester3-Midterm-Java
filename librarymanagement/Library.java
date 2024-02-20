// Main method to test the library management system
public static void main(String[] args) {
    // Create a library instance
    Library library = new Library();

    // Add authors
    Author author1 = new Author("J.K. Rowling", new Date(1965, 7, 31));
    Author author2 = new Author("George Orwell", new Date(1903, 6, 25));
    library.addAuthor(author1);
    library.addAuthor(author2);

    // Add books
    Book book1 = new Book("Harry Potter and the Sorcerer's Stone", author1, "9780545582889", "Scholastic", 5);
    Book book2 = new Book("1984", author2, "9780451524935", "Signet Classic", 3);
    library.addBook(book1);
    library.addBook(book2);

    // Add patrons
    Patron patron1 = new Patron("John Doe", "123 Main St", "555-1234");
    Patron patron2 = new Patron("Jane Smith", "456 Oak Ave", "555-5678");
    library.addPatron(patron1);
    library.addPatron(patron2);
}
