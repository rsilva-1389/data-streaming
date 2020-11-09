CREATE TABLE accounts (
	id serial PRIMARY KEY,
	username VARCHAR ( 50 ) UNIQUE NOT NULL,
	password VARCHAR ( 50 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL,
	created_on TIMESTAMP NOT NULL
);

INSERT INTO accounts values (1, 'john.doe', 'my_secret_password', 'john.doe@zup.com.br', CURRENT_TIMESTAMP);
INSERT INTO accounts values (2, 'jane.doe', 'my_secret_password', 'jane.doe@zup.com.br', CURRENT_TIMESTAMP);

UPDATE accounts set password = 'my_s3cr3t_pa55w0rd';

DELETE FROM accounts where id = 2;

INSERT INTO accounts values (3, 'jane.doe', 'my_secret_password', 'jane.doe@zup.com.br', CURRENT_TIMESTAMP);

