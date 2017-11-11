--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.
Select * From EMPLOYEE;

--Task – Select all records from the Employee table where last name is King.
Select * From EMPLOYEE Where LASTNAME = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
Select * From EMPLOYEE Where (FIRSTNAME = 'Andrew' AND REPORTSTO is NULL);


--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
Select * From ALBUM Order By TITLE DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
Select FIRSTNAME From CUSTOMER Order By CITY ASC;


--2.3 INSERT INTO
--Task – Insert two new records into Genre table
Insert Into GENRE (GENREID, NAME) 
Values (
(Select COUNT(*)FROM GENRE) + 1, 'TEST');

--Task – Insert two new records into Employee table
Insert Into EMPLOYEE
Values(
(Select COUNT(*)FROM EMPLOYEE) + 1, 'DOE', 'Jane', 'IT Staff', 6, '01-JAN-11', 
'12-DEC-12', '123 REAL PLACE', 'REALCITY', 'AB', 'Canada', 'TK 421', '+1 (404) 123-4567',
'+1 (404) 123-4567', 'Real@chinookcorp.com');
Insert Into EMPLOYEE
Values(
(Select COUNT(*)FROM EMPLOYEE) + 1, 'DOE', 'John', 'IT Staff', 6, '01-JAN-11', 
'12-DEC-12', '123 REAL PLACE', 'REALCITY', 'AB', 'Canada', 'TK 421', '+1 (404) 123-4568',
'+1 (404) 123-4568', 'TotallyReal@chinookcorp.com');



--Task – Insert two new records into Customer table
Insert Into CUSTOMER
Values(
(Select COUNT(*)FROM CUSTOMER) + 1, 'Jane', 'Doe', 'NSP Publishing', 
'123 REAL PLACE', 'REALCITY', 'AB', 'Canada', '12345-6789', '+1 (404) 123-4568',
'+1 (404) 123-4568', 'TotallyReal@chinookcorp.com', '8');

Insert Into CUSTOMER
Values(
(Select COUNT(*)FROM CUSTOMER) + 1, 'John', 'Doe', 'NSP Publishing', 
'123 REAL PLACE', 'REALCITY', 'AB', 'Canada', '12345-6789', '+1 (404) 123-4569',
'+1 (404) 123-4569', 'Real@chinookcorp.com', '8');


--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
Update CUSTOMER
Set FIRSTNAME = 'Robert', LASTNAME = 'Walter'
Where FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
Update ARTIST
SET NAME = 'CCR'
Where NAME = 'Creedence Clearwater Revival';


--2.5 LIKE
--Task – Select all invoices with a billing address like “T%
SELECT * FROM invoice WHERE BILLINGADDRESS LIKE 'T%';


--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL > 15 AND TOTAL  < 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE > '01-JUN-03' AND HIREDATE < '01-MAR-04';


--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM INVOICELINE WHERE INVOICEID IN (
    SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID IN (
        SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));
DELETE FROM INVOICE WHERE CUSTOMERID IN (
    SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';


--3.0	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT CURRENT_TIMESTAMP FROM DUAL;

--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH( NAME ) FROM MEDIATYPE;


--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
SELECT AVG ( TOTAL ) FROM INVOICE;

--Task – Create a function that returns the most expensive track
SELECT * FROM TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);


--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function avgPrice
return number
as
average NUMBER;
begin
    SELECT AVG ( UNITPRICE ) into average FROM invoiceline;
    return average;
end;
/
SELECT avgPrice() FROM dual;


--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968

create type my_tab_type is object
( nam varchar2(160))
/
create type temp is table of my_tab_type;
/
create or replace function bornAfter(
input DATE
)
return temp PIPELINED 
IS
BEGIN
    FOR i IN (SELECT *
    FROM employee 
    WHERE birthdate > input) LOOP
    PIPE ROW(my_tab_type(i.LASTNAME || ', ' || i.FIRSTNAME ));
    END LOOP;
    RETURN;
END;
/
SELECT nam FROM TABLE(bornAfter('01-JAN-1968'));


--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
create or replace procedure firstLastName
(reply out sys_refcursor)
IS
BEGIN
    OPEN reply for SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END firstLastName;
/
var x refcursor;
execute firstLastName(:x);
print x;


--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
create or replace procedure update_Employee
(empID IN NUMBER, var_Lname IN VARCHAR2, var_Fname IN VARCHAR2, var_Birthdate IN DATE, var_Phone IN VARCHAR2, var_Fax IN VARCHAR2, var_Email IN VARCHAR2)
as
begin
    UPDATE EMPLOYEE 
    SET LASTNAME = var_Lname, FIRSTNAME = var_Fname, BIRTHDATE = var_Birthdate, PHONE = var_Phone, FAX = var_Fax, EMAIL = var_Email
    WHERE EMPLOYEEID = empid;
end update_Employee;
/
execute update_Employee(1, 'Doe', 'Jane', '01-Jan-62', '', '', '');

--Task – Create a stored procedure that returns the managers of an employee.
create or replace procedure findManagers
(empID IN NUMBER, manager1 OUT NUMBER)
as
begin
    SELECT reportsto INTO manager1 
    FROM employee WHERE employeeid = empID;
end findManagers;
/
--SET SERVEROUTPUT ON
--DECLARE
--    manager1 NUMBER := 0;
--BEGIN
--    findManagers (6,manager1);
--    dbms_output.put_line('Managers ID: '||manager1);
--END;
--/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE nameCompany
(custID IN NUMBER, fName OUT VARCHAR2, lName OUT VARCHAR2, compy OUT VARCHAR2)
is
BEGIN
    SELECT FIRSTNAME INTO fName FROM customerid WHERE customerid = custID;
    SELECT lastname INTO lName FROM customerid WHERE customerid = custID;
    SELECT company INTO compy FROM customerid WHERE customerid = custID;
END;
/


--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE deleteInvoice
(invoID IN NUMBER)
is
BEGIN
    BEGIN
        DELETE FROM INVOICELINE WHERE invoiceid = invoID;
        DELETE FROM INVOICE WHERE invoiceid = invoID;
    END;
    COMMIT;
END;
/
--execute deleteInvoice(213);
--select * from invoice;

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace procedure insert_cust
    (var_customerid IN INT, 
    var_FirstName VARCHAR,
    var_LastName VARCHAR2,
    var_Company VARCHAR2,
    var_Address VARCHAR2,
    var_City VARCHAR2,
    var_State VARCHAR2,
    var_Country VARCHAR2,
    var_PostalCode VARCHAR2,
    var_Phone VARCHAR2,
    var_Fax VARCHAR2,
    var_Email VARCHAR2,
    var_SupportRepId NUMBER, 
    generated_id OUT sys_refcursor)
as -- or is
begin
    INSERT INTO customer (customerid, FirstName, LastName, Company, Address, City, 
        State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
    VALUES (var_customerid, var_FirstName, var_LastName, var_Company, var_Address, var_City, 
        var_State, var_Country, var_PostalCode, var_Phone, var_Fax, var_Email, var_SupportRepId);
    OPEN generated_id FOR SELECT * FROM CUSTOMER WHERE CUSTOMER.Firstname =var_FirstName;
end insert_cust;
/


--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger new_employee_trig
after insert on employee
for each row
begin
   UPDATE employee
   SET employeeid = (SELECT COUNT(*) FROM EMPLOYEE)
   where employeeid = (SELECT COUNT(*) FROM EMPLOYEE);
end;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger new_ablum_update_trig
--The question is confusing so i did both
after insert or update on album
for each row
begin
    if inserting then
        UPDATE employee
        SET employeeid = (SELECT COUNT(*) FROM EMPLOYEE)
        WHERE employeeid = (SELECT COUNT(*) FROM EMPLOYEE);
    elsif updating then
        UPDATE employee
        SET employeeid = (SELECT COUNT(*) FROM EMPLOYEE)
        WHERE employeeid = (SELECT COUNT(*) FROM EMPLOYEE);
    end if;
end;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace trigger new_customer_del_trig
after delete on customer
begin
   UPDATE customer
   SET customerid = :old.customerid
   where customerid = (SELECT COUNT(*) FROM customer);
end;
/


--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.

--Error report -
--ORA-25002: cannot create INSTEAD OF triggers on tables

--create or replace trigger instead_of_delete
--instead of delete on invoice
--for each row
--begin
--    if :old.total >=50 then
--        RAISE_APPLICATION_ERROR(-20001,'Record cannot be deleted.');
--        rollback;
--    end if;
--end;
--/


--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT customer.firstname, customer.lastname, invoice.invoiceid
FROM customer
INNER JOIN invoice ON customer.customerid = invoice.customerid;


--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer
FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;


--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title
FROM album
RIGHT JOIN artist ON album.artistid = artist.artistid;


--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM artist
CROSS JOIN album
ORDER BY artist.NAME ASC;


--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT t2.employeeID AS employee, t1.employeeid AS Manager
FROM employee t1, employee t2
WHERE t2.reportsto = t1.employeeID;


--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice
CREATE CLUSTER album_cluster (TITLE VARCHAR2(160))
   SIZE 600
   TABLESPACE users
   STORAGE (INITIAL 200K
      NEXT 300K
      MINEXTENTS 2
      PCTINCREASE 33);

CREATE INDEX ALBUM_INDEX
    on CLUSTER album_cluster
    TABLESPACE users
    STORAGE (INITIAL 50K
      NEXT 50K
      MINEXTENTS 2
      MAXEXTENTS 10
      PCTINCREASE 33);
    