--Part I – Working with an existing database
--
--1.0	Setting up Oracle Chinook
--In this section you will begin the process of working with the Oracle Chinook database
--Task – Open the Chinook_Oracle.sql file and execute the scripts within.
--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY Title DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO Genre(GENREID, NAME) 
VALUES (26, 'Trip Hop');

INSERT INTO Genre(GENREID, NAME) 
VALUES (27, 'Low Temp');
--Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES ('10', 'Baral', 'Santosh', 'IT Staff', '6', '05-MAY-1989', '01-MAY-2018', '7933 Fall Creek Rd', 'Dublin', 'CA', 'USA', '94568', '+1 650 917- 9756', '+1 510 857-3705','santoshbaral@gmail.com'); 
--Task – Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (60, 'Santosh', 'Baral', 'Revature', '7933 Fall Creek Rd', 'Dublin', 'CA', 'USA', '94568','+1 543 245-6958', '+1 234 324-4545','santoshbaral@gmail.com','5');
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMERID = 32;
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE '%T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-2003' AND '01-MAR-2004';
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
--
--3.0	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
create or replace FUNCTION getCurrentTime
return TIMESTAMP
IS
BEGIN
RETURN CURRENT_TIMESTAMP;
END;
/
SELECT GETCURRENTTIME FROM dual;
--Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION lengthMediaType
return number
IS
Begin
SELECT length
FROM
RETURN number;
END;
/
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION AvgTotalInvoice 
RETURN number
IS 
   AvgTotal number := 0; 
BEGIN 
   SELECT AVG(TOTAL) into AvgTotal 
   FROM INVOICE; 
    
   RETURN AvgTotal ; 
END; 
/ 

SELECT AvgTotalInvoice FROM dual;
--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION Most_Expensive_Track
RETURN number
IS
MostExpensive number := 0;
BEGIN
SELECT MAX(UNITPRICE) into MostExpensive
FROM TRACK;
RETURN MostExpensive;
END;
/

SELECT Most_Expensive_Track FROM dual;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function average_invoiceline_price
return number
as
avg_invo_price NUMBER;
begin
    select avg(UNITPRICE) into avg_invo_price
    from INVOICELINE;
    return avg_invo_price;
end;
/
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE EMPLOYEE_NAMES (names out SYS_REFCURSOR)
AS
BEGIN
OPEN names from SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
--Task – Create a stored procedure that returns the managers of an employee.
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE COMPANY_NAME( CUSTOMERID IN NUMBER, CUSTOMERNAME OUT VARCHAR2, COMPANY OUT VARCHAR2)
AS
BEGIN
    SELECT
        lastname || ', ' || firstname,
        company
    INTO
        CUSTOMERNAME,
        COMPANY
    FROM
        CUSTOMER 
    WHERE
    CUSTOMERID = CUSTOMERID;
END;
/

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER employee_added
AFTER INSERT ON EMPLOYEE 
FOR EACH ROW  

DECLARE 
   new_emp_id number ; 
   new_emp_first_name VARCHAR2(20);
   new_emp_last_name VARCHAR2(20);
BEGIN
    CASE
    WHEN INSERTING THEN
    DBMS_OUTPUT.PUT_LINE('Inserting');
   new_emp_id := :NEW.EMPLOYEEID;
   new_emp_first_name := :NEW.FIRSTNAME;
   new_emp_last_name := :NEW.LASTNAME;
   dbms_output.put('New Employee Added!'); 
   dbms_output.put('New Employee ID: ' || new_emp_id); 
   dbms_output.put('New Employee First Name: ' || new_emp_first_name);
   dbms_output.put('New Employee First Name: ' || new_emp_last_name); 
   END CASE;
END; 
/ 
DELETE FROM EMPLOYEE
WHERE LASTNAME ='Baral';

set serveroutput on;
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES ('10', 'Baral', 'Santosh', 'IT Staff', '6', '05-MAY-1989', '01-MAY-2018', '7933 Fall Creek Rd', 'Dublin', 'CA', 'USA', '94568', '+1 650 917- 9756', '+1 510 857-3705','santoshbaral@gmail.com');
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_inserted 
AFTER UPDATE ON ALBUM 
FOR EACH ROW  
DECLARE 
    new_album_id number ; 
   new_album_title VARCHAR2(20);
BEGIN 
   dbms_output.put_line('Album added '); 
   dbms_output.put_line('New Album ID: ' || :NEW.ALBUMID); 
   dbms_output.put_line('New Album Title: ' || :NEW.TITLE); 
END; 
/ 
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_delete_trigger 
AFTER DELETE ON CUSTOMER 
FOR EACH ROW 
 
DECLARE 
   del_cus_id number := :old.CUSTOMERID; 
   del_cus_first_name VARCHAR2(20) := :old.FIRSTNAME;
   del_cus_last_name VARCHAR2(20) := :old.LASTNAME; 
BEGIN 
    
   dbms_output.put(del_cus_id); 
   dbms_output.put(del_cus_first_name); 
   dbms_output.put(del_cus_last_name); 
END; 
/ 
--
--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE on CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
LEFT JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
RIGHT JOIN ALBUM ON ALBUM.ARTISTID = ARTIST.ARTISTID; 
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT NAME, TITLE
FROM ARTIST, ALBUM
ORDER BY ARTIST.NAME;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT e.EMPLOYEEID, e.FIRSTNAME, e.LASTNAME, r.REPORTSTO
FROM EMPLOYEE e
INNER JOIN EMPLOYEE r
ON e.EMPLOYEEID = r.EMPLOYEEID;

--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.

--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice
CREATE INDEX title_ind on ALBUM (TITLE);
