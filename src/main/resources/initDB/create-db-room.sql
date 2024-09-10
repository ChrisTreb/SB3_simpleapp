CREATE TABLE room (
	id SERIAL PRIMARY KEY,
	place_id INTEGER NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT now(),
	room_number INTEGER NOT NULL,
	room_type VARCHAR (50),
	price_per_night NUMERIC (10,2) NOT NULL,
	guests_capacity INT NOT NULL DEFAULT 0,
    is_available BOOLEAN
);