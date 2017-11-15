/*Author: Stephen Huelsman*/
/*Assignment 4: SQL*/

/*
1.0 Setting up Oracle Chinook
In this section you will begin the process of working with the Oracle Chinook database
Task – Open the Chinook_Oracle.sql file and execute the scripts within.
2.0 SQL Queries
In this section you will be performing various queries against the Oracle Chinook database.
*/

/*2.1 SELECT*/
--Task – Select all records from the Employee table.
select * from Employee;

--Task – Select all records from the Employee table where last name is King.
select * from Employee 
where LASTNAME = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from Employee
where FIRSTNAME = 'Andrew' AND REPORTSTO is null;


/*2.2 ORDER BY*/
--*Task – Select all albums in Album table and sort result set in descending order by title.
select * from Album
order by title DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
select FIRSTNAME from CUSTOMER
order by City;


/*2.3 INSERT INTO*/
--Task – Insert two new records into Genre table
select * from genre;
insert into genre values (26, 'Dubstep');
insert into genre values (27, 'Swing');
select * from genre;

--Task – Insert two new records into Employee table
select * from employee;
insert into employee (employeeid, lastname, firstname) values (9, 'Kruppa', 'Blake');
insert into employee (employeeid, lastname, firstname) values (10, 'Fay', 'David');

--Task – Insert two new records into Customer table
select * from customer;
insert into customer(customerid, firstname, lastname, email) values(60, 'Stephen', 'Huelsman', 'sjh817@gmail.com');
insert into customer(customerid, firstname, lastname, email) values(61, 'Sara', 'Huelsman', 'sah102@gmail.com');


/*2.4 UPDATE*/
--Task – Update Aaron Mitchell in Customer table to Robert Walter
update customer set firstname = 'Robert', lastname = 'Walter' where customerid = 32; 

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
update artist set name = 'CCR' where name = 'Creedence Clearwater Revival';
select * from artist order by name;


/*2.5 LIKE*/
--Task – Select all invoices with a billing address like “T%”
select * from invoice where billingaddress like 'T%';


/*2.6 BETWEEN*/
--Task – Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hiredate between '01-JUN-03' and '01-MAR-04';


/*2.7 DELETE*/
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
select * from customer where firstname = 'Robert';

alter table invoice drop constraint fk_invoicecustomerid;
alter table invoiceline drop constraint fk_invoicelineinvoiceid;
delete from customer where firstname = 'Robert' and lastname = 'Walter';
select * from customer where firstname = 'Robert';

rollback;
/*delete from invoiceline where invoiceid = 
    (select invoiceid from invoice where customerid = 
        (select customerid from customer where firstname = 'Robert' and lastname = 'Walter'));

delete from invoice where customerid = 
    (select customerid from customer where firstname = 'Robert' and lastname = 'Walter');
delete from customer where firstname = 'Robert' and lastname = 'Walter';
*/
/*3.0 SQL Functions
In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database*/

/*3.1 System Defined Functions*/
--Task – Create a function that returns the current time.
create or replace function calcTime 
return timestamp
as
currTime timestamp;
begin
    select current_timestamp into currTime from dual;
    return currTime;
end;
/
select calcTime from dual;

--Task – create a function that returns the length of a mediatype from the mediatype table
create or replace function mediaLength
(mediaid in NUMBER)
return number
as
mLength number;
begin
    select length(mediatype.name) into mLength from mediatype where mediatype.mediatypeid = mediaid;
    return mLength;
end;
/
select mediaLength(1) from dual;
select length(mediatype.name) from mediatype where mediatype.mediatypeid = 1;


/*3.2 System Defined Aggregate Functions*/
--Task – Create a function that returns the average total of all invoices
create or replace function invoiceTotal
return number
as
inTotal number;
begin
    select avg(total) into inTotal from invoice;
    return inTotal;
end;
/
select invoiceTotal from dual;

--Task – Create a function that returns the most expensive track
create or replace function mostExTrack
return number
as
expensiveTrack number;
begin
    select max(unitprice) into expensiveTrack from track;
    return expensiveTrack;
end;
/
select mostExTrack from dual;


/*3.3 User Defined Scalar Functions*/
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function invoiceAVG
return number
as
priceAVG number;
begin
    select avg(unitprice) into priceAVG from invoiceline;
    return priceAVG;
end;
/

select invoiceAVG from dual;


/*3.4 User Defined Table Valued Functions*/
--Task – Create a function that returns all employees who are born after 1968.
create or replace function empBorn
return SYS_REFCURSOR
as 
output SYS_REFCURSOR;
begin 
    open output for select * from employee where birthdate > '31-DEC-68';
end;
/


/*4.0 Stored Procedures
 In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.*/

/*4.1 Basic Stored Procedure*/
--Task – Create a stored procedure that selects the first and last names of all the employees.
create or replace procedure fullName 
(output out SYS_REFCURSOR) 
as 
begin 
    open output for select firstname, lastname from employee;
end;
/


/*4.2 Stored Procedure Input Parameters*/
--Task – Create a stored procedure that updates the personal information of an employee.
create or replace procedure updateInfo
(newfirst in VARCHAR2, newlast in VARCHAR2, empid in NUMBER)
as
begin
    update employee set firstname = newfirst, lastname = newlast where employeeid = empid;
end;
/

call updateInfo('Smith', 'Will', 1);
select * from employee;

--Task – Create a stored procedure that returns the managers of an employee.
create or replace procedure findManager
(empid in NUMBER, manager out VARCHAR2)
as
begin
    select employee.reportsto into manager from employee where employeeid = empid;
end;
/


/*4.3 Stored Procedure Output Parameters*/
--Task – Create a stored procedure that returns the name and company of a customer.
create or replace procedure custInfo
(custid in NUMBER, custFName out VARCHAR2, custLNAME out VARCHAR2, custComp out VARCHAR2)
as
begin
    select customer.firstname into custFNAME from customer where custid = customerid;
    select customer.lastname into custLNAME from customer where custid = customerid;
    select customer.company into custComp from customer where custid = customerid;
end;
/


/*5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.*/
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
create or replace procedure removeInvoice(removedid IN NUMBER)
as
begin
    --alter table invoice drop constraint fk_invoicecustomerid;
    --alter table invoiceline drop constraint fk_invoicelineinvoiceid;
    delete from invoiceline where invoiceid = removedid;
    delete from invoice where invoiceid = removedid;
    commit;
end;
/

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
select * from customer;
create or replace procedure newCustomer(newid IN NUMBER, newFNAME IN VARCHAR2, 
newLNAME IN VARCHAR2, newComp IN VARCHAR2, newEmail IN VARCHAR2)
as
begin
    insert into customer (customerid, firstname, lastname, company, email) 
    values (newid, newFNAME, newLNAME, newComp, newEmail);
    commit;
end;
/

/*6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.*/

/*6.1 AFTER/FOR*/
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger emp_insert_trig
after insert on employee
for each row
begin
    update employee set reportsto = 1 where employeeid = :new.employeeid;
end;
/
select * from album;
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger alb_insert_trig
after insert on album
for each row
begin
    update album set title = 'just released' + title where albumid = :new.albumid;
end;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace trigger cust_delete_trig
after delete on customer
for each row
begin
    dbms_output.put_line('good riddance');
end;
/

/*6.2 INSTEAD OF*/
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
create view invoiceView as select * from invoice;
create or replace trigger inv_delete_trig
instead of delete on invoiceView
for each row
    begin
        if(50 >= :old.total) then
            delete from invoice where invoiceid = :old.invoiceid;
        end if;
    end;
/


/*7.0 JOINS
In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.*/

/*7.1 INNER*/
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select firstname, lastname, invoiceid 
from customer 
inner join invoice 
on customer.customerid = invoice.customerid; 

/*7.2 OUTER*/
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select customer.customerid, firstname, lastname, invoiceid, total 
from customer 
full outer join invoice 
on customer.customerid = invoice.customerid; 

/*7.3 RIGHT*/
--Task – Create a right join that joins album and artist specifying artist name and title.
select name, title
from artist
right join album
on artist.ARTISTID = album.ARTISTID;

/*7.4 CROSS*/
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select *
from artist
cross join album
order by name asc;

/*7.5 SELF*/
--Task – Perform a self-join on the employee table, joining on the reportsto column.
select a.REPORTSTO, b.REPORTSTO
from employee a, employee b;


/*8.0 Indexes
In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
8.1 Clustered Indexes
Task – Create a clustered index on of table of your choice
*/

create index newIndex on track (unitprice, name);

/*class examples*/
SELECT * From Album;
SELECT title, artistid from album;
select * from customer;
/*case sensitivity is irrelevant*/

select * from album where artistid = 5;

select * from invoiceline;
delete from invoiceline where trackid = 3;

select * from employee;
update Employee set phone = '1111111' where employeeid = 1;

select * from artist where name like 'A%';

insert into employee (employeeid, lastname, firstname) values (9, 'Kruppa', 'Blake');

create view artists_track_start_b as
select * from artist 
    where artistid in (select artistid from album
        where albumid in (select albumid from track where name like 'B%'));
        
select * from artists_track_start_b where name like 'T%';
        
select upper(name) from artist;
select lower(name) from artist;
select max(length(name)) from artist;
select name from artist where length(name) = 85;

select name from artist where artistid in( 
    select artistid 
        from album 
        where upper(title) like 'A%'
        group by artistid 
        having count(artistid)>= 2)
order by name;

/*rollback undos updates and deletions as long as they were not committed*/
rollback;

select * from artist art inner join album alb on (art.artistid = alb.artistid)
order by art.name;

/*if the columns name are the EXACT SAME then you can shorthand it*/
select * from artist art inner join album alb using (artistid)
order by art.name;

--find all artists with an album title that is their name
select * from artist art inner join album alb on (art.name = alb.title)
order by art.name;

select * from artist art left outer join album alb on (art.name = alb.title)
order by art.name;

select * from artist art full outer join album alb on (art.name = alb.title) order by art.name;

--determines what to join based on column names, will have problems when multiple columns in both tables have exact same names
select * from artist art natural join album order by art.name;

select * from artist, album order by artist.name;
select * from artist cross join album order by artist.name;

select * from
    track t inner join
        (select * from
            artist art inner join album alb
                on (art.artistid = alb.artistid)
        ) a
        using (albumid);
        
