CREATE TABLE user_ (
	id SERIAL PRIMARY KEY,
	created_at TIMESTAMP NOT NULL DEFAULT now(),
	lastname VARCHAR (50) NOT NULL,
	firstname VARCHAR (50) NOT NULL,
	email VARCHAR (100) NOT NULL,
	gender VARCHAR (20) NOT NULL,
	phone VARCHAR (20) NOT NULL,
	address VARCHAR (150) NOT NULL,
	city VARCHAR (100) NOT NULL,
	country VARCHAR (100) NOT NULL,
	postal_code VARCHAR (20)
);