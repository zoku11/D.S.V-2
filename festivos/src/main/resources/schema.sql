CREATE TABLE country (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE holiday_type (
  id SMALLINT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  mode SMALLINT NOT NULL
);

CREATE TABLE holiday (
  id SERIAL PRIMARY KEY,
  country_id INTEGER NOT NULL REFERENCES country(id),
  name VARCHAR(255) NOT NULL,
  day SMALLINT,
  month SMALLINT,
  easter_offset SMALLINT,
  type_id SMALLINT NOT NULL REFERENCES holiday_type(id)
);
