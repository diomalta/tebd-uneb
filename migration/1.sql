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
    name VARCHAR(120),
    email VARCHAR(120),
    address_id INT,
    card_id INT,
    job_id INT,
    FOREIGN KEY(job_id) REFERENCES address(id),
    FOREIGN KEY(address_id) REFERENCES cards(id),
    FOREIGN KEY(card_id) REFERENCES address(id)
);

CREATE TABLE IF NOT EXISTS articles (
    id int(10) PRIMARY KEY NOT NULL,
    title VARCHAR(10),
    pdf VARCHAR(10),
    resume TEXT
);

CREATE TABLE IF NOT EXISTS authors (
    id int(10) PRIMARY KEY NOT NULL,
    participant_id INT,
    article_id INT,
    FOREIGN KEY(participant_id) REFERENCES participants(id),
    FOREIGN KEY(article_id) REFERENCES articles(id)
);

CREATE TABLE IF NOT EXISTS evaluations (
    id int(10) PRIMARY KEY NOT NULL,
    note VARCHAR(10),
    position VARCHAR(10),
    article_id INT,
    FOREIGN KEY(article_id) REFERENCES articles(id)
);

CREATE TABLE IF NOT EXISTS revisors (
    id int(10) PRIMARY KEY NOT NULL,
    participant_id INT,
    evaluation_id INT,
    FOREIGN KEY(participant_id) REFERENCES participants(id),
    FOREIGN KEY(evaluation_id) REFERENCES evaluations(id)
);
