DROP DATABASE IF EXISTS my_ticket_service_db;
CREATE DATABASE my_ticket_service_db;

USE my_ticket_service_db;

CREATE TABLE User (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    creation_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Ticket (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    ticket_type ENUM ('DAY', 'WEEK', 'MONTH', 'YEAR') NOT NULL,
    creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(user_id, creation_date),
    CONSTRAINT FK_USER_ID
    FOREIGN KEY (user_id) 
    REFERENCES User(id) ON DELETE CASCADE
);