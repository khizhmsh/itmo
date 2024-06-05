DROP TABLE IF EXISTS Route CASCADE;
DROP TABLE IF EXISTS Users CASCADE;

DROP DOMAIN IF EXISTS distance CASCADE;

CREATE DOMAIN distance AS INT CHECK (VALUE > 1);

create table Users(
  id serial PRIMARY KEY,
  login varchar(70) UNIQUE NOT NULL,
  password varchar(70) NOT NULL
);


CREATE TABLE Route (
  id SERIAL PRIMARY KEY,
  route_key varchar(70) NOT NULL UNIQUE,
  name varchar(70) NOT NULL,
  owner_id int REFERENCES Users(id),
  x DOUBLE PRECISION NOT NULL,
  y DOUBLE PRECISION NOT NULL,
  creation_date DATE NOT NULL,
  location_to_x DOUBLE PRECISION NOT NULL,
  location_to_y DOUBLE PRECISION NOT NULL,
  location_to_z int NOT NULL,
  location_to_name varchar(70),
  location_from_x DOUBLE PRECISION NOT NULL,
  location_from_y DOUBLE PRECISION NOT NULL,
  location_from_z int NOT NULL,
  location_from_name varchar(70),
  distance int NOT NULL
);