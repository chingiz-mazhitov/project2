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
	, ticket_t ticket_type
	, creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	, PRIMARY KEY (id)
	, CONSTRAINT FK_USER_ID
	FOREIGN KEY (user_id)
	REFERENCES app_user(id) ON DELETE CASCADE
);