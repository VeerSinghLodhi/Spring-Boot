# PostgreSQL Commands Notes

## Database Management
- **Create a database**  
  ```sql
  CREATE DATABASE database_name;
  ```
- **Connect to a database**  
  ```sql
  \c database_name
  ```
- **List all databases**  
  ```sql
  \l
  ```
- **Drop a database**  
  ```sql
  DROP DATABASE database_name;
  ```

## User and Role Management
- **Create a user**  
  ```sql
  CREATE USER username WITH PASSWORD 'password';
  ```
- **Grant privileges**  
  ```sql
  GRANT ALL PRIVILEGES ON DATABASE database_name TO username;
  ```
- **Revoke privileges**  
  ```sql
  REVOKE ALL PRIVILEGES ON DATABASE database_name FROM username;
  ```
- **Drop a user**  
  ```sql
  DROP USER username;
  ```

## Table Management
- **Create a table**  
  ```sql
  CREATE TABLE table_name (
      column_name1 data_type constraints,
      column_name2 data_type constraints,
      ...
  );
  ```
- **List all tables in the database**  
  ```sql
  \dt
  ```
- **Describe a table**  
  ```sql
  \d table_name
  ```
- **Rename a table**  
  ```sql
  ALTER TABLE old_table_name RENAME TO new_table_name;
  ```
- **Drop a table**  
  ```sql
  DROP TABLE table_name;
  ```

## Table Modification
- **Add a column**  
  ```sql
  ALTER TABLE table_name ADD COLUMN column_name data_type;
  ```
- **Drop a column**  
  ```sql
  ALTER TABLE table_name DROP COLUMN column_name;
  ```
- **Rename a column**  
  ```sql
  ALTER TABLE table_name RENAME COLUMN old_column_name TO new_column_name;
  ```
- **Change column data type**  
  ```sql
  ALTER TABLE table_name ALTER COLUMN column_name TYPE new_data_type;
  ```

## Data Manipulation
- **Insert data**  
  ```sql
  INSERT INTO table_name (column1, column2, ...) VALUES (value1, value2, ...);
  ```
- **Update data**  
  ```sql
  UPDATE table_name SET column_name = value WHERE condition;
  ```
- **Delete data**  
  ```sql
  DELETE FROM table_name WHERE condition;
  ```
- **Select data**  
  ```sql
  SELECT column1, column2 FROM table_name WHERE condition;
  ```
- **Select all data**  
  ```sql
  SELECT * FROM table_name;
  ```

## Constraints and Indexes
- **Add a primary key**  
  ```sql
  ALTER TABLE table_name ADD PRIMARY KEY (column_name);
  ```
- **Add a foreign key**  
  ```sql
  ALTER TABLE table_name ADD FOREIGN KEY (column_name) REFERENCES other_table(column_name);
  ```
- **Create an index**  
  ```sql
  CREATE INDEX index_name ON table_name(column_name);
  ```
- **Drop an index**  
  ```sql
  DROP INDEX index_name;
  ```

## Transactions
- **Begin a transaction**  
  ```sql
  BEGIN;
  ```
- **Commit a transaction**  
  ```sql
  COMMIT;
  ```
- **Rollback a transaction**  
  ```sql
  ROLLBACK;
  ```

## Views
- **Create a view**  
  ```sql
  CREATE VIEW view_name AS SELECT column1, column2 FROM table_name WHERE condition;
  ```
- **Drop a view**  
  ```sql
  DROP VIEW view_name;
  ```

## Advanced Queries
- **Join tables**  
  ```sql
  SELECT columns FROM table1
  INNER JOIN table2 ON table1.column = table2.column;
  ```
- **Group data**  
  ```sql
  SELECT column, COUNT(*) FROM table_name GROUP BY column;
  ```
- **Order data**  
  ```sql
  SELECT * FROM table_name ORDER BY column_name ASC/DESC;
  ```
- **Limit results**  
  ```sql
  SELECT * FROM table_name LIMIT number OFFSET number;
  ```

## Meta Commands (psql specific)
- **Show current database**  
  ```sql
  \conninfo
  ```
- **List all roles**  
  ```sql
  \du
  ```
- **Quit psql**  
  ```sql
  \q
  ```
- **Execute a script file**  
  ```bash
  \i filename.sql
  
