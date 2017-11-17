/*******************************************************************************
   Drop database if it exists
********************************************************************************/
--DROP USER Ers CASCADE;
DROP TABLE ers_reimbursement;
DROP TABLE ers_users;
DROP TABLE ers_reimbursement_status;
DROP TABLE ers_reimbursement_type;
DROP TABLE ers_user_roles;


/*******************************************************************************
   Create database
********************************************************************************/
--CREATE USER Ers
--IDENTIFIED BY p4ssw0rd
--DEFAULT TABLESPACE users
--TEMPORARY TABLESPACE temp
--QUOTA 10M ON users;
--
--GRANT connect to Ers;
--GRANT resource to Ers;
--GRANT create session TO Ers;
--GRANT create table TO Ers;
--GRANT create view TO Ers;
--
--conn Ers/p4ssw0rd


/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE ers_reimbursement
(
    reimb_id NUMBER,
    reimb_amount NUMBER,
    reimb_submitted TIMESTAMP,
    reimb_resolved TIMESTAMP,
    reimb_description VARCHAR2(250),
    reimb_receipt BLOB,
    reimb_author NUMBER,
    reimb_resolver NUMBER,
    reimb_status_id NUMBER,
    reimb_type_id NUMBER,
    CONSTRAINT ers_reimbursement_pk PRIMARY KEY (reimb_id)
);

CREATE TABLE ers_users
(
    ers_users_id NUMBER,
    ers_username VARCHAR2(50) UNIQUE,
    ers_password VARCHAR2(50),
    user_first_name VARCHAR2(100),
    user_last_name VARCHAR2(100),
    user_email VARCHAR2(150) UNIQUE,
    user_role_id NUMBER,
    CONSTRAINT ers_users_pk PRIMARY KEY (ers_users_id)
);

CREATE TABLE ers_reimbursement_status
(
    reimb_status_id NUMBER,
    reimb_status VARCHAR2(10),
    CONSTRAINT reimb_status_pk PRIMARY KEY (reimb_status_id)
);

CREATE TABLE ers_reimbursement_type
(
    reimb_type_id NUMBER,
    reimb_type VARCHAR2(10),
    CONSTRAINT reimb_type_pk PRIMARY KEY (reimb_type_id)
);

CREATE TABLE ers_user_roles
(
    ers_user_role_id NUMBER,
    user_role VARCHAR2(15),
    CONSTRAINT ers_user_roles_pk PRIMARY KEY (ers_user_role_id)
);

/*******************************************************************************
   Create Sequences and Triggers
********************************************************************************/
DROP SEQUENCE ers_reimbursement_seq;
DROP SEQUENCE ers_users_seq;

CREATE SEQUENCE ers_reimbursement_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE ers_users_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER ers_reimbursement_trig
BEFORE INSERT OR UPDATE ON ers_reimbursement
FOR EACH ROW
BEGIN
    IF INSERTING THEN
          SELECT ers_reimbursement_seq.NEXTVAL INTO :new.reimb_id FROM dual;
    ELSIF UPDATING THEN
        SELECT :old.reimb_id INTO :new.reimb_id FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER ers_users_trig
BEFORE INSERT OR UPDATE ON ers_users
FOR EACH ROW
BEGIN
    IF INSERTING THEN
          SELECT ers_users_seq.NEXTVAL INTO :new.ers_users_id FROM dual;
    ELSIF UPDATING THEN
        SELECT :old.ers_users_id INTO :new.ers_users_id FROM dual;
    END IF;
END;
/

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/

-- ers_reimbursement
ALTER TABLE ers_reimbursement ADD CONSTRAINT ers_users_fk_auth
    FOREIGN KEY (reimb_author) REFERENCES ers_users (ers_users_id);

ALTER TABLE ers_reimbursement ADD CONSTRAINT ers_users_fk_reslvr
    FOREIGN KEY (reimb_resolver) REFERENCES ers_users (ers_users_id);

ALTER TABLE ers_reimbursement ADD CONSTRAINT ers_reimbursement_status_fk
    FOREIGN KEY (reimb_status_id) REFERENCES ers_reimbursement_status (reimb_status_id);

ALTER TABLE ers_reimbursement ADD CONSTRAINT ers_reimbursement_type_fk
    FOREIGN KEY (reimb_type_id) REFERENCES ers_reimbursement_type (reimb_type_id);

-- ers_users
ALTER TABLE ers_users ADD CONSTRAINT ers_users_fk
    FOREIGN KEY (user_role_id) REFERENCES ers_users (ers_users_id);

/*********************
    INSERT SOME RECORDS
***************************/

INSERT INTO ers_reimbursement_status VALUES (1, 'Pending');
INSERT INTO ers_reimbursement_status VALUES (2, 'Approved');
INSERT INTO ers_reimbursement_status VALUES (3, 'Denied');

INSERT INTO ers_reimbursement_type VALUES (1, 'Lodging');
INSERT INTO ers_reimbursement_type VALUES (2, 'Travel');
INSERT INTO ers_reimbursement_type VALUES (3, 'Food');
INSERT INTO ers_reimbursement_type VALUES (4, 'Other');

INSERT INTO ers_user_roles VALUES (1, 'Employee');
INSERT INTO ers_user_roles VALUES (2, 'Finance Manager');

commit;