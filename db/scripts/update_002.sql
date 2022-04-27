create TABLE candidate (
   id SERIAL PRIMARY KEY,
   name TEXT,
   description text,
   created timestamp,
   photo bytea
);