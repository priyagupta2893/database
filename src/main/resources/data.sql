-- Required this file for create and insert values in table (H2 database) as H2 database got killed everytime server starts
create table PERSON
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);

INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (10001, 'PRIYA GUPTA', 'DELHI', SYSDATE());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (10002, 'MEGHA GUPTA', 'MUMBAI', SYSDATE());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (10003, 'SHIVAM GUPTA', 'BANGALORE', SYSDATE());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (10004, 'PRIYA GUPTA', 'PUNJAB', SYSDATE());

