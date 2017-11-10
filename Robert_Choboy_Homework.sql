----1.0	Setting up Oracle Chinook
----In this section you will begin the process of working with the Oracle Chinook database
----Task – Open the Chinook_Oracle.sql file and execute the scripts within.
----2.0 SQL Queries
----In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.
--
     SELECT * FROM EMPLOYEE;
     
--Task – Select all records from the Employee table where last name is King.
     SELECT * FROM EMPLOYEE
     WHERE LASTNAME = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
     SELECT * FROM EMPLOYEE
     WHERE FIRSTNAME = 'Andrew' AND REPORTSTO is NULL;
     
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
     SELECT * FROM ALBUM
     ORDER BY TITLE DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
     SELECT FIRSTNAME, CITY FROM CUSTOMER
     ORDER BY CITY ASC;
     
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
    INSERT INTO GENRE (Genreid, NAME)
    VALUES ('100', 'TYROD');
    INSERT INTO GENRE (Genreid, Name)
    VALUES ('200', 'ROBERT');
    
--Task – Insert two new records into Employee tabtle

    INSERT INTO EMPLOYEE (EMPLOYEEID, LastName, FirstName)
    VALUES ('99','CHOBOY', 'ROBERT');
    INSERT INTO EMPLOYEE (EMPLOYEEID, LastName, FirstName)
    VALUES ('100','TAYLOR', 'TYROD');
    

--Task – Insert two new records into Customer table

    INSERT INTO CUSTOMER (CustomerId, FirstName, LastName)
    VALUES ('1000', 'ROBERT', 'CHOBOY');
    INSERT INTO CUSTOMER (CustomerId, FirstName, LastName)
    VALUES ('2000', 'PETER', 'JOSEPH');
    
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter

    UPDATE CUSTOMER
    SET FirstName = 'Robert', LastName = 'Walter'
    WHERE FirstName = 'Aaron' AND LastName = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

    UPDATE Artist
    SET Name = 'CCR'
    WHERE Name = 'Creedence Clearwater Revival';
    
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
  SELECT * from Invoice
  Where BillingAddress like 'T%';
  
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
  SELECT * FROM Invoice
  Where TOTAL >= '15' and TOTAL <= '50';
  
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN TO_DATE('01-JUN-03', 'DD-MON-YY') AND TO_DATE('01-MAR-04', 'DD-MON-YY');

--2.7 DELETE

   DELETE FROM invoiceline
   WHERE invoiceid in (245,268,290,342,50,61,116);

   DELETE FROM invoice
   WHERE customerid = 32;

  DELETE FROM customer
  WHERE firstname = 'Robert' AND lastname = 'Walter';
    
--3.0	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.

CREATE OR REPLACE FUNCTION GETTHETIME
RETURN TIMESTAMP AS
BEGIN
  RETURN CURRENT_TIMESTAMP;
END;
/
    SELECT GETTHETIME FROM DUAL;
    
   
    
--Task – create a function
--that returns the length of a mediatype from the mediatype table

CREATE OR REPLACE FUNCTION getLength 
RETURN Number as mtnumber number;
    Begin 
        Select Length(name) INTO mtnumber from MEDIATYPE where MEDIATYPEID=1;
        return mtnumber;
END;
/
Select getLength from dual;


--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
   
   
   SELECT AVG(TOTAL)
   FROM INVOICE;
   
--Task – Create a function that returns the most expensive track
   SELECT NAME, UNITPRICE
   FROM TRACK
    WHERE UNITPRICE IN (
   SELECT MAX(UNITPRICE) FROM TRACK
);
   
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
   SELECT AVG(unitprice) "The Average Price" 
   FROM invoiceline;
   

  
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

Select * From Employee
Where BirthDate > '01-Jan-68'
Order By Birthdate;

    
--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.

 Create or Replace Procedure storproc_first_last
 (employee_firstname OUT VARCHAR2,
    employee_lastname OUT VARCHAR2)
AS
BEGIN
    SELECT firstname, lastname 
    INTO employee_firstname, employee_lastname 
    FROM employee;
END;

/  
  
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE EMPLOYEE_UPDATE
(
  THE_EMPLOYEEID IN NUMBER, NEW_LASTNAME IN VARCHAR2, NEW_FIRSTNAME IN VARCHAR2, NEW_TITLE IN VARCHAR2, NEW_REPORTSTO IN NUMBER,
  NEW_BIRTHDATE IN DATE, NEW_HIREDATE IN DATE, NEW_ADDRESS IN VARCHAR2, NEW_CITY IN VARCHAR2, NEW_STATE IN VARCHAR2, NEW_COUNTRY VARCHAR2,
  NEW_POSTALCODE VARCHAR2, NEW_PHONE VARCHAR2, NEW_FAX VARCHAR2, NEW_EMAIL VARCHAR2
)
AS 
BEGIN
  UPDATE EMPLOYEE
  SET LASTNAME = 
        CASE NEW_LASTNAME 
        WHEN NULL THEN 
          LASTNAME
        ELSE NEW_LASTNAME
        END,
      FIRSTNAME =
        CASE NEW_FIRSTNAME 
        WHEN NULL THEN 
          FIRSTNAME
        ELSE NEW_FIRSTNAME
        END,
      TITLE = NEW_TITLE,
      REPORTSTO = NEW_REPORTSTO,
      BIRTHDATE = NEW_BIRTHDATE,
      HIREDATE = NEW_HIREDATE,
      ADDRESS = NEW_ADDRESS,
      CITY = NEW_CITY,
      STATE = NEW_STATE,
      COUNTRY = NEW_COUNTRY,
      POSTALCODE = NEW_POSTALCODE,
      PHONE = NEW_PHONE,
      FAX = NEW_FAX,
      EMAIL = NEW_EMAIL
    WHERE EMPLOYEEID = THE_EMPLOYEEID;
END EMPLOYEE_UPDATE;
/

--Task – Create a stored procedure that returns the managers of an employee.
  CREATE OR REPLACE PROCEDURE StorProcFindManager(
    Employee_Id IN employee.employeeid%TYPE,
    Manager OUT employee.reportsto%TYPE
)
AS
BEGIN
    SELECT reportsto
    INTO Manager
    FROM employee WHERE employeeid = Employee_Id;
END;
/
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE storproc_name_company
(customer_id IN customer.customerid%TYPE, cust_firstname OUT customer.firstname%TYPE, cust_lastname OUT customer.lastname%TYPE,
    cust_company OUT customer.company%TYPE
)
AS
BEGIN
    SELECT firstname, lastname, company
    INTO cust_firstname, cust_lastname, cust_company
    FROM customer WHERE customerid = customer_id;
END;
/
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
   ALTER TABLE INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID;
   ALTER TABLE INVOICELINE ADD CONSTRAINT FK_INVOICELINEINVOICEID
        FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId) ON DELETE CASCADE;
       
        CREATE OR REPLACE PROCEDURE  StorProc_DeleteInvoice (Invoice_Id IN INT)
        AS 
        BEGIN
              DELETE FROM invoice WHERE Invoiceid=Invoice_ID;
              END StorProc_DeleteInvoice;
              /
           
  
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
Create or replace procedure CUSTOMER_INSERT

(
       customer_customer_id  IN     customer.customerid%TYPE,
       customer_first_name IN       customer.firstname%TYPE,
       customer_last_name  IN       customer.lastname%TYPE,
       customer_email IN            customer.email%TYPE
)
AS
Begin
       Insert into CUSTOMER
(
       CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL
      )
Values
      (
 customer_customer_id, customer_first_name, customer_last_name, customer_email
      );
END;
/

   
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE or Replace TRIGGER insert_new_employee
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
INSERT INTO EMPLOYEE 
VALUES (:old.employeeid,
       :old.lastname,
       :old.firstname,
       :old.title,
       :old.reportsto,
       :old.birthdate,
       :old.hiredate,
       :old.address,
       :old.city,
       :old.state,
       :old.country,
       :old.postalcode,
       :old.phone,
       :old.fax,
       :old.email
   );
END;
/


--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE or replace TRIGGER update_album
AFTER UPDATE ON ALBUM
FOR EACH ROW 
BEGIN
        
        INSERT INTO ALBUM (albumid, title, artistid)
        VALUES (:new.albumid,
                :new.title,
                :new.artistid
              );
              
END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
--
--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE TRIGGER Restrict
ON Invoice
INSTEAD OF INSERT
AS
BEGIN
DECLARE Total INT
/




--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

   SELECT customer.firstname, customer.lastname, invoice.invoiceId FROM customer
INNER JOIN invoice ON customer.customerid = invoice.customerid;
         
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
         SELECT Customer.CustomerId, Customer.FirstName, Customer.LastName, Invoice.InvoiceId, Invoice.total
                FROM CUSTOMER
         FULL OUTER JOIN INVOICE on Customer.CustomerId=Invoice.InvoiceId;
                                   
                                    
--Task – Create a right join that joins album and artist specifying artist name and title.

         Select ARTIST.NAME, ALBUM.TITLE
         From ARTIST
         Right Join ALBUM on ARTIST.ArtistId=ALBUM.AlbumId;
         
         
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

         Select Artist.name, Album.title
         From Artist
         Cross Join Album 
         Order by Artist.name Asc;
         
         
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
 
          Select Emp.FirstName, Emp.LastName, Emp.Title, Emp.ReportsTo
          From Employee Emp, Employee Empl
          Where Emp.ReportsTo=Empl.ReportsTo
          Order by Empl.ReportsTo;
          
          
--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice

       create table ROBS_TABLE
(
   MY_id  integer not null, 
   SOCIAL_id     integer not null, 
   primary key (MY_id, SOCIAL_id)
)
organization index;
        