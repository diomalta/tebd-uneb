CREATE DATABASE IF NOT EXISTS congresso;

CREATE TABLE IF NOT EXISTS address (
    id int(10) PRIMARY KEY NOT NULL,
    address VARCHAR(50) NOT NULL,
    cep VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS cards (
    id int(10) PRIMARY KEY NOT NULL,
    number VARCHAR(16) NOT NULL,
    flag VARCHAR(10) NOT NULL,
    ccv VARCHAR(4) NOT NULL,
    due DATETIME  NOT NULL
);