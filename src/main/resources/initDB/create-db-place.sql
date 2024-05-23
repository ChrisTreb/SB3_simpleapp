CREATE TABLE place (
	id SERIAL PRIMARY KEY,
	created_at TIMESTAMP NOT NULL DEFAULT now(),
	address VARCHAR (150) NOT NULL,
	city VARCHAR (100) NOT NULL,
	country VARCHAR (100) NOT NULL,
	postal_code VARCHAR (20) NOT NULL,
	int free_rooms NOT NULL
);