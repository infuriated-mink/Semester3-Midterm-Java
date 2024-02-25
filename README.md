# Library Management System
---
## Table of Contents
1. [Description](#description)
2. [Key Features](#key-features)
3. [Documentation](#documentation)
    - [User Manual](#user-manual)
    - [Development Documentation](#development-documentation)
    - [Deployment Documentation](#deployment-documentation)
4. [Installation](#installation)
5. [Usage](#usage)
6. [Contributing](#contributing)
7. [License](#license)
8. [Credits](#credits)

## Description

The Library Management System is a Java-based application designed to help libraries manage their book inventory, patron information, and book borrowing and returning operations efficiently. This system provides a user-friendly interface for librarians to perform various tasks such as adding and removing books, managing patron records, and handling book borrowing and returning processes.

## Key Features

- **Book Management**: Allows librarians to add new books to the inventory, remove existing books, and update book information.
- **Patron Management**: Enables librarians to manage patron records, including adding new patrons, updating patron information, and removing patrons from the system.
- **Book Borrowing and Returning**: Facilitates the borrowing and returning process for library patrons, including checking book availability, borrowing books, and returning books.
- **Fine Calculation**: Automatically calculates fines for overdue books and updates patron records accordingly.
- **Search Functionality**: Provides search functionality to quickly find books by title, author, or ISBN.
- **Author Information**: Stores author information, including name and birthdate, to associate authors with their respective books.

## Key Components

- **Library Class**: Manages book inventory, patron information, and book borrowing and returning operations.
- **Book Class**: Represents a book entity with attributes such as title, author, ISBN, publisher, and status.
- **Patron Class**: Represents a library patron with attributes such as name, address, phone number, and borrowed books.
- **Author Class**: Represents an author entity with attributes such as name and birthdate.
- **Status Enum**: Defines the status of a book (e.g., available, checked out, overdue).
- **Borrowable Interface**: Defines methods for borrowing and returning books.

## Documentation

The project documentation is located in the `docs` folder, which contains detailed guides and manuals for users, developers, and deployment.

### User Documentation

The user documentation provides instructions for end-users on how to navigate and utilize the Library Management System effectively.

### Development Documentation

The development documentation offers detailed insights into the system's architecture, design, and implementation for developers contributing to the project.

### Deployment Documentation

The deployment documentation outlines the steps required to deploy the Library Management System in various environments and configurations.


## Installation

1. Clone the repository to your local machine:
```
git clone <repository_url>
```

2. Navigate to the project directory:
```
cd library-management-system
```

3. Compile the Java source code:
```
javac *.java
```

4. Run the main program:
```
java Main
```


## Usage

1. Upon launching the application, you will be presented with a menu interface.
2. Use the menu options to perform various tasks such as adding books, managing patrons, and handling book borrowing and returning operations.
3. Follow the on-screen prompts to complete each task.

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/<feature_name>`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add new feature'`).
5. Push to the branch (`git push origin feature/<feature_name>`).
6. Create a new pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Credits

This project was created by [Vanessa Rice](https://www.github.com/infuriated-mink).
