CREATE TABLE flight(
   id SERIAL PRIMARY KEY NOT NULL,
   departure_location_id int,
   dep_date Date ,
   arr_date date ,
   arrival_location_id int
);

INSERT INTO flight(departure_location_id, dep_date, arr_date, arrival_location_id) VALUES(1, '2023-01-01', '2023-01-02', 3);
INSERT INTO flight(departure_location_id, dep_date, arr_date, arrival_location_id) VALUES(2, '2023-01-03', '2023-01-04', 1);
INSERT INTO flight(departure_location_id, dep_date, arr_date, arrival_location_id) VALUES(3, '2023-01-04', '2023-01-05', 1);
INSERT INTO flight(departure_location_id, dep_date, arr_date, arrival_location_id) VALUES(1, '2023-01-05', '2023-01-06', 3);
INSERT INTO flight(departure_location_id, dep_date, arr_date, arrival_location_id) VALUES(2, '2023-01-06', '2023-01-07', 3);
INSERT INTO flight(departure_location_id, dep_date, arr_date, arrival_location_id) VALUES(3, '2023-01-07', '2023-01-08', 2);
INSERT INTO flight(departure_location_id, dep_date, arr_date, arrival_location_id) VALUES(2, '2023-01-08', '2023-01-09', 1);
