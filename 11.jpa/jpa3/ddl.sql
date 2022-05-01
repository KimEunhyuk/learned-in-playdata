CREATE TABLE STUDENT(
    STUDENT_ID INT(5) unsigned NOT NULL AUTO_INCREMENT,
    MAJOR_ID INT(5) unsigned,
    STUDENT_NAME VARCHAR(255),
    PRIMARY KEY (STUDENT_ID)
);

CREATE TABLE MAJOR(
    MAJOR_ID INT(5) unsigned NOT NULL AUTO_INCREMENT,
    MAJOR_NAME VARCHAR(255),
    PRIMARY KEY (MAJOR_ID)
);

ALTER TABLE STUDENT
ADD CONSTRAINT FK_STUDENT_MAJOR
FOREIGN KEY (MAJOR_ID)
REFERENCES MAJOR(MAJOR_ID);

insert into major(major_name) values("CS");

insert into student(major_id, student_name) values(1, "KIM");
insert into student(major_id, student_name) values(1, "EUN");

-- 외래키 사용, JOIN
SELECT M.*, S.STUDENT_NAME
FROM STUDENT S JOIN MAJOR M ON S.MAJOR_ID = M.MAJOR_ID
WHERE S.STUDENT_ID = 1;