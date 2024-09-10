CREATE TABLE booking (
	id SERIAL PRIMARY KEY,
	created_at TIMESTAMP NOT NULL DEFAULT now(),
	user_id INTEGER NOT NULL,
	place_id INTEGER NOT NULL,
	room_id INTEGER NOT NULL,
	number_of_guests INTEGER NOT NULL,
	start_date DATE,
	end_date DATE,
	total_price NUMERIC (10,2) NOT NULL DEFAULT 0,
    status VARCHAR (50)
);