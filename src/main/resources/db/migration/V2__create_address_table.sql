CREATE TABLE address (
    id INT PRIMARY KEY,
    cep VARCHAR(11) NOT NULL,
    state states NOT NULL,
    city VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    number VARCHAR(30) NOT NULL
);