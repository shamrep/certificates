DROP DATABASE IF EXISTS certificates;

CREATE DATABASE cert
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_Europe.1252'
    LC_CTYPE = 'English_Europe.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE public.certificates (
    id integer NOT NULL,
    description varchar NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE customer (
  id integer PRIMARY KEY,
  email varchar NOT NULL UNIQUE,
  password varchar NOT NULL
);

INSERT INTO certificates (id, description)
VALUES (1, 'Test data for certificate');

INSERT INTO customer ( id, email, password)
VALUES (1, 'test@gmail.com', 'password_1');
