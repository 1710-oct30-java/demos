--SQL Homework - Brice Petty
--Credit to Micah, Jacob, Pascal, and Reagan for help on workarounds

--Task – Select all records from the Employee table.

SELECT * FROM employee;

--Task – Select all records from the Employee table where last name is King.

SELECT * FROM employee WHERE lastname = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS NULL;

--------------------------------------------------------------------------------------------------------------------------------

-- Task – Select all albums in Album table and sort result set in descending order by title.

SELECT * FROM album ORDER BY title ASC;

--Task – Select first name from Customer and sort result set in ascending order by city

SELECT firstname FROM customer ORDER BY city ASC;

--------------------------------------------------------------------------------------------------------------------------------

--Task – Insert two new records into Genre table

INSERT INTO genre VALUES ('26', 'Trance');
INSERT INTO genre VALUES ('27', 'Dubstep');

--Task – Insert two new records into Employee table

INSERT INTO employee VALUES ('9', 'Petty', 'Brice', 'Software Engineer Trainee', NULL, '10-SEP-92', '11-NOV-17', '4625 71st ST', 'Lubbock', 'TX', 'USA', '79424', '+1 (972) 965-1634', NULL, 'bricepetty1116@yahoo.com');
INSERT INTO employee VALUES ('10', 'Amigo', 'Jacob', 'Software Engineer Trainee', NULL, '5-DEC-2018', '11-NOV-17', '2905 Apple Valley DR', 'Tampa', 'FL', 'USA', '33559', '+1 (555) 555-5555', NULL, 'jacob@friend.com');

--Task – Insert two new records into Customer table

INSERT INTO customer (customerid, firstname, lastname, email) VALUES (60, 'Brice', 'Petty', 'bricepetty1116@yahoo.com');
INSERT INTO customer (customerid, firstname, lastname, email) VALUES (61, 'Jacob', 'Buddy', 'jacobbuddy@gmail.com');

--------------------------------------------------------------------------------------------------------------------------------

--Task – Update Aaron Mitchell in Customer table to Robert Walter

UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

--------------------------------------------------------------------------------------------------------------------------------

--Task – Select all invoices with a billing address like “T%”

SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--------------------------------------------------------------------------------------------------------------------------------

--Task – Select all invoices that have a total between 15 and 50

SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004

SELECT * FROM employee WHERE hiredate BETWEEN '6-JUN-03' AND '1-MAR-04';

--------------------------------------------------------------------------------------------------------------------------------

--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

ALTER TABLE invoiceline DROP CONSTRAINT fk_invoicelineinvoiceid;
ALTER TABLE invoiceline ADD CONSTRAINT fk_invoicelineinvoiceid FOREIGN KEY (invoiceid) REFERENCES invoice (invoiceid) ON DELETE CASCADE;
ALTER TABLE invoice DROP CONSTRAINT fk_invoicecustomerid;
ALTER TABLE invoice ADD CONSTRAINT fk_invoicecustomerid FOREIGN KEY (customerid) REFERENCES customer (customerid) ON DELETE CASCADE;

commit;

DELETE FROM customer WHERE firstname='Robert' AND lastname='Walter';

--I struggled with this one. Micah helped me handle the constraint. Delete the constraint, add it back with cascade delete
--so deleting Robert Walter will cascade delete the children which works around the original constraint the DELETE FROM produced

--------------------------------------------------------------------------------------------------------------------------------

--Task – Create a function that returns the current time.

CREATE OR REPLACE FUNCTION time_func RETURN TIMESTAMP AS 
BEGIN 
RETURN SYSTIMESTAMP; 
END time_func; 
/

--Task – create a function that returns the length of a mediatype from the mediatype table

CREATE OR REPLACE FUNCTION ret_med_len (inputMediaId IN NUMBER) RETURN NUMBER AS theLength NUMBER;
BEGIN
	SELECT LENGTH( name ) INTO theLength FROM mediatype where mediatypeid = inputMediaId;
	RETURN theLength;
END ret_med_len;
/

select * FROM mediatype;
select ret_med_len(3)from dual;

--------------------------------------------------------------------------------------------------------------------------------

--Task – Create a function that returns the average total of all invoices

CREATE FUNCTION invoice_avg_func RETURN NUMBER AS theAverage NUMBER;
BEGIN
    SELECT AVG(total) INTO theAverage FROM invoice;
    RETURN (theAverage);
END invoice_avg_func;
/

--Task – Create a function that returns the most expensive track

CREATE OR REPLACE FUNCTION track_max_func RETURN NUMBER AS theMax NUMBER;
BEGIN
    SELECT MAX(unitprice) INTO theMax FROM track;
    RETURN (theMax);
END track_max_func;
/

--------------------------------------------------------------------------------------------------------------------------------

--Task – Create a function that returns the average price of invoiceline items in the invoiceline table

CREATE OR REPLACE FUNCTION invoiceline_avg RETURN NUMBER AS theAvg NUMBER;
BEGIN
    SELECT AVG(unitprice) INTO theAvg FROM invoiceline;
    RETURN (theAvg);
END invoiceline_avg;
/

--------------------------------------------------------------------------------------------------------------------------------
--Task – Create a function that returns all employees who are born after 1968.

CREATE OR REPLACE FUNCTION born_post_68 RETURN SYS_REFCURSOR AS theCursor SYS_REFCURSOR;
BEGIN
    OPEN theCursor FOR
        SELECT * FROM employee WHERE birthdate >= '01-JAN-1969';
    RETURN theCursor;
END born_post_68;
/

--------------------------------------------------------------------------------------------------------------------------------

--Task – Create a stored procedure that selects the first and last names of all the employees.

CREATE OR REPLACE PROCEDURE get_employees (resultEmployees OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN resultEmployees FOR
        SELECT firstname, lastname FROM employee;
END get_employees;
/

--------------------------------------------------------------------------------------------------------------------------------

--Task – Create a stored procedure that updates the personal information of an employee.

CREATE OR REPLACE PROCEDURE update_employees (inEmployeeId IN NUMBER, inAddress IN VARCHAR2, inCity IN VARCHAR2, inState IN VARCHAR2, inCountry IN VARCHAR2, 
    inZip IN VARCHAR2, inPhone IN VARCHAR2, inFax IN VARCHAR2, inEmail IN VARCHAR2)
AS
BEGIN
    UPDATE employee
    SET address = inAddress, city = inCity, state = inState, country = inCountry, postalcode = inZip, phone = inPhone, fax = inFax, email = inEmail
    WHERE employeeid = inEmployeeId;
END update_employees;
/

--Task – Create a stored procedure that returns the managers of an employee.

CREATE OR REPLACE PROCEDURE who_da_boss (inEmployeeId IN NUMBER, bossResults OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN bossResults FOR 
    SELECT reportsto FROM employee WHERE employeeid = inEmployeeId;
END who_da_boss;
/

--------------------------------------------------------------------------------------------------------------------------------

--Task – Create a stored procedure that returns the name and company of a customer.

CREATE OR REPLACE PROCEDURE name_and_company_proc (inCustomerId IN NUMBER, outNameAndCompany OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN outNameAndCompany FOR 
    SELECT firstname, lastname, company FROM customer WHERE customerid = inCustomerId;
END name_and_company_proc;
/

--------------------------------------------------------------------------------------------------------------------------------

--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

CREATE OR REPLACE PROCEDURE del_given_invoice (inputInvoiceId IN NUMBER) 
AS 
BEGIN 
    DELETE FROM invoice WHERE invoiceid = inputInvoiceId;
END del_given_invoice;
/

--run the commit statement in 2.7. commiting the altered constraints in invoiceline will also resolve the constraint my 
--procedure will proc

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

CREATE OR REPLACE PROCEDURE ins_customer_proc (inCustomerId IN NUMBER, inFirstName IN VARCHAR2, inLastName IN VARCHAR2, inCompany IN VARCHAR2, inAddress IN VARCHAR2, inCity IN VARCHAR2, inState IN VARCHAR2, inCountry IN VARCHAR2, inZip IN VARCHAR2, inPhone IN VARCHAR2, inFax IN VARCHAR2, inEmail IN VARCHAR2)
AS
BEGIN
    INSERT INTO customer (customerid,firstname,lastname,company,address,city,state,country,postalcode,phone,fax,email)
    VALUES (inCustomerId, inFirstName, inLastName, inCompany, inAddress, inCity, inState, inCountry, inZip, inPhone, inFax, inEmail);
    COMMIT;
END ins_customer_proc;
/

--------------------------------------------------------------------------------------------------------------------------------

--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER after_insert_employee AFTER INSERT ON employee
BEGIN
    dbms_output.put_line('Triggered after insert on employee!');
END;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER after_update_album AFTER UPDATE ON album 
BEGIN
    dbms_output.put_line('Triggered after update on album!');
END after_update_album;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER after_delete_album AFTER DELETE ON customer 
BEGIN
    dbms_output.put_line('Triggered after delete on customer!');
END after_delete_customer;
/

--------------------------------------------------------------------------------------------------------------------------------

--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.

CREATE VIEW invoiceV AS SELECT * FROM invoice;
CREATE OR REPLACE TRIGGER no_del_over_$50 INSTEAD OF DELETE ON invoiceV
BEGIN
IF :old.total <= 50 THEN
    DELETE FROM invoice WHERE :old.invoiceid = invoiceid; --since the id is unique
ELSE
    RAISE_APPLICATION_ERROR( -20001, 'Invoice is of too high a value to be deleted!');
END IF;
END;

-- I had a pretty hard time on this one. I couldn't figure out how to do it directly on the table so I just made a view identical
-- to the invoice table and set the trigger for that view.
-- Credit to Micah and www.dba-oracle.com/t_raise_application_error.htm for the workaround

--------------------------------------------------------------------------------------------------------------------------------

--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

SELECT customer.firstname, customer.lastname, invoice.invoiceid FROM invoice INNER JOIN customer USING(customerid);

--------------------------------------------------------------------------------------------------------------------------------

--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total FROM invoice FULL OUTER JOIN customer ON (invoice.customerid = customer.customerid);

--------------------------------------------------------------------------------------------------------------------------------

--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name , album.title FROM album RIGHT JOIN artist USING(artistid);

--------------------------------------------------------------------------------------------------------------------------------

--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

SELECT * FROM album, artist ORDER BY artist.name ASC;

--------------------------------------------------------------------------------------------------------------------------------

--Task – Perform a self-join on the employee table, joining on the reportsto column.

SELECT * FROM employee emp1 INNER JOIN employee emp2 ON(emp1.employeeid = emp2.reportsto);

--------------------------------------------------------------------------------------------------------------------------------

--Task – Create a clustered index on of table of your choice

CREATE INDEX employeeIndex ON employee (firstname, lastname);

--------------------------------------------------------------------------------------------------------------------------------