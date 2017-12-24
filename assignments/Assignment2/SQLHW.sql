-- Part I � Working with an existing database

-- 1.0	Setting up Oracle Chinook
-- In this section you will begin the process of working with the Oracle Chinook database
-- Task � Open the Chinook_Oracle.sql file and execute the scripts within.


-- 2.0 SQL Queries
-- In this section you will be performing various queries against the Oracle Chinook database.
-- 2.1 SELECT
-- Task � Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

-- Task � Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE
WHERE lastname='King';

-- Task � Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE lastname='King' 
AND reportsto = null;

-- 2.2 ORDER BY
-- Task � Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album
ORDER BY title;

-- Task � Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM customer
ORDER BY city;

-- 2.3 INSERT INTO
-- Task � Insert two new records into Genre table
INSERT INTO genre (genreid, name) 
VALUES (26,'rgenre1');
INSERT INTO genre (genreid, name) 
VALUES (27,'rgenre2');

-- Task � Insert two new records into Employee table
INSERT INTO employee
VALUES(9,'cao','randy','trainee',1,'01-JAN-92','30-OCT-27','1234 WonderDr','Wonderville','Wonderstate','Wonderland','A1A 1A1','+1 (123) 456-7890','+1 (123) 456-7891', 'randythiencao@yahoo.com');
INSERT INTO employee
VALUES(10,'josh','kyle','trainee',3,'01-JUL-96','30-OCT-27','4132 WonderDr','Wonderville','Wonderstate','Wonderland','B2B 2b2','+1 (123) 456-7890','+1 (123) 456-7891', 'joshkyle@yahoo.com');

-- Task � Insert two new records into Customer table

INSERT INTO customer
VALUES(60, 'Randy', 'Cao',null,'1234 WonderDr','Wonderville','Wonderstate','Wonderland','A1A 1A1','+1 (123) 456-7890','+1 (123) 456-7890','randycao@yahoo.com', 5);
INSERT INTO customer
VALUES(61, 'Josh', 'Kyle',null,'4132 WonderDr','Wonderville','Wonderstate','Wonderland','B2B 2B2','+1 (312) 546-7098','+1 (123) 456-7891','JoshKyle@yahoo.com', 3);

-- 2.4 UPDATE
-- Task � Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname='Robert', lastname='Walter'
WHERE firstname='Aaron' AND lastname='Mitchell';

-- Task � Update name of artist in the Artist table �Creedence Clearwater Revival� to �CCR�
UPDATE artist
SET name='CCR'
where name='Creedence Clearwater Revival';

-- 2.5 LIKE
-- Task � Select all invoices with a billing address like �T%�
SELECT * FROM invoice
WHERE billingaddress like 'T%';

-- 2.6 BETWEEN
-- Task � Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total BETWEEN 15 and 50;

-- Task � Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7 DELETE
-- Task � Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';

-- 3.0	SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
-- 3.1 System Defined Functions
-- Task � Create a function that returns the current time.
CREATE OR REPLACE FUNCTION getdate
RETURN VARCHAR2
AS
o_date VARCHAR2(25);
BEGIN
    SELECT to_char (SYSDATE, 'MM-DD-YYY HH24:MI:SS') 
    INTO o_date FROM DUAL;
    RETURN o_date;
END;
/
-- Task � create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_media_length
(type_id IN NUMBER)
RETURN NUMBER
AS
type_length NUMBER;
BEGIN
    SELECT SUM(track.milliseconds) 
    INTO type_length FROM track
    WHERE type_id = track.mediatypeid;
    RETURN type_length;
END;
/

-- 3.2 System Defined Aggregate Functions
-- Task � Create a function that returns the average total of all invoices
SELECT avg(Total)
FROM invoice;

-- Task � Create a function that returns the most expensive track
SELECT name, unitprice
FROM track
WHERE unitprice = (SELECT max(unitprice) FROM track);

-- 3.3 User Defined Scalar Functions
-- Task � Create a function that returns the average price of invoiceline items in the invoiceline table

CREATE OR REPLACE FUNCTION invoiceline_avg
RETURN NUMBER
AS
o_avg NUMBER;
BEGIN
    SELECT avg(unitprice)
    INTO o_avg FROM invoiceline;
    RETURN o_avg;
END;
/

-- 3.4 User Defined Table Valued Functions
-- Task � Create a function that returns all employees who are born after 1968.
SELECT birthdate
FROM employee
WHERE birthdate > '01-JAN-68';

-- 4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
-- 4.1 Basic Stored Procedure
-- Task � Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_name
(generated_id OUT sys_refcursor)
AS
BEGIN
    OPEN generated_id FOR SELECT lastname,firstname FROM employee;
END get_name;
/

-- 4.2 Stored Procedure Input Parameters
-- Task � Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_info
(e_id IN NUMBER, lname IN VARCHAR2, fname IN VARCHAR2)
AS
BEGIN
    UPDATE employee
        SET firstname=fname, lastname=lname
            WHERE employeeid = e_id;
END update_info;
/

-- Task � Create a stored procedure that returns the managers of an employee.
SELECT * FROM employee
WHERE employeeid =
(SELECT reportsto FROM employee
WHERE employeeid = e_id);

CREATE OR REPLACE PROCEDURE return_manager
(e_id IN NUMBER, generated_id OUT sys_refcursor)
AS
BEGIN
    OPEN generated_id FOR SELECT * FROM employee
        WHERE employeeid =
            (SELECT reportsto FROM employee
                WHERE employeeid = e_id);
END return_manager;
/

-- 4.3 Stored Procedure Output Parameters
-- Task � Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE return_name_company
(cust_id IN NUMBER, output OUT sys_refcursor)
AS
BEGIN
    OPEN output FOR SELECT company FROM customer
        WHERE customerid = cust_id;
END return_name_company;
/

-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
-- Task � Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE delete_invoice
(invoice_id IN NUMBER)
AS
BEGIN
    DELETE FROM invoice
        WHERE invoiceid = invoice_id;
END delete_invoice;
/
    
-- Task � Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insert_customer
(var_id IN NUMBER, fname IN VARCHAR2, lname IN VARCHAR2, mail IN VARCHAR2)
AS -- or is
BEGIN
    INSERT INTO customer (customerid,firstname,lastname,email) VALUES (var_id,fname,lname,mail);
END insert_customer;
/

-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER after_insert_employee
AFTER INSERT ON employee
FOR EACH ROW
DECLARE
BEGIN
  UPDATE album SET title= 'after_insert_employee trigger was fired!!!' 
        WHERE albumid = 5;
END;
/

-- Task � Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER after_update_album
AFTER UPDATE ON album
FOR EACH ROW
DECLARE
BEGIN
  UPDATE employee SET email= 'after_update_album trigger was fired!!!' 
        WHERE employeeid = 11;
END;
/

-- Task � Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER after_delete_customer
AFTER DELETE ON customer
FOR EACH ROW
DECLARE
BEGIN
  UPDATE employee SET email= 'after_delete_customer trigger was fired!!!' 
        WHERE employeeid = 11;
END;
/
-- 6.2 INSTEAD OF
-- Task � Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
create or replace view V as select * from invoice;

CREATE OR REPLACE TRIGGER stop_del_invoice_over_50
INSTEAD OF DELETE ON V
BEGIN
    IF :old.total > 50 THEN
        raise_application_error (-20100, 'You can not delete invoice over $50');
    END IF;
END;
/

-- 7.0 JOINS
-- In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

-- 7.1 INNER
-- Task � Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT customer.firstname, customer.lastname, invoice.invoiceid
FROM customer
INNER JOIN invoice ON customer.customerid = invoice.customerid;

-- 7.2 OUTER
-- Task � Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT e.customerid,e.firstname,e.lastname,d.invoiceid,d.total
FROM customer e
FULL OUTER JOIN invoice d
ON e.customerid = d.customerid;

-- 7.3 RIGHT
-- Task � Create a right join that joins album and artist specifying artist name and title.
SELECT artistid,title,name
FROM album
RIGHT JOIN artist
USING (artistid);

-- 7.4 CROSS
-- Task � Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM album
CROSS JOIN artist
ORDER BY artist.name;

-- 7.5 SELF
-- Task � Perform a self-join on the employee table, joining on the reportsto column.
SELECT e1.firstname || ' ' || e1.lastname "EMPLOYEE",e2.firstname ||' '|| e2.lastname  "MANAGER"
FROM employee e1, employee e2  
WHERE e1.reportsto = e2.employeeid; 

-- 8.0 Indexes
-- In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
-- 8.1 Clustered Indexes
-- Task � Create a clustered index on of table of your choice
create cluster employee(employeeid number);
create index idx_emp_dept on cluster employee;


-- set serveroutput on;
-- begin
--     DBMS_OUTPUT.put_line(invoiceline_avg);
-- end;
-- /

-- EXECUTE update_info(9, 'Last', 'First');
-- INSERT INTO employee(employeeid, lastname, firstname, email) VALUES (12,'na','empty last','test@test.com');

-- UPDATE album SET title='testing' WHERE albumid=5;
-- variable rc refcursor;
-- exec return_manager(8, :rc);
-- print rc;
