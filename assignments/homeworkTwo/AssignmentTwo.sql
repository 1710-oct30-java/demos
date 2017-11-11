
-- Part I – Working with an existing database

-- 1.0	Setting up Oracle Chinook
-- In this section you will begin the process of working with the Oracle Chinook database
-- Task – Open the Chinook_Oracle.sql file and execute the scripts within.
-- 2.0 SQL Queries
-- In this section you will be performing various queries against the Oracle Chinook database.
-- 2.1 SELECT
-- Task – Select all records from the Employee table.
SELECT * FROM Employee
-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE lastname='King';
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE firstname='Andrew' AND REPORTSTO IS NULL;
-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY title DESC;
-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname from CUSTOMER ORDER BY city ASC;
-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
INSERT INTO GENRE VALUES (26,'Rap');
INSERT INTO GENRE VALUES (27,'EDM');
-- Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE (employeeid, lastname, firstname) VALUES(9,'Mall','Saad');
INSERT INTO EMPLOYEE (employeeid, lastname, firstname) VALUES(10,'Llam','Daas');
-- Task – Insert two new records into Customer table
INSERT INTO customer (customerid,firstname,lastname,email) VALUES (60,'bob','derp','derpbob@aol.com');
INSERT INTO customer (customerid,firstname,lastname,email) VALUES (61,'John','Perp','perpjohn@yahoo.com');
-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer SET firstname= 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname='Mitchell';
-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist SET name='CCR' WHERE name='Creedence Clearwater Revival';
-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';
-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';
-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
--Altered constraints to cascade on delete before doing delete
DELETE FROM customer WHERE firstname='Robert' AND lastname='Walter';
-- 3.0	SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.
create or replace function getDates
    return VARCHAR2 IS
        time_now VARCHAR2(20);
    begin
        SELECT TO_CHAR (SYSDATE, 'MM-DD-YYYY HH24:MI:SS') INTO time_now
            FROM DUAL;   
        return time_now;
    end;
/
var rc VARCHAR2;
exec :rc := getDates;
print rc;
-- Task – create a function that returns the length of a mediatype from the mediatype table
create or replace function getLength
    return NUMBER is
        returned_length NUMBER(20);
    begin
        SELECT LENGTH ('MEDIATYPE') INTO returned_length
            FROM DUAL;
        return returned_length;
    end;
/
var rl NUMBER;
exec :rl := getLength;
print rl;
-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices
create or replace function averageTotal
    return NUMBER is
        avg_total NUMBER(10,2);
    begin
        SELECT AVG(total) INTO avg_total 
            FROM invoice;
        return avg_total;
    end;
/
var avt NUMBER;
exec :avt := averageTotal;
print avt;
-- Task – Create a function that returns the most expensive track
create or replace function mostExpensive
    return NUMBER is
        most_expensive NUMBER(10,2);
    begin
        SELECT MAX(unitprice) into most_expensive
            FROM track;
        return most_expensive;
    end;
/
var me NUMBER;
exec :me := mostExpensive;
print me;
-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function invoiceAvg
    return NUMBER as
        invoice_avg NUMBER(10,2);
    begin
        SELECT AVG(unitprice) INTO invoice_avg
            FROM invoiceline;
        return invoice_avg;
    end;
/
var iat NUMBER;
exec :iat := invoiceAvg;
print iat;
-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
SELECT * FROM employee WHERE birthdate>('01-JAN-68');
-- 4.0 Stored Procedures
--  In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.
SELECT firstname, lastname FROM employee;
-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
create or replace procedure updatePersonal
(   new_address IN VARCHAR2, 
    new_city IN VARCHAR2, 
    new_state IN VARCHAR2, 
    new_email IN VARCHAR2)
as
begin
    UPDATE employee SET address= new_address, city = new_city, state= new_state, email= new_email;
    commit;
end updatePersonal;
/
-- Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE EMPLOYEEMANAGER 
(
  MANAGER_OF_EMPLOYEE IN VARCHAR2 
) AS 
BEGIN
    select * FROM employee WHERE title LIKE '%Manager';
END EMPLOYEEMANAGER;
-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE companyname 
(
  cust_first_name IN VARCHAR2, 
  cust_last_name IN VARCHAR2,
  cust_company IN VARCHAR2
) AS 
BEGIN
    select firstname,lastname,company into cust_first_name, cust_last_name, cust_company
        FROM customer;
END companyname;
-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM invoice WHERE invoiceid = 216;
commit;
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace procedure newCustomer
(new_CUSTOMERID NUMBER, new_FIRSTNAME VARCHAR2, new_LASTNAME VARCHAR2,
    new_COMPANY VARCHAR2, new_ADDRESS VARCHAR2, new_CITY VARCHAR2,
    new_STATE VARCHAR2, new_COUNTRY VARCHAR2, new_POSTALCODE VARCHAR2,
    new_PHONE VARCHAR2, new_FAX VARCHAR2, new_EMAIL VARCHAR2, new_SUPPORTREPID NUMBER)
as
begin
    INSERT INTO customer VALUES (new_CUSTOMERID,new_FIRSTNAME,new_LASTNAME,new_COMPANY,new_ADDRESS,new_CITY,new_STATE,
                                 new_COUNTRY,new_POSTALCODE,new_PHONE,new_FAX,new_EMAIL,new_SUPPORTREPID);
end;
/
-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger new_employee_trig
after insert on employee
for each row
begin
    if INSERTING then
        DBMS_OUTPUT.put_line('new record added');
    end if;
end;
/
-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger new_album_trig
after insert on album
for each row
begin
    if INSERTING then
        DBMS_OUTPUT.put_line('new album added');
    end if;
end;
/
-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace trigger removed_customer_trig
after delete on customer
for each row
begin
    if DELETING then
        DBMS_OUTPUT.put_line('customer removed');
    end if;
end;
/
-- 6.2 INSTEAD OF
-- Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
create or replace trigger restrict_invoice_trig
after delete on customer
for each row
begin
    if DELETING AND invoice.total<50 then
        DBMS_OUTPUT.put_line('invoice removed');
    else
        DBMS_OUTPUT.put_line('Cannot remove invoice higher than $50');
    end if;
end;
/
-- 7.0 JOINS
-- In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT customer.firstname, customer.lastname, invoice.invoiceid FROM invoice INNER JOIN customer USING(customerid);
-- 7.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total FROM invoice FULL OUTER JOIN customer ON(invoice.customerid = customer.customerid);
-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title FROM artist RIGHT JOIN album USING(artistid);
-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM artist CROSS JOIN album WHERE artist.artistid = album.artistid ORDER BY artist.name ASC;
-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT employee.firstname AS emp1, employee.firstname AS emp2 FROM employee WHERE(emp1.employeeid = emp2.reportsto);

SELECT e1.firstname||' works for '||e2.firstname "Employees and their Managers" FROM employee e1 JOIN employee e2 ON e1.employeeid = e2.reportsto;
--Thanks to http://www.orafaq.com/wiki/Self_join for the example
-- 8.0 Indexes
-- In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.

-- 8.1 Clustered Indexes
-- Task – Create a clustered index on of table of your choice
CREATE INDEX customerIndex ON customer (firstname, lastname);