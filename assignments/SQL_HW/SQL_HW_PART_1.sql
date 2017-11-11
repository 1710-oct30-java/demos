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
   SELECT CURRENT_TIMESTAMP INTO currentTime 
   FROM dual; 
	
   RETURN currentTime; 
END; 
/

-- Call Function
SELECT getCurrentTime FROM dual;


-- Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION getMediatypeLength(media_id NUMBER)
RETURN NUMBER IS
    mediaLength NUMBER := 0;
BEGIN
    SELECT LENGTH(name) INTO mediaLength FROM mediatype WHERE mediatypeid = media_id;
    RETURN mediaLength;
END;
/

-- Returns the number of characters of the name mediatype
SELECT getMediatypeLength(1) FROM dual;

						-- OR -- this is extra
-- This function returns the length of the track in bytes
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
SELECT name, unitprice FROM track
WHERE unitprice = (SELECT MAX(unitprice) FROM track);


-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avgTotalInvoiceline
RETURN NUMBER IS
    avgTotal NUMBER :=0;
BEGIN
    SELECT AVG(unitprice) INTO avgTotal FROM invoiceline;
    RETURN avgTotal;
END;
/

SELECT avgTotalInvoiceline AS "Average Price" FROM dual;


-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
SELECT * FROM employee
WHERE birthdate > '01-JAN-68';


-- 4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE employeeNames 
AS 
	emp SYS_REFCURSOR;  
BEGIN
	open emp for
	SELECT firstname AS "First Name", lastname AS "Last Name" FROM employee;
	DBMS_SQL.RETURN_RESULT(emp);
END; 
/

EXECUTE employeeNames;


-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE updateEmployee(
    employee_id IN employee.employeeid%TYPE,
    employee_firstName IN employee.firstname%TYPE,
    employee_lastName IN employee.lastname%TYPE,
    employee_dob IN employee.birthdate%TYPE,
    employee_email IN employee.email%TYPE,
    employee_phone IN employee.phone%TYPE,
    employee_fax IN employee.fax%TYPE)
IS
BEGIN
    -- updates employee but doesn't change column value if input if empty
    UPDATE employee SET
    firstname = NVL(employee_firstName, (SELECT firstname FROM employee WHERE employeeid = employee_id)),
    lastname = NVL(employee_lastName, (SELECT lastname FROM employee WHERE employeeid = employee_id)),
    birthdate = NVL(employee_dob, (SELECT birthdate FROM employee WHERE employeeid = employee_id)),
    email = NVL(employee_email, (SELECT email FROM employee WHERE employeeid = employee_id)),
    phone = NVL(employee_phone, (SELECT phone FROM employee WHERE employeeid = employee_id)),
    fax = NVL(employee_fax, (SELECT fax FROM employee WHERE employeeid = employee_id))
    WHERE employeeid = employee_id;
    
    COMMIT;

END;
/

-- stored procedure updates only the phone number in this example
-- updateEmployee(emp_id, fname, lname, dob, email, phone, fax)
EXECUTE updateEmployee(2, '', '', '', '', '+1 (403) 163 2222', '');


-- Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE employeeManagers (employee_id NUMBER)
AS 
    emp SYS_REFCURSOR;  
BEGIN

    open emp for
    
	-- Subquery returns the manager of employee
    SELECT lastname AS "BOSS Last Name", firstname AS "BOSS First Name" FROM employee 
    WHERE employeeid = (SELECT reportsto FROM employee WHERE employeeid = employee_id);
    
    DBMS_SQL.RETURN_RESULT(emp);
END; 
/

EXECUTE employeeManagers(2);


-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE customerCompany (customer_id NUMBER)
AS 
    emp SYS_REFCURSOR;  
BEGIN

    open emp for
    
	-- Subquery returns the manager of employee
    SELECT firstname AS "First Name", lastname AS "Last Name", company AS "Company"
    FROM customer WHERE customerid = customer_id;
    
    DBMS_SQL.RETURN_RESULT(emp);
END; 
/

EXECUTE customerCompany(1);


-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE deleteInvoice(invoice_id NUMBER)
AS
BEGIN
    DELETE FROM invoice
    WHERE invoiceid = invoice_id;
END;
/
-- I already had updated the constraint with ON DELETE CASCADE on previous question
-- Does not auto commit so you can rollback just in case
EXECUTE deleteInvoice(114);


-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insertCustomer
(
first_name IN customer.firstname%TYPE,
last_name IN customer.lastname%TYPE,
cust_email IN customer.email%TYPE
)
AS
lastID NUMBER := 0;
BEGIN
    -- Get last(max) customer id, add it to variable and increment it
    -- It will be inserted into the table as the new customer id
    SELECT MAX(customerid) INTO lastID FROM customer;
    lastID := lastID + 1;
    
    INSERT INTO customer (customerid, firstname, lastname, email)
    VALUES (lastID, first_name, last_name, cust_email);
END;
/

EXECUTE insertCustomer('Peter', 'Parker', 'spiderman@gmail.com');


-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
-- This audit table will keep record of all employees, even if deleted from the employee table
CREATE TABLE employee_audit
(
    employeeid NUMBER NOT NULL,
    firstname VARCHAR2(50) NOT NULL,
    lastname VARCHAR2(50) NOT NULL,
    email VARCHAR2(100) NOT NULL
);

-- Trigger will insert employee into audit table.
CREATE OR REPLACE TRIGGER employees_after_insert
AFTER INSERT ON employee
    FOR EACH ROW
BEGIN    
    -- Insert record into audit table
    INSERT INTO employee_audit (employeeid, firstname, lastname, email)
    VALUES (:new.employeeid, :new.firstname, :new.lastname, :new.email );
END;
/

INSERT INTO employee (employeeid, firstname, lastname, email)
VALUES (63, 'Peter', 'Parker', 'spiderman@gmail.com');

SELECT * FROM employee;
SELECT * FROM employee_audit;


-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
-- This audit table will keep record of all album, even if deleted from the album table
CREATE TABLE album_audit
(
    albumid NUMBER NOT NULL,
    title VARCHAR2(255) NOT NULL,
    artistid NUMBER
);

CREATE OR REPLACE TRIGGER album_after_insert
AFTER INSERT ON album
FOR EACH ROW
BEGIN
	-- Insert record into audit table
   INSERT INTO album_audit(albumid, title, artistid)
   VALUES(:new.albumid, :new.title, :new.artistid);
END;
/

INSERT INTO album (albumid, title, artistid)
VALUES (630, 'Christmas Jazz', 2);


-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
-- This audit table will keep record of all deleted customers
CREATE TABLE customer_audit
(
    customerid NUMBER NOT NULL,
    firstname VARCHAR2(30) NOT NULL,
    lastname VARCHAR2(30) NOT NULL,
    email VARCHAR2(100) NOT NULL,
    transactionDate TIMESTAMP
);

CREATE OR REPLACE TRIGGER customer_after_delete
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    -- Insert customer info into customer_audit table
    INSERT INTO customer_audit(customerid, firstname, lastname, email, transactionDate)
    VALUES(:old.customerid, :old.firstname, :old.lastname, :old.email, (SELECT CURRENT_TIMESTAMP FROM dual));
END;
/

DELETE FROM customer WHERE customerid = 50;


-- 6.2 INSTEAD OF
-- Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE VIEW vw_invoice
AS
SELECT * FROM invoice;

-- attempt 1
CREATE OR REPLACE TRIGGER trg_prevent_delete
    INSTEAD OF DELETE ON vw_invoice
    FOR EACH ROW
BEGIN
    DELETE FROM invoice
    WHERE :old.total < 50;
END;
/

-- attempt 2
CREATE OR REPLACE TRIGGER trg_prevent_delete_2
  BEFORE DELETE ON invoice
  FOR EACH ROW
  WHEN(old.total < 50)
begin
  dbms_output.put_line( 'Record can not be deleted because total is $50+');
end;
/


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