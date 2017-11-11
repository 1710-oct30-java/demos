/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER book CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER book
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to book;
GRANT resource to book;
GRANT create session TO book;
GRANT create table TO book;
GRANT create view TO book;



conn book/p4ssw0rd


/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE book
(
    isbn NUMBER(13) PRIMARY KEY,
    title VARCHAR2(160) NOT NULL UNIQUE,
    author_id INT NOT NULL,
    price NUMBER(6,2) NOT NULL CHECK(price >= 0)
);

CREATE TABLE author
(
    author_id INT PRIMARY KEY,
    firstname VARCHAR2(50) NOT NULL,
    lastname VARCHAR2(50) NOT NULL,
    address_id NUMBER(20)
);

CREATE TABLE Customer
(
    customer_id NUMBER NOT NULL,
    FirstName VARCHAR2(40) NOT NULL,
    LastName VARCHAR2(20) NOT NULL,
    Company VARCHAR2(80),
    address_id NUMBER(20),
    Phone VARCHAR2(24),
    Fax VARCHAR2(24),
    Email VARCHAR2(60) NOT NULL,
    SupportRepId NUMBER,
    CONSTRAINT PK_Customer PRIMARY KEY  (customer_id)
);

CREATE TABLE address
(
    address_id NUMBER(20) PRIMARY KEY,
    street VARCHAR2(50) NOT NULL,
    zip_id NUMBER(5) NOT NULL
);

CREATE TABLE zip
(
    zip_id NUMBER(5) PRIMARY KEY,
    city VARCHAR2(25),
    state VARCHAR2(15),
    country VARCHAR2(25)
);

CREATE TABLE purchases
(
    purchase_id NUMBER(20) PRIMARY KEY,
    customer_id INT NOT NULL,
    isbn NUMBER(13) NOT NULL,
    total NUMBER(7,2) NOT NULL
);




/*******************************************************************************
   Create Primary Key Unique Indexes
********************************************************************************/

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE book ADD CONSTRAINT fk_book_author
    FOREIGN KEY (author_id) REFERENCES author (author_id);
    
ALTER TABLE author ADD CONSTRAINT fk_author_address
    FOREIGN KEY (address_id) REFERENCES address (address_id);
    
ALTER TABLE purchases ADD CONSTRAINT fk_purchase_cust
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id);

ALTER TABLE purchases ADD CONSTRAINT fk_purchase_book
    FOREIGN KEY (isbn) REFERENCES book (isbn);

ALTER TABLE address ADD CONSTRAINT fk_address_zip
    FOREIGN KEY (zip_id) REFERENCES zip (zip_id);
    
ALTER TABLE customer ADD CONSTRAINT fk_customer_address
    FOREIGN KEY (address_id) REFERENCES address (address_id);
    
    
/*******************************************************************************
   Triggers and Sequences
********************************************************************************/

create sequence book_seq;
create sequence author_seq;
create sequence customer_seq;
create sequence purchases_seq;
create sequence address_seq;
create sequence zip_seq;

create or replace trigger book_pk_trig
before insert or update on book
for each row
begin
    if INSERTING then
        select book_seq.nextVal into :new.isbn from dual;
    elsif UPDATING then
        select :old.isbn into :new.isbn from dual;
    end if;
end;
/

create or replace trigger author_pk_trig
before insert or update on author
for each row
begin
    if INSERTING then
        select author_seq.nextVal into :new.author_id from dual;
    elsif UPDATING then
        select :old.author_id into :new.author_id from dual;
    end if;
end;
/

create or replace trigger customer_pk_trig
before insert or update on custome
for each row
begin
    if INSERTING then
        select customer_seq.nextVal into :new.customer_id from dual;
    elsif UPDATING then
        select :old.customer_id into :new.customer_id from dual;
    end if;
end;
/


/****************************************************
    Stored Procedures
******************************************************/
create or replace procedure insert_book
(var_title IN VARCHAR2, author_id IN INT, price IN NUMBER, generated_id OUT sys_refcursor)
as -- or is
begin
    INSERT INTO book (title, author_id, price) VALUES (var_title, author_id, price);
    OPEN generated_id FOR SELECT * FROM book WHERE book.title = var_title;
end insert_book;

/*************************************************************
    Functions
**************************************************************/
create or replace function calculateTax
(book_id IN NUMBER, tax_rate IN NUMBER)
return number
as
book_price NUMBER;
begin
    select price into book_price from book where isbn = book_id;
    return book_price*tax_rate;
end;
/


INSERT INTO author (firstname, lastname) VALUES ('Mark', 'Twain');
INSERT INTO author (firstname, lastname) VALUES ('George', 'RR Martin');

INSERT INTO book (title, author_id, price) VALUES ('Adventures of Hucklebery Fin', 1, 20.00);

/*******************************
    Calling Functions and Stored Procedures
*********************************/
set serveroutput on;
declare 
    gen_rows sys_refcursor;
    isbn NUMBER;
    title VARCHAR2(256);
    author_id INT;
    price NUMBER;
begin
    insert_book('Song of Ice and Fire',2, 50, gen_rows);
    LOOP
        FETCH gen_rows INTO isbn, title, author_id, price;
        exit when gen_rows%NOTFOUND;
        dbms_output.put_line(isbn || ':' || title || ':' || author_id || ':' || price); 
    end LOOP;
end;
/

select calculateTax(18, .07) from dual;
        
