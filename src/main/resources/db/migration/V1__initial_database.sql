CREATE SEQUENCE hibernate_sequence
START 1 INCREMENT 1;

CREATE TABLE weather (
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    city VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    temperature NUMERIC(5, 2)
);