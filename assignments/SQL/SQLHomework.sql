-- KYLE SETTLES

-- 2.0 SQL Queries
-- In this section you will be performing various queries against the Oracle Chinook database.
-- 2.1 SELECT
-- Task – Select all records from the Employee table.
SELECT * FROM Employee;

-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM Employee
WHERE LASTNAME = 'King';

-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM Employee
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO is NULL;

-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM Album
ORDER BY TITLE desc;

-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM Customer
ORDER BY CITY ASC;

-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
INSERT INTO Genre (genreid, name)
VALUES (26, 'Hype');
INSERT INTO Genre(genreid, name)
VALUES (27, 'Awesome');

-- Task – Insert two new records into Employee table
INSERT INTO Employee(employeeid, lastname, firstname)
    VALUES (9, 'Settles', 'Kyle');
INSERT INTO Employee(employeeid, lastname, firstname)
    VALUES (10, 'Smith', 'John');

-- Task – Insert two new records into Customer table
INSERT INTO Customer(customerid, firstname, lastname, email)
    VALUES (60, 'Kyle', 'Settles', 'kyle@email.com');
INSERT INTO Customer(customerid, firstname, lastname, email)
    VALUES (61, 'John', 'Johnson', 'john@email.com');

-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' and LASTNAME = 'Mitchell';

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';

-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;

-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate BETWEEN TO_DATE('01-JUN-03', 'DD-MON-YY') AND TO_DATE('01-MAR-04', 'DD-MON-YY');

-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM invoiceline
where invoiceid in (245,268,290,342,50,61,116);

DELETE FROM invoice
where customerid = 32;

DELETE FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';

-- 3.0	SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.
SELECT TO_CHAR(SYSDATE,'HH24:MI:SS') FROM dual;

-- Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(name) FROM mediatype;

-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices
SELECT AVG(total) "Total" FROM invoice;

-- Task – Create a function that returns the most expensive track
SELECT unitprice FROM track ORDER BY unitprice;
SELECT MAX(unitprice) "Most Expensive" FROM track;

-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT AVG(unitprice) "Average Price" FROM invoiceline;

-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
SELECT * FROM employee
WHERE birthdate > TO_DATE('01-JAN-1968', 'DD-MON-YY');

-- 4.0 Stored Procedures
--  In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE selectAllEmployees(
    emp_firstname OUT VARCHAR2,
    emp_lastname OUT VARCHAR2
)
AS
BEGIN
    SELECT firstname, lastname 
    INTO emp_firstname, emp_lastname 
    FROM employee;
END;

-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE updateEmployee(
    emp_id IN employee.employeeid%TYPE,
    new_first IN employee.firstname%TYPE,
    new_last IN employee.lastname%TYPE,
)
AS
BEGIN
    UPDATE employee
    SET firstname = new_first, lastname = new_last
    WHERE employeeid = emp_id;
END;

-- Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE managerFinder(
    emp_id IN employee.employeeid%TYPE,
    manager OUT employee.reportsto%TYPE
)
AS
BEGIN
    SELECT reportsto
    INTO manager
    FROM employee WHERE employeeid = emp_id;
END;

-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE customerInfo(
    cust_id IN customer.customerid%TYPE,
    cust_fname OUT customer.firstname%TYPE,
    cust_lname OUT customer.lastname%TYPE,
    cust_company OUT customer.company%TYPE
)
AS
BEGIN
    SELECT firstname, lastname, company
    INTO cust_fname, cust_lname, cust_company
    FROM customer WHERE customerid = cust_id;
END;

-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID;
ALTER TABLE INVOICELINE ADD CONSTRAINT FK_INVOICELINEINVOICEID
    FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId) ON DELETE CASCADE;

CREATE OR REPLACE PROCEDURE deleteInvoice (
    invoice_id IN invoice.invoiceid%TYPE
)
AS
BEGIN 
    DELETE FROM invoice WHERE
    invoiceid = invoice_id;
END;
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insertRecord (
    cust_id IN customer.customerid%TYPE,
    cust_fname IN customer.firstname%TYPE,
    cust_lname IN customer.lastname%TYPE,
    cust_email IN customer.email%TYPE
)
AS
BEGIN
    INSERT INTO customer (customerid, firstname, lastname,email)
    VALUES (cust_id, cust_fname, cust_lname, cust_email);
end;

-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER newInsert
AFTER INSERT
    ON employee
    FOR EACH ROW
BEGIN
    INSERT INTO employee
    VALUES (
        :old.employeeid,
        :old.lastname,
        :old.firstname,
        :old.title,
        :old.reportsto,
        :old.birthdate,
        :old.hiredate,
        :old.address,
        :old.city,
        :old.state,
        :old.country,
        :old.postalcode,
        :old.phone,
        :old.fax,
        :old.email
    );
END;

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER updateAfterRow
AFTER UPDATE
    ON album 
    FOR EACH ROW
BEGIN
    INSERT INTO album (albumid, title, artistid)
    VALUES (
        :new.albumid,
        :new.title,
        :new.artistid
    );
END;

-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER afterDeleteCust
AFTER DELETE   
    ON customer 
    FOR EACH ROW
BEGIN
    -- no idea what I need to do here
END;

-- 6.2 INSTEAD OF
-- Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.

-- Could not figure it out... Sorry

-- 7.0 JOINS
-- In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT customer.firstname, customer.lastname, invoice.invoiceId FROM customer
INNER JOIN invoice ON customer.customerid = invoice.customerid;

-- 7.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer
LEFT OUTER JOIN invoice ON customer.customerid = invoice.customerid;

-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT album.title, artist.name FROM album
RIGHT OUTER JOIN artist ON album.artistid = artist.artistid;

-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM artist, album ORDER BY artist.name;

-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.firstname, a.lastname, b.firstname, b.lastname
FROM employee a, employee b
where a.reportsto = b.employeeid;

-- 8.0 Indexes
-- In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
-- 8.1 Clustered Indexes
-- Task – Create a clustered index on a table of your choice
create table test
(
   test_id  integer not null, 
   cust_id     integer not null, 
   primary key (test_id, cust_id)
)
organization index;