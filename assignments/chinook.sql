 2.1 SELECT
 SELECT * FROM employee;
 SELECT * FROM employee WHERE LASTNAME='King';
 SELECT * FROM employee WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;
 
 2.2 ORDER BY
 SELECT * FROM  Album ORDER BY TITLE desc;
 SELECT firstname, city FROM customer ORDER BY CITY;
 
 2.3 INSERT INTO
 INSERT ALL INTO Genre (GENREID, NAME) VALUES ('614', 'Spooky') INTO Genre (GENREID, NAME) VALUES ('615', 'Conspiracy') SELECT * FROM dual ;
 INSERT ALL INTO Employee (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES ('9', 'Hearn', 'Austin') INTO Employee (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES ('10', 'Montgomery', 'Jimmy') SELECT * FROM dual;
 INSERT ALL INTO Customer (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES ('60', 'Hearn', 'James', 'jay@myemail.com') INTO Customer (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES ('61', 'Ball', 'Lavar', 'lavarball@gmail.com') SELECT * FROM dual;
 
 2.4 UPDATE
 UPDATE Customer SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
 UPDATE Artist SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
 
 2.5 LIKE
 SELECT * FROM Invoice WHERE BILLINGADDRESS LIKE 'T%';
 
 2.6 BETWEEN
 SELECT * FROM Invoice WHERE TOTAL BETWEEN 15 AND 50;
 SELECT * FROM Employee WHERE HIREDATE BETWEEN TO_DATE ('2003/06/01', 'yyyy/mm/dd') AND TO_DATE ('2004/03/01', 'yyyy/mm/dd');
 
 2.7 DELETE
 ALTER TABLE Invoice DISABLE CONSTRAINT FK_INVOICECUSTOMERID;
 DELETE FROM Customer WHERE LASTNAME = 'Walter' AND FIRSTNAME = 'Robert';
 
 3.1 System Defined Functions
create or replace function getDate
return date is
    getSystemDate date;
    begin
    SELECT sysdate
    INTO getSystemDate
    from dual;
    return getSystemDate;
end;
 SELECT length(NAME) FROM MEDIATYPE;
 
 3.2 System Defined Aggregate Functions
 Create a function that returns the average total of all invoices
 SELECT AVG(TOTAL) FROM INVOICE;
 Create a function that returns the most expensive track
 SELECT MAX(UNITPRICE) FROM TRACK;
SELECT NAME, UNITPRICE
FROM TRACK
WHERE UNITPRICE IN (SELECT MAX(UNITPRICE) FROM TRACK);

 3.3 User Defined Scalar Functions
 Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function AvgInvoiceline
return NUMBER is 
anumber number;
BEGIN
SELECT AVG(UNITPRICE)
INTO anumber
FROM INVOICELINE;
return anumber;
end;
/
SELECT AvgInvoiceline from dual;

 3.4 Create a function that returns all employees who are born after 1968
create or replace function Employee1968
CREATE TABLE employees
AS (SELECT * FROM Employee WHERE BIRTHDATE > 1968-12-31);

4.1 Create a stored procedure that selects the first and last names of all employees
create or replace PROCEDURE firstLast AS
recordset SYS_REFCURSOR;
BEGIN 
OPEN recordset FOR 
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
dbms_sql.return_result(recordset);
END;
/
execute firstLast;

4.2 Updates the personal information of an employee
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

-- 4.2 Stored procedure that returns the managers of an employee
CREATE OR REPLACE PROCEDURE managers (eid IN NUMBER, manager OUT VARCHAR2)
AS
recordset SYS_REFCURSOR;
BEGIN
OPEN recordset FOR
SELECT REPORTSTO into manager FROM employee WHERE employeeid = eid;
dbms_sql.return_result(recordset);
END;
/

DECLARE manager VARCHAR2(40);
BEGIN
managers (7, MANAGER);
END;

-- 4.3 Create a stored procedure that returns the name and company of a customer
CREATE OR REPLACE PROCEDURE customerInfo(
cust_id IN VARCHAR2,
cust_fname OUT VARCHAR2,
cust_lname OUT VARCHAR2,
cust_company OUT VARCHAR2)
AS
recordset SYS_REFCURSOR;
BEGIN
OPEN recordset FOR
SELECT FIRSTNAME, LASTNAME, COMPANY
INTO cust_fname, cust_lname, cust_company
FROM customer WHERE customerid = cust_id;
dbms_sql.return_result(recordset);
END;
/

-- 5.0 Create a transaction that given an invoiceId will delete that invoice 

ALTER TABLE INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID;
ALTER TABLE INVOICELINE ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId) ON DELETE CASCADE;
        
CREATE OR REPLACE PROCEDURE  DeleteInvoice (Invoice_Id IN INT)
AS
BEGIN
DELETE FROM invoice WHERE invoiceid=invoice_ID;              
END DeleteInvoice;
/
EXEC DeleteInvoice(1);


-- Create a transaction nested within a stored procedure that inserts a new record
-- in the Customer table

CREATE OR REPLACE PROCEDURE NewRecord (
cust_id IN VARCHAR2, cust_fname IN VARCHAR2, cust_lname IN VARCHAR2, cust_email IN VARCHAR2)
AS
BEGIN
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) 
VALUES (cust_id, cust_fname, cust_lname, cust_email);
END;
/
EXEC NewRecord(62, 'Jimmy', 'Neutron', 'jneu@gmail.com');

-- 6.1 TRIGGERS
-- AFTER FOR
-- Create an after insert trigger on the employee table fired after a new record s inserted into the table

CREATE OR REPLACE TRIGGER afterIns
AFTER INSERT
ON employee
FOR EACH ROW
declare
v_line varchar2(40);
BEGIN
v_line := 'After insert trigger fired';
dbms_output.put_line(v_line);
END;
/

-- Create an after update trigger on the album table taht fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER afterUpd
AFTER UPDATE
ON album
FOR EACH ROW
declare
v_line varchar2(40);
BEGIN
v_line := 'After update trigger fired';
dbms_output.put_line(v_line);
END;
/

 -- Create an after delete trigger on the customer table that fires after a row is deleted from the table
CREATE OR REPLACE TRIGGER afterDel
AFTER DELETE
ON customer
FOR EACH ROW
declare
v_line varchar2(40);
BEGIN
v_line := 'After delete trigger fired';
dbms_output.put_line(v_line);
END;
/

-- 6.2 Create instead of trigger that restricts deletion of any invoice that is price over 50 dollars
-- Not sure?????????????
CREATE OR REPLACE TRIGGER restrictDel
BEFORE DELETE
ON invoice
FOR EACH ROW
WHEN (OLD.TOTAL > 50)
BEGIN
raise_application_error(-20100, 'You cannot delete this record');
END;
/

-- 7.0 Joins
-- 7.1 Create an inner join that joins customers and orders and specifies the name of the customer and invoiceID
SELECT customer.firstname, customer.lastname, invoice.invoiceId 
FROM customer
INNER JOIN invoice ON customer.customerid = invoice.customerid;

-- 7.2 Create an outer join that joins customer and invocie table
--     specifying customerid firstname lastname invoiceid and total

SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer
LEFT OUTER JOIN invoice ON customer.customerid = invoice.customerid;

-- 7.3 Create a right join that joins album and artist specifying artist name and title
SELECT album.title, artist.name FROM album
RIGHT OUTER JOIN artist ON album.artistid = artist.artistid;

-- 7.4 Create cross join that joins album and artist and sorts by artist name in asc
SELECT * FROM artist, album ORDER BY artist.name;

-- 7.5 Perform self join on employee table, joining on reportsto column
SELECT one.firstname, one.lastname, two.firstname, two.lastname
FROM employee one, employee two
where one.reportsto = two.employeeid;

-- Create a clustered index on table of your choice
-- Unsure????????????????????????
create table numbers
(
   number_id  integer not null, 
   int_id     integer not null, 
   primary key (number_id, int_id)
)
organization index;
