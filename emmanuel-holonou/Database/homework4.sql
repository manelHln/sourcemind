-- Create the tables
CREATE TABLE Categories (
    category_id INT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL
);

CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    book_name VARCHAR(100) NOT NULL,
    category_id INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);

-- Insert data into the tables
INSERT INTO Categories (category_id, category_name) VALUES
(1, 'Programming'),
(2, 'Java'),
(3, 'C++'),
(4, 'Databases'),
(5, 'Relational Databases'),
(6, 'Oracle'),
(7, 'Postgres'),
(8, 'NoSQL Databases'),
(9, 'MongoDB');

INSERT INTO Books (book_id, book_name, category_id) VALUES
(1, 'Java Programming 101', 2),
(2, 'C++ Programming Basics', 3),
(3, 'Advanced Java Programming', 2),
(4, 'Data Structures in C++', 3),
(5, 'Relational Database Concepts', 5),
(6, 'Oracle Database Administration', 6),
(7, 'PostgreSQL Essentials', 7),
(8, 'MongoDB Fundamentals', 9),
(9, 'NoSQL Database Design', 8);

-- Select all books from the Programming category
SELECT book_name FROM Books
JOIN Categories ON Books.category_id = Categories.category_id
WHERE Categories.category_name = 'Programming';

-- Select all books from the Relational Databases category
SELECT book_name FROM Books
JOIN Categories ON Books.category_id = Categories.category_id
WHERE Categories.category_name = 'Relational Databases';

-- Get the number of books in the IT Books category
SELECT COUNT(*) AS num_books FROM Books
JOIN Categories ON Books.category_id = Categories.category_id
WHERE Categories.category_name LIKE 'IT Books';

