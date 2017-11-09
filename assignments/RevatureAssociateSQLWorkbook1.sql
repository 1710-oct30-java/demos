-- Part I – Working with an existing database

--     1.0 Setting up Oracle Chinook
-- In this section you will begin the process of working with the Oracle Chinook database
-- Task – Open the Chinook_Oracle.sql file and execute the scripts within.

-- 2.0 SQL Queries
-- In this section you will be performing various queries against the Oracle Chinook database.
-- 2.1 SELECT
-- Task – Select all records from the Employee table.
SELECT * FROM employee;
-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM employee WHERE lastname = 'King';
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee WHERE firstname = 'Andrew' and REPORTSTO = NULL;
-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album ORDER BY title;
-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM customer ORDER BY city;
-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
INSERT INTO Genre (genreid,name) VALUES (26,'better');
INSERT INTO Genre (genreid,name) VALUES (27,'best');
-- Task – Insert two new records into Employee table
INSERT INTO employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'prime', '01', 'super', 6, TO_DATE('1968-1-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 7 ST NW', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 467-3351', '+1 (403) 467-8772', 'prime@chinookcorp.com');
INSERT INTO employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'second', '02', 'minor', 6, TO_DATE('1968-1-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 7 ST NW', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 467-3351', '+1 (403) 467-8772', 'second@chinookcorp.com');
-- Task – Insert two new records into Customer table
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (60, 'doe', 'john', '1 one rd', 'one', 'One', '111111', '+123', 'onek@one.com', 3);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (61, 'doe', 'jane', '2 two st', 'one', 'One', '222222', '+321', 'two@two.in', 3);
-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer SET firstname = 'Robert',lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';
-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';
-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total between 15 AND 50;
-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee WHERE hiredate between '1-JUN-2003' AND '1-MAR-2004';
-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE InvoiceLine
    DROP CONSTRAINT FK_InvoiceLineInvoiceId;

ALTER TABLE InvoiceLine ADD CONSTRAINT FK_InvoiceLineInvoiceId
    FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId)
    ON DELETE CASCADE;

ALTER TABLE invoice
    DROP CONSTRAINT FK_InvoiceCustomerId;

ALTER TABLE invoice ADD CONSTRAINT FK_InvoiceCustomerId
    FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId)
    ON DELETE CASCADE;
    
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';

--     3.0 SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION myCurrentTime
RETURN TIMESTAMP AS out_var TIMESTAMP;
begin
    SELECT  CURRENT_TIMESTAMP INTO out_var FROM DUAL;
    RETURN out_var;
END;
/
-- Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION mediatype_length
(mtid IN NUMBER)
RETURN NUMBER AS out_var NUMBER;
begin
    SELECT  LENGTH(mediatype.name) INTO out_var from mediatype where mediatypeid = mtid;
    RETURN out_var;
END;
/

-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION average_invoice_total
RETURN NUMBER AS out_var NUMBER;
begin
    SELECT  AVG(invoice.total) INTO out_var FROM invoice;
    RETURN out_var;
END;
/

-- Task – Create a function that returns the most expensive track
create or replace function get_most_expensive_track
return sys_refcursor is
v_curs sys_refcursor;
maxprice number;
begin
    select max(t.unitprice) into maxprice from track t;
    open v_curs for select * from track
    where UNITPRICE = maxprice;
    return v_curs;
end;
/
--to run
-- var rc refcursor;
-- exec :rc := get_most_expensive_track;
-- print rc;

-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION average_invoiceline_price
RETURN NUMBER AS out_var NUMBER;
begin
    SELECT  AVG(unitprice)  INTO out_var 
    FROM invoice i
    INNER JOIN invoiceline l
    ON (i.invoiceid = l.invoiceid);
    
    RETURN out_var;
END;
/


-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
create or replace function employee_after68
return sys_refcursor is
v_curs sys_refcursor;
begin
    open v_curs for select * from employee
    where birthdate > '31-DEC-68';
    return v_curs;
end;
/

--to run
-- var rc refcursor;
-- exec :rc := employee_after68;
-- print rc;

-- 4.0 Stored Procedures
--  In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE empNames AS
    firstname EMPLOYEE.FIRSTNAME%TYPE;
    lastname EMPLOYEE.LASTNAME%TYPE;
    CURSOR names IS
         SELECT firstname, lastname FROM employee;
BEGIN
 dbms_output.put_line('test'); 
    OPEN names; 
    LOOP 
    FETCH names into firstname, lastname; 
        EXIT WHEN names%notfound; 
        dbms_output.put_line(firstname || ' ' || lastname); 
    END LOOP; 
    CLOSE names; 
END;
/

-- SET SERVEROUT ON;
-- exec EMPNAMES;

-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE empUpdate AS  
BEGIN
    UPDATE employee
    SET city = 'City'
    Where city <> 'City';
END;
/

-- Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE empManager
(empID IN number)AS
    firstname EMPLOYEE.FIRSTNAME%TYPE;
    lastname EMPLOYEE.LASTNAME%TYPE;
    CURSOR names IS
         SELECT b.firstname, b.lastname 
         FROM employee b 
         INNER JOIN employee g
         ON (g.reportsto = b.employeeid)
         WHERE g.employeeid = empID;
BEGIN
    OPEN names; 
    LOOP 
    FETCH names into firstname, lastname; 
        EXIT WHEN names%notfound; 
        dbms_output.put_line(firstname || ' ' || lastname); 
    END LOOP; 
    CLOSE names; 
END;
/

-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE custNameComp
(cusID IN number)
AS
    firstname customer.FIRSTNAME%TYPE;
    lastname customer.LASTNAME%TYPE;
    company customer.COMPANY%TYPE;
    CURSOR names IS
         SELECT firstname, lastname, company
         FROM customer
         WHERE cusID = CUSTOMERID;
BEGIN
    OPEN names; 
    LOOP 
    FETCH names into firstname, lastname, company; 
        EXIT WHEN names%notfound; 
        dbms_output.put_line(firstname || ' ' || lastname || ' ' || company); 
    END LOOP; 
    CLOSE names; 
END;
/

-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE invDelete 
(invID IN number) AS
BEGIN
   DELETE FROM invoice
   WHERE invID = invoiceid;
   COMMIT;
END;
/
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE newCust 
(cid IN NUMBER, fname IN VARCHAR2, lname IN VARCHAR2, comp IN VARCHAR2,
add IN VARCHAR2, city IN VARCHAR2, st IN VARCHAR2, cnty IN VARCHAR2,
pc IN VARCHAR2, phn IN VARCHAR2, fx IN VARCHAR2, eml IN VARCHAR2, sprpid IN NUMBER) 
AS
BEGIN
   INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) 
   VALUES (cid, fname, lname, comp, add, city, st, cnty, pc, phn, fx, eml, sprpid);
   COMMIT;
END;
/

-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER employee_insert
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Inserting employee');
END;
/
-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_update
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('updating album');
END;
/
-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_delete
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('deleting customer');
END;
/

-- 6.2 INSTEAD OF
-- Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE VIEW invoice_view AS
SELECT * FROM invoice;

CREATE OR REPLACE TRIGGER invoice_view_delete
INSTEAD OF DELETE ON invoice_view
FOR EACH ROW
BEGIN
    IF (:old.total <= 50) THEN
        DELETE FROM invoice WHERE invoiceid = :old.invoiceid;
    ELSE
        DBMS_OUTPUT.PUT_LINE('can not delete over $50');
    END IF;
END;
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
SELECT customer.customerId, firstname, lastname, invoiceId, total
FROM customer FULL JOIN invoice 
ON customer.customerid = invoice.customerid;    
-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title
FROM album RIGHT JOIN artist
on artist.artistid = album.artistid;
-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM album 
CROSS JOIN artist
ORDER BY artist.name;
-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT boss.firstname,boss.lastname,grunt.firstname, grunt.lastname
FROM employee boss, employee grunt
WHERE boss.employeeid <> grunt.employeeid
AND  boss.employeeid = grunt.reportsto;

-- 8.0 Indexes
-- In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
-- 8.1 Clustered Indexes
-- Task – Create a clustered index on of table of your choice
CREATE INDEX track_index
ON track (albumid);