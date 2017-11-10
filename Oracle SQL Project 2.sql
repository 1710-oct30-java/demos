--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM employee;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM employee e WHERE e.lastname = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee e WHERE e. firstname = 'Andrew' AND e.reportsto IS NULL;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album a ORDER BY a.title;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT  c.firstname FROM customer c ORDER BY c.city;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
--SELECT MAX(genreid) FROM genre;
INSERT INTO genre (genreid, name) VALUES (26, 'Dub Step');
INSERT INTO genre (genreid, name) VALUES (27, 'Spoken Word');
--Task – Insert two new records into Employee table
--SELECT MAX(employeeid) FROM employee;
--SELECT * FROM employee ORDER BY employeeid;
INSERT INTO employee (employeeid, lastname,  firstname) VALUES (9, 'ONE', 'NO');
INSERT INTO employee (employeeid, lastname,  firstname, title, reportsto, firthdate, hiredate, address, city, state, posalcode, country, phone, email) VALUES (10, 'Brown', 'John', 'Lead Software Developer', 9, TO_DATE('1979-08-08', 'YYYY-MM-DD'), TO_DATE('2017-10-30', 'YYYY-MM-DD'), '270 Lazy Hollow Lane', 'Covington', 'GA', '30016', 'USA', '(404) 317-2257', 'john.w.brown.jr@gmail.com');
--Task – Insert two new records into Customer table
--SELECT MAX(  customerid) FROM  customer;
--SELECT * FROM  customer ORDER BY   customerid DESC;
INSERT INTO  customer (  customerid, lastname,  firstname, email) VALUES (60, 'Dupont', 'Joseph', 'jdupont@dupont.com');
INSERT INTO  customer (  customerid, lastname,  firstname, email) VALUES (61, 'Rockefeller', 'David', 'drockefeller@bbg.com');
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
--SELECT * FROM  customer C WHERE C.lastname = 'Mitchell';
UPDATE  customer c SET c.lastname = 'Walter', c.firstname = 'Robert' WHERE c.lastname = 'Mitchell' AND c.firstname = 'Aaron';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
--SELECT * FROM ARTIST A WHERE A.name = 'Creedence Clearwater Revival';
UPDATE artist a SET a.name = 'CCR' WHERE a.name = 'Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice i WHERE i.billingaddress LIKE 'T%' ORDER BY i.billingaddress;
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice i WHERE i.total BETWEEN 15 AND 50 ORDER BY i.total;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee e WHERE e.hiredate BETWEEN TO_DATE('2003-06-01', 'YYYY-MM-DD') AND TO_DATE('2004-03-01', 'YYYY-MM-DD') ORDER BY e.hiredate;
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
-- SubTask(1 0f 3): delete InvoiceLine table entries
DELETE FROM invoiceline il WHERE il.invoicelineid IN (
    SELECT 
        il.invoicelineid 
    FROM 
        customer c
        INNER JOIN invoice i ON (i.customerid = c.customerid)
        INNER JOIN invoiceline il ON (il.invoiceid = i.invoiceid)
    WHERE 
        c.lastname = 'Walter' AND 
        c.firstname = 'Robert'
);
-- SubTask(2 of 3): delete Invoice table entries
DELETE FROM invoice i WHERE i.invoiceid IN (
    SELECT 
        i.invoiceid
    FROM 
        customer c
        INNER JOIN invoice i ON (i.customerid = c.customerid)
    WHERE 
        c.lastname = 'Walter' AND 
        c.firstname = 'Robert'
);
-- SubTask(3 of 3): delete Customer table entries
DELETE FROM  customer c WHERE c.lastname = 'Walter' AND  c.firstname = 'Robert';




--SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_current_time
    RETURN TIMESTAMP
AS
    ctime TIMESTAMP;
BEGIN
    SELECT SYSTIMESTAMP INTO ctime FROM DUAL;
    RETURN ctime;
END get_current_time;
/

SELECT get_current_time() AS now FROM DUAL;

--Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_char_len( val IN VARCHAR2)
    RETURN NUMBER
AS
    len NUMBER;
BEGIN
    SELECT LENGTH(val) INTO len FROM DUAL;
    RETURN len;
END get_char_len;
/

SELECT 
    get_char_len(m.name) AS characters,
    m.name
FROM
    mediatype m
ORDER BY
    m.name;
    
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION get_invoice_avg
    RETURN NUMBER
AS
    mean NUMBER;
BEGIN
    SELECT
        AVG(i.total) INTO mean
    FROM
        invoice i;
        
    RETURN mean;
        
END get_invoice_avg;
/

SELECT get_invoice_avg() AS mean_invoice_total FROM DUAL;

--Task – Create a function that returns the most expensive track
CREATE OR REPLACE TYPE track_record
AS OBJECT
(
   trackId          NUMBER,
   name             VARCHAR2(200),
   albumid          NUMBER,
   mediaTypeId      NUMBER,
   genreId          NUMBER,
   composer         VARCHAR2(220),
   milliseconds     NUMBER,
   bytes            NUMBER,
   unitPrice        NUMBER(10, 2)
);
/

CREATE OR REPLACE TYPE track_table
AS TABLE OF track_record;
/

CREATE OR REPLACE FUNCTION get_most_expensive_tracks
RETURN track_table
PIPELINED
AS
BEGIN
    FOR results IN ( 
        SELECT 
            * 
        FROM 
            track t 
        WHERE t.unitprice = ( SELECT MAX(unitprice) FROM track )
    ) 
    LOOP
      PIPE ROW ( track_record(
        results.trackid,
        results.name,
        results.albumid,
        results.mediatypeid,
        results.genreid,
        results.composer,
        results.milliseconds,
        results.bytes,
        results.unitprice
      ));
    END LOOP;
    RETURN;
END get_most_expensive_tracks;
/

SELECT * FROM TABLE( get_most_expensive_tracks() );

--3.3 User Defined Scalar Functions 
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_invoice_price
    RETURN NUMBER
AS
    mean NUMBER;
BEGIN
   SELECT AVG( i.unitprice) INTO mean FROM invoiceline i;
   RETURN mean;
END avg_invoice_price;
/

SELECT avg_invoice_price() FROM DUAL;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE TYPE employee_record
AS OBJECT
(
   employeeId       NUMBER,
   lastName         VARCHAR2(20),
   firstName        VARCHAR2(20),
   title            VARCHAR2(30),
   reportsTo        NUMBER,
   birthDate        DATE,
   hireDate         DATE,
   address          VARCHAR2(70),
   city             VARCHAR2(40),
   state            VARCHAR2(40),
   country          VARCHAR2(40),
   postalCode       VARCHAR2(10),
   phone            VARCHAR2(24),
   fax              VARCHAR2(24),
   email            VARCHAR2(60)
);
/

CREATE OR REPLACE TYPE employee_table
AS TABLE OF employee_record;
/

CREATE OR REPLACE FUNCTION get_employees_born_after_68
RETURN employee_table
PIPELINED
AS
BEGIN
    FOR results IN ( SELECT * FROM employee e WHERE TO_CHAR(e.birthdate, 'YYYY') >= '1968' ) 
    LOOP
      PIPE ROW ( employee_record(
        results.employeeid,
        results.lastname,
        results.firstname,
        results.title,
        results.reportsto,
        results.birthdate,
        results.hiredate,
        results.address,
        results.city,
        results.state,
        results.country,
        results.postalcode,
        results.phone,
        results.fax,
        results.email
      ));
    END LOOP;
    RETURN;
END get_employees_born_after_68;
/

SELECT * FROM TABLE( get_employees_born_after_68() );




--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_names ( results OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN results FOR SELECT e.firstname, e.lastname FROM employee e ORDER BY firstname, lastname;
END;
/


--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee
    (
        id IN NUMBER, 
        lastName IN VARCHAR2, 
        firstName IN VARCHAR2, 
        title IN VARCHAR2,
        reportsTo IN NUMBER,
        birthDate IN DATE,
        hireDate IN DATE,
        address IN VARCHAR2,
        city IN VARCHAR2,
        state IN VARCHAR2,
        country IN VARCHAR2,
        zip IN VARCHAR2,
        phone IN VARCHAR2,
        fax IN VARCHAR2,
        email IN VARCHAR2
    )
AS
BEGIN
    UPDATE
        employee e
    SET
        e.lastname = lastName,
        e.firstname = firstName,
        e.title = title,
        e.reportsto = reportsTo,
        e.birthdate = birthDate,
        e.hiredate = hireDate,
        e.address = address,
        e.city = city,
        e.state = state,
        e.country = country,
        e.postalcode = zip,
        e.phone = phone,
        e.fax = fax,
        e.email = email
    WHERE
        e.employeeid = id;
END;
/

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE get_manager( id IN NUMBER, results OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN results FOR 
        SELECT 
            * 
        FROM 
            employee manager 
        WHERE 
            manager.employeeid IN ( SELECT e.reportsto FROM employee e WHERE e.employeeid = id);   
END;
/
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_name_company( id IN NUMBER, name OUT VARCHAR2, company OUT VARCHAR2)
AS
BEGIN
    SELECT
        c.lastname || ', ' || c.firstname,
        c.company
    INTO
        name,
        company
    FROM
        customer c
    WHERE
        c.customerid = id;
END;
/



--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM invoiceline il WHERE il.invoiceid = (SELECT MAX(i.invoiceid) FROM invoice i);
DELETE FROM invoice i WHERE i.invoiceid = (SELECT MAX(i.invoiceid) FROM invoice i);
COMMIT;


--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insert_customer
    ( 
        p_customerid IN NUMBER, 
        p_firstname IN VARCHAR2, 
        p_lastname IN VARCHAR2,
        p_company IN VARCHAR2,
        p_address IN VARCHAR2,
        p_city IN VARCHAR2,
        p_state IN VARCHAR2,
        p_country IN VARCHAR2,
        p_postalcode IN VARCHAR2,
        p_phone IN VARCHAR2,
        p_fax IN VARCHAR2,
        p_email IN VARCHAR2,
        p_supportrepid IN NUMBER
    )
AS
BEGIN
    INSERT INTO customer
    (
        customerid,
        firstname,
        lastname,
        company,
        address,
        city,
        state,
        country,
        postalcode,
        phone,
        fax,
        email,
        supportrepid
    ) VALUES (
        p_customerid,
        p_firstname,
        p_lastname,
        p_company,
        p_address,
        p_city,
        p_state,
        p_country,
        p_postalcode,
        p_phone,
        p_fax,
        p_email,
        p_supportrepid    
    );
    
    COMMIT;
END;
/


--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER employee_insert_after_trig
AFTER INSERT
    ON employee
    FOR EACH ROW
DECLARE
    username VARCHAR2(100);
BEGIN
    SELECT user INTO username FROM DUAL;
END;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_update_after_trig
AFTER UPDATE OR INSERT
    ON album
    FOR EACH ROW
DECLARE
    username VARCHAR2(100);
BEGIN
    SELECT user INTO username FROM DUAL;
END;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_delete_after_trig
AFTER DELETE
    ON customer
    FOR EACH ROW
DECLARE
    username VARCHAR2(100);
BEGIN
    SELECT user INTO username FROM DUAL;
END;
/

--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
--ORA-25002: cannot create INSTEAD OF triggers on tables
--25002. 00000 -  "cannot create INSTEAD OF triggers on tables"
--*Cause:    Only BEFORE or AFTER triggers can be created on a table.
--*Action:   Change the trigger type to BEFORE or AFTER.
CREATE OR REPLACE TRIGGER invoice_delete_trig
BEFORE DELETE ON invoice
FOR EACH ROW
    WHEN ( old.total > 50.00 )
BEGIN
    raise_application_error (-20999, 'you cannot delete invoices with a total over $50.00');
END;
/

INSERT INTO invoice 
    (
        invoiceid, 
        customerid, 
        invoicedate, 
        billingaddress, 
        billingcity,
        billingstate,
        billingcountry,
        billingpostalcode,
        total
    ) SELECT
        999,
        i.customerid,
        i.invoicedate,
        i.billingaddress,
        i.billingcity,
        i.billingstate,
        i.billingcountry,
        i.billingpostalcode,
        60.00
    FROM invoice i
    WHERE i.invoiceid = 279
;
/

INSERT INTO invoice 
    (
        invoiceid, 
        customerid, 
        invoicedate, 
        billingaddress, 
        billingcity,
        billingstate,
        billingcountry,
        billingpostalcode,
        total
    ) SELECT
        998,
        i.customerid,
        i.invoicedate,
        i.billingaddress,
        i.billingcity,
        i.billingstate,
        i.billingcountry,
        i.billingpostalcode,
        40.00
    FROM invoice i
    WHERE i.invoiceid = 279
;
/

SELECT * FROM invoice i WHERE i.total > 50;
DELETE FROM invoice WHERE invoiceid = 999;

-- OR IF YOU INTERPRET AS CREATE A VIEW FIRST

CREATE OR REPLACE VIEW invoice_view
AS SELECT * FROM invoice;

SELECT * FROM invoice_view WHERE invoiceid > 900;

CREATE OR REPLACE TRIGGER invoice_view_delete_trig
    INSTEAD OF DELETE ON invoice_view
    FOR EACH ROW
BEGIN
    IF ( :old.total > 50.00 )
    THEN raise_application_error (-20999, 'you cannot delete invoices with a total over $50.00');
    ELSE 
        DELETE FROM invoice i WHERE i.invoiceid = :old.invoiceid;
    END IF;
END;
/

DELETE FROM invoice_view WHERE invoiceid = 999;
DELETE FROM invoice_view WHERE invoiceid = 998;

--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT
    c.lastname, 
    c.firstname,
    i.invoiceid
FROM
    customer c
    INNER JOIN invoice i ON ( i.customerid = c.customerid)
ORDER BY
    lastname,
    firstname,
    invoiceid
;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT
    c.customerid,
    c.lastname, 
    c.firstname,
    i.invoiceid,
    i.total
FROM
    customer c
    INNER JOIN invoice i ON ( i.customerid = c.customerid)
ORDER BY
    lastname,
    firstname,
    invoiceid
;
    
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT
    ar.name,
    al.title
FROM
    artist ar
    RIGHT JOIN album al ON (al.artistid = ar.artistid)
ORDER BY name, title;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT
    ar.name
FROM
    artist ar,
    album al
ORDER BY name;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT
    e.employeeid,
    e.lastname,
    e.firstname,
    e.title,
    m.lastname || ', ' || m.firstname AS reportsto,
    e.birthdate,
    e.hiredate,
    e.address,
    e.city,
    e.state,
    e.country,
    e.postalcode,
    e.phone,
    e.fax,
    e.email
FROM
    employee e
    INNER JOIN employee m ON (m.employeeid = e.reportsto)
ORDER BY e.lastname, e.firstname;


--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice
CREATE INDEX lookup_invoiceline_ind ON invoiceline( invoiceid, invoicelineid)
    TABLESPACE users
    STORAGE (
        INITIAL 20K
        NEXT 20k
        PCTINCREASE 75
    );
/
