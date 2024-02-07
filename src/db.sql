DROP DATABASE IF EXISTS certificates;

CREATE DATABASE certificates
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_Europe.1252'
    LC_CTYPE = 'English_Europe.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

