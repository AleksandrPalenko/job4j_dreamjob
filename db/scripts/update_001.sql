create TABLE if not exists post (
   id SERIAL PRIMARY KEY,
   name TEXT,
   description text,
   created timestamp,
   visible boolean,
   city_id int REFERENCES city (id)
);



create TABLE if not exists candidate (
   id SERIAL PRIMARY KEY,
   name TEXT,
   description text,
   created timestamp,
   photo bytea
);

create TABLE if not exists city (
   id SERIAL PRIMARY KEY,
   name TEXT
);

CREATE TABLE if not exists users (
  id SERIAL PRIMARY KEY,
  name TEXT,
  email VARCHAR,
  password TEXT,
  CONSTRAINT email_unique UNIQUE (email)
);