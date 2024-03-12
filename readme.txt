COMP3005 Assignment 3 - Documentation
March 11th, 2024

----------------------------------------------------------------------------------------------------
Author:
    - Evan Baldwin, 101222276
----------------------------------------------------------------------------------------------------
====================================================================================================
Description
____________________________________________________________________________________________________
This assignment provides SQL queries to implement a PostgreSQL database,
and methods written in Java to perform CRUD operations. All methods are
contained within the Main class and operations include the retrieval of
the "students" table, the addition of a new student to said table,
the ability to update the email of a student, and the removal of a
previously existing student.

The following contains a link to an unlisted video demonstrating the usage of
each function and their interaction with a newly created PostgreSQL database.
https://youtu.be/3mDi2JN0AOc
----------------------------------------------------------------------------------------------------
====================================================================================================
Using the program
____________________________________________________________________________________________________
1) Begin by initializing a new database utilizing pgAdmin4 (PostgreSQL) named
Assignment3_Question1. Alternatively, another name can be chosen and the String
variable "url" within the Main class can be modified by replacing the name
of the database with the newly chosen one.

2) Open the Query Tool for the new database, then copy/paste the text found within
the "Database Schema and Associated Data" section of this file and execute the query.
Alternatively, the database schema is contained within a separate text file titled
"Database_Schema.txt" which can be utilized.

3) The database is now fully implemented and populated. A main executable method
is present within the Main.java file which can be run to test each individual
function with proper formatting and delays to allow for greater readability.
Alternatively, the main method can be modified to execute each or every function
with any desired parameters.

NOTE: Because each student ID is generated incrementally, deletion of a student and
subsequent generation of the same or another student will generate a new student ID
instead of the last deleted one.
----------------------------------------------------------------------------------------------------
====================================================================================================
Database Schema and Associated Data
____________________________________________________________________________________________________

create table students
	(student_id SERIAL,
	 first_name TEXT NOT NULL,
	 last_name TEXT NOT NULL,
	 email TEXT UNIQUE NOT NULL,
	 enrollment_date DATE,
	 primary key (student_id)
	);

INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');

----------------------------------------------------------------------------------------------------
====================================================================================================
Deliverables
- Main.java
    - Located within Assignment3_Database_Code/src/main/java
    - Contains the source code for the functions required to
    connect to the database, as well as perform CRUD operations.

- Database_Schema.txt
    - Located within Assignment3_Database_Code
    - Contains a backup of the database schema in a text file
    utilized to create and populate the database.

- Demonstration video
    - A demonstration of this assignment can be found at:
    https://youtu.be/3mDi2JN0AOc
____________________________________________________________________________________________________
