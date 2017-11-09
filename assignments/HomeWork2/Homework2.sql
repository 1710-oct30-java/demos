-- 2.1 SELECT
-- Task – Select all records from the Employee table.
SELECT * FROM Employee;
-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM Employee
WHERE lastname LIKE 'King';
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM Employee
WHERE firstname LIKE 'Andrew' 
AND REPORTSTO IS NULL;
-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM Album
ORDER BY title DESC;
-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM Customer
ORDER BY city ASC;
-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
INSERT INTO Genre Values (66,"Smooth Jazz");
INSERT INTO Genre Values (67,"Melodic DeathMetal");
-- Task – Insert two new records into Employee table
INSERT INTO Employee (EMPLOYEEID,FIRSTNAME,LASTNAME) VALUES (9,'boe','jackson');
INSERT INTO Employee (EMPLOYEEID,FIRSTNAME,LASTNAME) VALUES (10, 'Gravey', 'Grumps');

-- Task – Insert two new records into Customer table
INSERT INTO Customer (CUSTOMERID,FIRSTNAME,LASTNAME,EMAIL) VALUES (60, 'boe','jackson','boejackson@boejackon.jackson');
INSERT INTO Customer (CUSTOMERID,FIRSTNAME,LASTNAME,EMAIL) VALUES (61, 'Moe','jackson','moejackson@boejackson.jackson');
-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist
SET Name = 'CCR'
WHERE Name = 'Creedence Clearwater Revival';
-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%”
SELECT * FROM Invoice
WHERE BillingAdress LIKE 'T%';
-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
Select * from Invoice
Where total between 15 AND 50;
-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
Select * from Employee
Where HIREDATE between TO_DATE('01/07/2003', 'DD/MM/YYYY') AND 
 TO_DATE('01/04/2004', 'DD/MM/YYYY');
-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER Table Album Drop Constraint FK_AlbumArtistId;
ALTER TABLE Album ADD CONSTRAINT FK_AlbumArtistId
    FOREIGN KEY (ArtistId) REFERENCES Artist (ArtistId)  
    ON DELETE CASCADE enable novalidate;

ALTER TABLE Customer Drop CONSTRAINT FK_CustomerSupportRepId;
ALTER TABLE Customer ADD CONSTRAINT FK_CustomerSupportRepId
    FOREIGN KEY (SupportRepId) REFERENCES Employee (EmployeeId)  
    ON DELETE CASCADE enable novalidate;

ALTER TABLE Employee DROP CONSTRAINT FK_EmployeeReportsTo;
ALTER TABLE Employee ADD CONSTRAINT FK_EmployeeReportsTo
    FOREIGN KEY (ReportsTo) REFERENCES Employee (EmployeeId)  
    ON DELETE CASCADE enable novalidate;

ALTER TABLE Invoice DROP CONSTRAINT FK_InvoiceCustomerId;
ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceCustomerId
    FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId)  
    ON DELETE CASCADE enable novalidate;

ALTER TABLE InvoiceLine DROP CONSTRAINT FK_InvoiceLineInvoiceId;
ALTER TABLE InvoiceLine ADD CONSTRAINT FK_InvoiceLineInvoiceId
    FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId)  
    ON DELETE CASCADE enable novalidate;

ALTER TABLE InvoiceLine DROP CONSTRAINT FK_InvoiceLineTrackId;
ALTER TABLE InvoiceLine ADD CONSTRAINT FK_InvoiceLineTrackId
    FOREIGN KEY (TrackId) REFERENCES Track (TrackId)  
    ON DELETE CASCADE enable novalidate;

ALTER TABLE PlaylistTrack DROP CONSTRAINT FK_PlaylistTrackPlaylistId;
ALTER TABLE PlaylistTrack ADD CONSTRAINT FK_PlaylistTrackPlaylistId
    FOREIGN KEY (PlaylistId) REFERENCES Playlist (PlaylistId)  
    ON DELETE CASCADE enable novalidate;

ALTER TABLE PlaylistTrack DROP CONSTRAINT FK_PlaylistTrackTrackId;
ALTER TABLE PlaylistTrack ADD CONSTRAINT FK_PlaylistTrackTrackId
    FOREIGN KEY (TrackId) REFERENCES Track (TrackId)  
    ON DELETE CASCADE enable novalidate;

ALTER TABLE Track DROP CONSTRAINT FK_TrackAlbumId;
ALTER TABLE Track ADD CONSTRAINT FK_TrackAlbumId
    FOREIGN KEY (AlbumId) REFERENCES Album (AlbumId)  
    ON DELETE CASCADE enable novalidate;

ALTER TABLE Track DROP CONSTRAINT FK_TrackGenreId;
ALTER TABLE Track ADD CONSTRAINT FK_TrackGenreId
    FOREIGN KEY (GenreId) REFERENCES Genre (GenreId)  
    ON DELETE CASCADE enable novalidate;

ALTER TABLE Track DROP CONSTRAINT FK_TrackMediaTypeId;
ALTER TABLE Track ADD CONSTRAINT FK_TrackMediaTypeId
    FOREIGN KEY (MediaTypeId) REFERENCES MediaType (MediaTypeId)  
    ON DELETE CASCADE enable novalidate;

DELETE FROM Customer
Where firstname = 'Robert' AND lastname = 'Walter';
-- ⦁	SQL Functions
-- In this section you will be using the Oracle system functions, AS well AS your own functions, to perform various actions against the database
-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION time
    RETURN TIMESTAMP
    AS
    BEGIN
        RETURN systimestamp;
    end;
/
-- Task – create a function that returns the length of a mediatype from the mediatype table
CREATE FUNCTION length_mediatype(mtid IN NUMBER)
    RETURN NUMBER
    IS mtlength NUMBER;
    BEGIN
        SELECT LENGTH(name)
        INTO mtlength
        FROM mediatype
        WHERE MediaTypeId = mtid;
        RETURN(mtlength);
    END;
/
-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices
CREATE FUNCTION get_invoice_avg
    RETURN NUMBER  
    IS average NUMBER;
    BEGIN
        SELECT AVG(total)
        INTO average
        FROM invoice;
        RETURN (average);
    END;
/
-- Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION get_most_expensive_track
return SYS_REFCURSOR
AS
out_cursor SYS_REFCURSOR;
BEGIN
    OPEN out_cursor FOR
     SELECT *
        FROM Track
        where unitprice in (Select MAX(unitprice) from Track);
        RETURN out_cursor;
end;
/
-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE FUNCTION get_invoiceline_avg
    RETURN NUMBER  
    IS average NUMBER;
    BEGIN
        SELECT AVG(unitprice)
        INTO average
        FROM invoiceline;
        RETURN (average);
    END;
/
-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION get_born_after_sixtyeight
return SYS_REFCURSOR
AS
out_cursor SYS_REFCURSOR;
BEGIN
    OPEN out_cursor FOR
     SELECT *
        FROM Employee
        WHERE EXTRACT(YEAR FROM Birthdate) < 1968;
        RETURN out_cursor;
end;
/
-- 4.0 Stored Procedures
--  In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_name_employee
(out_cursor OUT SYS_REFCURSOR)
is
BEGIN
    OPEN out_cursor FOR SELECT firstname, lastname FROM employee;
end get_name_employee;
/
-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee
(id IN NUMBER, lname IN VARCHAR2, fname IN VARCHAR2, add IN VARCHAR2, pho IN VARCHAR2, emailadd IN VARCHAR2)
AS
BEGIN
    UPDATE employee 
    SET lastname = lname, firstname = fname, address = add, phone = pho, email = emailadd
    WHERE employeeid = id;
end;
/

-- Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE get_manager
(eid IN NUMBER, out_cursor OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN out_cursor FOR SELECT * from employee where employeeid in (Select reportsto from employee where employeeid = eid);
end;
/
-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
 CREATE OR REPLACE PROCEDURE get_cust_name_comp
(cid IN NUMBER, out_cursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN out_cursor FOR 
    SELECT firstname, lastname company FROM customer WHERE customerid = cid;
end;
/
-- 5.0 Transactions
--USE COMMIT
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE remove_invoice
(iid IN NUMBER)
AS
BEGIN
    --ALL DEPENDENCY ISSUES WERE HANDLED IN PROBLEM 2.7
    DELETE FROM invoice WHERE invoiceid = iid;
    commit;
end;
/
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE add_customer
(cid IN NUMBER, fname IN VARCHAR2, lname IN VARCHAR2, comp IN VARCHAR2, add IN VARCHAR2, cty IN VARCHAR2, stte IN VARCHAR2, cntry IN VARCHAR2, pc IN VARCHAR2, fone IN VARCHAR2, fx IN VARCHAR2, mail IN VARCHAR2)
AS
BEGIN
    INSERT INTO customer (customerid,firstname,lastname,company,address,city,state,country,postalcode,phone,fax,email)
    VALUES (cid,fname,lname,comp,add,cty,stte,cntry,pc,fone,fx,mail);
    COMMIT;
END;
/
-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER no_insert
AFTER INSERT ON employee
FOR EACH ROW
begin
    Delete from employee where employeeid = :old.employeeid;
end;
/
-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER no_update
AFTER UPDATE ON album
FOR EACH ROW
begin
    DELETE FROM album where albumid = :old.albumid;
end;
/
-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER no_delete
AFTER DELETE ON customer
FOR EACH ROW
begin
    INSERT INTO 
end;
/
-- 6.2 INSTEAD OF
-- Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER no_delete_high_price
BEFORE DELETE ON Invoice
FOR EACH ROW
WHEN(old.total > 50)
BEGIN
    RAISE_APPLICATION_ERROR(-20000, 'Invoice worth too much.');
end;
/
-- 7.0 JOINS
-- In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT customer.firstname,customer.lastname, invoice.invoiceid 
FROM customer 
INNER JOIN invoice 
Using(customerid);
-- 7.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total 
FROM customer 
FULL OUTER JOIN invoice
ON (customer.customerid = invoice.customerid);
-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name , album.title
FROM album
RIGHT JOIN artist
USING(artistid);
-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM album, artist
ORDER BY artist.name ASC;
-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT *
FROM employee e1
INNER JOIN employee e2
ON(e1.reportsto = e2.employeeid);
-- 8.0 Indexes
-- In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
-- 8.1 Clustered Indexes
-- Task – Create a clustered index on of table of your choice
CREATE INDEX employeeid_index ON employee (employeeid, firstname, lastname);