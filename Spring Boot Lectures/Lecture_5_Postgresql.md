# PostgreSQL Overview

## Introduction
This document provides a comprehensive overview of PostgreSQL, exploring its definition, history, architecture, and basic commands to equip users with foundational knowledge of this powerful database system.

---

## 01 Overview

### What Is PostgreSQL?
PostgreSQL is an open-source relational database management system (RDBMS) known for its advanced features and robust performance. It supports various data types, including JSON and XML, and adheres to SQL standards, making it a versatile choice for various applications.

### ACID Compliance
**ACID compliance** refers to a set of properties that ensure reliable and consistent database transactions. It stands for:

- **Atomicity**: Ensures that a transaction is "all or nothing." If any part fails, the entire transaction is rolled back. For example, in money transfers, a failure midway cancels the transaction entirely.
- **Consistency**: Guarantees the database transitions from one valid state to another while adhering to integrity rules.
- **Isolation**: Ensures transactions execute independently and do not interfere with each other. PostgreSQL supports isolation levels like Read Committed and Serializable.
- **Durability**: Ensures committed transaction changes are permanent, even after system failures.

---

## Brief History
- **Origins at UC Berkeley**: PostgreSQL began as a project called POSTGRES at UC Berkeley, led by Professor Michael Stonebraker in 1986.
- **Post-Ingres**: It was designed as a successor to the Ingres database system.
- **Innovation**: Introduced complex data types and rules, addressing limitations of existing databases.
- **Growth**: It evolved into an advanced open-source system with regular updates and strong community support, making it a favorite among developers and organizations.

---

## 02 pgAdmin

### What is pgAdmin?
pgAdmin is the most popular open-source administration and development platform for PostgreSQL. It provides a graphical interface for managing PostgreSQL databases.

#### Key Features
- **User-friendly dashboard** to monitor servers and databases.
- **SQL Query Tool** to create, browse, and execute queries.
- **Visual tools** for table creation, user role management, and schema visualization.
- **Import/Export tools** for data.
- **Multiple server support** for managing PostgreSQL instances.
- **Debugging tools** to handle errors effectively.

---

## Basic SQL Commands in PostgreSQL

### Common Commands
1. **Create Database**: `CREATE DATABASE DBNAME;`
2. **Connect to Database**: `\c DBNAME`
3. **View Table Structure**: `\d TABLENAME`
4. **List Databases**: `\l` or `\list`
5. **List Tables**: `\dt`
6. **Create User**: `CREATE USER USERNAME WITH PASSWORD 'PASSWORD';`
7. **List Users**: `\du`

### Meta-Commands vs SQL Commands
| Meta-Command         | Description                         | SQL Equivalent                                                                 |
|-----------------------|-------------------------------------|-------------------------------------------------------------------------------|
| `\l`                 | List all databases                 | `SELECT datname FROM pg_database;`                                           |
| `\c [database_name]` | Connect to a database              | `\connect [database_name]` (No direct SQL equivalent)                        |
| `\dt`                | List all tables in the current schema | `SELECT tablename FROM pg_tables WHERE schemaname='public';`                |
| `\du`                | List all roles (users)             | `SELECT * FROM pg_roles;`                                                    |
| `\d [table_name]`    | Describe a table                   | `SELECT column_name, data_type FROM information_schema.columns WHERE table_name='[table_name]';` |
| `\dn`                | List all schemas                   | `SELECT schema_name FROM information_schema.schemata;`                       |
| `\q`                 | Quit psql                          | Not applicable                                                               |

---

This document provides the essential foundational knowledge required to start working with PostgreSQL and its administration tool, pgAdmin.
