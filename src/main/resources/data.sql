DROP DATABASE IF EXISTS nguyenduyvu_final_exam;
CREATE DATABASE nguyenduyvu_final_exam;
USE nguyenduyvu_final_exam;

DROP TABLE IF EXISTS users;
CREATE TABLE users (
                       id          INT PRIMARY KEY AUTO_INCREMENT,
                       full_name   VARCHAR(50)                     NOT NULL,
                       email       VARCHAR(50) UNIQUE KEY          NOT NULL,
                       password    VARCHAR(50)                     NOT NULL DEFAULT '123456Q',
                       exp_in_year INT,
                       pro_skill   VARCHAR(50),
                       project_id INT,
                       role        ENUM('EMPLOYEE', 'MANAGER')       NOT NULL DEFAULT 'EMPLOYEE'
);
