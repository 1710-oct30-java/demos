/***********************************************************************************************************
                                        Database script for ers database 
                                        Created by: Kyle Settles 
************************************************************************************************************/

/* Drop database if it exists */
drop user ersfinal cascade;

/* create databse */
create user ersfinal
identified by p4ssw0rd

default tablespace users
temporary tablespace temp

quota 10m on users;

grant connect to ersfinal;
grant resource to ersfinal;
grant create session to ersfinal;
grant create table to ersfinal;
grant create view to ersfinal;

/* connect to database */
conn ersfinal/p4ssw0rd

/**************************************************************************************************************
                                    CREATE THE TABLES FOR THE DATABASE
**************************************************************************************************************/

create table ers_reimbursement
(
  reimb_id number(10) primary key,
  reimb_amount number(10,2) not null,
  reimb_submitted timestamp not null,
  reimb_resolved timestamp,
  reimb_description varchar2(250),
  reimb_receipt blob,
  reimb_author number(10) not null,
  reimb_resolver number(10),
  reimb_status_id number(10) not null,
  reimb_type_id number(10) not null
);

create table ers_users (
    ers_users_id number(10) primary key,
    ers_username varchar2(50) not null unique,
    ers_password varchar2(50) not null,
    user_first_name varchar2(100) not null,
    user_last_name varchar2(100) not null,
    user_email varchar2(150) not null unique,
    user_role_id number(10) not null
);

create table ers_reimbursement_status (
    reimb_status_id number(10) primary key,
    reimb_status varchar2(10) not null
);

create table ers_reimbursement_type (
    reimb_type_id number(10) primary key,
    reimb_type varchar2(10) not null
);

create table ers_user_roles (
    ers_user_role_id number(10) primary key,
    user_role varchar2(10) not null
);

/********************************************************************************************
                                    SETUP FOREIGN KEYS
*********************************************************************************************/
ALTER TABLE ers_reimbursement ADD CONSTRAINT ers_users_fk_auth
    FOREIGN KEY (reimb_author) REFERENCES ers_users (ers_users_id);
    
ALTER TABLE ers_reimbursement ADD CONSTRAINT ers_users_fk_reslvr
    FOREIGN KEY (reimb_resolver) REFERENCES ers_users (ers_users_id);
    
ALTER TABLE ers_reimbursement ADD CONSTRAINT ers_reimbursement_status_fk
    FOREIGN KEY (reimb_status_id) REFERENCES ers_reimbursement_status (reimb_status_id);
    
ALTER TABLE ers_reimbursement ADD CONSTRAINT ers_reimbursement_type_fk
    FOREIGN KEY (reimb_type_id) REFERENCES ers_reimbursement_type (reimb_type_id);
    
ALTER TABLE ers_users ADD CONSTRAINT user_roles_fk
    FOREIGN KEY (user_role_id) REFERENCES ers_user_roles (ers_user_role_id);
    
    
/**********************************************************************************************
                                        SEQUENCES
***********************************************************************************************/

CREATE SEQUENCE reimb_seq;
CREATE SEQUENCE user_seq;

/**********************************************************************************************
                                        TRIGGERS
***********************************************************************************************/

/* update sequence on insert of new reimbursement */
create or replace trigger reimb_id_trig
before insert or update on ers_reimbursement
for each row
begin
    if inserting then 
        select reimb_seq.nextVal into :new.reimb_id from dual;
    elsif updating then
        select :old.reimb_id into :new.reimb_id from dual;
    end if;
end;
/

/* update sequence on insert of new user */
create or replace trigger user_id_trig
before insert or update on ers_users
for each row
begin
    if inserting then 
        select user_seq.nextVal into :new.ers_users_id from dual;
    elsif updating then
        select :old.ers_users_id into :new.ers_users_id from dual;
    end if;
end;
/


/*********************************************************************************************
                            INITIALIZE DATABASE VALUES
**********************************************************************************************/

/* reimbursement status codes */
INSERT INTO ers_reimbursement_status (reimb_status_id, reimb_status)
VALUES (1, 'Pending');
INSERT INTO ers_reimbursement_status (reimb_status_id, reimb_status)
VALUES (2, 'Approved');
INSERT INTO ers_reimbursement_status (reimb_status_id, reimb_status)
VALUES (3, 'Denied');

/* reimbursement type codes */
INSERT INTO ers_reimbursement_type (reimb_type_id, reimb_type)
VALUES (1, 'Lodging');
INSERT INTO ers_reimbursement_type (reimb_type_id, reimb_type)
VALUES (2, 'Travel');
INSERT INTO ers_reimbursement_type (reimb_type_id, reimb_type)
VALUES (3, 'Food');
INSERT INTO ers_reimbursement_type (reimb_type_id, reimb_type)
VALUES (4, 'Other');

/* ers user roles */
INSERT INTO ers_user_roles (ers_user_role_id, user_role)
VALUES (1, 'Employee');
INSERT INTO ers_user_roles (ers_user_role_id, user_role)
VALUES (2, 'Manager');

/* insert primary user */
INSERT INTO ers_users (ers_users_id, ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
VALUES (1, 'kylesettles', 'pass', 'Kyle', 'Settles', 'kylesettles@email.com', 2);

