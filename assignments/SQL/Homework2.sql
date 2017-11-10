-- 2.0 SQL Queries
-- In this section you will be performing various queries against the Oracle Chinook database.
-- 2.1 SELECT
-- Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE
	WHERE LASTNAME='King';

-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
	WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;

-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM
    ORDER BY TITLE DESC;

-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER
    ORDER BY CITY ASC;

-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
INSERT INTO GENRE (GENREID, NAME)
    VALUES (26, 'Classic Rock');
INSERT INTO GENRE (GENREID, NAME)
    VALUES (27, 'Symphonic Metal');

-- Task – Insert two new records into Employee table
-- [Micah] Most of the fields were left empty on these because I didn't want to fabricate that amount of information. All fields not listed here default to null.
INSERT INTO EMPLOYEE (EmployeeId, LastName, FirstName, Title)
    VALUES (9, 'West', 'Micah', 'Trainee');
INSERT INTO EMPLOYEE (EmployeeId, LastName, FirstName, Title)
    VALUES (10, 'Kruppa', 'Black', 'Trainer');

-- Task – Insert two new records into Customer table
INSERT INTO CUSTOMER (CustomerId, FirstName, LastName, Email)
    VALUES(60, 'Micah', 'West', 'micahwest13@gmail.com');
INSERT INTO CUSTOMER (CustomerId, FirstName, LastName, Email)
    VALUES(61, 'Blake', 'Kruppa', 'black.kruppa@revature.com');

-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
-- [Micah] Technically I could have fetched his customer id and then used that, but the question asked for Aaron Mitchell, not customer number 32.
UPDATE CUSTOMER
    SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
    WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
    SET NAME = 'CCR'
    WHERE NAME = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE
    WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
    WHERE TOTAL BETWEEN 15 AND 50;

-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
    WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
-- [Micah] Because Invoice table has foreign key constraints to the Customer, these tables need to be altered to allow for cascading deletions.
ALTER TABLE InvoiceLine
   DROP CONSTRAINT FK_InvoiceLineInvoiceId;
   
ALTER TABLE InvoiceLine
   ADD CONSTRAINT FK_InvoiceLineInvoiceId
   FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId) ON DELETE CASCADE;
   
ALTER TABLE Invoice
   DROP CONSTRAINT FK_InvoiceCustomerId;
   
ALTER TABLE Invoice
   ADD CONSTRAINT FK_InvoiceCustomerId
   FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId) ON DELETE CASCADE;

-- [Micah] Then Oracle SQL will allow you to delete the record.
DELETE FROM CUSTOMER
    WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';

-- SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION getTime
RETURN VARCHAR2
AS
BEGIN
    RETURN SYSTIMESTAMP;
END getTime;

-- Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION media_length
(media_id IN NUMBER)
RETURN NUMBER
AS
media_type NUMBER;
BEGIN
	SELECT LENGTH(name) INTO media_type FROM mediatype where mediatypeid = media_id;
	RETURN media_type;
END media_length;

-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION average_invoice
RETURN NUMBER
AS
temp_avg NUMBER(10, 2);
BEGIN
    SELECT AVG(total) INTO temp_avg FROM invoice;
    RETURN temp_avg;
END average_invoice;

-- Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION max_track
RETURN NUMBER
AS
temp_max NUMBER(10, 2);
BEGIN
    SELECT MAX(unitprice) INTO temp_max FROM track;
    RETURN temp_max;
END max_track;

-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_invoiceline
RETURN NUMBER
AS
temp_avg NUMBER(6,2);
BEGIN
    SELECT AVG(unitprice) INTO temp_avg FROM invoiceline;
    RETURN temp_avg;
END avg_invoiceline;

-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION bornAfter1968
RETURN SYS_REFCURSOR
AS
resultSet SYS_REFCURSOR;
BEGIN
    OPEN resultSet FOR
		SELECT * FROM employee WHERE birthdate >= '01-JAN-1969';
    RETURN resultSet;
END bornAfter1968;

-- 4.0 Stored Procedures
 -- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE selectEmployees
(resultSet OUT sys_refcursor)
AS
BEGIN
    OPEN resultSet FOR SELECT firstname, lastname FROM employee;
END selectEmployees;

-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE updateEmployeeContact
(iemployeeId IN NUMBER, iaddress IN VARCHAR2, icity IN VARCHAR2, istate IN VARCHAR2, icountry IN VARCHAR2, 
    ipostalcode IN VARCHAR2, iphone IN VARCHAR2, ifax IN VARCHAR2, iemail IN VARCHAR2)
AS
BEGIN
    UPDATE employee
        SET address = iaddress, city = icity, state = istate, country = icountry, postalcode = ipostalcode,
            phone = iphone, fax = ifax, email = iemail
        WHERE employeeid = iemployeeid;
END updateEmployeeContact;

-- Task – Create a stored procedure that returns the managers of an employee.
-- [Micah] Pass in a cursor to keep the result set in.
CREATE OR REPLACE PROCEDURE getManager
(iemployeeid IN NUMBER, resultSet OUT sys_refcursor)
AS
BEGIN
    OPEN resultSet FOR 
        SELECT reportsto FROM employee
            WHERE employeeid = iemployeeid;
END getManager;

-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
-- [Micah] Pass in a cursor to keep the result set in.
CREATE OR REPLACE PROCEDURE getCustomerInfo
(icustomerid IN NUMBER, resultSet OUT sys_refcursor)
AS
BEGIN
    OPEN resultSet FOR 
        SELECT firstname, lastname, company FROM customer
            WHERE customerid = icustomerid;
END getCustomerInfo;

-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
-- [Micah] Similar to 2.7, InvoiceLine has constraints on Invoice. Change those constraints with cascading delete.
ALTER TABLE InvoiceLine
   DROP CONSTRAINT FK_InvoiceLineInvoiceId;
   
ALTER TABLE InvoiceLine
   ADD CONSTRAINT FK_InvoiceLineInvoiceId
   FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId) ON DELETE CASCADE;
   
CREATE OR REPLACE PROCEDURE deleteInvoice
(iinvoiceid IN NUMBER)
AS
BEGIN
    DELETE FROM invoice
        WHERE invoiceid = iinvoiceid;
    commit;
END deleteInvoice;

-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
-- [Micah] This sequence wasn't generated by default but it'd be useful to automatically generate primary keys.
CREATE SEQUENCE customer_seq;

CREATE OR REPLACE PROCEDURE insertCustomer
(ifirstname IN VARCHAR2, ilastname IN VARCHAR2, iemail IN VARCHAR2)
AS
BEGIN
    INSERT INTO customer (customerid, firstname, lastname, email)
        VALUES (customer_seq.nextVal, ifirstname, ilastname, iemail);
    commit;
END insertCustomer;

-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER employee_after_hiredDate
    AFTER INSERT ON employee
    BEGIN
        UPDATE employee
            SET hiredate = SYSDATE
            WHERE employeeid = (SELECT MAX(employeeid) FROM employee);
    END;

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_after_insert
    AFTER INSERT ON album
    BEGIN
        dbms_output.put_line('In album_after_insert');
    END;

-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_after_delete
    AFTER DELETE ON customer
    BEGIN
        dbms_output.put_line('In customer_after_delete');
    END;

-- 6.2 INSTEAD OF
-- Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE VIEW invoice_view AS SELECT * FROM invoice;

CREATE OR REPLACE TRIGGER invoice_instead_of_del
    INSTEAD OF DELETE ON invoice_view
    BEGIN
        IF :old.total <= 50 THEN
            DELETE FROM invoice
                WHERE :old.invoiceid = invoiceid;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Invoice worth more than $50. Record not deleted.');
        END IF;
    END;

-- 7.0 JOINS
-- In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
-- [Micah] Since INSTEAD OF cannot be applied to a table, we have to create a view for the invoice table.

CREATE OR REPLACE VIEW invoice_view AS SELECT * FROM invoice;
SELECT * FROM invoice_view ORDER BY TOTAL DESC; -- To show that the view's output matches the table's

SELECT firstname, lastname, invoiceId FROM customer INNER JOIN invoice USING(customerid);

-- 7.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CustomerId, firstname, lastname, invoiceId, total
    FROM customer
    FULL OUTER JOIN invoice
    USING(customerid);

-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT name, title
    FROM album RIGHT JOIN artist
    USING(artistid);

-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM artist, album
    ORDER BY artist.name ASC;

-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT *
    FROM employee e1 INNER JOIN employee e2
    ON (e1.reportsto = e2.employeeid);
-- 8.0 Indexes
-- In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
-- 8.1 Clustered Indexes
-- Task – Create a clustered index on of table of your choice
CREATE INDEX index_musicalbum
    ON track(albumid, trackid);
