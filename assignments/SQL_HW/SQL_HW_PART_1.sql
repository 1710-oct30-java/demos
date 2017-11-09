-- Part I – Working with an existing database

-- 1.0	Setting up Oracle Chinook
-- In this section you will begin the process of working with the Oracle Chinook database
-- Task – Open the Chinook_Oracle.sql file and execute the scripts within.
-- 2.0 SQL Queries
-- In this section you will be performing various queries against the Oracle Chinook database.
-- 2.1 SELECT
-- Task – Select all records from the Employee table.
SELECT * FROM Employee;
	
-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM Employee WHERE LASTNAME = 'King';

-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM Employee WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;

-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT * FROM CUSTOMER ORDER BY CITY ASC;

-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
INSERT INTO GENRE(GENREID ,NAME) VALUES(26, 'Instrumental');
INSERT INTO GENRE(GENREID ,NAME) VALUES(27, 'Dance');

-- Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS)
VALUES(9, 'Benavides', 'Edel', 'Software Engineer', 1, '13-JAN-93', '30-OCT-17', '2919 Network PL');

INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, BIRTHDATE, HIREDATE, ADDRESS)
VALUES(10, 'Wayne', 'Bruce', 'Vigilante', '20-JAN-83', '15-MAY-14', '2434 Gotham St');

-- Task – Insert two new records into Customer table
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Email, SupportRepId)
VALUES (60, 'Edel', 'Benavides', 'Revature', '2919 Network Pl', 'Lutz', 'FL', 'USA', '33559-000', '+1 (786) 333-1577', 'edelbenavides@gmail.com', 1);

INSERT INTO Customer 
VALUES (61, 'Bruce', 'Wayne', 'Wayne Enterprises', '2434 Gotham St', 'Gotham', 'FL', 'USA', '33123-000', '+1 (786) 444-5555', '1+ (786) 444-5551', 'batman@gmail.com', 2);

-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;

-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
-- Drop original constraint from Invoice Table
ALTER TABLE Invoice
DROP CONSTRAINT FK_InvoiceCustomerId;

-- Add updated constraint with ON DELETE CASCADE
ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceCustomerIdDelete
FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId) ON DELETE CASCADE;

-- Drop original constraint from InvoiceLine Table
ALTER TABLE InvoiceLine
DROP CONSTRAINT FK_InvoiceLineInvoiceId;

-- Add updated constraint with ON DELETE CASCADE
ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceLineInvoiceIdDelete
FOREIGN KEY (InvoiceID) REFERENCES Invoice (InvoiceID) ON DELETE CASCADE;

-- Then you are able to delete
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

-- 3.0	SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION getCurrentTime 
RETURN TIMESTAMP IS 
   currentTime TIMESTAMP; 
BEGIN 
   SELECT CURRENT_TIMESTAMP into currentTime 
   FROM dual; 
	
   RETURN currentTime; 
END; 
/

-- Call Function
SELECT CURRENT_TIMESTAMP FROM dual;

-- Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION getLengthOfTrack (track_id NUMBER)
RETURN NUMBER IS 
	trackLength NUMBER := 0; 
BEGIN 
	SELECT track.bytes INTO trackLength
	FROM mediatype INNER JOIN track 
	USING (mediatypeid) WHERE track.trackid=track_id;
	
	RETURN trackLength; 
END; 
/

-- Call Function to return the length in bytes of that track number
SELECT GETLENGTHOFTRACK(1) FROM dual;

-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION getInvoicesAvg
RETURN NUMBER IS 
	total_avg NUMBER := 0; 
BEGIN 
	SELECT AVG(total) INTO total_avg FROM Invoice;
	RETURN total_avg; 
END; 
/

SELECT GETINVOICESAVG AS "Average of Total Invoices" FROM dual;

-- Task – Create a function that returns the most expensive track


-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
-- 4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.
-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
-- Task – Create a stored procedure that returns the managers of an employee.
-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.

-- 6.2 INSTEAD OF
-- Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.

-- 7.0 JOINS
-- In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT customer.firstname, customer.lastname, invoice.invoiceid
FROM customer INNER JOIN invoice 
ON customer.customerid = invoice.customerid;

-- 7.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer FULL OUTER JOIN invoice 
ON customer.customerid = invoice.customerid;

-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title
FROM album RIGHT JOIN artist
ON artist.artistid = album.artistid;

-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM artist CROSS JOIN album ORDER BY artist.name ASC;

-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
-- This selects all the employees that report to someone.
SELECT b.lastname AS "Emp Last Name", b.firstname AS "Emp First Name", b.title AS "Emp Title", b.reportsto AS "Reports To",
   a.lastname AS "Boss Last Name", a.firstname AS "Boss First Name", a.title AS "Boss Title"
FROM Employee a INNER JOIN Employee b 
ON a.employeeid = b.reportsto ORDER BY b.reportsto;

-- 8.0 Indexes
-- In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
-- 8.1 Clustered Indexes
-- Task – Create a clustered index on of table of your choice
CREATE INDEX idx_trackname_composer
ON track(name, composer);