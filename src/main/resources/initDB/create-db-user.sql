CREATE TABLE app_user (
	id SERIAL PRIMARY KEY,
	created_at TIMESTAMP NOT NULL DEFAULT now(),
	lastname VARCHAR (50) NOT NULL,
	firstname VARCHAR (50) NOT NULL,
	email VARCHAR (100) NOT NULL,
	gender VARCHAR (20) NOT NULL,
	date_of_birth DATE,
	address VARCHAR (150) NOT NULL,
	city VARCHAR (100) NOT NULL,
	country VARCHAR (100) NOT NULL,
	role VARCHAR (20),
	image TEXT,
	login VARCHAR(50),
	password TEXT
);