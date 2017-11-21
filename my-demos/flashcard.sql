/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER flashcard CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER flashcard
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to flashcard;
GRANT resource to flashcard;
GRANT create session TO flashcard;
GRANT create table TO flashcard;
GRANT create view TO flashcard;

conn flashcard/p4ssw0rd


/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE flashcard
(
    flashcard_id INT PRIMARY KEY,
    question VARCHAR2(160) NOT NULL,
    answer VARCHAR2(256) NOT NULL,
    user_id INT
);

CREATE TABLE app_user
(
    user_id INT PRIMARY KEY,
    username VARCHAR2(32) UNIQUE NOT NULL,
    password VARCHAR2(32) NOT NULL
);

/*******************************************************************************
   Create Primary Key Unique Indexes
********************************************************************************/

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE flashcard ADD CONSTRAINT FK_FlashCardUserId
    FOREIGN KEY (user_id) REFERENCES app_user (user_id);
    
create sequence flashcard_seq;
create sequence user_seq;

create or replace trigger flashcard_id_trig
before insert or update on flashcard
for each row
begin
    if inserting then 
        select flashcard_seq.nextVal into :new.flashcard_id from dual;
    elsif updating then
        select :old.flashcard_id into :new.flashcard_id from dual;
    end if;
end;
/

create or replace trigger user_id_trig
before insert or update on app_user
for each row
begin
    if inserting then 
        select user_seq.nextVal into :new.user_id from dual;
    elsif updating then
        select :old.user_id into :new.user_id from dual;
    end if;
end;
/


/*********************
    INSERT SOME RECORDS
***************************/

INSERT INTO app_user (username, password) VALUES ('Micah', 'pass');
INSERT INTO app_user (username, password) VALUES ('John H.', 'word');
INSERT INTO app_user (username, password) VALUES ('Pascal', 'pword');

INSERT INTO flashcard (question, answer, user_id) VALUES ('What is JSON', 'JavaScript Object Notation', 1);
INSERT INTO flashcard (question, answer, user_id) VALUES ('What is the DAO', 'DAO is the Data Access Object', 1);
INSERT INTO flashcard (question, answer, user_id) VALUES ('What is a Servlet', 'Java Object for handling requests and responses', 1);
INSERT INTO flashcard (question, answer, user_id) VALUES ('What is a forward', 'When the request is sent internally to another url without the sender being aware of it', 3);
INSERT INTO flashcard (question, answer, user_id) VALUES ('What is JSON', 'JavaScript Object Notation', 3);
INSERT INTO flashcard (question, answer, user_id) VALUES ('What is JSON', 'JavaScript Object Notation', 2);

commit;
