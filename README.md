# Library Management System

## User Documentation

### Introduction

The Library Management System is a Java application designed to streamline the management of books, authors, and patrons in a library environment. It provides features such as adding, editing, and deleting books and authors, managing patrons, and facilitating book borrowing and returning.

### Class Descriptions

1. **Book**: Represents a book in the library. It includes properties such as title, author, ISBN, publisher, and number of copies. Implements the `Borrowable` interface.

2. **Author**: Represents an author. Contains properties such as name, date of birth, and a list of books they have written.

3. **Patron**: Represents a library patron. Includes properties like name, address, phone number, and a list of borrowed books.

4. **Library**: Manages books, authors, and patrons. Provides methods to search for books by title, author, or ISBN, and to borrow and return books.

### Functionality

- **Book Management**: Add, edit, and delete books from the library inventory.
- **Author Management**: Add, edit, and delete authors from the library database.
- **Patron Management**: Add, edit, and delete patrons from the library records.
- **Book Borrowing**: Patrons can search for books by title, author, or ISBN and borrow specific copies.
- **Book Returning**: Patrons can return books they have borrowed.

### Accessing the Application

1. Ensure you have Java installed on your system.
2. Download the provided `.rar` file and extract it.
3. Compile the Java files using `javac *.java`.
4. Run the main class to start the application.

### Class Diagram

[Library] --- has --- [Book]
| |
| --- has --- [Author]
|
--- has --- [Patron]

## Development

- **Javadocs**: Detailed documentation for each class and method is available in the source code.
- **Source Code Structure**: The source code is organized into packages under the `com.yourname` directory.
- **Build Process**: Compile the Java files using `javac *.java`.
- **Dependencies**: No external dependencies are required.
- **Development Standards**: Follow standard Java coding conventions.

## Deployment

- **Installation**: No installation steps are required. Simply compile the Java files and run the main class.
- **Running the Application**: Follow the instructions provided in the "How to Use" section.
- **Configuration**: No additional configuration is needed for deployment.

## Video Demonstration

A video demonstration showcasing the functionality of the Library Management System is available [here](video_demo.mp4).

## Documentation

For detailed documentation, including user, development, and deployment guides, refer to the documents provided in the `docs` directory.

## License

This project is licensed under the [MIT License](LICENSE).
