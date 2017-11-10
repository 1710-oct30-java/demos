--Part I – Working with an existing database
--
--1.0	Setting up Oracle Chinook
--In this section you will begin the process of working with the Oracle Chinook database
--Task – Open the Chinook_Oracle.sql file and execute the scripts within.
--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.

--SELECT * FROM Employee;

--Task – Select all records from the Employee table where last name is King.

--SELECT * FROM Employee WHERE Employee.LASTNAME = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

--SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.

--SELECT * FROM ALBUM ORDER BY TITLE DESC;

--Task – Select first name from Customer and sort result set in ascending order by city

--SELECT FIRSTNAME,LASTNAME FROM CUSTOMER ORDER BY CITY;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table

--INSERT INTO GENRE (GenreID, Name) VALUES (26, 'OST');
--INSERT INTO GENRE (GenreID, Name) VALUES (27, 'Nu Genre');


--Task – Insert two new records into Employee table

--INSERT INTO employee (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES 
--                    (123456789,   'Smith',  'Smitty');
--
--INSERT INTO employee (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES 
--                    (123456790,   'von Eldunberry',  'Federick');

--Task – Insert two new records into Customer table

--INSERT INTO customer (customerid, firstname, lastname, email) VALUES (9999, 'Mike', 'Prison', 'mike@prison.gov');
--INSERT INTO customer (customerid, firstname, lastname, email) VALUES (10000, 'Mike', 'Date', 'mike@date.fun');

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter

--UPDATE Customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

--UPDATE artist SET name = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”

--SELECT * FROM invoice WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50

--SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004

--NEEDS FIX
--SELECT * FROM employee WHERE hiredate BETWEEN TO_DATE('01/06/2003', 'DD/MM/YYYY') AND TO_DATE('01/03/2004', 'DD/MM/YYYY');

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

--ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
--ALTER TABLE INVOICE ADD CONSTRAINT FK_INVOICECUSTSOMERID FOREIGN KEY (customerid) REFERENCES customer (customerid) ON DELETE CASCADE;
--ALTER TABLE INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID;
--ALTER TABLE INVOICELINE ADD CONSTRAINT FK_INVOICELINEINVOICEID FOREIGN KEY (invoicelineid) REFERENCES invoice (invoiceid) ON DELETE CASCADE;
--
--
--DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';


--3.0	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.

--CREATE OR REPLACE FUNCTION getCurrentTime
--    RETURN TIMESTAMP
--    IS stamp TIMESTAMP DEFAULT SYSTIMESTAMP;
--    BEGIN
--        RETURN stamp;
--END;     
        

--Task – create a function that returns the length of a mediatype from the mediatype table
    
--CREATE OR REPLACE Function getMediaTypeLength(mediaName IN varchar2)
--    RETURN number
--    IS lengthOfName number DEFAULT 0;
--    BEGIN
--        lengthOfName := LENGTH(mediaName);
--        --SELECT LENGTH(name) INTO lengthOfName FROM mediatype WHERE name = mediaName;
--        return lengthOfName;
--END;


--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices

--CREATE OR REPLACE FUNCTION getAverageTotal
--    RETURN number
--    IS average NUMBER DEFAULT 0;
--    BEGIN 
--        SELECT AVG(total) INTO average FROM invoice;
--END;    

--Task – Create a function that returns the most expensive track

--CREATE OR REPLACE FUNCTION getMostExpensiveTrack
--    RETURN varchar2
--    IS trackname varchar2(200) DEFAULT '';
--    BEGIN
--        SELECT name INTO trackname FROM track WHERE 
--            unitprice = (SELECT MAX(unitprice) FROM track);
--        RETURN trackname;
--END;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table

--CREATE OR REPLACE FUNCTION getAveragePrice
--    RETURN number
--    IS average NUMBER DEFAULT 0;
--    BEGIN 
--        SELECT AVG(unitprice) INTO average FROM invoiceline;
--END;    

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

--CREATE OR REPLACE FUNCTION bornAfter1968
--    RETURN SYS_REFCURSOR
--    IS resultSet SYS_REFCURSOR;
--    BEGIN
--        OPEN resultSet FOR 'SELECT * FROM employee WHERE birthdate > Date(1969-01-01)';
--        RETURN resultSet;
--    END;    


--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.

--CREATE OR REPLACE PROCEDURE firstAndLastNames(curs OUT SYS_REFCURSOR)
--AS
--BEGIN
--    OPEN curs FOR 'SELECT firstname, lastname FROM employee';
--END;

--CREATE OR REPLACE PROCEDURE firstAndLastNames
--AS
--BEGIN
--    SELECT firstname, lastname FROM employee;
--END;
--    

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.

--CREATE OR REPLACE PROCEDURE updatePersonal(e_id IN NUMBER, newPhone IN VARCHAR2, newEmail IN VARCHAR2)
--    IS
--    BEGIN
--        UPDATE employee SET phone = newPhone, email = newEmail WHERE employeeID = e_id;
--    END;

--Task – Create a stored procedure that returns the managers of an employee.

--CREATE OR REPLACE PROCEDURE getManager(e_id IN NUMBER, m_id OUT NUMBER)
--    AS
--    BEGIN
--        SELECT reportsTo INTO m_id FROM employee WHERE employeeID = e_id;
--    END;

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.

--CREATE OR REPLACE PROCEDURE getCustomerNameAndCompany(c_id IN NUMBER, c_first OUT VARCHAR2, c_last OUT VARCHAR2, c_company OUT VARCHAR2)
--    AS
--    BEGIN
--        SELECT
--            firstname,  lastname, company
--            INTO
--            c_first,    c_last,   c_company
--            FROM customer WHERE customerid = c_id;
--    END;
--/
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

--CREATE OR REPLACE PROCEDURE deleteInvoice(i_id IN NUMBER)
--    AS
--    BEGIN    
--        DELETE FROM invoiceline WHERE invoiceid = i_id;
--        DELETE FROM invoice WHERE invoiceid = i_id;
--        COMMIT;
--    EXCEPTION WHEN OTHERS THEN
--        ROLLBACK;
--    END;    
--/

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

--CREATE OR REPLACE PROCEDURE newCustomer(c_id IN NUMBER, c_firstname IN VARCHAR2, c_lastname IN VARCHAR2, c_email IN VARCHAR2)
--AS
--    BEGIN
--            INSERT INTO customer (customerid, firstname, lastname, email)
--                VALUES(c_id, c_firstname, c_lastname, c_email);
--            COMMIT;
--        EXCEPTION WHEN OTHERS THEN
--            ROLLBACK;
--    END;
--/

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

--CREATE OR REPLACE TRIGGER new_employee_trig
--    AFTER INSERT ON employee
--    FOR EACH ROW
--    BEGIN
--        UPDATE employee SET title = 'newbie' WHERE employeeid = :new.employeeid;
--    END;    
--            

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table

--CREATE OR REPLACE TRIGGER new_album_trig
--    AFTER UPDATE ON album
--    FOR EACH ROW
--    BEGIN
--        UPDATE album SET title = 'NEW RELEASE ' || title WHERE albumid = :new.albumid;
--    END;
--    /

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
--
--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.

--CREATE VIEW invoice_v AS
--    SELECT * FROM invoice;
--
--CREATE OR REPLACE TRIGGER cantDeleteLargeInvoice
--    INSTEAD OF DELETE ON invoice_v
--    FOR EACH ROW
--    BEGIN
--        IF(:old.total <= 50) THEN
--            DELETE FROM invoice WHERE invoiceid = :old.invoiceid;
--        END IF;
--    END;
--    /

--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

--SELECT invoiceid, firstname, lastname FROM invoice
--    INNER JOIN customer USING (customerid);

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

--SELECT invoiceid, firstname, lastname, total FROM invoice
--    FULL OUTER JOIN customer USING (customerid);

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.

--SELECT title, name FROM album
--    RIGHT JOIN artist USING(artistid);

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

--SELECT * FROM album, artist ORDER BY name;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.

--SELECT o.*, r.firstname || ' ' || r.lastname AS manager FROM employee o
--    LEFT JOIN employee r ON o.reportsto = r.employeeid;

--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice

--CREATE INDEX LASTFIRSTINDEX ON EMPLOYEE (LASTNAME ASC, FIRSTNAME ASC);
