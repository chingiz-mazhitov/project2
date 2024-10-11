CREATE TYPE ticket_type AS ENUM ('DAY', 'WEEK', 'MONTH', 'YEAR');
CREATE TABLE app_user (
	id int GENERATED ALWAYS AS IDENTITY
	, name VARCHAR(45) NOT NULL
	, creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	, PRIMARY KEY (id)
);

CREATE TABLE Ticket (
	id int GENERATED ALWAYS AS IDENTITY
	, user_id INT NOT NULL
	, ticket_type ticket_type
	, creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	, PRIMARY KEY (id)
	, CONSTRAINT FK_USER_ID
	FOREIGN KEY (user_id)
	REFERENCES app_user(id) ON DELETE CASCADE
);

-- Insert 10 rows into app_user
INSERT INTO app_user (name) VALUES ('Alice');
INSERT INTO app_user (name) VALUES ('Bob');
INSERT INTO app_user (name) VALUES ('Charlie');
INSERT INTO app_user (name) VALUES ('Diana');
INSERT INTO app_user (name) VALUES ('Evan');
INSERT INTO app_user (name) VALUES ('Fiona');
INSERT INTO app_user (name) VALUES ('George');
INSERT INTO app_user (name) VALUES ('Hannah');
INSERT INTO app_user (name) VALUES ('Ivy');
INSERT INTO app_user (name) VALUES ('Jack');

-- Insert 10 rows into Ticket
INSERT INTO Ticket (user_id, ticket_type) VALUES (1, 'DAY');
INSERT INTO Ticket (user_id, ticket_type) VALUES (2, 'WEEK');
INSERT INTO Ticket (user_id, ticket_type) VALUES (3, 'MONTH');
INSERT INTO Ticket (user_id, ticket_type) VALUES (4, 'YEAR');
INSERT INTO Ticket (user_id, ticket_type) VALUES (5, 'DAY');
INSERT INTO Ticket (user_id, ticket_type) VALUES (6, 'WEEK');
INSERT INTO Ticket (user_id, ticket_type) VALUES (7, 'MONTH');
INSERT INTO Ticket (user_id, ticket_type) VALUES (8, 'YEAR');
INSERT INTO Ticket (user_id, ticket_type) VALUES (9, 'DAY');
INSERT INTO Ticket (user_id, ticket_type) VALUES (10, 'WEEK');