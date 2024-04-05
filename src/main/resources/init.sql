CREATE DATABASE IF NOT EXISTS bilt;
USE bilt;

DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS Account;
DROP TABLE IF EXISTS Employee;

CREATE TABLE Customers(
                        name VARCHAR(50) NOT NULL,
                        account_number INT PRIMARY KEY AUTO_INCREMENT,
                        email varchar(20),
                        password varchar(5) DEFAULT("1234"));
ALTER TABLE Customers auto_increment=1001;
INSERT INTO Customers (name, email, password)
VALUES ("Seth", "kal@c","5762"),
       ("Tim",  "M","123"),
       ("Belinda", "F","134");

CREATE TABLE Account(
                        account_number  INT  PRIMARY KEY,
                        balance long not null DEFAULT(0),
                        FOREIGN KEY (account_number) REFERENCES Customers(account_number));

INSERT INTO Account (account_number, balance)
VALUES (1001,"2000"),
       (1002,"457837"),
       (1003,"54748");

CREATE TABLE Employee(
                         name VARCHAR(50) NOT NULL,
                         password varchar(10),
                         email varchar(25));
