-- Part I – Working with an existing database

-- 1.0	Setting up Oracle Chinook
-- In this section you will begin the process of working with the Oracle Chinook database
-- Task – Open the Chinook_Oracle.sql file and execute the scripts within.



-- 2.0 SQL Queries
-- In this section you will be performing various queries against the Oracle Chinook database.
-- 2.1 SELECT
-- Task – Select all records from the Employee table.

SELECT * FROM employee;

-- Task – Select all records from the Employee table where last name is King.

SELECT * FROM employee WHERE lastname='King';

-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

SELECT * FROM employee WHERE firstname='Andrew' AND REPORTSTO is NULL;

-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.

SELECT * FROM album ORDER BY title DESC;

-- Task – Select first name from Customer and sort result set in ascending order by city

SELECT firstname FROM Customer ORDER BY city ASC;

-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table

INSERT INTO Genre
VALUES ('Dance');

INSERT INTO Genre
VALUES ('Dubstep');

-- Task – Insert two new records into Employee table

SELECT * FROM Employee

INSERT INTO Employee
VALUES (9, 'Smith', 'John', 'Sales Manager', 1, "03-AUG-51", "18-SEP-01");

INSERT INTO Employee
VALUES ('Dubstep');

-- Task – Insert two new records into Customer table

INSERT INTO customer (60, 'Bob', 'Bobberson', 'Company Inc.', '1234 Main st', 'Dallas', 'Texas', 'United States', '12345', '1234567890', '6549871827', 'name@email.com', 1 );
INSERT INTO customer (60, 'Bill', 'Billers', 'Organization', '6541 Main st', 'Raleigh', 'North Carolina', 'United States', '65412', '7854210056', '4587110163', 'thename@email.com', 2 );


-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter

UPDATE customer SET firstname = 'Robert', lastname = 'Walker' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%”

SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50

SELECT * FROM invoice WHERE total >= 14 AND total <= 50;

-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004

SELECT * FROM employee WHERE hiredate BETWEEN #06/01/2003# AND #01/03/2004#; 


-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';

-- 3.0	SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database

-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.

CREATE OR REPLACE FUNCTION getCurrentTime
    RETURN TIMESTAMP
    AS
    BEGIN
        RETURN systimestamp;
    end;
/


-- Task – create a function that returns the length of a mediatype from the mediatype table

CREATE FUNCTION mediatypeLength(mediatypeid IN NUMBER)

    RETURN NUMBER
    IS mediatypelength NUMBER;
    BEGIN
        SELECT LENGTH(name) INTO mediatypelength
        FROM mediatype
        WHERE MediaTypeId = mediatypeid;

        RETURN(mediatypelength);
    END;
/

-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices

SELECT AVG(total) FROM invoice;

-- Task – Create a function that returns the most expensive track

SELECT MAX(unitprice) FROM track;

-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table

SELECT AVG(unitprice) FROM invoiceline;

-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.

SELECT * FROM employee WHERE birthdate > DATE '31-DEC-1968';

-- 4.0 Stored Procedures
--  In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.



-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.

CREATE OR REPLACE PROCEDURE selectEmployeeNames (
 	   p_employeeid IN employee.EMPLOYEEID%TYPE,
 	   o_firstname OUT employee.FIRSTNAME%TYPE,
 	   o_lastname OUT  employee.LASTNAME%TYPE,
 )
AS
BEGIN

   SELECT FIRSTNAME , LASTNAME
   INTO o_firstname, o_lastname
   FROM  employee WHERE employeeid = p_employeeid;

 END;
 /

-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.

 CREATE OR REPLACE PROCEDURE updateEmployeeInfo (
     p_employeeid IN employee.EMPLOYEEID%TYPE,	
     p_lastname IN employee.LASTNAME%TYPE,	
     p_firstname IN employee.FIRSTNAME%TYPE,	
     p_title IN employee.TITLE%TYPE,	
     p_reportsto IN employee.REPORTSTO%TYPE,	
     p_birthdate IN employee.BIRTHDATE%TYPE,	
     p_hiredate IN employee.HIREDATE%TYPE,	
     p_address IN employee.ADDRESS%TYPE,	
     p_city IN employee.CITY%TYPE,
     p_state IN employee.STATE%TYPE,	
     p_country IN employee.COUNTRY%TYPE,	
     p_postalcode IN employee.POSTALCODE%TYPE,	
     p_phone IN employee.PHONE%TYPE,	
     p_fax IN employee.FAX%TYPE,	
     p_email IN employee.EMAIL%TYPE
 )
 AS
 BEGIN

     UPDATE employee
     SET 
         lastname = p_LASTNAME,
         firstname = p_FIRSTNAME,
         title = p_TITLE,
         reportsto = p_REPORTSTO,
         birthdate = p_BIRTHDATE,
         hiredate = p_HIREDATE,
         address = p_ADDRESS,
        city = p_CITY,
         state = p_STATE,
         country = p_COUNTRY,
         postalcode = p_POSTALCODE,
         phone = p_PHONE,
         fax = p_FAX,
         email = p_EMAIL
     WHERE EMPLOYEEID = p_employeeid;

 END;
 /

  

-- Task – Create a stored procedure that returns the managers of an employee.

 CREATE OR REPLACE PROCEDURE getManagers(
     p_employeeid IN employee.EMPLOYEEID%TYPE,
     p_reportsto IN employee.REPORTSTO%TYPE,
     o_firstname OUT employee.FIRSTNAME%TYPE,
     o_lastname OUT employee.LASTNAME%TYPE,
 )
 AS
 BEGIN
     SELECT FIRSTNAME, LASTNAME
     INTO o_firstname, o_lastname
     FROM employee WHERE REPORTSTO = p_employeeid;

 END;
 /

-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.

CREATE OR REPLACE PROCEDURE getCustomerInfo (
    p_customerid IN customer.CUSTOMERID%TYPE,
    o_firstname OUT customer.FIRSTNAME%TYPE,
    o_lastname OUT customer.LASTNAME%TYPE,
    o_company OUT customer.COMPANY%TYPE
)
AS
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY
    INTO o_firstname, o_lastname, o_company
    FROM customer WHERE CUSTOMERID = p_customerid;

END;
/

-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

	CREATE OR REPLACE PROCEDURE deleteInvoice (
    p_invoiceid IN invoice.INVOICEID%TYPE
)
AS
BEGIN
    DELETE FROM invoice WHERE invoiceid = p_invoiceid;
    
    COMMIT;
END;
/

-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

CREATE OR REPLACE PROCEDURE insertRecord (
    p_customerid IN customer.CUSTOMERID%TYPE,
    p_firstname IN customer.FIRSTNAME%TYPE,
    p_lastname IN customer.LASTNAME%TYPE,
    p_company IN customer.COMPANY%TYPE,
    p_address IN customer.ADDRESS%TYPE,
    p_city IN customer.CITY%TYPE,
    p_state IN customer.STATE%TYPE,
    p_country IN customer.COUNTRY%TYPE,
    p_postalcode IN customer.POSTALCODE%TYPE,
    p_phone IN customer.PHONE%TYPE,
    p_fax IN customer.FAX%TYPE,
    p_email IN customer.EMAIL%TYPE,
    p_supportrepid IN customer.SUPPORTREPID%TYPE
)
AS
BEGIN
    INSERT INTO customer (customerid,firstname,lastname,company,address,city,state,country,postalcode,phone,fax,email)
    VALUES (p_customerid,p_firstname,p_lastname,p_company,p_address,p_city,p_state,p_country,p_postalcode,p_phone,p_fax,p_email);
    COMMIT;
END;
/

-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER onInsert AFTER INSERT ON employee
BEGIN
    INSERT INTO employee VALUES(10, 'Bill', 'Markson', 'Sales Rep', 2, "03-MAY-41", "18-OCT-05");
END;
/

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER onInsert AFTER INSERT ON album
FOR EACH ROW
BEGIN
    INSERT INTO album VALUES(348, "New Album", 276);
END;
/

-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.

CREATE OR REPLACE onDelete AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    INSERT INTO customer VALUES (60, "Jack", "Ripper", "Company Name", "1 Main Street", "Los Angeles", "California", "United States", 45678, 210457852, 8956421578, "word@email.com", 4);

-- 6.2 INSTEAD OF
-- Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.

CREATE OR REPLACE TRIGGER preventDelete
BEFORE DELETE ON invoice
FOR EACH ROW
WHEN(old.total > 50)
BEGIN
    raise_application_error(-20001, 'invoice is too high.');
    dbms_output.put_line( 'This record cannot be deleted');
END;
/

-- 7.0 JOINS
-- In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

SELECT customer.firstname, customer.lastname, invoice.invoiceid 
FROM customer 
INNER JOIN invoice USING (CUSTOMERID);

-- 7.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

SELECT customer.CUSTOMERID, customer.FIRSTNAME, customer.LASTNAME, invoice.INVOICEID, invoice.TOTAL
FROM customer 
FULL OUTER JOIN invoice
ON (customer.CUSTOMERID = invoice.CUSTOMERID);

-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.

SELECT artist.name , album.title FROM album RIGHT JOIN artist USING(ARTISTID);

-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

SELECT * FROM album, artist ORDER BY artist.name ASC;

-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.

SELECT * FROM employee e1 INNER JOIN employee e2 ON (e1.reportsto = e2.employeeid);

-- 8.0 Indexes
-- In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
-- 8.1 Clustered Indexes
-- Task – Create a clustered index on of table of your choice

CREATE INDEX clustered_album_index ON album (ALBUMID, FIRSTNAME, LASTNAME);