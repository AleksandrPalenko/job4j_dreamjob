create TABLE post (
   id SERIAL PRIMARY KEY,
   name TEXT,
   description text,
   created timestamp,
   visible boolean,
   city_id int
);