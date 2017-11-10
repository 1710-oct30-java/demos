--Part I – Working with an existing database
--
--1.0	Setting up Oracle Chinook
--In this section you will begin the process of working with the Oracle Chinook database
--Task – Open the Chinook_Oracle.sql file and execute the scripts within.
--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM Employee;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM Employee WHERE LASTNAME='King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM Employee WHERE FIRSTNAME='Andrew' AND REPORTSTO=NULL;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT TITLE FROM ALBUM ORDER BY TITLE DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER ORDER BY city ASC;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO GENRE (GENREID, NAME)
VALUES (100, 'newGENRE');
INSERT INTO GENRE (GENREID, NAME)
VALUES (101, 'newerGENRE');
--Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE (EMAIL, FIRSTNAME, LASTNAME, EMPLOYEEID)
VALUES ('email@internet.com', 'Brandon', 'Richardson', 200);
INSERT INTO EMPLOYEE (EMAIL, FIRSTNAME, LASTNAME, EMPLOYEEID)
VALUES ('anotheremail@internet.com', 'Summer', 'Richardson', 201);
--Task – Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, COUNTRY, LASTNAME, FIRSTNAME, EMAIL)
VALUES (100, 'USA', 'Richardson', 'Brandon', 'brichardson1222@yahoo.com');
INSERT INTO CUSTOMER (CUSTOMERID, COUNTRY, LASTNAME, FIRSTNAME, EMAIL)
VALUES (101, 'England', 'Rooney', 'Wayne', 'rooney@email.com');
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer
SET FirstName = 'Robert', LastName= 'Walker'
WHERE CustomerID = 32;
commit;
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist
SET NAME='CCR'
WHERE NAME='Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE WHERE billingaddress LIKE 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE 
WHERE HIREDATE BETWEEN '01-JUN-2003' AND '01-MAR-2004';
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE customer DROP CONSTRAINT FK_CustomerSupportRepId;
ALTER TABLE customer ADD CONSTRAINT FK_CustomerSupportRepId
   FOREIGN KEY (SupportRepId) REFERENCES Employee (EmployeeId); 
DELETE FROM CUSTOMER WHERE firstname='Robert' AND lastname = 'Walker';
--
--3.0	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION returnTime
RETURN TIMESTAMP
AS
cur_time TIMESTAMP;
BEGIN
    SELECT CURRENT_TIMESTAMP INTO cur_time FROM dual;
    RETURN cur_time;
END;
/
SELECT returnTime FROM dual;
--Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION returnLength
RETURN NUMBER
AS
mt_length NUMBER;
BEGIN
    SELECT LENGTH(name) INTO mt_length FROM mediatype WHERE MEDIATYPEID = 1;
    RETURN mt_length;
END;
/
SELECT returnLength FROM dual;
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION returnAvg
RETURN NUMBER
AS
invoice_avg NUMBER;
BEGIN
    SELECT AVG(total) INTO invoice_avg FROM INVOICE;
    RETURN invoice_avg;
END;
/
SELECT returnAvg FROM dual;
--Task – Create a function that returns the most expensive track
SELECT NAME, UNITPRICE FROM TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION returnAvg
RETURN NUMBER
AS
avg_price NUMBER;
BEGIN
    SELECT AVG(unitprice) INTO avg_price FROM INVOICELINE;
    RETURN avg_price;
END;
/
SELECT returnAvg FROM dual;
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
SELECT * FROM table (get_emps) WHERE birthdate > date '1968-12-31';
--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE getNames
AS
num_1 SYS_REFCURSOR;
BEGIN 
    OPEN num_1 FOR
    SELECT firstname, lastname FROM employee;
    dbms_sql.return_result(num_1);
END getNames;
/
EXECUTE getNames;
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE procedure updateEmployee
(employee_id IN NUMBER, newFirstName IN VARCHAR2, 
newLastName IN VARCHAR2, newBirthDate IN VARCHAR2,
newAddress IN VARCHAR2, newCity IN VARCHAR2,
newState IN VARCHAR2, newPostalCode IN VARCHAR2,
newPhone IN VARCHAR2, newEmail IN VARCHAR2
)
AS 
BEGIN 
    UPDATE employee SET firstname = newFirstName, lastname = newLastName, birthdate = newBirthDate,
    address = newAddress, city = newCity, state = newState, postalcode = newPostalCode,
    phone = newPhone, email = newEmail WHERE employeeid=employee_id;
END updateEmployee;
/
EXECUTE updateEmployee(1, 'Brandon', 'Richardson', '31-JUL-1994', '110 Mountain Ridge Road', 'Millbrook', 'Alabama', '36054', '334-313-4594', 'brich13@email.com');
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE procedure returnManager(employee_id IN NUMBER)
AS 
emp SYS_REFCURSOR;
BEGIN 
    OPEN emp FOR
    SELECT firstname, lastname FROM EMPLOYEE WHERE employeeid = 
    (SELECT reportsto FROM EMPLOYEE WHERE employee_id=employeeid);
    dbms_sql.return_result(emp);
END returnManager;
/
EXECUTE returnManager(2);
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE procedure returnNameAndCompany(customer_id IN NUMBER)
AS 
cust SYS_REFCURSOR;
BEGIN 
    OPEN cust FOR
    SELECT firstname, lastname, company FROM customer WHERE customerid=customer_id;
    dbms_sql.return_result(cust);
END returnNameAndCompany;
/
EXECUTE returnNameAndCompany(2);
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE invoiceline DROP CONSTRAINT FK_InvoiceLineInvoiceId;
ALTER TABLE Invoiceline ADD CONSTRAINT FK_InvoiceLineInvoiceId
    FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId)  ON DELETE CASCADE;
CREATE OR REPLACE procedure deleteInvoiceID(invoice_id IN INT)
AS 
BEGIN
    DELETE FROM invoice WHERE invoiceid=invoice_id;
END deleteInvoiceID;
/
EXECUTE deleteInvoiceID(1);
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER emp_insert_trig
AFTER INSERT ON employee
BEGIN
    dbms_output.put_line('employee insert trigger');
END;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER alb_insert_trig
AFTER INSERT ON album
BEGIN
    dbms_output.put_line('album insert trigger');
END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_delete_trig
AFTER DELETE ON customer
BEGIN
    dbms_output.put_line('customer delete trigger');
END;
/
--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.

CREATE VIEW viewInvoice
AS SELECT * FROM invoice;

CREATE OR REPLACE TRIGGER inv_delete_trig
INSTEAD OF DELETE ON viewInvoice
BEGIN
    IF :new.total > 50 THEN
    dbms_output.put_line('cannot delete invoice over $50');
    END IF;
END;
/
--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT cust.firstname, cust.lastname, inv.invoiceid 
    FROM customer cust INNER JOIN invoice inv 
        ON(cust.customerid = inv.invoiceid)
            ORDER BY cust.firstname, inv.invoiceid ASC;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT cust.customerid, cust.firstname, cust.lastname, inv.invoiceid, inv.total 
    FROM customer cust FULL OUTER JOIN invoice inv 
        ON(cust.customerid = inv.invoiceid);
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT * FROM album alb RIGHT JOIN artist art ON(alb.albumid = art.artistid);
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM album CROSS JOIN artist;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM employee a INNER JOIN employee b USING(reportsto);
--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice
CREATE TABLE PlaylistIndex
(
    PlaylistId,
    Name,
    CONSTRAINT PK_PlaylistIndex PRIMARY KEY  (PlaylistId)
)
ORGANIZATION INDEX TABLESPACE users
AS SELECT * FROM playlist;