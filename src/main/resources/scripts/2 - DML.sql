INSERT INTO GENDER(DESCRIPTION) VALUES ('Male');
INSERT INTO GENDER(DESCRIPTION) VALUES ('Female');

INSERT INTO SCREENWRITER(NAME, AGE, FK_GENDER) VALUES ('Nahuel',26,1);
INSERT INTO SCREENWRITER(NAME, AGE, FK_GENDER) VALUES ('Micaela',32,2);
INSERT INTO SCREENWRITER(NAME, AGE, FK_GENDER) VALUES ('Javier',29,1);
INSERT INTO SCREENWRITER(NAME, AGE, FK_GENDER) VALUES ('Jazmin',22,2);
INSERT INTO SCREENWRITER(NAME, AGE, FK_GENDER) VALUES ('Solange',25,2);

INSERT INTO SCRIPT(TIMES_MODIFIED, LAST_MODIFIED) VALUES (1, '1942-12-09');
INSERT INTO SCRIPT(TIMES_MODIFIED, LAST_MODIFIED) VALUES (2, '1999-11-04');
INSERT INTO SCRIPT(TIMES_MODIFIED, LAST_MODIFIED) VALUES (3, '1995-02-16');
INSERT INTO SCRIPT(TIMES_MODIFIED, LAST_MODIFIED) VALUES (4, '1972-03-15');
INSERT INTO SCRIPT(TIMES_MODIFIED, LAST_MODIFIED) VALUES (5, '1994-10-06');
INSERT INTO SCRIPT(TIMES_MODIFIED, LAST_MODIFIED) VALUES (6, '1978-11-16');

INSERT INTO COMPANY(NAME, ADDRESS, VALUE) VALUES ('Warner Bros','3400 Warner Blvd, Burbank, CA',5000000.0);
INSERT INTO COMPANY(NAME, ADDRESS, VALUE) VALUES ('Paramount Pictures','5555 Melrose Avenue, Hollywood, California',8000000.0);
INSERT INTO COMPANY(NAME, ADDRESS, VALUE) VALUES ('Fox Pictures','10201 W. Pico Blvd., Bldg. 78 , Los Angeles, CA',3500000.0);
INSERT INTO COMPANY(NAME, ADDRESS, VALUE) VALUES ('Jersey Films','10351 Santa Monica Blvd, Los Angeles, CA',2000000.0);

INSERT INTO MOVIE(NAME, DURATION_IN_MINUTES, RELEASE_DATE, CRITIC_REVIEW,FK_SCRIPT,FK_COMPANY)
	VALUES ('Casablanca', 102, '1942-12-09', 8.4, 1, 1);
INSERT INTO MOVIE(NAME, DURATION_IN_MINUTES, RELEASE_DATE, CRITIC_REVIEW,FK_SCRIPT,FK_COMPANY) 
	VALUES ('Fight Club', 139, '1999-11-04', 8.8, 2, 3);
INSERT INTO MOVIE(NAME, DURATION_IN_MINUTES, RELEASE_DATE, CRITIC_REVIEW,FK_SCRIPT,FK_COMPANY) 
	VALUES ('Pulp Fiction', 165, '1995-02-16', 8.6, 3, 4);
INSERT INTO MOVIE(NAME, DURATION_IN_MINUTES, RELEASE_DATE, CRITIC_REVIEW,FK_SCRIPT,FK_COMPANY) 
	VALUES ('The Godfather', 175, '1972-03-15', 9.0, 4, 2);
INSERT INTO MOVIE(NAME, DURATION_IN_MINUTES, RELEASE_DATE, CRITIC_REVIEW,FK_SCRIPT,FK_COMPANY) 
	VALUES ('Forrest Gump', 142, '1994-10-06', 9.0, 5, 2);
INSERT INTO MOVIE(NAME, DURATION_IN_MINUTES, RELEASE_DATE, CRITIC_REVIEW,FK_SCRIPT,FK_COMPANY) 
	VALUES ('Avatar', 162, '2010-01-01', 7.2, 6, 3);

INSERT INTO SCREENWRITER_MOVIE VALUES (1,1);
INSERT INTO SCREENWRITER_MOVIE VALUES (1,2);
INSERT INTO SCREENWRITER_MOVIE VALUES (1,3);
INSERT INTO SCREENWRITER_MOVIE VALUES (2,3);
INSERT INTO SCREENWRITER_MOVIE VALUES (2,4);
INSERT INTO SCREENWRITER_MOVIE VALUES (3,1);
INSERT INTO SCREENWRITER_MOVIE VALUES (3,3);
INSERT INTO SCREENWRITER_MOVIE VALUES (3,4);
INSERT INTO SCREENWRITER_MOVIE VALUES (4,1);
INSERT INTO SCREENWRITER_MOVIE VALUES (4,2);
INSERT INTO SCREENWRITER_MOVIE VALUES (5,1);
INSERT INTO SCREENWRITER_MOVIE VALUES (5,2);
INSERT INTO SCREENWRITER_MOVIE VALUES (5,3);
INSERT INTO SCREENWRITER_MOVIE VALUES (5,4);
INSERT INTO SCREENWRITER_MOVIE VALUES (6,2);

select * from GENDER;
select * from SCREENWRITER;
select * from SCRIPT;
select * from COMPANY;
select * from MOVIE;
select * from SCREENWRITER_MOVIE;