
/*******************************************************************************
   Chinook Database - Version 1.4
   Script: Chinook_Oracle.sql
   Description: Creates and populates the Chinook database.
   DB Server: Oracle
   Author: Luis Rocha
   License: http://www.codeplex.com/ChinookDatabase/license
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER ers_users CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER ers_users
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to ers_users;
GRANT resource to ers_users;
GRANT create session TO ers_users;
GRANT create table TO ers_users;
GRANT create view TO ers_users;



conn ers_users/p4ssw0rd


/*******************************************************************************
   Create Tables
********************************************************************************/


CREATE TABLE Users
(
    UserId NUMBER NOT NULL,
    UserName VARCHAR2(20) NOT NULL,
    PassWord VARCHAR2(20) NOT NULL,
    FirstName VARCHAR2(100),
    LastName VARCHAR2(100),
    Email VARCHAR2 (150),
    RoleId NUMBER,
    CONSTRAINT PK_Users PRIMARY KEY  (UserId)
);

CREATE TABLE User_Roles
(
    UserRoleId NUMBER NOT NULL,
    UserRole VARCHAR2(10),
    CONSTRAINT PK_UserRoles PRIMARY KEY  (UserRoleId)
);

CREATE TABLE Reimbursements
(
    ReimbId NUMBER NOT NULL,
    ReimbAmount NUMBER,
    ReimbSubmitted TIMESTAMP,
    ReimbResolved TIMESTAMP,
    ReimbDescription VARCHAR2(250),
    ReimbReceipt BLOB,
    ReimbAuthor NUMBER,
    ReimbResolver NUMBER,
    ReimbStatusId NUMBER,
    ReimbTypeId NUMBER,
    CONSTRAINT PK_Reimbursements PRIMARY KEY  (ReimbId)
);

CREATE TABLE Reimbursement_Status
(
    ReimbStatusId NUMBER NOT NULL,
    ReimbStatus VARCHAR2(10),
    CONSTRAINT PK_Reimbursement_Status PRIMARY KEY  (ReimbStatusId)
);

CREATE TABLE Reimbursement_Type
(
    ReimbTypeId NUMBER NOT NULL,
    ReimbType VARCHAR2(10),
    CONSTRAINT PK_Reimbursement_Type PRIMARY KEY  (ReimbTypeId)
);


/*******************************************************************************
   Create Primary Key Unique Indexes
********************************************************************************/

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE Users ADD CONSTRAINT FK_RoleId
    FOREIGN KEY (RoleId) REFERENCES User_Roles (UserRoleId)  ;

ALTER TABLE Reimbursements ADD CONSTRAINT FK_ReimbAuthor
    FOREIGN KEY (ReimbAuthor) REFERENCES User_Roles (UserRoleId)  ;
    
ALTER TABLE Reimbursements ADD CONSTRAINT FK_ReimbResolver
    FOREIGN KEY (ReimbResolver) REFERENCES User_Roles (UserRoleId)  ;
    
ALTER TABLE Reimbursements ADD CONSTRAINT FK_ReimbStatus
    FOREIGN KEY (ReimbStatusId) REFERENCES Reimbursement_Status (ReimbStatusId)  ;
    
ALTER TABLE Reimbursements ADD CONSTRAINT FK_ReimbTypeId
    FOREIGN KEY (ReimbTypeId) REFERENCES Reimbursement_Type (ReimbTypeId)  ;


/*******************************************************************************
   Populate Tables
********************************************************************************/

INSERT INTO Users VALUES (1, 'bob', 'password', 'bob', 'bobson', 'bobbobson@gmail.com', 1);
INSERT INTO Users VALUES (2, 'bill', 'password', 'bill', 'billson', 'billbillson@gmail.com', 2);
INSERT INTO Users VALUES (3, 'roger', 'password', 'roger', 'rogerson', 'rogerrogerson@gmail.com', 3);
INSERT INTO Users VALUES (4, 'don', 'password', 'don', 'donson', 'dondonson@gmail.com', 4);

INSERT INTO User_Roles VALUES (1, 'Employee');
INSERT INTO User_Roles VALUES (2, 'Employee');
INSERT INTO User_Roles VALUES (3, 'Manager');
INSERT INTO User_Roles VALUES (4, 'Manager');

INSERT INTO Reimbursements VALUES (1, 37, TIMESTAMP '2011-03-07 13:35:00', TIMESTAMP '2012-04-04 13:35:00', 6, hextoraw('33333333'), 5, 4, 3, 2 );
INSERT INTO Reimbursements VALUES (2, 3, TIMESTAMP '2011-03-07 13:35:00', TIMESTAMP '2012-04-04 13:35:00', 2, hextoraw('33333333'), 1, 7, 1, 4);
INSERT INTO Reimbursements VALUES (3, 37, TIMESTAMP '2011-03-07 13:35:00', TIMESTAMP '2012-04-04 13:35:00', 6, hextoraw('33333333'), 3, 4, 4, 1);
INSERT INTO Reimbursements VALUES (4, 37, TIMESTAMP '2011-03-07 13:35:00', TIMESTAMP '2012-04-04 13:35:00', 6, hextoraw('33333333'), 9, 17, 2, 3);

INSERT INTO Reimbursement_Status VALUES (1, 'Approved');
INSERT INTO Reimbursement_Status VALUES (2, 'Denied');
INSERT INTO Reimbursement_Status VALUES (3, 'Pending');
INSERT INTO Reimbursement_Status VALUES (4, 'Denied');

INSERT INTO Reimbursement_Type VALUES (1, 'Lodging');
INSERT INTO Reimbursement_Type VALUES (2, 'Travel');
INSERT INTO Reimbursement_Type VALUES (3, 'Food');
INSERT INTO Reimbursement_Type VALUES (4, 'Other');

commit;
exit;
