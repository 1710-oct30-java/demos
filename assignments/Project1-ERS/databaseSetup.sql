/* Database script for ers database */
/* Created by: Kyle Settles */

/* Drop database if it exists */
drop user ers cascade;

/* create databse */
create user ers
identified by p4ssw0rd

default tablespace users
temporary tablespace temp

quota 10m on users;

grant connect to ers;
grant resource to ers;
grant create session to ers;
grant create table to ers;
grant create view to ers;

/* connect to database */
conn ers/p4ssw0rd

/**************************************************************************************************************
CREATE THE TABLES FOR THE DATABASE
**************************************************************************************************************/

create table ers_reimbursement
(
  reimb_id number(10) primary key,
  reimb_amount number(10) not null,
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
