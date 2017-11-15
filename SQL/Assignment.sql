-- 1.0	Setting up Oracle Chinook
-- In this section you will begin the process of working with the Oracle Chinook database
-- Task – Open the Chinook_Oracle.sql file and execute the scripts within.
-- 2.0 SQL Queries
-- In this section you will be performing various queries against the Oracle Chinook database.
-- 2.1 SELECT
-- Task – Select all records from the Employee table.
SELECT * FROM Employee;
-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM Employee WHERE lastname = 'King';
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM Employee WHERE firstname = 'Andrew' AND reportsto IS NULL;
-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM Album ORDER BY Title DESC;
-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM Customer ORDER BY City;
-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
INSERT INTO Genre VALUES (26, 'Grunge');
INSERT INTO Genre VALUES (27, 'Ska');
-- Task – Insert two new records into Employee table
INSERT INTO Employee VALUES (
    9, 'Worcester', 'Chris', 'Java Developer', 6, (TO_DATE('07/03/1992', 'MM/DD/YYYY')), (TO_DATE('12/12/2015', 'MM/DD/YYYY')),
    '123 Main St', 'Tampa', 'FL', 'United States', '33023', '+1 (954) 505-1234', '+1 (954) 505-1234', 'chrisworc@gmail.com'
	);
INSERT INTO Employee VALUES (
    10, 'McDuderson', 'Dude', 'Coffee Fetcher', 1, (TO_DATE('05/16/1990', 'MM/DD/YYYY')), (TO_DATE('11/04/2017', 'MM/DD/YYYY')),
    '456 Main St', 'Tampa', 'FL', 'United States', '33023', '+1 (954) 505-5678', '+1 (954) 505-5678', 'dude@gmail.com'
	);
-- Task – Insert two new records into Customer table
INSERT INTO Customer VALUES (
    60, 'David', 'Jones', 'Nintendo', '123 Johnson St', 'Greenburg', 'CA', 'United States',
    '12345', '+1 (514) 7121-4711', NULL, 'djones@gmail.com', 2
    );
INSERT INTO Customer VALUES (
    61, 'Hugh', 'Mungus', 'Google', '123 Jefferson St', 'Cloaca', 'CA', 'United States',
    '12345', '+1 (554) 6517-4711', '+1 (554) 6517-4754', 'hmungus@gmail.com', 5
    );
-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer
    SET firstname = 'Robert', lastname = 'Walter'
    WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
    SET name = 'CCR'
    WHERE name = 'Creedence Clearwater Revival';
-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';
-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total > 15 AND total < 50;
-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee WHERE hiredate > (TO_DATE('06/01/2003', 'MM/DD/YYYY'))
	AND hiredate < (TO_DATE('03/01/2004', 'MM/DD/YYYY'));
-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM customer
    WHERE lastname = 'walter' AND firstname = 'robert';
-- 3.0	SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_time RETURN CHAR AS
    BEGIN
        RETURN to_char(SYSTIMESTAMP, 'HH:MM:SS');
    END;
    /
-- Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION getTypeLength
    (typeId IN NUMBER)
    RETURN VARCHAR2
    AS typeLength VARCHAR2(256);
    BEGIN
        SELECT LENGTH(name) INTO typeLength
        FROM mediatype WHERE mediatypeid = typeId;
        RETURN typeLength;
    END;
/
-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION getInvoiceAvg
    RETURN NUMBER
    AS avgTotal NUMBER(10,2);
    BEGIN
        SELECT AVG(total) INTO avgTotal
            FROM invoice;
        RETURN avgTotal;
    END;
/
-- Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION getMaxPrice
    RETURN NUMBER
    AS maxPrice NUMBER(10,2);
    BEGIN
        SELECT Max(unitprice) INTO maxPrice
        FROM track;
        RETURN maxPrice;
    END;
/
-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION getAvgPrice
    RETURN NUMBER
    AS avgPrice NUMBER(10,2);
    BEGIN
        SELECT AVG(unitprice)
        INTO avgPrice FROM invoiceline;
        RETURN avgPrice;
    END;
/
-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE TYPE empObject IS OBJECT (firstname VARCHAR2(20), lastname VARCHAR2(20), birthdate DATE);
/
CREATE OR REPLACE TYPE empTable IS TABLE OF empObject;
/
CREATE OR REPLACE FUNCTION getYoungerEmployees
    RETURN empTable
        IS tbl empTable := empTable();
        I INTEGER := 0;
    BEGIN
        FOR J IN (SELECT * FROM EMPLOYEE WHERE birthdate >= '01-JAN-69')
        LOOP
            tbl.EXTEND;
            I := I+1;
            tbl(I) := empObject(J.firstname, J.lastname, J.birthdate);
        END LOOP;
        RETURN tbl;
    END;
/
SELECT * FROM TABLE (getYoungerEmployees);

-- 4.0 Stored Procedures
 -- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.CREATE OR REPLACE PROCEDURE getEmployeeNames (csr OUT sys_refcursor) AS
CREATE OR REPLACE PROCEDURE getEmployeeNames (csr OUT sys_refcursor) AS
BEGIN
    OPEN csr FOR 'SELECT firstname, lastname FROM employee';
END;
/
    VARIABLE rc refcursor;
    EXEC getEmployeeNames(:rc);
    print rc;
/

-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE updateEmployee
    (empId IN INTEGER,
    newTitle IN VARCHAR2,
    newAddress IN VARCHAR2,
    newCity IN VARCHAR2,
    newState IN VARCHAR2,
    newCountry IN VARCHAR2,
    newPostal IN VARCHAR2) AS
BEGIN
    UPDATE employee SET
        title = newTitle,
        address = newAddress,
        city = newCity,
        state = newState,
        country = newCountry,
        postalcode = newPostal
        WHERE employeeid = empId;
END;
/
    exec updateEmployee(1, 'GM', '123 Main St', 'Riverton', 'CA', 'United States', '12345');
/
-- Task – Create a stored procedure that returns the managers of an employee.
-- 4.3 Stored Procedure Output Parameters
CREATE OR REPLACE PROCEDURE getBoss
    (empLast IN VARCHAR2,
    empFirst IN VARCHAR2,
    bossLast OUT VARCHAR2,
    bossFirst OUT VARCHAR2)
AS BEGIN
    SELECT lastname INTO bossLast from employee WHERE employeeid =
		(SELECT reportsto FROM employee WHERE
			lastname = empLast AND firstName = empFirst);
    SELECT firstname INTO bossFirst from employee WHERE employeeid =
		(SELECT reportsto FROM employee WHERE
            lastname = empLast AND firstName = empFirst);
END;
/
VARIABLE lName VARCHAR2(20);
VARIABLE fName VARCHAR2(20);
EXECUTE getBoss('King', 'Robert', :lName, :fName);
PRINT lName;
PRINT fName;
-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE getCustomerInfo
    (custID IN INTEGER,
    custLast OUT VARCHAR2,
    custFirst OUT VARCHAR2,
    custComp OUT VARCHAR2)
AS BEGIN
    SELECT lastname INTO custLast from customer
        WHERE customerID = custID;
    SELECT firstname INTO custFirst from customer
        WHERE customerID = custID;
    SELECT company INTO custComp from customer
        WHERE customerID = custID;
END;
/
VARIABLE lName VARCHAR2(20);
VARIABLE fName VARCHAR2(20);
VARIABLE comp VARCHAR2(50);
EXECUTE getCustomerInfo(1, :lName, :fName, :comp);
PRINT lName;
PRINT fName;
PRINT comp;
-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE deleteInvoice
    (iID IN INTEGER)
AS BEGIN
    DELETE FROM invoiceline WHERE invoiceid = iID;
    DELETE FROM invoice WHERE invoiceid = iID;
	COMMIT;
	EXCEPTION
		WHEN OTHERS THEN
		ROLLBACK;
END;
/
EXECUTE deleteInvoice(217);
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE addCustomer
    (cID IN INTEGER,
    cFirst IN VARCHAR,
    cLast IN VARCHAR,
    cComp IN VARCHAR,
    cEmail IN VARCHAR)
AS BEGIN
    INSERT INTO customer (customerid, firstname, lastname, company, email)
    VALUES (cID, cFirst, cLast, cComp, cEmail);
    COMMIT;
    EXCEPTION
		WHEN OTHERS THEN
		ROLLBACK;
END;
/
EXECUTE addCustomer(60, 'Chris', 'Worcester', 'Microsoft', 'chrisworc@gmail.com');
-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER emp_insert_trig
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    COMMIT;
END;
/
-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_insert_trig
AFTER INSERT ON album
FOR EACH ROW
BEGIN
    COMMIT;
END;
/
-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_delete_trig
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    COMMIT;
END;
/

-- 6.2 INSTEAD OF
-- Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE VIEW invoice_view AS SELECT * FROM invoice;

CREATE OR REPLACE TRIGGER instead_invoice_trig
INSTEAD OF DELETE ON invoice_view
FOR EACH ROW
    BEGIN
    IF(:old.total <= 50) THEN
        DELETE FROM invoice WHERE invoiceid = :old.invoiceid;
    ELSE
        raise_application_error(-20001,'Records can not be deleted');
    END IF;
END;
/
-- 7.0 JOINS
-- In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT firstname, lastname, invoiceid FROM customer
INNER JOIN invoice USING (customerid)
ORDER BY invoiceid;
-- 7.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customerid, firstname, lastname, invoiceid, total FROM customer
FULL OUTER JOIN invoice USING (customerid)
ORDER BY invoiceid;
-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT * FROM album
RIGHT OUTER JOIN artist USING (artistid);
-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM album
CROSS JOIN artist ORDER BY artist.name;
-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM employee
INNER JOIN employee USING (reportsto);
-- 8.0 Indexes
-- In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
-- 8.1 Clustered Indexes
-- Task – Create a clustered index on of table of your choice
CREATE INDEX invoice_value ON invoice (total DESC, invoicedate DESC);