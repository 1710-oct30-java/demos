
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
    RoleID NUMBER,
    CONSTRAINT PK_Users PRIMARY KEY  (UserId)
);

CREATE TABLE User_Roles
(
    UserRoleId NUMBER NOT NULL,
    UserRole VARCHAR2(10),
    CONSTRAINT PK_Users PRIMARY KEY  (UserRoleId)
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
ALTER TABLE Reimbursements ADD CONSTRAINT FK_ReimbAuthor
    FOREIGN KEY (ReimbAuthor) REFERENCES Users (Author)  ;
    
ALTER TABLE Reimbursements ADD CONSTRAINT FK_Resolver
    FOREIGN KEY (ReimbResolver) REFERENCES Users (ReimbResolver)  ;
    
ALTER TABLE Reimbursements ADD CONSTRAINT FK_ReimbStatus
    FOREIGN KEY (ReimbStatusId) REFERENCES Reimbursement_Status (ReimbStatusId)  ;
    
ALTER TABLE Reimbursements ADD CONSTRAINT FK_ReimbTypeId
    FOREIGN KEY (ReimbTypeId) REFERENCES Reimbursement_Type (ReimbTypeId)  ;
    
ALTER TABLE Users ADD CONSTRAINT FK_UserRoles
    FOREIGN KEY (UserRoleId) REFERENCES UserRoleId (User_Roles)  ;

/*******************************************************************************
   Populate Tables
********************************************************************************/

INSERT INTO Users VALUES (1, 'bob', 'password', 'bob', 'bobson', 'bobbobson@gmail.com', 1);
INSERT INTO Users VALUES (2, 'bill', 'password', 'bill', 'billson', 'billbillson@gmail.com', 2);
INSERT INTO Users VALUES (3, 'roger', 'password', 'roger', 'rogerson', 'rogerrogerson@gmail.com', 3);
INSERT INTO Users VALUES (4, 'don', 'password', 'don', 'donson', 'dondonson@gmail.com', 4);

INSERT INTO User_Roles VALUES (1, 'Employee');
INSERT INTO User_Roles VALUES (1, 'Employee');
INSERT INTO User_Roles VALUES (2, 'Manager');
INSERT INTO User_Roles VALUES (2, 'Manager');

INSERT INTO Reimbursements VALUES (1, 37, '1997-01-31 09:26:50.12', '1999-08-17 08:26:50.12', 6, EMPTY_BLOB, 5, 4, 6, 7 );
INSERT INTO Reimbursements VALUES (1, 3, '1997-07-30 09:26:50.12', '1997-01-31 09:26:50.12', 2, EMPTY_BLOB, 1, 7, 2, 7 );
INSERT INTO Reimbursements VALUES (1, 37, '2000-01-31 09:26:50.12', '2003-01-31 09:26:50.12', 6, EMPTY_BLOB, 3, 4, 6, 152);
INSERT INTO Reimbursements VALUES (1, 37, '2001-01-21 09:26:50.12', '2007-11-11 09:26:50.12', 6, EMPTY_BLOB, 9, 17, 6, 4 );

INSERT INTO Reimbursement_Status VALUES (2, 'Approved');
INSERT INTO Reimbursement_Status VALUES (3, 'Denied');
INSERT INTO Reimbursement_Status VALUES (1, 'Pending');
INSERT INTO Reimbursement_Status VALUES (3, 'Denied');

INSERT INTO Reimbursement_Type VALUES (1, 'Lodging');
INSERT INTO Reimbursement_Type VALUES (2, 'Travel');
INSERT INTO Reimbursement_Type VALUES (3, 'Food');
INSERT INTO Reimbursement_Type VALUES (4, 'Other');

commit;
exit;
