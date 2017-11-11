-- 2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME='King';
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE firstname='Andrew' and reportsto is null;
-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
Select * from album order by title desc;
-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT * FROM customer order by city asc;
-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
Insert into Genre Values (26, 'my genre');
-- Task – Insert two new records into Employee table
Insert into employee (employeeid, lastname, firstname) Values (9,'my lastname', 'my firstname');
Insert into employee (employeeid, lastname, firstname) Values (10,'my lastname2', 'my firstname2');
-- Task – Insert two new records into Customer table
Insert into customer (customerid, lastname, firstname, email) Values (60,'my lastname1', 'my firstname1', 'my email1');
Insert into customer (customerid, lastname, firstname, email) Values (61,'my lastname2', 'my firstname2', 'my email2');
-- 2.4 Update
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer SET FIRSTNAME='Robert', LASTNAME='Walter'
WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist SET NAME='CCR'
WHERE name='Creedence Clearwater Revival';

-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%”
Select * from Invoice where BILLINGADDRESS like 'T%';

-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
Select * from Invoice where TOTAL between 15 and 50;
-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
Select * from Employee where HIREDATE between '1-JUN-03' and '1-MAR-04';


-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE Invoice DROP CONSTRAINT FK_INVOICECUSTOMERID;
delete from Customer where FIRSTNAME='Robert' and LASTNAME='Walter';

-- 3.0	SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
-- shows all user defined functions
SELECT * FROM ALL_OBJECTS WHERE OBJECT_TYPE IN ('FUNCTION','PROCEDURE','PACKAGE') and owner='CHINOOK';

-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.
Create or replace Function GetTheTime 
return timestamp as
Begin
     return current_timestamp;
end;
/

select getthetime from dual;



-- Task – create a function that returns the length of a mediatype from the mediatype table
Create or replace Function GetMediaLength 
return number as mt_num number;
Begin
     SELECT LENGTH(name) INTO mt_num from mediatype where mediatypeid = 1;
     return mt_num;
end;
/
select GetMediaLength from dual;
-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices
select avg(total)from INVOICE;
-- Task – Create a function that returns the most expensive track
SELECT name FROM track WHERE unitprice = 
    (SELECT MAX(unitprice) FROM track);
-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
select * from invoiceline;
create or replace function average_invoice_line
return number as inv_num number;
Begin
     Select avg(unitprice) into inv_num from invoiceline;
     return inv_num;
end;
/
select average_invoice_line from dual;


-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
-- drop type employee_obj;
-- drop type employee_tab;
-- Have to create objects and tables to store the table in
create type employee_obj is object (employeeid number, firstname varchar2(20), birth_date date);
create type employee_tab is table of employee_obj;

create or replace function get_young_employees return employee_tab
    is 
        emp_tab employee_tab := employee_tab();
        n integer := 0;
    Begin
        for r in (select * from employee where birthdate>='01-JAN-68')
        loop 
          emp_tab.extend;
            n := n+1;
     emp_tab(n) := employee_obj(r.employeeid, r.firstname, r.birthdate);
    end loop;
    return emp_tab;
end;
/
select * from table (get_young_employees);


--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_names
AS
n SYS_REFCURSOR;
BEGIN
   OPEN n FOR
   SELECT firstname, lastname FROM employee;
   dbms_sql.return_result(n);
END;
/
EXECUTE get_names;
-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_names ( 
A_EMPLOYEEID in NUMBER,
NEWLASTNAME in VARCHAR2,
NEWFIRSTNAME in VARCHAR2,
NEWTITLE in VARCHAR2,
NEWREPORTSTO in NUMBER,
NEWBIRTHDATE in DATE,
NEWHIREDATE in DATE,
NEWADDRESS in VARCHAR2,
NEWCITY in VARCHAR2,
NEWSTATE in VARCHAR2,
NEWCOUNTRY in VARCHAR2,
NEWPOSTALCODE in VARCHAR2,
NEWPHONE in VARCHAR2,
NEWFAX in VARCHAR2,
NEWEMAIL in VARCHAR2
) as
BEGIN
   update employee set
   lastname = newlastname,
   firstname = newfirstname,
   title = newtitle,
   reportsto = newreportsto,
   birthdate = newbirthdate,
   hiredate = newhiredate,
   address = newaddress,
   city = newcity,
   state = newstate,
   country = newcountry,
   postalcode = newpostalcode,
   phone = newphone,
   email = newemail
   where employeeid=a_employeeid;
END;
/
execute update_names(1,'mylastname', 'myfirstame', 'mytitle', 2, '01-JAN-00', '01-JAN-00', 'myaddress', 'mycity', 'mystate', 'mycountry', 'mypostal', 'myphone','myfax', 'myemail');
-- Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE get_managers 
(
theid in NUMBER
) as
num SYS_REFCURSOR;
BEGIN
   OPEN num FOR
   SELECT firstname from employee where reportsto=
   (SELECT reportsto FROM employee where employeeid=theid);
   dbms_sql.return_result(num);
END;
/
EXECUTE get_managers(2);

-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_name_and_co
(
custid in NUMBER
) as
num SYS_REFCURSOR;
BEGIN
   OPEN num FOR
   SELECT firstname, lastname, company from customer where customerid=custid;
   dbms_sql.return_result(num);
END;
/
EXECUTE get_name_and_co(1);
/
-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID;
ALTER TABLE INVOICELINE ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (invoiceid) REFERENCES Invoice (invoiceid) ON DELETE CASCADE;
       
CREATE OR REPLACE PROCEDURE  DeleteInvoice (Invoice_Id IN INT)
AS
BEGIN
DELETE FROM invoice WHERE invoiceid=invoice_ID;              
END DeleteInvoice;
/
EXECUTE DeleteInvoice(324);

-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE NewRecord (
custid IN number, custfname IN VARCHAR2, custlname IN VARCHAR2, custemail IN VARCHAR2)
AS
BEGIN
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
VALUES (custid, custfname, custlname, custemail);
END;
/
EXECUTE NewRecord(100, 'fname3214','lname2134','email2314');



-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER insert_employee_trigger
AFTER INSERT
ON employee
BEGIN
dbms_output.put_line('Insert employee trigger fired');
END;
/
-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER insert_ablum_trigger
AFTER INSERT
ON album
BEGIN
dbms_output.put_line('Insert album trigger fired');
END;
/
-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER delete_customer_trigger
AFTER DELETE
ON customer
BEGIN
dbms_output.put_line('Delete customer trigger fired');
END;
/

-- 6.2 INSTEAD OF
-- Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.

CREATE OR REPLACE TRIGGER restrict_delete_invoice_50
BEFORE DELETE
ON invoice when (total>50)
BEGIN
dbms_output.put_line('Restrict trigger fired');
END;
/

-- 7.0 JOINS
-- In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT customer.firstname, customer.lastname, invoice.invoiceid 
    FROM customer
    INNER JOIN invoice ON customer.customerid = invoice.customerid;
-- 7.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer
left outer join invoice ON customer.customerid = invoice.customerid;

-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT album.title, artist.name FROM album
RIGHT OUTER JOIN artist ON album.artistid = artist.artistid;

-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM artist, album ORDER BY artist.name;

-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT emp1.firstname, emp1.lastname, emp2.firstname, emp2.lastname
FROM employee emp1, employee emp2
where emp1.reportsto = emp2.employeeid;

-- 8.0 Indexes
-- In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
-- 8.1 Clustered Indexes
-- Task – Create a clustered index on of table of your choice
create table playlist_cluster
(
  playlistid primary key,
  name
)
organization index tablespace users
as select * from playlist;
-- creating an index
CREATE INDEX playlist_ix
   ON playlist_cluster (name);




