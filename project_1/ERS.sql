/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER ers CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER ers
IDENTIFIED BY password
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;
GRANT connect to ers;
GRANT resource to ers;
GRANT create session TO ers;
GRANT create table TO ers;
GRANT create view TO ers;

conn ers/password


/*******************************************************************************
   Create Tables
********************************************************************************/
-- Create table Users
CREATE TABLE USERS
(
	user_id NUMBER PRIMARY KEY NOT NULL,
    username VARCHAR2(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    firstname VARCHAR2(100) NOT NULL,
    lastname VARCHAR2(100) NOT NULL,
    email VARCHAR2(150) NOT NULL,
    role_id NUMBER NOT NULL
);


-- Create table USER_ROLES
CREATE TABLE USER_ROLES
(
    role_id NUMBER PRIMARY KEY NOT NULL,
    user_role VARCHAR2(10)
);


-- Create table REIMBURSEMENT_TYPE
CREATE TABLE REIMBURSEMENT_TYPE
(
    r_type_id NUMBER PRIMARY KEY NOT NULL,
    r_type VARCHAR2(10)
);


-- Create table Reimbursement_Status
CREATE TABLE REIMBURSEMENT_STATUS
(
    r_status_id NUMBER PRIMARY KEY NOT NULL,
    r_status VARCHAR2(10)
);

-- Create table Reimbursement
CREATE TABLE Reimbursement
(
    r_id NUMBER PRIMARY KEY NOT NULL,
    r_amount NUMBER NOT NULL,
    r_submitted TIMESTAMP NOT NULL,
    r_resolved TIMESTAMP,
    r_description VARCHAR2(250),
    r_receipt BLOB,
    r_author NUMBER NOT NULL,
    r_resolver NUMBER,
    r_status_id NUMBER NOT NULL,
    r_type_id NUMBER NOT NULL
);


/*******************************************************************************
   Create Primary Key Unique Indexes
********************************************************************************/
-- Add UNIQUE conastraints to table USERS
--ALTER TABLE USERS
--ADD CONSTRAINT email_username_unique UNIQUE (email, username);

ALTER TABLE USERS
ADD CONSTRAINT unique_email UNIQUE (email);

ALTER TABLE USERS
ADD CONSTRAINT unique_username UNIQUE (username);


/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE USERS
ADD CONSTRAINT fk_role_id
FOREIGN KEY (role_id) REFERENCES USER_ROLES (role_id) ON DELETE CASCADE;

-- Add FOREIGN constraints to table REIMBURSEMENT
ALTER TABLE REIMBURSEMENT
ADD CONSTRAINT fk_author_user_id
FOREIGN KEY (r_author) REFERENCES USERS (user_id) ON DELETE CASCADE;

ALTER TABLE REIMBURSEMENT
ADD CONSTRAINT fk_resolver_role_id
FOREIGN KEY (r_resolver) REFERENCES USERS (user_id) ON DELETE CASCADE;

ALTER TABLE REIMBURSEMENT
ADD CONSTRAINT fk_status_id
FOREIGN KEY (r_status_id) REFERENCES REIMBURSEMENT_STATUS (r_status_id) ON DELETE CASCADE;

ALTER TABLE REIMBURSEMENT
ADD CONSTRAINT fk_type_id
FOREIGN KEY (r_type_id) REFERENCES REIMBURSEMENT_TYPE (r_type_id) ON DELETE CASCADE;


/*******************************************************************************
   Create Sequence
********************************************************************************/
CREATE SEQUENCE seq_users
MINVALUE 100000
START WITH 100000
INCREMENT BY 1;

CREATE SEQUENCE seq_reimbursement
MINVALUE 1000000
START WITH 1000000
INCREMENT BY 1;


/*******************************************************************************
   Create Triggers
********************************************************************************/
CREATE OR REPLACE TRIGGER trg_users_pk_incr
BEFORE INSERT OR UPDATE ON USERS
FOR EACH ROW
BEGIN
    IF INSERTING THEN
        SELECT seq_users.nextVal INTO :new.user_id FROM dual;
        
        -- hash password if inserting
        SELECT STANDARD_HASH(:new.password, 'SHA256') INTO :new.password FROM dual;
        
    ELSIF UPDATING THEN
        SELECT :old.user_id INTO :new.user_id FROM dual;
        
        -- hash password if updating
        SELECT STANDARD_HASH(:new.password, 'SHA256') INTO :new.password FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER trg_reimbursement_pk_incr
BEFORE INSERT OR UPDATE ON REIMBURSEMENT
FOR EACH ROW
BEGIN
    IF INSERTING THEN
        SELECT seq_reimbursement.nextVal INTO :new.r_id FROM dual;
    ELSIF UPDATING THEN
        SELECT :old.r_id INTO :new.r_id FROM dual;
    END IF;
END;
/


/*******************************************************************************
   Create Stored Procedures
********************************************************************************/
-- Stored procedure tp update user information
CREATE OR REPLACE PROCEDURE updateUser
(
    u_user_id IN users.user_id%TYPE,
    u_username IN users.username%TYPE,
    u_password IN users.password%TYPE,
    u_firstname IN users.firstname%TYPE,
    u_lastname IN users.lastname%TYPE,
    u_email IN users.email%TYPE,
    u_role_id IN users.role_id%TYPE
)
IS
BEGIN
    
    -- updates employee but doesn't change column value if input is empty
    UPDATE users SET
    username = NVL(u_username, (SELECT username FROM users WHERE user_id = u_user_id)),
    password = NVL(u_password, (SELECT password FROM users WHERE user_id = u_user_id)),
    firstname = NVL(u_firstname, (SELECT firstname FROM users WHERE user_id = u_user_id)),
    lastname = NVL(u_lastname, (SELECT lastname FROM users WHERE user_id = u_user_id)),
    email = NVL(u_email, (SELECT email FROM users WHERE user_id = u_user_id)),
    role_id = NVL(u_role_id, (SELECT role_id FROM users WHERE user_id = u_user_id))
    WHERE user_id = u_user_id;
    
    COMMIT;

END;
/


-- Stored procedure to update reimbursement upon approval or denial
CREATE OR REPLACE PROCEDURE updateReimbursement
(
    rr_id IN reimbursement.r_id%TYPE,
    rr_resolved IN reimbursement.r_resolved%TYPE,
    rr_resolver IN reimbursement.r_resolver%TYPE,
    rr_status_id IN reimbursement.r_status_id%TYPE
)
IS
BEGIN
    
    -- updates only the resolved date(approval), resolver(approver), and status
    UPDATE reimbursement SET
    r_resolved = NVL((SELECT CURRENT_TIMESTAMP FROM dual), (SELECT r_resolved FROM reimbursement WHERE r_id = rr_id)),
    r_resolver = NVL(rr_resolver, (SELECT r_resolver FROM reimbursement WHERE r_id = rr_id)),
    r_status_id = NVL(rr_status_id, (SELECT r_status_id FROM reimbursement WHERE r_id = rr_id))
    WHERE r_id = rr_id;
    
    COMMIT;

END;
/


/*******************************************************************************
   Insert Data to tables
********************************************************************************/
-- INITIAL DATA PROVIDED
INSERT INTO USER_ROLES (role_id, user_role)
VALUES (1, 'Manager');

INSERT INTO USER_ROLES (role_id, user_role)
VALUES (2, 'Employee');

INSERT INTO REIMBURSEMENT_STATUS (r_status_id, r_status)
VALUES (1, 'Pending');

INSERT INTO REIMBURSEMENT_STATUS (r_status_id, r_status)
VALUES (2, 'Approved');

INSERT INTO REIMBURSEMENT_STATUS (r_status_id, r_status)
VALUES (3, 'Denied');

INSERT INTO REIMBURSEMENT_TYPE (r_type_id, r_type)
VALUES (1, 'Lodging');

INSERT INTO REIMBURSEMENT_TYPE (r_type_id, r_type)
VALUES (2, 'Travel');

INSERT INTO REIMBURSEMENT_TYPE (r_type_id, r_type)
VALUES (3, 'Food');

INSERT INTO REIMBURSEMENT_TYPE (r_type_id, r_type)
VALUES (4, 'Other');

-- SAMPLE DATA
--Users
INSERT INTO USERS(username, password, firstname, lastname, email, role_id)	-- 100000
VALUES('batman', 'batman', 'Bruce', 'Wayne', 'batman@ers.com', 1);

INSERT INTO USERS(username, password, firstname, lastname, email, role_id) -- 100001
VALUES('edel', 'edel', 'Edel', 'Benavides', 'edel@ers.com', 1);

INSERT INTO USERS(username, password, firstname, lastname, email, role_id) -- 100002
VALUES('palfred', 'palfred', 'Alfred', 'Pennyworth', 'palfred@ers.com', 2);

INSERT INTO USERS(username, password, firstname, lastname, email, role_id) -- 100003
VALUES('wonderwoman', 'wonderwoman', 'Diana', 'Prince', 'wonderwoman@ers.com', 2);

INSERT INTO USERS(username, password, firstname, lastname, email, role_id) -- 100004
VALUES('flash', 'flash', 'Barry', 'Allen', 'flash@ers.com', 2);

INSERT INTO USERS(username, password, firstname, lastname, email, role_id) -- 100005
VALUES('superman', 'superman', 'Clark', 'Kent', 'superman@ers.com', 2);

INSERT INTO USERS(username, password, firstname, lastname, email, role_id) -- 100006
VALUES('arrow', 'arrow', 'Olvier', 'Queen', 'arrow@ers.com', 2);

--Reimbursement
INSERT INTO REIMBURSEMENT(r_amount, r_submitted, r_author, r_status_id, r_type_id)
VALUES (250, (SELECT CURRENT_TIMESTAMP FROM dual), 100001, 1, 3);

INSERT INTO REIMBURSEMENT(r_amount, r_submitted, r_author, r_status_id, r_type_id)
VALUES (1000, (SELECT CURRENT_TIMESTAMP FROM dual), 100001, 1, 1);

INSERT INTO REIMBURSEMENT(r_amount, r_submitted, r_author, r_status_id, r_type_id)
VALUES (1500, (SELECT CURRENT_TIMESTAMP FROM dual), 100002, 1, 2);

INSERT INTO REIMBURSEMENT(r_amount, r_submitted, r_author, r_status_id, r_type_id)
VALUES (1250, (SELECT CURRENT_TIMESTAMP FROM dual), 100002, 1, 1);

INSERT INTO REIMBURSEMENT(r_amount, r_submitted, r_author, r_status_id, r_type_id)
VALUES (3000, (SELECT CURRENT_TIMESTAMP FROM dual), 100003, 1, 3);

INSERT INTO REIMBURSEMENT(r_amount, r_submitted, r_author, r_status_id, r_type_id)
VALUES (2151.78, (SELECT CURRENT_TIMESTAMP FROM dual), 100003, 1, 4);

INSERT INTO REIMBURSEMENT(r_amount, r_submitted, r_author, r_status_id, r_type_id)
VALUES (100.03, (SELECT CURRENT_TIMESTAMP FROM dual), 100000, 1, 3);

INSERT INTO REIMBURSEMENT(r_amount, r_submitted, r_author, r_status_id, r_type_id)
VALUES (1251, (SELECT CURRENT_TIMESTAMP FROM dual), 100004, 1, 4);

INSERT INTO REIMBURSEMENT(r_amount, r_submitted, r_author, r_status_id, r_type_id)
VALUES (143.42, (SELECT CURRENT_TIMESTAMP FROM dual), 100001, 1, 4);

INSERT INTO REIMBURSEMENT(r_amount, r_submitted, r_author, r_status_id, r_type_id)
VALUES (33.51, (SELECT CURRENT_TIMESTAMP FROM dual), 100000, 1, 4);

COMMIT;
/*******************************************************************************
   Show data from tables
********************************************************************************/
--SELECT * FROM USERS;
--SELECT * FROM USER_ROLES;
--SELECT * FROM REIMBURSEMENT;
--SELECT * FROM REIMBURSEMENT_STATUS;
--SELECT * FROM REIMBURSEMENT_TYPE;


/*******************************************************************************
   Sample JOINS
********************************************************************************/
-- Sample inner join where 3 tables are joined together
--SELECT username, firstname, lastname, r_type, r_status FROM REIMBURSEMENT
--INNER JOIN USERS ON REIMBURSEMENT.r_author = USERS.user_id
--INNER JOIN REIMBURSEMENT_TYPE ON REIMBURSEMENT.r_type_id = REIMBURSEMENT_TYPE.r_type_id
--INNER JOIN REIMBURSEMENT_STATUS ON REIMBURSEMENT.r_status_id = REIMBURSEMENT_STATUS.r_status_id
--WHERE REIMBURSEMENT.r_author = 100003;


--SELECT r_id, USERS.username, r_amount, r_submitted, r_resolved, r_description,
--(SELECT username FROM USERS WHERE REIMBURSEMENT.R_RESOLVER = USERS.USER_ID) AS Approved_By,
--(SELECT r_status FROM REIMBURSEMENT_STATUS WHERE r_status_id = REIMBURSEMENT.R_STATUS_ID) AS Status,
--(SELECT r_type FROM REIMBURSEMENT_TYPE WHERE r_type_id = REIMBURSEMENT.R_type_ID) AS Status
--FROM REIMBURSEMENT
--INNER JOIN USERS ON REIMBURSEMENT.r_author = USERS.user_id
--INNER JOIN REIMBURSEMENT_TYPE ON REIMBURSEMENT.r_type_id = REIMBURSEMENT_TYPE.r_type_id
--INNER JOIN REIMBURSEMENT_STATUS ON REIMBURSEMENT.r_status_id = REIMBURSEMENT_STATUS.r_status_id;