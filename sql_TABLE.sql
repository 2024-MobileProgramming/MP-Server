SHOW DATABASES;
CREATE DATABASE MP;
USE MP;
SHOW tables;

CREATE TABLE USER (
    ID INT PRIMARY KEY auto_increment,
    NAME VARCHAR(255),
    EMAIL VARCHAR(255)
);

CREATE TABLE GOAL (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    GOAL_STATEMENT TEXT
);


CREATE TABLE USER_GOAL (
    User_ID INT,
    Goal_ID INT,
    PRIMARY KEY (User_ID, Goal_ID),
    FOREIGN KEY (User_ID) REFERENCES USER(ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Goal_ID) REFERENCES GOAL(ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE AGREED_MEMBER (
    User_ID INT,
    Goal_ID INT,
    Member_ID INT,
    AGREED BOOLEAN default 0,
    PRIMARY KEY (User_ID, Goal_ID, Member_ID),
    FOREIGN KEY (User_ID) REFERENCES USER(ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Goal_ID) REFERENCES GOAL(ID) ON DELETE CASCADE ON UPDATE CASCADE
);

SHOW TABLES;

SELECT * FROM goal;
SELECT * FROM User;