--1.0	Setting up Oracle Chinook
--In this section you will begin the process of working with the Oracle Chinook database
--Task – Open the Chinook_Oracle.sql file and execute the scripts within.
--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.

--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM employee;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM employee 
WHERE lastname = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee
WHERE firstname = 'Andrew' AND reportsto IS NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album
ORDER BY title DESC; 
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname
FROM Customer
ORDER BY city;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO genre
VALUES (26,'Latin Pop');
INSERT INTO genre
VALUES (27,'Country');
--Task – Insert two new records into Employee table
INSERT INTO employee
VALUES (9, 'Rojas', 'Rosario', 'IT Staff', 6, '12-DEC-86', '23-JAN-05','6415 Melody Ln', 'Dallas', 'TX', 'United States', '75231','+1 (214) 815-5659','+1 (780) 456-4332', 'rojas@gmail.com');
INSERT INTO employee
VALUES (10, 'Smith', 'James', 'Sales Support Agent', 2, '12-DEC-93', '01-FEB-06','7832 Bears Av', 'Tampa', 'FL', 'United States', '33559','+1 (469) 325-6671','+1 (780) 123-4567', 'smith@gmail.com');
--Task – Insert two new records into Customer table
INSERT INTO customer
VALUES (61, 'Jose', 'Rodriguez', NULL, '1234 Greenville Ave', 'Dallas', 'TX', 'United States', '75208', '214-987-1245', NULL,'jose@yahoo.com',3);

INSERT INTO customer
VALUES (62, 'Sarah', 'Jones', NULL, '1234 Long Ave', 'Denver', NULL, 'United States', '75208', '876-009-9753', NULL,'sarahj@yahoo.com',3);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name='CCR'
WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE invoiceline
DROP CONSTRAINT fk_invoicelineinvoiceid;

ALTER TABLE invoiceline 
ADD CONSTRAINT fk_invoicelineinvoiceid
    FOREIGN KEY (invoiceid) REFERENCES invoice(invoiceid)
    ON DELETE CASCADE;
    
ALTER TABLE Invoice 
DROP CONSTRAINT FK_InvoiceCustomerId;

ALTER TABLE Invoice 
ADD CONSTRAINT FK_InvoiceCustomerId
    FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId)
    ON DELETE CASCADE;
    
DELETE FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';

--3.0	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION getCurrentTime
    RETURN VARCHAR2
    IS 
    BEGIN
        RETURN to_char(CURRENT_TIMESTAMP, 'HH:MI:SS');
    END;
/
SELECT getCurrentTime FROM dual;

--Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION lengthMediaType
(mediatype_id IN NUMBER)
RETURN NUMBER
IS
len NUMBER;
BEGIN
    SELECT LENGTH(name) INTO len FROM mediatype
    WHERE mediatype_id = mediatypeid;
    RETURN len;
END;
/

SELECT lengthMediaType(3) FROM dual;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION invoicesAverageTotal
RETURN NUMBER
IS 
invoiceAvgTotal NUMBER;
BEGIN
    SELECT AVG(total) INTO invoiceAvgTotal FROM invoice;
    RETURN invoiceAvgTotal;
END;
/

SELECT invoicesAverageTotal FROM dual;

--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION mostExpensiveTrack
RETURN sys_refcursor
AS 
    out_cursor sys_refcursor;
BEGIN
    open out_cursor FOR
        SELECT name FROM track
        WHERE unitprice =(SELECT MAX(unitprice) FROM track);
    RETURN out_cursor;
end;
/
var rc refcursor;
exec :rc :=mostExpensiveTrack;
print rc;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_price_invoiceline
RETURN NUMBER
AS
avg_p_invoiceline NUMBER;
BEGIN 
    SELECT AVG(unitprice) INTO avg_p_invoiceline FROM invoiceline;
    RETURN avg_p_invoiceline;
END;
/
SELECT avg_price_invoiceline FROM dual;    

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION employeesAfter1968
    RETURN sys_refcursor
AS
    out_cursor sys_refcursor;
BEGIN
   open out_cursor FOR
        SELECT * FROM employee
        WHERE birthdate > '31-DEC-68';
        RETURN out_cursor;
END;
/

var rc refcursor;
exec :rc :=employeesAfter1968;
print rc;

--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE selectEmployeeNames
(name OUT sys_refcursor)
AS
first_name VARCHAR2(20);
last_name VARCHAR(20);
BEGIN
    OPEN name FOR SELECT firstname, lastname INTO first_name, last_name FROM employee;
END selectEmployeeNames;
/

set serveroutput on;
declare
    names sys_refcursor;
    fname VARCHAR(20);
    lname VARCHAR(20);
BEGIN
    selectEmployeeNames(names);
    LOOP
        FETCH names INTO fname, lname;
        EXIT when names%NOTFOUND;
        dbms_output.put_line(fname || ' ' || lname);
    END LOOP;
END;
/
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee
(employee_id IN NUMBER, last_name IN VARCHAR2,first_name IN VARCHAR2, var_title IN VARCHAR2,
var_reportsto IN NUMBER,var_birthdate  IN DATE,var_hiredate IN DATE,var_address IN VARCHAR2,var_city IN VARCHAR2,
var_state IN VARCHAR2,var_country IN VARCHAR2,var_postalcode IN VARCHAR2,var_phone IN VARCHAR2,var_fax IN VARCHAR2,
var_email IN VARCHAR2)
AS
 BEGIN
        UPDATE employee
        SET lastname = last_name, firstname = first_name, title = var_title, reportsto = var_reportsto,
        birthdate =var_birthdate, hiredate = var_hiredate, address = var_address, city = var_city, state = var_state, 
        country = var_country, postalcode = var_postalcode, phone =var_phone, fax = var_fax, email = var_email
        WHERE employee_id = employeeid;
end update_employee;
/

BEGIN
    update_employee(9, 'Vidales', 'Joan', 'IT Staff', 6, '12-DEC-92', '03-JAN-17','6252 Bears Ave','Dallas','TX', 'US', '75231','111','1212','4@gmail.com');
END;
/
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE managersOfEmployee
(employee_id IN NUMBER, first OUT VARCHAR2, last OUT VARCHAR2)
IS
BEGIN
   SELECT firstname, lastname INTO first, last FROM employee 
   WHERE employeeid IN (SELECT reportsto FROM employee
   WHERE employeeid = employee_id);
END managersOfEmployee;
/

set serveroutput on;
declare
    fname VARCHAR2(250);
    lname VARCHAR2(250);
BEGIN 
    managersOfEmployee(2, fname, lname);
    dbms_output.put_line(fname || ' ' ||lname);
END;
/
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE name_and_company_customer
(customer_id IN NUMBER, first OUT VARCHAR2, last OUT VARCHAR2, comp OUT VARCHAR2)
IS
BEGIN
    SELECT firstname, lastname, company INTO first, last, comp FROM customer
    WHERE customer_id = customerid;
END name_and_company_customer;
/

set serveroutput on;
declare
    --customer_id NUMBER;
    fname VARCHAR2(150);
    lname VARCHAR2(150);
    comp VARCHAR2(150);    
BEGIN 
    name_and_company_customer(16, fname, lname, comp);
    dbms_output.put_line(fname || ' ' ||lname || ' ' || comp);
END;
/

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE deleteInvoice
(invoice_id IN NUMBER)
IS
BEGIN
    DELETE FROM invoice
    WHERE invoiceid = invoice_id;
    commit;
END deleteInvoice;
/

BEGIN
    deleteInvoice(215);
END;
/
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insert_new_customer
(customer_id IN NUMBER, first_name IN VARCHAR2,last_name IN VARCHAR2, var_company IN VARCHAR2,
var_address IN VARCHAR2, var_city IN VARCHAR2, var_state IN VARCHAR2, var_country IN VARCHAR2,
var_postalcode IN VARCHAR2,var_phone IN VARCHAR2,var_fax IN VARCHAR2,
var_email IN VARCHAR2, var_support IN NUMBER, record OUT sys_refcursor)
IS
BEGIN
    INSERT INTO customer(customerid, firstname, lastname, company, address, city, state, country,
    postalcode, phone, fax, email, supportrepid) VALUES (customer_id, first_name, last_name, var_company, var_address,
    var_city, var_state, var_country, var_postalcode, var_phone, var_fax, var_email, 
    var_support);
    commit;
    OPEN record FOR SELECT * FROM customer WHERE customerid = customer_id;
END insert_new_customer;
/

set serveroutput on;
declare
    customerid NUMBER;
    firstname VARCHAR2(40);
    lastname VARCHAR2(20);
    company VARCHAR2(80);
    address VARCHAR2(70);
    city VARCHAR2(40);
    state VARCHAR2(40);
    country VARCHAR2(40);
    postalcode VARCHAR2(10);
    phone VARCHAR2(24);
    fax VARCHAR2(24);
    email VARCHAR2(60);
    supportrepid NUMBER;
    new_customer sys_refcursor;
BEGIN
    insert_new_customer(199, 'John', 'Smith', 'Samsung', 'address', 'Tampa', 'Florida',
    'US', '33559','214-833-9988', '24235','js@gmail.com', 5, new_customer);
    LOOP 
        FETCH new_customer INTO customerid, firstname, lastname, company, address, city,
        state, country, postalcode, phone, fax, email, supportrepid;
        EXIT when new_customer%NOTFOUND;
        dbms_output.put_line(customerid || ' ' || firstname || ' ' || lastname || ' ' || company
        || ' ' || address || ' ' ||city || ' ' ||state || ' ' || country || ' ' || postalcode || ' ' ||
        phone || ' ' || fax || ' ' || email|| ' ' ||  supportrepid);
    END LOOP;
END;
/

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER after_insert_employee
AFTER INSERT on employee
BEGIN
   INSERT INTO employee
   SELECT * FROM employee;
end;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE TABLE update_album(
albumid NUMBER,
title VARCHAR2(159),
artistid NUMBER);

CREATE OR REPLACE TRIGGER after_update_album
AFTER UPDATE on album
FOR EACH ROW
BEGIN
    INSERT INTO update_album(albumid, title, artistid)
    VALUES (:NEW.albumid, :NEW.title, :NEW.artistid);
end;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER after_delete_customer
AFTER DELETE on customer
DECLARE 
current_customer_id NUMBER;
BEGIN
   SELECT customerid INTO current_customer_id FROM customer;
end;
/
--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER restrict_delete 
BEFORE DELETE ON INVOICE FOR EACH ROW
DECLARE 
var_total NUMBER;
BEGIN
    SELECT total INTO var_total FROM invoice;
    IF var_total > 50 THEN
    RAISE_APPLICATION_ERROR(-20001,'Cannot delete invoice');
    END IF;
END;
/

        
--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT firstname, lastname, invoiceid FROM customer INNER JOIN invoice ON(customer.customerid = invoice.customerid);

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customerid,firstname, lastname, invoiceid, total FROM customer OUTER JOIN invoice USING(customerid);

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT name, title FROM album RIGHT JOIN artist USING(artistid);

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM artist, album ORDER BY artist.name;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM employee emp INNER JOIN employee e ON (e.employeeid = emp.reportsto);

--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice
CREATE CLUSTER invoice_customer_id
(customer_id NUMBER)
SIZE 512
STORAGE (INITIAL 100K NEXT 50K);

CREATE INDEX invoice_customer_id_index
ON CLUSTER invoice_customer_id
TABLESPACE users
STORAGE(INITIAL 50K
        NEXT 50K
        MINEXTENTS 2
        MAXEXTENTS 10
        PCTINCREASE 33);