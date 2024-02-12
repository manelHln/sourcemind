Isolation Levels in a Relational Database:
Isolation levels in a relational database define how transactions are isolated from each other. They ensure that concurrent transactions don't interfere with each other's operations. There are different isolation levels, including:
Read Uncommitted: Transactions can read uncommitted changes from other transactions.
Read Committed: Transactions can only read committed changes from other transactions.
Repeatable Read: Ensures that read operations retrieve the same data throughout the transaction, preventing changes made by other transactions.
Serializable: Transactions are executed in a way that their outcomes are equivalent to running them serially, one after the other.

B-TREE and HASH indexes are two common types of indexes used in databases, each with its own advantages:
B-TREE indexes: They work well for range queries and can maintain sorted order. They're suitable for columns with a high degree of variability in the data. B-TREE indexes can also be used for partial matches, which is beneficial in scenarios where you have wildcard searches or only part of the indexed column value.
HASH indexes: They're efficient for equality comparisons, like exact match searches. They're great when you want to look up a specific value. However, they're not as effective for range queries or partial matches as B-TREE indexes.

docker run --name db-homework -e POSTGRES_PASSWORD=mowgli -p 5432:5432 -d postgres

psql -h localhost -p 5432 -U postgres -d postgres -W



-- Create the Homework database
CREATE DATABASE Homework;

-- Connect to the Homework database
\c Homework

-- Create the admin role
CREATE ROLE admin WITH LOGIN PASSWORD 'adminpass';
GRANT CONNECT ON DATABASE Homework TO admin;
GRANT USAGE, CREATE ON SCHEMA public TO admin;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO admin;

-- Create the viewer role
CREATE ROLE viewer WITH LOGIN PASSWORD 'password';
GRANT CONNECT ON DATABASE Homework TO viewer;
GRANT USAGE ON SCHEMA public TO viewer;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO viewer;

-- Create the restricted role
CREATE ROLE restricted;

