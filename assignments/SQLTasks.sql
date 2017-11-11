-- Part I – Working with an existing database

-- 1.0	Setting up Oracle Chinook
-- In this section you will begin the process of working with the Oracle Chinook database
-- Task – Open the Chinook_Oracle.sql file and execute the scripts within.

----------------------------------------------------------------------------------------------
-- 2.0 SQL Queries
-- In this section you will be performing various queries against the Oracle Chinook database.
----------------------------------------------------------------------------------------------
-- 2.1 SELECT
-- Task – Select all records from the Employee table.
SELECT * 
FROM employee;
-- Task – Select all records from the Employee table where last name is King.
SELECT * 
FROM employee 
WHERE lastname = 'King';
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * 
FROM employee 
WHERE firstname = 'Andrew' AND REPORTSTO is NULL;

-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT title 
FROM album
ORDER BY  title DESC;
-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname
FROM customer
ORDER BY city ASC;

-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
INSERT INTO genre VALUES (26, 'Audio Books');
INSERT INTO genre VALUES (27, 'Comedy');
-- Task – Insert two new records into Employee table
INSERT INTO employee VALUES (9, 'Keener', 'Kelton', 'IT Staff', 3, '14-SEP-94', '01-JAN-17', '12345 5th St.', 'Tampa', 'FL', 'United States', '12324', '9349499582', '8485038594',  'kemail@email.com');
INSERT INTO employee VALUES (10, 'Keener', 'Camden', 'IT Staff', 3, '04-MAR-92', '01-JAN-17', '12345 5th St.', 'Tampa', 'FL', 'United States', '12324', '9349499482', '8485028594',  'cemail@email.com');
-- Task – Insert two new records into Customer table
INSERT INTO customer (customerid, firstname, lastname, email)  VALUES (60, 'Bob', 'Jones', 'bobjones@aol.com');
INSERT INTO customer (customerid, firstname, lastname, email)  VALUES (61, 'Bob', 'Smith', 'bobsmith@aol.com');

-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE  name = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%”
SELECT *
FROM invoice
WHERE billingaddress LIKE 'T%';
-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;
-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate
BETWEEN '01-JUN-2003' AND '01-MAR-2004';

-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE customer DROP CONSTRAINT FK_CustomerSupportRepId;
ALTER TABLE customer ADD CONSTRAINT FK_CustomerSupportRepId
FOREIGN KEY (CustomerSupportRepId) REFERENCES customer (customerid) ON DELETE CASCADE;

DELETE FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';

----------------------------------------------------------------------------------------------
-- 3.0	SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.
CURRENT_TIMESTAMP;
-- Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(name) FROM mediatype;
-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices
SELECT AVG(total) FROM invoice;
-- Task – Create a function that returns the most expensive track
SELECT name, unitprice FROM track
WHERE unitprice = (SELECT MAX(unitprice) FROM track);
-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION getAverageInvoice
RETURN NUMBER
IS
    n NUMBER;
BEGIN
    SELECT AVG(Total) INTO n FROM invoice;
    RETURN n;
END;
/
-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
--??????????????????????????????????
CREATE OR REPLACE
  FUNCTION func_multi_val
    RETURN VARCHAR2
  IS
    names VARCHAR2(100);
  BEGIN
    SELECT firstname INTO names FROM employee;
    return names;
  END;
  /
  


----------------------------------------------------------------------------------------------
-- 4.0 Stored Procedures
--  In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE select_first_and_last
AS
    n SYS_REFCURSOR;
BEGIN
    OPEN n FOR
    SELECT firstname, lastname FROM employee;
    dbms_sql.return_result(n);
end select_first_and_last;
/
-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_personal_info (
    var_id in NUMBER,
    var_firstname IN VARCHAR2,
    var_lastname IN VARCHAR2,
    var_title IN VARCHAR2,
    var_reportsto IN NUMBER,
    var_birthdate IN DATE,
    var_hiredate IN DATE,
    var_address IN VARCHAR2,
    var_city IN VARCHAR2,
    var_state IN VARCHAR2,
    var_country IN VARCHAR2,
    var_postalcode IN VARCHAR2,
    var_phone IN VARCHAR2,
    var_fax IN VARCHAR2,
    var_email in VARCHAR2)   
AS
BEGIN
    UPDATE employee e SET
    e.lastname = var_lastname,
    e.firstname = var_lastname,
    e.title = var_title,
    e.reportsto = var_reportsto,
    e.birthdate = var_birthdate,
    e.hiredate = var_hiredate,
    e.address = var_address,
    e.city = var_city,
    e.state = var_state,
    e.postalcode = var_postalcode,
    e.phone = var_phone,
    e.fax = var_fax,
    e.email = var_email
    WHERE employeeid = var_id;
end update_personal_info;
/
-- Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE get_manager_of_employee
(var_id IN NUMBER)
AS
    n SYS_REFCURSOR;
BEGIN
    OPEN n FOR
    SELECT firstname, lastname FROM employee WHERE employeeid = 
    (SELECT reportsto FROM employee WHERE var_id = employeeid);
    dbms_sql.return_result(n);
end get_manager_of_employee;
/
-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_name_and_company_of_cust(var_id IN NUMBER)
AS
    n SYS_REFCURSOR;
BEGIN
    OPEN n FOR
    SELECT firstname, lastname, company FROM customer WHERE var_id = customerid;
    dbms_sql.return_result(n);
    
end get_name_and_company_of_cust;
/


----------------------------------------------------------------------------------------------
-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).\
ALTER TABLE INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID;
ALTER TABLE INVOICELINE ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId) ON DELETE CASCADE;

CREATE OR REPLACE PROCEDURE  delInv (var_invoiceid IN INT)
AS
BEGIN
DELETE FROM invoice WHERE invoiceid=var_invoiceid;              
END delInv;
/
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE newRecTransaction (
var_customerid IN VARCHAR2, var_firstname IN VARCHAR2, var_lastname IN VARCHAR2, var_email IN VARCHAR2)
AS
BEGIN
INSERT INTO CUSTOMER (customerid, firstname, lastname, email)
VALUES (var_customerid, var_firstname, var_lastname, var_email);
END;
/

----------------------------------------------------------------------------------------------
-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER employee_inserted_trigger
AFTER INSERT ON employee
BEGIN
   dbms_output.put_line('Inserted into employee.');
end;
/
-- Task – Create an after update trigger on the album table that fires after a row is updated in the table
CREATE OR REPLACE TRIGGER album_update_trigger
AFTER UPDATE ON album
BEGIN
   dbms_output.put_line('Updated album row.');
end;
/
-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_delete_trigger
AFTER DELETE ON customer
BEGIN
   dbms_output.put_line('Customer deleted.');
end;
/
-- 6.2 INSTEAD OF
CREATE OR REPLACE TRIGGER prevent_delete
INSTEAD OF DELETE ON customer
BEGIN
   dbms_output.put_line('Customer deleted.');
end;
/
----------------------------------------------------------------------------------------------
-- 7.0 JOINS
-- In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT firstname, lastname, invoiceid
FROM customer
INNER JOIN invoice USING (customerid);
-- 7.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customerid, firstname, lastname, invoiceid, total
FROM customer
OUTER JOIN invoice USING (customerid);
-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT name, title
FROM artist
RIGHT JOIN album USING (artistid); 
-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT name, title
FROM artist
CROSS JOIN album;
-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.lastname, b.lastname
FROM employee a, employee b
WHERE a.reportsto = b.employeeid;

----------------------------------------------------------------------------------------------
-- 8.0 Indexes
-- In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
-- 8.1 Clustered Indexes
-- Task – Create a clustered index on of table of your choice
CREATE INDEX idx_names 
ON customer(firstname, lastname);

