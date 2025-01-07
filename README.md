# School-Library
This project models a Library Management System that handles books, readers, and library operations. It is divided into three main classes: Book, Reader, and Library.

The Book class represents individual books in the library, storing information such as the title, author, publication year, ISBN, status, and rating. It enforces strict validation rules for data consistency and tracks rental history, including readers and their ratings.

The Reader class models a library member with attributes like full name, year of birth, and zip code. It ensures valid input through specific rules and provides essential details about the reader.

The Library class manages the collection of books and provides functionality for adding, removing, renting, and returning books. It also tracks the status of books and maintains a list of available titles.

Overall, the system supports operations like archiving books, calculating average ratings, and displaying detailed information about the library and its inventory. This design ensures data integrity and facilitates the effective management of books and readers.
