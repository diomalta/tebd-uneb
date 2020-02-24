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

CREATE TABLE IF NOT EXISTS participants (
    id int(10) PRIMARY KEY NOT NULL,
    telephone VARCHAR(10),
    name VARCHAR(10),
    email VARCHAR(10),
    address INT,
    job INT,
    card INT,
    FOREIGN KEY(card) REFERENCES cards(id),
    FOREIGN KEY(address) REFERENCES address(id),
    FOREIGN KEY(job) REFERENCES address(id)
);

CREATE TABLE IF NOT EXISTS articles (
    id int(10) PRIMARY KEY NOT NULL,
    title VARCHAR(10),
    pdf VARCHAR(10),
    resume TEXT
);

CREATE TABLE IF NOT EXISTS authors (
    id int(10) PRIMARY KEY NOT NULL,
    participant INT,
    article INT,
    FOREIGN KEY(participant) REFERENCES participants(id),
    FOREIGN KEY(article) REFERENCES articles(id)
);

CREATE TABLE IF NOT EXISTS evaluations (
    id int(10) PRIMARY KEY NOT NULL,
    note VARCHAR(10),
    position VARCHAR(10),
    revisor INT,
    article INT,
    FOREIGN KEY(article) REFERENCES articles(id)
);

CREATE TABLE IF NOT EXISTS revisors (
    id int(10) PRIMARY KEY NOT NULL,
    participant INT,
    evaluation INT,
    FOREIGN KEY(participant) REFERENCES participants(id),
    FOREIGN KEY(evaluation) REFERENCES evaluations(id)
);
