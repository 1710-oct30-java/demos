-- Create table Users
CREATE TABLE USERS
(
	user_id NUMBER PRIMARY KEY NOT NULL,
    username VARCHAR2(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
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
    status_id NUMBER PRIMARY KEY NOT NULL,
    status VARCHAR2(10)
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


-- Add conastraints to table USERS
ALTER TABLE USERS
ADD CONSTRAINT email_username_unique UNIQUE (email, username);

ALTER TABLE USERS
ADD CONSTRAINT fk_role_id
FOREIGN KEY (role_id) REFERENCES USER_ROLES (role_id) ON DELETE CASCADE;

-- Add constraints to table REIMBURSEMENT
ALTER TABLE REIMBURSEMENT
ADD CONSTRAINT fk_author_user_id
FOREIGN KEY (r_author) REFERENCES USERS (user_id) ON DELETE CASCADE;

ALTER TABLE REIMBURSEMENT
ADD CONSTRAINT fk_resolver_role_id
FOREIGN KEY (r_resolver) REFERENCES USERS (user_id) ON DELETE CASCADE;

ALTER TABLE REIMBURSEMENT
ADD CONSTRAINT fk_status_id
FOREIGN KEY (r_status_id) REFERENCES REIMBURSEMENT_STATUS (status_id) ON DELETE CASCADE;

ALTER TABLE REIMBURSEMENT
ADD CONSTRAINT fk_type_id
FOREIGN KEY (r_type_id) REFERENCES REIMBURSEMENT_TYPE (r_type_id) ON DELETE CASCADE;
